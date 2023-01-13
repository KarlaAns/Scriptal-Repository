
package ec.edu.espe.studentsystem.controller;

import ec.edu.espe.studentsystem.model.Activity;
import ec.edu.espe.studentsystem.model.Classroom;
import ec.edu.espe.studentsystem.model.Event;
import ec.edu.espe.studentsystem.model.Student;
import ec.edu.espe.studentsystem.model.Teacher;

/**
 *
 * @author Alejandro Andrade, Scriptal, DCCO_ESPE
 */
public interface IMongoConnection {
    
    void create();
    void read();
    void update();
    void delete();
    
    void create(Event event);
    void read(Event event);
    void update(Event event);
    void delete(Event event);
    
    void create(Student student);
    void read(Student student);
    void update(Student student);
    void delete(Student student);
    
    void create(Classroom classroom);
    void read(Classroom classroom);
    void update(Classroom classroom);
    void delete(Classroom classroom);
    
    void create(Teacher teacher);
    void read(Teacher teacher);
    void update(Teacher teacher);
    void delete(Teacher teacher);
    
    void create(Activity activity);
    void read(Activity activity);
    void update(Activity activity);
    void delete(Activity activity);
    
}
