package ec.edu.espe.studentsystem.controller;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for LogInController.
 * 
 * @author Karla Ansatuña, Scriptal, DCCO-ESPE
 */
public class LogInControllerTest {

    @BeforeAll
    public static void setUpClass() {
    }

    @AfterAll
    public static void tearDownClass() {
    }

    @BeforeEach
    public void setUp() {
    }

    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of matchInMongo method, of class LogInController.
     */
    @Test
    public void testMatchInMongo() {
        System.out.println("matchInMongo");
        int id = 99999;
        String password = "1234";
        LogInController instance = new LogInController();
        boolean expResult = true;
        boolean result = instance.matchInMongo(id, password);
        assertEquals(expResult, result);
    }

    /**
     * Test of setCollection method, of class LogInController.
     */
    @Test
    public void testSetCollection() {
        System.out.println("setCollection");
        int id = 99999;
        LogInController instance = new LogInController();
        CollectionStrategy expResult =new CollectionPrincipal();
        CollectionStrategy result = instance.setCollection(id);
        assertEquals(expResult, result);
    }
}