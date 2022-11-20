
package studentcontrolsystem.model;

/**
 *
 * @author Alejandro Andrade, Scriptal, DCCO_ESPE
 */
public class Classroom {
    
    private int id;
    private Student students[] = {};
    
    public Classroom(int numberOfStudents){
        id = 0;
        for (int i = 0; i < numberOfStudents; i++)
        {
            students[i] = new Student();            
        }
        
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the students
     */
    public Student[] getStudents() {
        return students;
    }

    /**
     * @param students the students to set
     */
    public void setStudents(Student[] students) {
        this.students = students;
    }
    
    
    
}
