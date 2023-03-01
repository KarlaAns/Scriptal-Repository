
package ec.edu.espe.studentsystem.controller;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Alejandro Andrade, Scriptal, DCCO_ESPE
 */
public class CollectionStudentTest {
    
    public CollectionStudentTest() {
    }

    @Test
    public void testObtainUser() {
        System.out.println("obtainUser");
        int id = 0;
        String password = "";
        CollectionStudent instance = new CollectionStudent();
        boolean expResult = false;
        boolean result = instance.obtainUser(id, password);
        assertEquals(expResult, result);
    }
    
}
