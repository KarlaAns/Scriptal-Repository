package ec.edu.espe.studentsystem.controller;

import com.google.gson.Gson;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import ec.edu.espe.studentsystem.model.Event;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;

/**
 *
 * @author Karla Ansatuña, Scriptal, DCCO-ESPE
 */
public class EventController {

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

        if (cursor.hasNext())
        {
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
        MongoCollection<Document> collection = MongoConection.getConnection("events");
        Bson filter = Filters.eq("id", String.valueOf(id));
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
