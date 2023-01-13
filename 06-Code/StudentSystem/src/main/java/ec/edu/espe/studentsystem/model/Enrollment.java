
package ec.edu.espe.studentsystem.model;

import java.util.ArrayList;

/**
 *
 * @author Alejandro Andrade, Scriptal, DCCO_ESPE
 */
public class Enrollment {
    
    private ArrayList<String> subjects;
    private double average;
    private int studentId;

    public Enrollment(ArrayList<String> subjects, double average, int studentId) {
        this.subjects = subjects;
        this.average = average;
        this.studentId = studentId;
    }

    /**
     * @return the subjects
     */
    public ArrayList<String> getSubjects() {
        return subjects;
    }

    /**
     * @param subjects the subjects to set
     */
    public void setSubjects(ArrayList<String> subjects) {
        this.subjects = subjects;
    }

    /**
     * @return the average
     */
    public double getAverage() {
        return average;
    }

    /**
     * @param average the average to set
     */
    public void setAverage(double average) {
        this.average = average;
    }

    /**
     * @return the studentId
     */
    public int getStudentId() {
        return studentId;
    }

    /**
     * @param studentId the studentId to set
     */
    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }
    
    
}
