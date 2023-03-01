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
import com.mongodb.client.result.InsertOneResult;
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

    public static boolean createClassroom(String classroomName, Document teacher) {
        MongoCollection teacherCollection = getConnection("teachers");
        MongoCollection classroomsCollection = getConnection("classrooms");

        Bson filter = Filters.and(Filters.eq("name", classroomName));
        Document classroomExistance = (Document) classroomsCollection.find(filter).first();

        if (classroomExistance == null) {
            ArrayList<String> actualClassrooms = (ArrayList<String>) teacher.get("classrooms");
            actualClassrooms.add(classroomName);
            Document idToSearchDocument = new Document("id", teacher.getInteger("id"));
            Document updatedClassroomsDocument = new Document("$set", new Document("classrooms", actualClassrooms));
            teacherCollection.updateOne(idToSearchDocument, updatedClassroomsDocument);
            classroomsCollection.insertOne(new Document().append("name", classroomName));
            return true;
        }else{
            return false;
        }
    }

    public static ArrayList<String> findClassroom(String classroomName, int teacherId) {
        MongoCollection teacherCollection = getConnection("teachers");
        Bson filter = Filters.and(Filters.eq("id", teacherId));
        Document dataTeacher = (Document) teacherCollection.find(filter).first();
        if (dataTeacher != null) {
            ArrayList<String> classrooms = (ArrayList<String>) dataTeacher.get("classrooms");
            ArrayList<String> classroomFind = new ArrayList<>();
            for (String classroom : classrooms) {
                if (classroom.equals(classroomName)) {
                    classroomFind.add(classroom);
                    return classroomFind;
                }
            }
        }
        return null;
    }

    public static boolean updateClassroom(String nameToChange, String newName, int teacherId) {
        boolean teacherUpdateVerified = updateToTeacher(teacherId, nameToChange, newName);//OK
        boolean enrollmentsUpdateVerified = updateToEnrollments(nameToChange, newName);//OK
        boolean activitiesUpdateVerified = updateToactivities(teacherId, nameToChange, newName);//OK
        boolean subjectsUpdateVerified = updateToSubjects(nameToChange, newName);//OK
        boolean classroomsUpdateVerified = updateToClassrooms(nameToChange, newName);//OK
        System.out.println("-->" + teacherUpdateVerified);
        System.out.println("-->" + enrollmentsUpdateVerified);
        System.out.println("-->" + activitiesUpdateVerified);
        System.out.println("-->" + subjectsUpdateVerified);
        System.out.println("-->" + classroomsUpdateVerified);
        if (teacherUpdateVerified!=false&&
            enrollmentsUpdateVerified!=false&&
            activitiesUpdateVerified!=false&&
            subjectsUpdateVerified != false&&
            classroomsUpdateVerified!=false) {
            return true;
        }else{
            return false;
        }
    }

    public static boolean updateToTeacher(int teacherId, String nameToChange, String newName) throws MongoClientException {
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
            return true;
        }
        return false;
    }

    public static boolean updateToEnrollments(String nameToChange, String newName) {
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
            return true;
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

    public static boolean updateToClassrooms(String nameToChange, String newName) {
        MongoCollection classromsCollection = getConnection("classrooms");
        Bson filter = Filters.and(Filters.eq("name", nameToChange));
        Document classroom = (Document) classromsCollection.find(filter).first();
        if (classroom != null) {
            classromsCollection.replaceOne(filter, new Document().append("name", newName));
            return true;
        } else {
            return false;
        }
    }

    public static boolean deleteClassroom(int teacherId, String classroomName) {
        boolean teacherVerivied = deleteToTeacher(classroomName, teacherId);
        boolean enrollmentVerivied = deleteToEnrollments(classroomName);
        boolean activitiesVerivied = deleteToactivities(classroomName, teacherId);
        boolean subjectVerivied = deleteToSubjects(classroomName);
        boolean classroomsVerified = deleteToClassrooms(classroomName);
        if( teacherVerivied!=false&&
            enrollmentVerivied!=false&&
            activitiesVerivied!=false&&
            subjectVerivied!=false&&
            classroomsVerified!=false){
            return true;
        }
        return false;
    }

    public static boolean deleteToTeacher(String classroomName, int teacherId) throws MongoClientException {
        if (findClassroom(classroomName, teacherId) != null) {
            MongoCollection teacherCollection = getConnection("teachers");
            Bson filter = Filters.and(Filters.eq("id", teacherId));
            Document dataTeacher = (Document) teacherCollection.find(filter).first();
            if (dataTeacher != null) {
                ArrayList<String> classrooms = (ArrayList<String>) dataTeacher.get("classrooms");
                for (int i = 0; i < classrooms.size(); i++) {
                    if (classrooms.get(i).equals(classroomName)) {
                        classrooms.remove(i);
                    }
                }
                Document updatedClassroomsDocument = new Document("$set", new Document("classrooms", classrooms));
                teacherCollection.updateOne(filter, updatedClassroomsDocument);
            }
            return true;
        } else {
            return false;
        }
    }

    public static boolean deleteToEnrollments(String name) {
        MongoCollection enrollmentsCollection = getConnection("enrollments");
        Bson filter = Filters.all("subjects", name);
        MongoCursor<Document> enrollments = enrollmentsCollection.find(filter).iterator();
        System.out.println("ENROLLMENTS");

        try {
            while (enrollments.hasNext()) {
                Document enrollmentDoc = enrollments.next();
                ArrayList<String> subjects = (ArrayList<String>) enrollmentDoc.get("subjects");
                subjects.remove(name);
                Document idToSearchDocument = new Document("studentId", (int) enrollmentDoc.get("studentId"));
                Document updatedClassroomsDocument = new Document("$set", new Document("subjects", subjects));
                enrollmentsCollection.updateOne(idToSearchDocument, updatedClassroomsDocument);
            }
        } finally {
            enrollments.close();
        }
        return true;
    }

    public static boolean deleteToactivities(String classroomName, int teacherId) {
        MongoCollection activitiesCollection = getConnection("activities");
        Bson filter = Filters.and(Filters.eq("teacherId", teacherId), Filters.eq("subjectName", classroomName));
        MongoCursor<Document> activities = activitiesCollection.find(filter).iterator();
        if (activities != null) {
            activitiesCollection.deleteMany(filter);
            return true;
        }
        return false;
    }

    public static boolean deleteToSubjects(String classromName) {
        MongoCollection subjectsCollection = getConnection("subjects");
        Bson filter = Filters.elemMatch("gradesReport", Filters.eq("subject", classromName));
        MongoCursor<Document> subjects = subjectsCollection.find(filter).iterator();

        try {
            while (subjects.hasNext()) {
                Document subjectDoc = subjects.next();
                ArrayList<Document> gradesReport = (ArrayList<Document>) subjectDoc.get("gradesReport");
                for (int i = 0; i < gradesReport.size(); i++) {
                    if (gradesReport.get(i).get("subject").equals(classromName)) {
                        gradesReport.remove(i);
                    }
                }
                Document idToSearchDocument = new Document("studentId", (int) subjectDoc.get("studentId"));
                Document updatedClassroomsDocument = new Document("$set", new Document("subjects", gradesReport));
                subjectsCollection.updateOne(idToSearchDocument, updatedClassroomsDocument);
            }
        } finally {
            subjects.close();
        }
        return true;
    }

    public static boolean deleteToClassrooms(String classroomName) {
        MongoCollection classromsCollection = getConnection("classrooms");
        Bson filter = Filters.and(Filters.eq("name", classroomName));
        Document classroom = (Document) classromsCollection.find(filter).first();
        if (classroom != null) {
            classromsCollection.deleteOne(filter);
            return true;
        } else {
            return false;
        }
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
}
