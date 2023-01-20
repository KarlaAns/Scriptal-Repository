/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.studentsystem.controller;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import static ec.edu.espe.studentsystem.controller.MongoConection.getConnection;
import ec.edu.espe.studentsystem.model.Activity;
import ec.edu.espe.studentsystem.model.Assignation;
import ec.edu.espe.studentsystem.model.Enrollment;
import ec.edu.espe.studentsystem.model.Subject;
import com.google.gson.Gson;
import java.util.ArrayList;
import org.bson.Document;
import org.bson.conversions.Bson;

/**
 *
 * @author Cristian Acalo, Scriptal, DCCO-ESPE
 */
public class ActivityController {

    public static Document findDataStudent(int id) {
        Document dataStudent;

        MongoCollection activityCollection = getConnection("students");

        Bson filter = Filters.and(Filters.eq("id", id));
        dataStudent = (Document) activityCollection.find(filter).first();

        if (dataStudent != null) {
            return dataStudent;
        } else {
            return null;
        }
    }

    public static ArrayList<Assignation> establishAssignation(String className) {
        Gson gson = new Gson();
        ArrayList<Assignation> activityReport = new ArrayList<>();

        MongoCollection enrollmentsCollection = getConnection("enrollments");

        Bson filter = Filters.and(Filters.gt("studentId", 0));

        MongoCursor<Document> enrollments = enrollmentsCollection.find(filter).iterator();
        ArrayList<String> subjects = new ArrayList<String>();

        Assignation assignation;
        Enrollment enrollment;
        int studentId;

        try {
            while (enrollments.hasNext()) {

                String enrollmentDoc = enrollments.next().toJson();
                enrollment = gson.fromJson(enrollmentDoc, Enrollment.class);
                subjects = enrollment.getSubjects();

                for (String subject : subjects) {
                    if (subject.equals(className)) {
                        studentId = enrollment.getStudentId();
                        assignation = new Assignation(studentId, 0);
                        activityReport.add(assignation);
                    }
                }
            }
        } finally {
            enrollments.close();
        }

        return activityReport;
    }

    public static ArrayList<Activity> findAllActivities(int id, String subjectName) {
        MongoCollection enrollmentsCollection = getConnection("activities");

        Bson filter = Filters.and(Filters.all("teacherId", id));
        MongoCursor<Document> activities = enrollmentsCollection.find(filter).iterator();
        Gson gson = new Gson();
        ArrayList<Activity> activitiesFiltred = new ArrayList<>();
        Activity activity;
        try {
            while (activities.hasNext()) {
                
                String activityDoc = activities.next().toJson();
                activity = gson.fromJson(activityDoc, Activity.class);
                
                if(activity.getSubjectName().equals(subjectName)){
                    activitiesFiltred.add(activity);
                }
            }
        } finally {
            activities.close();
        }
        return activitiesFiltred;
    }
    
    public static void updateActivity(String activityName,ArrayList data){
        MongoCollection enrollmentsCollection = getConnection("activities");
        Bson filter = Filters.and(Filters.eq("name", activityName));
        Document dataToUpdate = new Document().append("name", data.get(0))
                .append("shipping", data.get(1))
                .append("deadline", data.get(2))
                .append("comment", data.get(3))
                .append("activityType", data.get(4));
        enrollmentsCollection.updateOne(filter, dataToUpdate);
    }

    public static void updateGrade(int teacherId,String activityName,int studentId,double grade){
        MongoCollection enrollmentsCollection = getConnection("activities");
        Bson filter = Filters.and(Filters.eq("teacherId",teacherId),Filters.eq("name",activityName),Filters.elemMatch("activityReport", Filters.eq("studentId", studentId)));
        Document updatedGradeDocument = new Document("$set", new Document("activityReport.$.grade", grade));
        enrollmentsCollection.updateMany(filter, updatedGradeDocument);
    }
    
    public static void deteleActivity(int teacherId, String name){
        MongoCollection enrollmentsCollection = getConnection("activities");
        Bson filter = Filters.and(Filters.eq("teacherId",teacherId),Filters.eq("name",name));
        enrollmentsCollection.deleteOne(filter);
    }
}
