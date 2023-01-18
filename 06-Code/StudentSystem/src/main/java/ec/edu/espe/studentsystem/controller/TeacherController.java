/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.studentsystem.controller;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import static ec.edu.espe.studentsystem.controller.MongoConection.getConnection;
import ec.edu.espe.studentsystem.model.Classroom;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import org.bson.Document;
import org.bson.conversions.Bson;

/**
 *
 * @author Cristian Acalo, Scriptal, DCCO-ESPE
 */
public class TeacherController {

    public static void createClassroom(String classroomName, Document teacher) {
        MongoCollection teacherCollection = getConnection("teachers");

        ArrayList<String> actualClassrooms = (ArrayList<String>) teacher.get("classrooms");
        actualClassrooms.add(classroomName);
        Document idToSearchDocument = new Document("id", teacher.getInteger("id"));
        Document updatedClassroomsDocument = new Document("$set", new Document("classrooms", actualClassrooms));
        teacherCollection.updateOne(idToSearchDocument, updatedClassroomsDocument);
    }
    
    public static ArrayList<String> findClassroom(String classroomName, Document teacher){
        MongoCollection teacherCollection = getConnection("teachers");
        Bson filter = Filters.and(Filters.eq("id", teacher.getInteger("id")));
        Document dataTeacher = (Document) teacherCollection.find(filter).first();
        ArrayList<String> classrooms = (ArrayList<String>) teacher.get("classrooms");
        ArrayList<String> classroomFind = new ArrayList<>();
        for (String classroom : classrooms) {
            if(classroom.equals(classroomName)){
                classroomFind.add(classroom);
                return classroomFind;
            }
        }
        return null;
    }
    
    public static boolean enterToClassroom(String classroomName){
        MongoCollection classroomsCollection = getConnection("classrooms");
        Bson filter = Filters.and(Filters.eq("name", classroomName));
        Document dataExistance = (Document) classroomsCollection.find(filter).first();
        
        return dataExistance!=null;
    }
}
