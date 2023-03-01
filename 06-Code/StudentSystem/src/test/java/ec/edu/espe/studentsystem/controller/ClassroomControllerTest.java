package ec.edu.espe.studentsystem.controller;

import ec.edu.espe.studentsystem.model.Activity;
import java.util.ArrayList;
import org.bson.Document;
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
public class ClassroomControllerTest {
    
    public ClassroomControllerTest() {
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
     * Test of createActivity method, of class ClassroomController.
     */
    @Test
    public void testCreateActivity() {
        System.out.println("createActivity");
        Activity activity = null;
        ClassroomController.createActivity(activity);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of readClassrooms method, of class ClassroomController.
     */
    @Test
    public void testReadClassrooms() {
        System.out.println("readClassrooms");
        int teacherId = 0;
        ArrayList<String> expResult = null;
        ArrayList<String> result = ClassroomController.readClassrooms(teacherId);
        assertEquals(expResult, result);
    }

    /**
     * Test of findTeacher method, of class ClassroomController.
     */
    @Test
    public void testFindTeacher() {
        System.out.println("findTeacher");
        int teacherId = 0;
        Document expResult = null;
        Document result = ClassroomController.findTeacher(teacherId);
        assertEquals(expResult, result);
    }

    /**
     * Test of countNumberStudents method, of class ClassroomController.
     */
    @Test
    public void testCountNumberStudents() {
        System.out.println("countNumberStudents");
        String classroom = "";
        int expResult = 0;
        int result = ClassroomController.countNumberStudents(classroom);
        assertEquals(expResult, result);
    }

    /**
     * Test of validateActivityExistance method, of class ClassroomController.
     */
    @Test
    public void testValidateActivityExistance() {
        System.out.println("validateActivityExistance");
        String activityName = "";
        int teacherId = 0;
        String classroomName = "";
        boolean expResult = false;
        boolean result = ClassroomController.validateActivityExistance(activityName, teacherId, classroomName);
        assertEquals(expResult, result);
    }
    
}
