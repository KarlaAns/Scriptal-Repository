/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package studentcontrolsystem.model;

/**
 *
 * @author DCCO-ESPE
 */
public class Registration {
    private int id;
    private int Course;
    
    public Registration(){
        id=0;
        Course=0;
    }
    
    //Constructor
    public Registration(int id, int Course) {
        this.id = id;
        this.Course = Course;
    }

    //Setters and Getters
    public void setId(int id) {
        this.id = id;
    }

    public void setCourse(int Course) {
        this.Course = Course;
    }

    public int getId() {
        return id;
    }

    public int getCourse() {
        return Course;
    }
    
    
}
