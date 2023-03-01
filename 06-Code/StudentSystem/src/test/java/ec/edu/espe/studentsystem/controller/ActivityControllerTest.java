
package ec.edu.espe.studentsystem.controller;

import ec.edu.espe.studentsystem.model.Activity;
import ec.edu.espe.studentsystem.model.Assignation;
import java.util.ArrayList;
import org.bson.Document;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Alejandro Andrade, Scriptal, DCCO_ESPE
 */
public class ActivityControllerTest {
    
    public ActivityControllerTest() {
    }

    @Test
    public void testFindDataStudent() {
        System.out.println("findDataStudent");
        int id = 0;
        Document expResult = null;
        Document result = ActivityController.findDataStudent(id);
        assertEquals(expResult, result);
    }

    @Test
    public void testFindActivity() {
        System.out.println("findActivity");
        int teacherId = 0;
        String activityName = "";
        String classroomName = "";
        Document expResult = null;
        Document result = ActivityController.findActivity(teacherId, activityName, classroomName);
        assertEquals(expResult, result);
    }

    @Test
    public void testEstablishAssignation() {
        System.out.println("establishAssignation");
        String className = "";
        ArrayList<Assignation> expResult = null;
        ArrayList<Assignation> result = ActivityController.establishAssignation(className);
        assertEquals(expResult, result);
    }

    @Test
    public void testFindAllActivities() {
        System.out.println("findAllActivities");
        int id = 0;
        String subjectName = "";
        ArrayList<Activity> expResult = null;
        ArrayList<Activity> result = ActivityController.findAllActivities(id, subjectName);
        assertEquals(expResult, result);
    }

    @Test
    public void testUpdateActivity() {
        System.out.println("updateActivity");
        int teacherId = 0;
        String activityName = "";
        String subjectName = "";
        ArrayList data = null;
        ActivityController.updateActivity(teacherId, activityName, subjectName, data);
    }

    @Test
    public void testUpdateGrade() {
        System.out.println("updateGrade");
        String classroomName = "";
        int teacherId = 0;
        String activityName = "";
        int studentId = 0;
        double grade = 0.0;
        ActivityController.updateGrade(classroomName, teacherId, activityName, studentId, grade);
    }

    @Test
    public void testDeteleActivity() {
        System.out.println("deteleActivity");
        int teacherId = 0;
        String activityName = "";
        String subjectName = "";
        ActivityController.deteleActivity(teacherId, activityName, subjectName);
    }
    
}
