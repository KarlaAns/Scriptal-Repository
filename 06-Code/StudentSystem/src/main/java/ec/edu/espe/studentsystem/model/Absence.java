package ec.edu.espe.studentsystem.model;

/**
 *
 * @author Alejandro Andrade, Scriptal, DCCO_ESPE
 */
public class Absence {

    private String studentName;
    private String studentId;
    private String date;
    private String classroomName;

    public Absence(String studentName, String studentId, String date, String classroomName) {
        this.studentName = studentName;
        this.studentId = studentId;
        this.date = date;
        this.classroomName = classroomName;
    }

    /**
     * @return the studentName
     */
    public String getStudentName() {
        return studentName;
    }

    /**
     * @param studentName the studentName to set
     */
    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    /**
     * @return the studentId
     */
    public String getStudentId() {
        return studentId;
    }

    /**
     * @param studentId the studentId to set
     */
    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    /**
     * @return the date
     */
    public String getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(String date) {
        this.date = date;
    }

    /**
     * @return the classroomName
     */
    public String getClassroomName() {
        return classroomName;
    }

    /**
     * @param classroomName the classroomName to set
     */
    public void setClassroomName(String classroomName) {
        this.classroomName = classroomName;
    }
    

}
