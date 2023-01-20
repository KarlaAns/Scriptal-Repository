
package ec.edu.espe.studentsystem.model;

/**
 *
 * @author Alejandro Andrade, Scriptal, DCCO_ESPE
 */
public class Event {
    
    private String id;
    private String name;
    private String date;
    private String description;

    public Event(String id, String name, String date, String description) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

  
}
