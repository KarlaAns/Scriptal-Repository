
package ec.edu.espe.studentsystem.controller;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Alejandro Andrade, Scriptal, DCCO_ESPE
 */
public class ThemeControllerTest {
    
    public ThemeControllerTest() {
    }

    @Test
    public void testSetFlatLightLafTheme() {
        System.out.println("setFlatLightLafTheme");
        ThemeController.setFlatLightLafTheme();
    }

    @Test
    public void testSetDarkTheme() {
        System.out.println("setDarkTheme");
        ThemeController.setDarkTheme();
    }
    
}
