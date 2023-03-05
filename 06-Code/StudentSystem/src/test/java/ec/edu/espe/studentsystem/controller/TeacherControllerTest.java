
package ec.edu.espe.studentsystem.controller;

import java.util.ArrayList;
import org.bson.Document;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Alejandro Andrade, Scriptal, DCCO_ESPE
 */
public class TeacherControllerTest {
    
    public TeacherControllerTest() {
    }

    @Test
    public void testCreateClassroom() {
        System.out.println("createClassroom");
        String classroomName = "";
        Document teacher = null;
        boolean expResult = false;
        boolean result = TeacherController.createClassroom(classroomName, teacher);
        assertEquals(expResult, result);
    }

    @Test
    public void testFindClassroom() {
        System.out.println("findClassroom");
        String classroomName = "";
        int teacherId = 0;
        ArrayList<String> expResult = null;
        ArrayList<String> result = TeacherController.findClassroom(classroomName, teacherId);
        assertEquals(expResult, result);
    }

    @Test
    public void testUpdateClassroom() {
        System.out.println("updateClassroom");
        String nameToChange = "";
        String newName = "";
        int teacherId = 0;
        boolean expResult = false;
        boolean result = TeacherController.updateClassroom(nameToChange, newName, teacherId);
        assertEquals(expResult, result);
    }

    @Test
    public void testUpdateToTeacher() {
        System.out.println("updateToTeacher");
        int teacherId = 0;
        String nameToChange = "";
        String newName = "";
        boolean expResult = false;
        boolean result = TeacherController.updateToTeacher(teacherId, nameToChange, newName);
        assertEquals(expResult, result);
    }

    @Test
    public void testUpdateToEnrollments() {
        System.out.println("updateToEnrollments");
        String nameToChange = "";
        String newName = "";
        boolean expResult = false;
        boolean result = TeacherController.updateToEnrollments(nameToChange, newName);
        assertEquals(expResult, result);
    }

    @Test
    public void testUpdateToactivities() {
        System.out.println("updateToactivities");
        int teacherId = 0;
        String nameToChange = "";
        String newName = "";
        boolean expResult = false;
        boolean result = TeacherController.updateToActivities(teacherId, nameToChange, newName);
        assertEquals(expResult, result);
    }

    @Test
    public void testUpdateToSubjects() {
        System.out.println("updateToSubjects");
        String nameToChange = "";
        String newName = "";
        boolean expResult = false;
        boolean result = TeacherController.updateToSubjects(nameToChange, newName);
        assertEquals(expResult, result);
    }

    @Test
    public void testUpdateToClassrooms() {
        System.out.println("updateToClassrooms");
        String nameToChange = "";
        String newName = "";
        boolean expResult = false;
        boolean result = TeacherController.updateToClassrooms(nameToChange, newName);
        assertEquals(expResult, result);
    }

    @Test
    public void testDeleteClassroom() {
        System.out.println("deleteClassroom");
        int teacherId = 0;
        String classroomName = "";
        boolean expResult = false;
        boolean result = TeacherController.deleteClassroom(teacherId, classroomName);
        assertEquals(expResult, result);
    }

    @Test
    public void testDeleteToTeacher() {
        System.out.println("deleteToTeacher");
        String classroomName = "";
        int teacherId = 0;
        boolean expResult = false;
        boolean result = TeacherController.deleteToTeacher(classroomName, teacherId);
        assertEquals(expResult, result);
    }

    @Test
    public void testDeleteToEnrollments() {
        System.out.println("deleteToEnrollments");
        String name = "";
        boolean expResult = false;
        boolean result = TeacherController.deleteToEnrollments(name);
        assertEquals(expResult, result);
    }

    @Test
    public void testDeleteToactivities() {
        System.out.println("deleteToactivities");
        String classroomName = "";
        int teacherId = 0;
        boolean expResult = false;
        boolean result = TeacherController.deleteToActivities(classroomName, teacherId);
        assertEquals(expResult, result);
    }

    @Test
    public void testDeleteToSubjects() {
        System.out.println("deleteToSubjects");
        String classromName = "";
        boolean expResult = false;
        boolean result = TeacherController.deleteToSubjects(classromName);
        assertEquals(expResult, result);
    }

    @Test
    public void testDeleteToClassrooms() {
        System.out.println("deleteToClassrooms");
        String classroomName = "";
        boolean expResult = false;
        boolean result = TeacherController.deleteToClassrooms(classroomName);
        assertEquals(expResult, result);
    }

    @Test
    public void testEnterToClassroom() {
        System.out.println("enterToClassroom");
        String classroomName = "";
        int teacherId = 0;
        boolean expResult = false;
        boolean result = TeacherController.enterToClassroom(classroomName, teacherId);
        assertEquals(expResult, result);
    }
    
}
