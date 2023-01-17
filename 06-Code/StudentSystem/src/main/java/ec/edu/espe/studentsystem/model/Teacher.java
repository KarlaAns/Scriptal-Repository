
package ec.edu.espe.studentsystem.model;

import java.util.ArrayList;

/**
 *
 * @author Alejandro Andrade, Scriptal, DCCO_ESPE
 */
public class Teacher extends HighSchoolUser{
    
    private ArrayList<Classroom> classroms;

    public Teacher(ArrayList<Classroom> classroms, int id, String name, String password, String email) {
        super(id, name, password, email);
        this.classroms = classroms;
    }

    @Override
    public String toString() {
        return "Teacher{" + "classroms=" + classroms + '}';
    }
    
    /**
     * @return the classroms
     */
    public ArrayList<Classroom> getClassroms() {
        return classroms;
    }

    /**
     * @param classroms the classroms to set
     */
    public void setClassroms(ArrayList<Classroom> classroms) {
        this.classroms = classroms;
    }

    
}
