
package ec.edu.espe.studentsystem.model;

import java.util.ArrayList;

/**
 *
 * @author Alejandro Andrade, Scriptal, DCCO_ESPE
 */
public class GradeReport {
    
    private String subject;
    private ArrayList<String> grades;
    private double average;

    public GradeReport(String subject, ArrayList<String> grades, double average) {
        this.subject = subject;
        this.grades = grades;
        this.average = average;
    }

    /**
     * @return the subject
     */
    public String getSubject() {
        return subject;
    }

    /**
     * @param subject the subject to set
     */
    public void setSubject(String subject) {
        this.subject = subject;
    }

    /**
     * @return the grades
     */
    public ArrayList<String> getGrades() {
        return grades;
    }

    /**
     * @param grades the grades to set
     */
    public void setGrades(ArrayList<String> grades) {
        this.grades = grades;
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
    
    
}
