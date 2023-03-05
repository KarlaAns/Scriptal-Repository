package ec.edu.espe.studentsystem.controller;

import javax.swing.JLabel;
import javax.swing.table.DefaultTableModel;
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
public class EnrollmentControllerTest {
    
    public EnrollmentControllerTest() {
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
     * Test of viewData method, of class EnrollmentController.
     */
    @Test
    public void testViewData() {
        System.out.println("viewData");
        int id = 99999;
        DefaultTableModel model = null;
        JLabel lblAverageTotal = null;
        EnrollmentController.viewData(id, model, lblAverageTotal);

    }
    
}
