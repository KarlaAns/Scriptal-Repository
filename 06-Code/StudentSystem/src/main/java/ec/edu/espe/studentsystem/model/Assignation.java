
package ec.edu.espe.studentsystem.model;

/**
 *
 * @author Alejandro Andrade, Scriptal, DCCO_ESPE
 */
public class Assignation {
    
    private int StudentId;
    private double grade;

    public Assignation(int StudentId, double grade) {
        this.StudentId = StudentId;
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Assignation{" + "StudentId=" + StudentId + ", grade=" + grade + '}';
    }
    
    /**
     * @return the StudentId
     */
    public int getStudentId() {
        return StudentId;
    }

    /**
     * @param StudentId the StudentId to set
     */
    public void setStudentId(int StudentId) {
        this.StudentId = StudentId;
    }

    /**
     * @return the grade
     */
    public double getGrade() {
        return grade;
    }

    /**
     * @param grade the grade to set
     */
    public void setGrade(double grade) {
        this.grade = grade;
    }
    
    
}
