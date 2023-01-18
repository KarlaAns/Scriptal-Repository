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
        
        if(dataStudent!=null){
            return dataStudent;
        }else{
            return null;
        }
    }
    
    public static void createActivity(){
        
    }
    
    public static ArrayList<Assignation> establishAssignation(String className){
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
                subjects=enrollment.getSubjects();
                
                for (String subject : subjects) {
                    if(subject.equals(className)){
                        studentId= enrollment.getStudentId();
                        assignation = new Assignation(studentId,0);
                        activityReport.add(assignation);
                    }
                }
            }
        } finally {
            enrollments.close();
        }
        
        return activityReport;
    }
    
}
