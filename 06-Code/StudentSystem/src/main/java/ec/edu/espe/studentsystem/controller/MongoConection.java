/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.studentsystem.controller;

import com.mongodb.MongoClientException;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
/**
 *
 * @author Cristian Acalo, Scriptal, DCCO-ESPE
 */
public class MongoConection {
    private static MongoClient mongoClient;
    private static MongoDatabase mongoDatabase;
    
    public static MongoCollection<Document> getConnection(String collection) throws MongoClientException {
        try {
            String url = "mongodb+srv://laandrade:laandrade@cluster0.jcz1lsa.mongodb.net/test";
            String dataBase = "StudentControlSystem";
            MongoClient mc = MongoClients.create(url);
            MongoDatabase database = mc.getDatabase(dataBase);
            MongoCollection<Document> c = database.getCollection(collection);
            System.out.println("Successfully connected to MongoDB Atlas");
            return c;
        } catch (MongoClientException e) {
            System.out.println("Error connecting to MongoDB Atlas: " + e.getMessage());
            throw e;
        }
    }
    
    public static void closeConnection() {
        mongoClient.close();
        System.out.println("Successfully closed connection to MongoDB Atlas");
    }
}
