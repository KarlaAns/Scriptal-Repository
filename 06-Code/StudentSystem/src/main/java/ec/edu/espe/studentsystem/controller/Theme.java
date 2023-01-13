
package ec.edu.espe.studentsystem.controller;

import com.formdev.flatlaf.FlatDarculaLaf;
import com.formdev.flatlaf.FlatLaf;
import com.formdev.flatlaf.FlatLightLaf;
import javax.swing.UIManager;

/**
 *
 * @author Alejandro Andrade, Scriptal, DCCO_ESPE
 */
public class Theme {
    
    public static void setFlatLightLafTheme() {
        try
        {
            UIManager.setLookAndFeel(new FlatLightLaf());
            FlatLaf.updateUI();
        } catch (Exception ex)
        {
            System.err.println("Failed to initialize LaF");
        }
    }
    
    public static void setDarkTheme() {
        try
        {
            UIManager.setLookAndFeel(new FlatDarculaLaf());
            FlatLaf.updateUI();
        } catch (Exception ex)
        {
            System.err.println("Failed to initialize LaF");
        }
    }
    
}
