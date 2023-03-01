
package ec.edu.espe.studentsystem.controller;

import javax.swing.JTable;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Alejandro Andrade, Scriptal, DCCO_ESPE
 */
public class PrintControllerTest {
    
    public PrintControllerTest() {
    }

    @Test
    public void testPrintPDF() {
        System.out.println("printPDF");
        String title = "";
        JTable table = null;
        PrintController.printPDF(title, table);
    }
    
}
