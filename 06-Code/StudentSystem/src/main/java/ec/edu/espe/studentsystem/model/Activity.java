
package ec.edu.espe.studentsystem.model;

import java.util.ArrayList;

/**
 *
 * @author Alejandro Andrade, Scriptal, DCCO_ESPE
 */
public class Activity {
    
    private String subjectName;
    private String name;
    private String shipping;
    private String deadline;
    private String comment;
    private String activityType;
    private ArrayList<Assignation> activityReport;

    public Activity(String subjectName, String name, String shipping, String deadline, String comment, String activityType, ArrayList<Assignation> activityReport) {
        this.subjectName = subjectName;
        this.name = name;
        this.shipping = shipping;
        this.deadline = deadline;
        this.comment = comment;
        this.activityType = activityType;
        this.activityReport = activityReport;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the shipping
     */
    public String getShipping() {
        return shipping;
    }

    /**
     * @param shipping the shipping to set
     */
    public void setShipping(String shipping) {
        this.shipping = shipping;
    }

    /**
     * @return the deadline
     */
    public String getDeadline() {
        return deadline;
    }

    /**
     * @param deadline the deadline to set
     */
    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }

    /**
     * @return the comment
     */
    public String getComment() {
        return comment;
    }

    /**
     * @param comment the comment to set
     */
    public void setComment(String comment) {
        this.comment = comment;
    }

    /**
     * @return the activityType
     */
    public String getActivityType() {
        return activityType;
    }

    /**
     * @param activityType the activityType to set
     */
    public void setActivityType(String activityType) {
        this.activityType = activityType;
    }

    /**
     * @return the activityReport
     */
    public ArrayList<Assignation> getActivityReport() {
        return activityReport;
    }

    /**
     * @param activityReport the activityReport to set
     */
    public void setActivityReport(ArrayList<Assignation> activityReport) {
        this.activityReport = activityReport;
    }

    /**
     * @return the subjectName
     */
    public String getSubjectName() {
        return subjectName;
    }

    /**
     * @param subjectName the subjectName to set
     */
    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }
    
}
