
package ec.edu.espe.studentsystem.controller;

import com.mongodb.client.MongoCollection;
import org.bson.Document;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Alejandro Andrade, Scriptal, DCCO_ESPE
 */
public class MongoConectionTest {
    
    public MongoConectionTest() {
    }

    @Test
    public void testGetConnection() {
        System.out.println("getConnection");
        String collection = "";
        MongoCollection<Document> expResult = null;
        MongoCollection<Document> result = MongoConection.getConnection(collection);
        assertEquals(expResult, result);
    }

    @Test
    public void testCloseConnection() {
        System.out.println("closeConnection");
        MongoConection.closeConnection();
    }
    
}
