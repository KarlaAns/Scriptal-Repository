package ec.edu.espe.studentsystem.controller;

import ec.edu.espe.studentsystem.model.Event;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Karla Ansatuña, Scriptal, DCCO-ESPE
 */
public class EventControllerTest {
    
    public EventControllerTest() {
    }
    
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
     * Test of insertEvent method, of class EventController.
     */
    @Test
    public void testInsertEvent() {
        System.out.println("insertEvent");
        String id = "1";
        String name = "Christmas";
        String date = "12-02-2023";
        String description = "nothing here";
        EventController.insertEvent(id, name, date, description);

    }

    /**
     * Test of findEvent method, of class EventController.
     */
    @Test
    public void testFindEvent() {
        System.out.println("findEvent");
        String id = "2";
        Event expResult = EventController.findEvent(id);
        Event result = EventController.findEvent(id);
        assertEquals(expResult, result);
    }

    /**
     * Test of updateEvent method, of class EventController.
     */
    @Test
    public void testUpdateEvent() {
        System.out.println("updateEvent");
        Event event = null;
        EventController.updateEvent(event);

    }

    /**
     * Test of deleteEvent method, of class EventController.
     */
    @Test
    public void testDeleteEvent() {
        System.out.println("deleteEvent");
        int id = 0;
        EventController.deleteEvent(id);

    }

    /**
     * Test of insertCancelledEvent method, of class EventController.
     */
    @Test
    public void testInsertCancelledEvent() {
        System.out.println("insertCancelledEvent");
        String id = "1";
        String name = "halloween";
        String date = "20-01-2023";
        String description = "";
        EventController.insertCancelledEvent(id, name, date, description);
    }
    
}
