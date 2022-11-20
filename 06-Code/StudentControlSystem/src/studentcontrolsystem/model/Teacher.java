
package studentcontrolsystem.model;

/**
 *
 * @author Alejandro Andrade, Scriptal, DCCO_ESPE
 */
public class Teacher {
    
    private String name;
    private Classroom classroom[] = {};
    
    public Teacher(int numberOfClassrooms, int numberOfStudentsInClass){
        name = "";
        for (int i = 0; i < numberOfClassrooms; i++)
        {
            classroom[i] = new Classroom(numberOfStudentsInClass);          
        }
               
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
     * @return the classroom
     */
    public Classroom[] getClassroom() {
        return classroom;
    }

    /**
     * @param classroom the classroom to set
     */
    public void setClassroom(Classroom[] classroom) {
        this.classroom = classroom;
    }
}
