
package ec.edu.espe.studentsystem.model;

/**
 *
 * @author Alejandro Andrade, Scriptal, DCCO_ESPE
 */
public class Assignation {
    
    private int studentId;
    private double grade;

    public Assignation(int studentId, double grade) {
        this.studentId = studentId;
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Assignation{" + "StudentId=" + studentId + ", grade=" + grade + '}';
    }
    
    /**
     * @return the StudentId
     */
    public int getStudentId() {
        return studentId;
    }

    /**
     * @param StudentId the StudentId to set
     */
    public void setStudentId(int StudentId) {
        this.studentId = StudentId;
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
