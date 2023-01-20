/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.studentsystem.controller;

import com.google.gson.Gson;
import com.mongodb.MongoClientException;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.model.Filters;
import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Projections.elemMatch;
import static ec.edu.espe.studentsystem.controller.MongoConection.getConnection;
import ec.edu.espe.studentsystem.model.Activity;
import ec.edu.espe.studentsystem.model.Assignation;
import ec.edu.espe.studentsystem.model.Classroom;
import ec.edu.espe.studentsystem.model.Enrollment;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;

/**
 *
 * @author Cristian Acalo, Scriptal, DCCO-ESPE
 */
public class TeacherController {

    public static void createClassroom(String classroomName, Document teacher) {
        MongoCollection teacherCollection = getConnection("teachers");

        ArrayList<String> actualClassrooms = (ArrayList<String>) teacher.get("classrooms");
        actualClassrooms.add(classroomName);
        Document idToSearchDocument = new Document("id", teacher.getInteger("id"));
        Document updatedClassroomsDocument = new Document("$set", new Document("classrooms", actualClassrooms));
        teacherCollection.updateOne(idToSearchDocument, updatedClassroomsDocument);
    }

    public static ArrayList<String> findClassroom(String classroomName, Document teacher) {
        MongoCollection teacherCollection = getConnection("teachers");
        Bson filter = Filters.and(Filters.eq("id", teacher.getInteger("id")));
        Document dataTeacher = (Document) teacherCollection.find(filter).first();
        ArrayList<String> classrooms = (ArrayList<String>) teacher.get("classrooms");
        ArrayList<String> classroomFind = new ArrayList<>();
        for (String classroom : classrooms) {
            if (classroom.equals(classroomName)) {
                classroomFind.add(classroom);
                return classroomFind;
            }
        }
        return null;
    }

    public static boolean updateClassroom(String nameToChange, String newName, int teacherId) {
        ArrayList<String> teacherUpdateVerified = updateToTeacher(teacherId, nameToChange, newName);//OK
        ArrayList<String> enrollmentsUpdateVerified = updateToEnrollments(nameToChange, newName);//OK
        boolean activitiesUpdateVerified = updateToactivities(teacherId, nameToChange, newName);//OK
        boolean subjectsUpdateVerified = updateToSubjects(nameToChange, newName);

        if ((activitiesUpdateVerified != false) && (subjectsUpdateVerified != false)) {
            return true;
        }
        return false;
    }

    public static ArrayList<String> updateToTeacher(int teacherId, String nameToChange, String newName) throws MongoClientException {
        MongoCollection teacherCollection = getConnection("teachers");
        Bson filter = Filters.and(Filters.eq("id", teacherId));
        Document dataTeacher = (Document) teacherCollection.find(filter).first();
        if (dataTeacher != null) {
            ArrayList<String> classrooms = (ArrayList<String>) dataTeacher.get("classrooms");
            for (int i = 0; i < classrooms.size(); i++) {
                if (classrooms.get(i).equals(nameToChange)) {
                    classrooms.set(i, newName);
                }
            }
            Document idToSearchDocument = new Document("id", teacherId);
            Document updatedClassroomsDocument = new Document("$set", new Document("classrooms", classrooms));
            teacherCollection.updateOne(idToSearchDocument, updatedClassroomsDocument);
            return classrooms;
        }
        return null;
    }

    public static ArrayList<String> updateToEnrollments(String nameToChange, String newName) {
        MongoCollection enrollmentsCollection = getConnection("enrollments");
        Bson filter = Filters.and(Filters.gt("studentId", 0));
        MongoCursor<Document> enrollments = enrollmentsCollection.find(filter).iterator();
        Gson gson = new Gson();
        Enrollment enrollment;
        ArrayList<String> studentSubjects = new ArrayList<>();
        try {
            while (enrollments.hasNext()) {

                String enrollmentDoc = enrollments.next().toJson();
                enrollment = gson.fromJson(enrollmentDoc, Enrollment.class);
                studentSubjects = enrollment.getSubjects();
                for (int i = 0; i < studentSubjects.size(); i++) {
                    if (studentSubjects.get(i).equals(nameToChange)) {
                        studentSubjects.set(i, newName);
                    }
                }
                Document idToSearchDocument = new Document("studentId", enrollment.getStudentId());
                Document updatedClassroomsDocument = new Document("$set", new Document("subjects", studentSubjects));
                enrollmentsCollection.updateOne(idToSearchDocument, updatedClassroomsDocument);
            }
            return studentSubjects;
        } finally {
            enrollments.close();
        }
    }

    public static boolean updateToactivities(int teacherId, String nameToChange, String newName) {
        MongoCollection activitiesCollection = getConnection("activities");
        Bson filter = Filters.and(Filters.eq("teacherId", teacherId), Filters.eq("subjectName", nameToChange));
        MongoCursor<Document> activities = activitiesCollection.find(filter).iterator();
        if (activities != null) {
            Document updatedSubjectDocument = new Document("$set", new Document("subjectName", newName));
            activitiesCollection.updateMany(filter, updatedSubjectDocument);
            return true;
        }
        return false;
    }

    public static boolean updateToSubjects(String nameToChange, String newName) {
        MongoCollection activitiesCollection = getConnection("subjects");
        Bson filter = Filters.elemMatch("gradesReport", Filters.eq("subject", nameToChange));
        //Bson filter = Filters.all("gradesReport", values);
        MongoCursor<Document> subjects = activitiesCollection.find(filter).iterator();
        if (subjects != null) {
            Document updatedSubjectDocument = new Document("$set", new Document("gradesReport.$.subject", newName));
            activitiesCollection.updateMany(filter, updatedSubjectDocument);
            return true;
        }
        return false;
    }

    public static boolean enterToClassroom(String classroomName, int teacherId) {
        MongoCollection teacherCollection = getConnection("teachers");
        Bson filter = Filters.and(Filters.eq("id", teacherId));
        Document teacherData = (Document) teacherCollection.find(filter).first();
        ArrayList<String> classrooms = (ArrayList<String>) teacherData.get("classrooms");

        for (String classroom : classrooms) {
            if (classroom.equals(classroomName)) {
                return true;
            }
        }
        return false;
    }

    public static void createActivity(Activity activity) {
        MongoCollection activitiesCollection = getConnection("activities");
        ArrayList<Assignation> activityReport = activity.getActivityReport();
        ArrayList<Document> activityReportDoc = new ArrayList<>();
        for (Assignation assignation : activityReport) {
            activityReportDoc.add(new Document()
                    .append("studentId", assignation.getStudentId())
                    .append("grade", assignation.getGrade()));
        }

        Document activityDoc = new Document().append("_id", new ObjectId())
                .append("subjectName", activity.getSubjectName())
                .append("teacherId", activity.getTeacherId())
                .append("name", activity.getName())
                .append("shipping", activity.getShipping())
                .append("shipping", activity.getDeadline())
                .append("comment", activity.getComment())
                .append("activityType", activity.getActivityType())
                .append("activityReport", activityReportDoc);
        activitiesCollection.insertOne(activityDoc);
    }

    public static Document findActivity(int id, String name) {
        MongoCollection enrollmentsCollection = getConnection("activities");
        Bson filter = Filters.and(Filters.eq("teacherId",id),Filters.eq("name",name));
        Document activity = (Document) enrollmentsCollection.find(filter).first();
        return activity;
    }

    public static void deleteClassroom(String classroomName, Document teacher) {
        MongoCollection teacherCollection = getConnection("teachers");

        ArrayList<String> actualClassrooms = (ArrayList<String>) teacher.get("classrooms");
        actualClassrooms.remove(classroomName);
        Document idToSearchDocument = new Document("id", teacher.getInteger("id"));
        Document updatedClassroomsDocument = new Document("$set", new Document("classrooms", actualClassrooms));
        teacherCollection.updateOne(idToSearchDocument, updatedClassroomsDocument);
    }

}
