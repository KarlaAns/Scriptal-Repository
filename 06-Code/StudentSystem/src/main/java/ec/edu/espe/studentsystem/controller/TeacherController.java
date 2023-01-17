/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.studentsystem.controller;

import com.mongodb.client.MongoCollection;
import static ec.edu.espe.studentsystem.controller.MongoConection.getConnection;
import ec.edu.espe.studentsystem.model.Classroom;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import org.bson.Document;

/**
 *
 * @author Cristian Acalo, Scriptal, DCCO-ESPE
 */
public class TeacherController {

    public static void createClassroom(String classroomName, Document teacher) {
        MongoCollection teacherCollection = getConnection("teachers");

        ArrayList<String> actualClassrooms = (ArrayList<String>) teacher.get("classrooms");
        System.out.println(actualClassrooms);
        actualClassrooms.add(classroomName);
        System.out.println(actualClassrooms);
        Document idToSearchDocument = new Document("id", teacher.getInteger("id"));
        Document updatedClassroomsDocument = new Document("$set", new Document("classrooms", actualClassrooms));
        teacherCollection.updateOne(idToSearchDocument, updatedClassroomsDocument);
    }
}
