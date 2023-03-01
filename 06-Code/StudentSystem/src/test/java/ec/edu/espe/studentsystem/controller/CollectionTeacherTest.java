
package ec.edu.espe.studentsystem.controller;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Alejandro Andrade, Scriptal, DCCO_ESPE
 */
public class CollectionTeacherTest {
    
    public CollectionTeacherTest() {
    }

    @Test
    public void testObtainUser() {
        System.out.println("obtainUser");
        int id = 0;
        String password = "";
        CollectionTeacher instance = new CollectionTeacher();
        boolean expResult = false;
        boolean result = instance.obtainUser(id, password);
        assertEquals(expResult, result);
    }
    
}
