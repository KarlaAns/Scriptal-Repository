
package ec.edu.espe.studentsystem.view;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Alejandro Andrade, Scriptal, DCCO_ESPE
 */
public class FrmLogInTest {
    
    public FrmLogInTest() {
    }

    @org.junit.jupiter.api.Test
    public void testValidatePassword() {
        System.out.println("validatePassword");
        FrmLogIn instance = new FrmLogIn();
        boolean expResult = false;
        boolean result = instance.validatePassword();
        assertEquals(expResult, result);
    }

    @org.junit.jupiter.api.Test
    public void testValidateId() {
        System.out.println("validateId");
        FrmLogIn instance = new FrmLogIn();
        boolean expResult = false;
        boolean result = instance.validateId();
        assertEquals(expResult, result);
    }

    @org.junit.jupiter.api.Test
    public void testGetTfId() {
        System.out.println("getTfId");
        FrmLogIn instance = new FrmLogIn();
        int expResult = 0;
        int result = instance.getTfId();
        assertEquals(expResult, result);
    }

    @org.junit.jupiter.api.Test
    public void testGetPfPassword() {
        System.out.println("getPfPassword");
        FrmLogIn instance = new FrmLogIn();
        String expResult = "";
        String result = instance.getPfPassword();
        assertEquals(expResult, result);
    }

    @org.junit.jupiter.api.Test
    public void testGetStatusCbmiDarkMode() {
        System.out.println("getStatusCbmiDarkMode");
        FrmLogIn instance = new FrmLogIn();
        boolean expResult = false;
        boolean result = instance.getStatusCbmiDarkMode();
        assertEquals(expResult, result);
    }

    @org.junit.jupiter.api.Test
    public void testSetStatusCbmiDarkMode() {
        System.out.println("setStatusCbmiDarkMode");
        boolean isSelected = false;
        FrmLogIn instance = new FrmLogIn();
        instance.setStatusCbmiDarkMode(isSelected);
    }
    
}
