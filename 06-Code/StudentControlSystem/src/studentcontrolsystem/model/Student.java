
package studentcontrolsystem.model;

/**
 *
 * @author Scriptal, DCCO_ESPE
 */
public class Student {
    private String name;
    private int age;
    private int id;
    private String gender;
    private String DNI;
    
    public Student(){
        name = "";
        age = 0;
        id = 0;
        gender="";
        
    }

    public Student(String name, int age, int id, String gender) {
        this.name = name;
        this.age = age;
        this.id = id;
        this.gender = gender;
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
     * @return the age
     */
    public int getAge() {
        return age;
    }

    /**
     * @param age the age to set
     */
    public void setAge(int age) {
        this.age = age;
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
     * @return the gender
     */
    public String getGender(String next) {
        return getGender();
    }

    /**
     * @param gender the gender to set
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * @return the gender
     */
    public String getGender() {
        return gender;
    }

    /**
     * @return the DNI
     */
    public String getDNI() {
        return DNI;
    }

    /**
     * @param DNI the DNI to set
     */
    public void setDNI(String DNI) {
        this.DNI = DNI;
    }
}
