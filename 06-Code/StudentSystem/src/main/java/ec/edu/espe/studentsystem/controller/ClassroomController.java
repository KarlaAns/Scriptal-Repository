/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.studentsystem.controller;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.model.Filters;
import static ec.edu.espe.studentsystem.controller.MongoConection.getConnection;
import ec.edu.espe.studentsystem.model.Activity;
import ec.edu.espe.studentsystem.model.Assignation;
import java.util.ArrayList;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;

/**
 *
 * @author Cristian Acalo, Scriptal, DCCO-ESPE
 */
public class ClassroomController {
    
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
                .append("deadline", activity.getDeadline())
                .append("comment", activity.getComment())
                .append("activityType", activity.getActivityType())
                .append("activityReport", activityReportDoc);
        activitiesCollection.insertOne(activityDoc);
    }

    public static ArrayList<String> readClassrooms(int teacherId) {
        MongoCollection teacherCollection = getConnection("teachers");

        Bson filter = Filters.and(Filters.eq("id", teacherId));
        Document teacher = (Document) teacherCollection.find(filter).first();
        if(teacher!=null){
            ArrayList<String> classrooms = (ArrayList<String>) teacher.get("classrooms");
            return classrooms;
        }
        return null;
    }

    public static Document findTeacher(int teacherId) {
        Document dataTeacher;
        MongoCollection teacherCollection = getConnection("teachers");

        Bson filter = Filters.and(Filters.eq("id", teacherId));
        dataTeacher = (Document) teacherCollection.find(filter).first();
        return dataTeacher;
    }

    public static int countNumberStudents(String classroom) {

        MongoCollection enrollmentsCollection = getConnection("enrollments");

        Bson filter = Filters.and(Filters.gt("studentId", 0));

        MongoCursor<Document> enrollments = enrollmentsCollection.find(filter).iterator();
        ArrayList<String> subjects = new ArrayList<>();
        int count = 0;
        
        try {
            while (enrollments.hasNext()) {
                subjects = (ArrayList<String>) enrollments.next().get("subjects");
                for (String subject : subjects) {
                    if(subject.equals(classroom)){
                        count++;
                    }
                }
            }
            return count;
        } finally {
            enrollments.close();
        }
    }
    
    public static boolean validateActivityExistance(String activityName,int teacherId, String classroomName){
        MongoCollection activitiesCollection = getConnection("activities");
        Bson filter = Filters.and(Filters.eq("name",activityName),Filters.eq("teacherId",teacherId),Filters.eq("subjectName",classroomName));
        Document classroomExistance = (Document) activitiesCollection.find(filter).first();
        if(classroomExistance!=null){
            return true;
        }else{
            return false;
        }
    }
}
