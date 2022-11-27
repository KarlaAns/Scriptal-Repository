
package studentcontrolsystem.model;

/**
 *
 * @author Scriptal, DCCO_ESPE
 */
public class Teacher {
    private long id;
    private String password;
    private String name;
    private String email;

    public Teacher() {
        id = 1234;
        password = "xdnt";
        name = "";
        email = "";
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

    @Override
    public String toString() {
        return "Teacher{" + "id=" + id + ", password=" + password + ", name=" + name + ", email=" + email + '}';
    }
    
    public Teacher(long id, String password, String name, String email) {
        this.id = id;
        this.password = password;
        this.name = name;
        this.email = email;
    }
    
}