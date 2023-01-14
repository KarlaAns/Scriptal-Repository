package ec.edu.espe.studentsystem.controller;

import com.mongodb.MongoException;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import org.bson.Document;
import org.bson.conversions.Bson;

/**
 *
 * @author Alejandro Andrade, Scriptal, DCCO_ESPE
 */
public class LogInController {

    public static boolean matchInMongo(int id, String password) {

        String uri = "mongodb+srv://laandrade:laandrade@cluster0.jcz1lsa.mongodb.net/test";

        try ( MongoClient mongoClient = MongoClients.create(uri))
        {
            MongoDatabase database = mongoClient.getDatabase("StudentControlSystem");
            try
            {
                System.out.println("Connected successfully to server(Project).");

                MongoCollection<Document> collection = database.getCollection("principal");
                if (id < 100000 && id > 99000)
                {
                    collection = database.getCollection("principal");
                }
                if (id < 99000 && id > 50000)
                {
                    collection = database.getCollection("teachers");
                }
                if (id < 50000 && id > 10000)
                {
                    collection = database.getCollection("students");
                }

                Bson filter = Filters.eq("id", id);
                try
                {
                    Document doc = collection.find(filter).first();
                    if (password.equals(doc.get("password").toString()))
                    {
                        return true;
                    }

                } catch (Exception e)
                {
                    System.out.println("Data not found");
                }
            } catch (MongoException me)
            {
                System.out.println("An error occurred while attempting to connect: " + me);
            }

        }
        return false;
    }
}
