
package ec.edu.espe.studentsystem.controller;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Alejandro Andrade, Scriptal, DCCO_ESPE
 */
public class CollectionPrincipalTest {
    
    public CollectionPrincipalTest() {
    }

    @Test
    public void testObtainUser() {
        System.out.println("obtainUser");
        int id = 0;
        String password = "";
        CollectionPrincipal instance = new CollectionPrincipal();
        boolean expResult = false;
        boolean result = instance.obtainUser(id, password);
        assertEquals(expResult, result);
    }
    
}
