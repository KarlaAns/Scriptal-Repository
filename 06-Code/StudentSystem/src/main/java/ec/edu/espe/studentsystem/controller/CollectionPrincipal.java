
package ec.edu.espe.studentsystem.controller;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import org.bson.Document;
import org.bson.conversions.Bson;

/**
 *
 * @author Alejandro Andrade, Scriptal, DCCO_ESPE
 */
public class CollectionPrincipal implements  CollectionStrategy{

    @Override
    public boolean obtainUser(int id, String password) {
        MongoCollection<Document> collection = MongoConection.getConnection("principal");
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
        return false;
    }
    
}
