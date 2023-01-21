
package ec.edu.espe.studentsystem.controller;

import com.google.gson.Gson;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import ec.edu.espe.studentsystem.model.Subject;
import javax.swing.table.DefaultTableModel;
import org.bson.Document;
import org.bson.conversions.Bson;

/**
 *
 * @author Alejandro Andrade, Scriptal, DCCO_ESPE
 */
public class EnrollmentController {
    
    public static void viewData(int id, DefaultTableModel model, javax.swing.JLabel lblAverageTotal) {
        String collection = "subjects";
        Gson gson = new Gson();
        
        MongoCollection<Document> subjectCollection = MongoConection.getConnection(collection);
        Bson bsonFilter = Filters.eq("studentId", id);
        Document doc = subjectCollection.find(Filters.and(bsonFilter)).first();
        String studentDoc = doc.toJson();
        Subject subjects = gson.fromJson(studentDoc, Subject.class);
        
        for(int i = 0; i < subjects.getGradesReport().size(); i++){
            String []info = new String[2];
            info[0] = subjects.getGradesReport().get(i).getSubject();
            info[1] = String.valueOf(subjects.getGradesReport().get(i).getAverage());
            model.addRow(info);
        }
        
        double averageTotal = 0;
        for(int i = 0; i < subjects.getGradesReport().size(); i++){
            averageTotal += subjects.getGradesReport().get(i).getAverage();
        }
        lblAverageTotal.setText(String.valueOf(averageTotal/subjects.getGradesReport().size()));
    }
    
}
