
package studentcontrolsystem.model;

/**
 *
 * @author Alejandro Andrade, Scriptal, DCCO_ESPE
 */
public class Teacher {
    private long id;
    private String password;
    private String name;
    private String email;

    public Teacher() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Teacher(long id, String password, String name, String email) {
        this.id = id;
        this.password = "normal";
        this.name = name;
        this.email = email;
    }
}