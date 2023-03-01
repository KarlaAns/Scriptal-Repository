
package ec.edu.espe.studentsystem.controller;

import ec.edu.espe.studentsystem.model.Student;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Alejandro Andrade, Scriptal, DCCO_ESPE
 */
public class StudentControllerTest {
    
    public StudentControllerTest() {
    }

    @Test
    public void testGenerateRandomId() {
        System.out.println("generateRandomId");
        int expResult = 0;
        int result = StudentController.generateRandomId();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testAddToStudentsCollection() {
        System.out.println("addToStudentsCollection");
        int id = 0;
        String name = "";
        String password = "";
        String email = "";
        String dateOfBirth = "";
        StudentController.addToStudentsCollection(id, name, password, email, dateOfBirth);
    }

    @Test
    public void testAddToSubjectsCollection() {
        System.out.println("addToSubjectsCollection");
        int id = 0;
        StudentController.addToSubjectsCollection(id);
    }

    @Test
    public void testAddToEnrollmentCollection() {
        System.out.println("addToEnrollmentCollection");
        int id = 0;
        StudentController.addToEnrollmentCollection(id);
    }

    @Test
    public void testFind() {
        System.out.println("find");
        int id = 0;
        Student expResult = null;
        Student result = StudentController.find(id);
        assertEquals(expResult, result);
    }

    @Test
    public void testDeleteStudent() {
        System.out.println("deleteStudent");
        int id = 0;
        StudentController.deleteStudent(id);
    }

    @Test
    public void testUpdateStudent() {
        System.out.println("updateStudent");
        Student student = null;
        StudentController.updateStudent(student);
    }

    @Test
    public void testAssingInSubjects() {
        System.out.println("assingInSubjects");
        int id = 0;
        String newSubject = "";
        StudentController.assingInSubjects(id, newSubject);
    }

    @Test
    public void testAssingInEnrollments() {
        System.out.println("assingInEnrollments");
        int id = 0;
        String newSubject = "";
        StudentController.assingInEnrollments(id, newSubject);
    }
    
}
