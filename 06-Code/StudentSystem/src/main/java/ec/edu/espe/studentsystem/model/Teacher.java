
package ec.edu.espe.studentsystem.model;

import java.util.ArrayList;

/**
 *
 * @author Alejandro Andrade, Scriptal, DCCO_ESPE
 */
public class Teacher extends HighSchoolUser{
    
    private ArrayList<String> classroms;

    public Teacher(int id, String name, String password, String email, ArrayList<String> classrooms) {
        super(id, name, password, email);
        this.classroms = classrooms;
    }

    @Override
    public String toString() {
        return "Teacher{" + "classroms=" + classroms + '}';
    }
    
    /**
     * @return the classroms
     */
    public ArrayList<String> getClassroms() {
        return classroms;
    }

    /**
     * @param classroms the classroms to set
     */
    public void setClassroms(ArrayList<String> classroms) {
        this.classroms = classroms;
    }
    
    
}
