
package ec.edu.espe.studentsystem.controller;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Alejandro Andrade, Scriptal, DCCO_ESPE
 */
public class CollectionStrategyTest {
    
    public CollectionStrategyTest() {
    }

    @Test
    public void testObtainUser() {
        System.out.println("obtainUser");
        int id = 0;
        String password = "";
        CollectionStrategy instance = new CollectionStrategyImpl();
        boolean expResult = false;
        boolean result = instance.obtainUser(id, password);
        assertEquals(expResult, result);
    }

    public class CollectionStrategyImpl implements CollectionStrategy {

        public boolean obtainUser(int id, String password) {
            return false;
        }
    }
    
}
