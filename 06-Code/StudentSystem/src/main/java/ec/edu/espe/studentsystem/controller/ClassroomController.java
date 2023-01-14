/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.studentsystem.controller;

import com.mongodb.MongoException;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import ec.edu.espe.studentsystem.model.Teacher;
import java.util.ArrayList;
import org.bson.Document;
import org.bson.conversions.Bson;

/**
 *
 * @author Cristian Acalo, Scriptal, DCCO-ESPE
 */
public class ClassroomController {

    public static ArrayList<String> readClassrooms() {
        Document dataTeacher;
        ArrayList<String> classrooms = new ArrayList<>();
        Teacher teacher;
        String uri = "mongodb+srv://laandrade:laandrade@cluster0.jcz1lsa.mongodb.net/test";
        try ( MongoClient mongoClient = MongoClients.create(uri)) {
            MongoDatabase database = mongoClient.getDatabase("StudentControlSystem");

            try {
                System.out.println("Connected successfully to server.");

                MongoCollection teachersCollection = database.getCollection("teachers");

                Bson filter = Filters.and(Filters.eq("id", 50123));
                dataTeacher = (Document) teachersCollection.find(filter).first();

                if (dataTeacher != null) {
                    return (ArrayList<String>) dataTeacher.get("classrooms");
                } else {
                    return null;
                }

            } catch (MongoException me) {
                System.err.println("An error occurred while attempting to connect: " + me);
            }
        }
        return null;
    }

    public static Document enterToActivity(String activityName) {
        Document dataActivity;
        
        String uri = "mongodb+srv://laandrade:laandrade@cluster0.jcz1lsa.mongodb.net/test";

        MongoDatabase db = MongoConection.getConnection(uri, "StudentControlSystem");

        MongoCollection activityCollection = db.getCollection("activities");

        Bson filter = Filters.and(Filters.eq("name", activityName));
        dataActivity = (Document) activityCollection.find(filter).first();
        System.out.println("---------->   " + dataActivity);
        return dataActivity;
    }
}
