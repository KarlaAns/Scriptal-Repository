package ec.edu.espe.studentsystem.controller;

import com.google.gson.Gson;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import ec.edu.espe.studentsystem.model.Enrollment;
import ec.edu.espe.studentsystem.model.GradeReport;
import ec.edu.espe.studentsystem.model.Student;
import java.util.ArrayList;
import java.util.Random;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;

/**
 *
 * @author Alejandro Andrade, Scriptal, DCCO_ESPE
 */
public class StudentController {

    public static int generateRandomId() {
        Random r = new Random();
        Gson gson = new Gson();
        int id = r.nextInt((50000 - 10000) + 1) + 10000;
        MongoCollection<Document> collection = MongoConection.getConnection("students");
        Bson filter = Filters.eq("id", id);
        MongoCursor<Document> cursor = collection.find(filter).limit(1).iterator();

        if (cursor.hasNext())
        {
            Document doc = collection.find(filter).first();
            String studentDoc = doc.toJson();
            Student student = gson.fromJson(studentDoc, Student.class);
            while (student.getId() == id)
            {
                id = (r.nextInt() * (50000 - 10000)) + 10000;
            }
        }

        return id;
    }

    public static void addToStudentsCollection(int id, String name, String password, String email, String dateOfBirth) {
        MongoCollection<Document> collectionStudents = MongoConection.getConnection("students");
        Document studentDoc = new Document("_id", new ObjectId())
                .append("id", id)
                .append("name", name)
                .append("password", password)
                .append("email", email)
                .append("dateOfBirth", dateOfBirth);
        collectionStudents.insertOne(studentDoc);
        
    }
    
    public static void addToSubjectsCollection(int id) {
        MongoCollection<Document> collectionSubjects = MongoConection.getConnection("subjects");
        ArrayList<GradeReport> gradesReport = new ArrayList<>();
        Document subjectDoc = new Document("_id", new ObjectId())
                .append("studentId", id)
                .append("gradesReport", gradesReport);
        collectionSubjects.insertOne(subjectDoc);
    }

    public static Student find(int id) {
        Gson gson = new Gson();
        MongoCollection<Document> collection = MongoConection.getConnection("students");
        Bson filter = Filters.eq("id", id);
        MongoCursor<Document> cursor = collection.find(filter).limit(1).iterator();

        if (cursor.hasNext())
        {
            Document doc = collection.find(filter).first();
            String studentDoc = doc.toJson();
            Student student = gson.fromJson(studentDoc, Student.class);
            return student;
        } 
        return new Student("", 0, "", "", "");
    }

    public static void deleteStudent(int id) {
        MongoCollection<Document> collection = MongoConection.getConnection("students");
        Bson filter = Filters.and(Filters.eq("id", id));
        collection.deleteOne(filter);
    }

    public static void updateStudent(Student student) {
        MongoCollection<Document> collection = MongoConection.getConnection("students");
        Bson filter = Filters.and(Filters.eq("id", student.getId()));
        Bson studentUpdates = Updates.combine(
                        Updates.set("name", student.getName()),
                        Updates.set("id", student.getId()),
                        Updates.set("password", student.getPassword()),
                        Updates.set("email", student.getEmail()),
                        Updates.set("dateOfBirth", student.getDateOfBirth()));
        collection.updateOne(filter, studentUpdates);
    }

    public static void assingStudent(int id, String newSubject){
        Gson gson = new Gson();
        MongoCollection<Document> collectionEnrollment = MongoConection.getConnection("enrollments");
        Bson filter = Filters.and(Filters.eq("studentId", id));
        Document doc = collectionEnrollment.find(filter).first();
        String enrollmentJson = doc.toJson();
        Enrollment enrollment = gson.fromJson(enrollmentJson, Enrollment.class);
        ArrayList<String> subjects = enrollment.getSubjects();
        subjects.add(newSubject);
        Bson studentUpdates = Updates.combine(
                        Updates.set("studentId", enrollment.getStudentId()),
                        Updates.set("subjects", enrollment.getSubjects()),
                        Updates.set("average", enrollment.getAverage()));
        collectionEnrollment.updateOne(filter, studentUpdates);
    }
}
