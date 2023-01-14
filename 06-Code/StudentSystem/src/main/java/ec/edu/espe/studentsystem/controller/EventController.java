/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.studentsystem.controller;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.mongodb.MongoException;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import com.mongodb.client.result.UpdateResult;
import ec.edu.espe.studentsystem.model.Event;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;

/**
 *
 * @author NW USER
 */
public class EventController {
 public static void insertEvent(Event event) {
        String uri = "mongodb+srv://laandrade:laandrade@cluster0.jcz1lsa.mongodb.net/test";
        try ( MongoClient mongoClient = MongoClients.create(uri)) {

            MongoDatabase database = mongoClient.getDatabase("StudentControlSystem");
            try {
                System.out.println("Connected successfully to the server.");
                MongoCollection<Document> collectionResident = database.getCollection("Event");

                Document events = new Document("_id", new ObjectId())
                        .append("id", event.getId())
                        .append("name", event.getName())
                        .append("date", event.getDate())
                        .append("description", event.getDescription());

                collectionResident.insertOne(events);

            } catch (MongoException me) {
                System.out.println("An error occurred while attempting to connect: " + me);
            }

        }
    }
    public static Event findEvent(Event event) {

        String Data;
        Gson gson = new Gson();
        String uri = "mongodb+srv://laandrade:laandrade@cluster0.jcz1lsa.mongodb.net/test";

        try ( MongoClient mongoClient = MongoClients.create(uri)) {
            MongoDatabase database = mongoClient.getDatabase("StudentControlSystem");
            try {
                MongoCollection<Document> collectionEvent = database.getCollection("Event");

                Bson filter = Filters.eq("name", event.getName());
                try {
                    Document doc = collectionEvent.find(Filters.and(filter)).first();
                    Data = doc.toJson();
                    TypeToken<Event> type = new TypeToken<Event>() {
                    };
                    event = gson.fromJson(Data, type.getType());

                } catch (Exception e) {
                    System.out.println("Data not found");
                }

            } catch (MongoException me) {
                System.out.println("An error occurred while attempting to connect: " + me);
            }
        }

        return event;
    }

    public static void updateEvent(Event event) {
        String uri = "mongodb+srv://laandrade:laandrade@cluster0.jcz1lsa.mongodb.net/test";
        try ( MongoClient mongoClient = MongoClients.create(uri)) {

            MongoDatabase database = mongoClient.getDatabase("StudentControlSystem");
            try {
                System.out.println("Connected successfully to the server.");
                MongoCollection<Document> collectionEvent = database.getCollection("Event");
                Bson filter = Filters.eq("name", event.getName());
                Document update = new Document("$set", new Document("id", event.getId()).append("date", event.getDate()).append("description", event.getDescription()));

                UpdateResult result = collectionEvent.updateOne(filter, update);

            } catch (MongoException me) {
                System.out.println("An error occurred while attempting to connect: " + me);
            }
        }
    }

    public static void deleteEvent(Event event) {

        String uri = "mongodb+srv://laandrade:laandrade@cluster0.jcz1lsa.mongodb.net/test";

        try ( MongoClient mongoClient = MongoClients.create(uri)) {
            MongoDatabase database = mongoClient.getDatabase("StudentControlSystem");
            try {
                MongoCollection collectionResident = database.getCollection("Event");

                Bson filter = Filters.eq("name", event.getName());
                collectionResident.deleteOne(filter);

            } catch (MongoException me) {
                System.out.println("An error occurred while attempting to connect: " + me);
            }

        }
    }

   
}
