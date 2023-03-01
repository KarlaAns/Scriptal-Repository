package ec.edu.espe.studentsystem.controller;

/**
 *
 * @author Alejandro Andrade, Scriptal, DCCO_ESPE
 */
public class LogInController {
    
    private CollectionStrategy cs;

    public boolean matchInMongo(int id, String password) {

        cs = setCollection(id);
        return cs.obtainUser(id, password);

    }

    public CollectionStrategy setCollection(int id) {
        
        if (id < 100000 && id > 99000)
        {
            cs = new CollectionPrincipal();
        }
        if (id < 99000 && id > 50000)
        {
            cs = new CollectionTeacher();
        }
        if (id < 50000 && id > 10000)
        {
            cs = new CollectionStudent();
        }
        
        return cs;
    }
}
