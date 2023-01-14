/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.studentsystem.controller;

import com.mongodb.MongoClientException;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
/**
 *
 * @author Cristian Acalo, Scriptal, DCCO-ESPE
 */
public class MongoConection {
    private static MongoClient mongoClient;
    private static MongoDatabase mongoDatabase;
    
    public static MongoDatabase getConnection(String url, String database) throws MongoClientException {
        try {
            mongoClient = MongoClients.create(url);
            mongoDatabase = mongoClient.getDatabase(database);
            System.out.println("Successfully connected to MongoDB Atlas");
            return mongoDatabase;
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
