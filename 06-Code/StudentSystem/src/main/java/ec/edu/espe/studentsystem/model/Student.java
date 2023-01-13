
package ec.edu.espe.studentsystem.model;

/**
 *
 * @author Alejandro Andrade, Scriptal, DCCO_ESPE
 */
public class Student extends HighSchoolUser{
    private String dateOfBirth;

    public Student(String dateOfBirth, int id, String name, String password, String email) {
        super(id, name, password, email);
        this.dateOfBirth = dateOfBirth;
    }

    /**
     * @return the dateOfBirth
     */
    public String getDateOfBirth() {
        return dateOfBirth;
    }

    /**
     * @param dateOfBirth the dateOfBirth to set
     */
    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
    
}
