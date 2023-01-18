/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.studentsystem.controller;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import static ec.edu.espe.studentsystem.controller.MongoConection.getConnection;
import org.bson.Document;
import org.bson.conversions.Bson;

/**
 *
 * @author Cristian Acalo, Scriptal, DCCO-ESPE
 */
public class ActivityController {
    
    public static Document findDataStudent(int id) {
        Document dataStudent;
        
        MongoCollection activityCollection = getConnection("students");

        Bson filter = Filters.and(Filters.eq("id", id));
        dataStudent = (Document) activityCollection.find(filter).first();
        
        if(dataStudent!=null){
            return dataStudent;
        }else{
            return null;
        }
    }
    
}
