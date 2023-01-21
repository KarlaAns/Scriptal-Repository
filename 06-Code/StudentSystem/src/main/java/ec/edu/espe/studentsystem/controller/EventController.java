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
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import static com.mongodb.client.model.Filters.eq;
import com.mongodb.client.model.Updates;
import com.mongodb.client.result.UpdateResult;
import ec.edu.espe.studentsystem.model.Event;
import java.util.Scanner;
import javax.swing.JOptionPane;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;

/**
 *
 * @author NW USER
 */
public class EventController {

    private static final Scanner sc = new Scanner(System.in);

    public static void insertEvent(String id, String name, String date, String description) {
        MongoCollection<Document> collectionEvent = MongoConection.getConnection("events");

        Document events = new Document("_id", new ObjectId())
                .append("id", id)
                .append("name", name)
                .append("date", date)
                .append("description", description);

        collectionEvent.insertOne(events);
    }

    public static Event findEvent(String id) {

        Gson gson = new Gson();
        MongoCollection<Document> collection = MongoConection.getConnection("events");
        Bson filter = Filters.eq("id", id);
        MongoCursor<Document> cursor = collection.find(filter).limit(1).iterator();

        if (cursor.hasNext()) {
            Document doc = collection.find(filter).first();
            String eventDoc = doc.toJson();
            Event event = gson.fromJson(eventDoc, Event.class);
            return event;
        }
        return new Event("", "", "", "");
    }

    public static void updateEvent(Event event) {
        MongoCollection<Document> collection = MongoConection.getConnection("events");
        Bson filter = Filters.and(Filters.eq("id", event.getId()));
        Bson eventUpdates = Updates.combine(
                Updates.set("id", event.getId()),
                Updates.set("name", event.getName()),
                Updates.set("date", event.getDate()),
                Updates.set("description", event.getDescription()));
        collection.updateOne(filter, eventUpdates);
    }

    public static void deleteEvent(int id) {
        //int idDigit = Integer.parseInt(id);
     MongoCollection<Document> collection = MongoConection.getConnection("events");
        Bson filter =Filters.eq("id", String.valueOf(id));
        collection.deleteOne(filter);
    }
    public static void insertCancelledEvent(String id, String name, String date, String description) {
        MongoCollection<Document> collectionEvent = MongoConection.getConnection("cancelled events");

        Document cancelledEvents = new Document("_id", new ObjectId())
                .append("id", id)
                .append("name", name)
                .append("date", date)
                .append("description", description);

        collectionEvent.insertOne(cancelledEvents);
    }
}
