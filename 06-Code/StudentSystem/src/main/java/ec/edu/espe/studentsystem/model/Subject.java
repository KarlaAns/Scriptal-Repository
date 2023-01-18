
package ec.edu.espe.studentsystem.model;

import java.util.ArrayList;

/**
 *
 * @author Alejandro Andrade, Scriptal, DCCO_ESPE
 */
public class Subject {
    
    private int studentId;
    private ArrayList<GradeReport> gradesReport;

    public Subject(int studentId, ArrayList<GradeReport> gradesReport) {
        this.studentId = studentId;
        this.gradesReport = gradesReport;
    }

    @Override
    public String toString() {
        return "Subject{" + "studentId=" + studentId + ", gradesReport=" + gradesReport + '}';
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

    /**
     * @return the gradesReport
     */
    public ArrayList<GradeReport> getGradesReport() {
        return gradesReport;
    }

    /**
     * @param gradesReport the gradesReport to set
     */
    public void setGradesReport(ArrayList<GradeReport> gradesReport) {
        this.gradesReport = gradesReport;
    }
        
    
}
