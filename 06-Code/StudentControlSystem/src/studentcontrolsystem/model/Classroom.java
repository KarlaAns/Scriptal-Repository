
package studentcontrolsystem.model;

/**
 *
 * @author Scriptal, DCCO_ESPE
 */
public class Classroom {
    
    private String name;
    private int id;
    
    public Classroom(int numberOfStudents){
        name = "";
        id = 0;
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
    
}
