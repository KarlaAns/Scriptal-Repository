package studentcontrolsystem.view;

import java.io.*;
import java.util.*;
import studentcontrolsystem.model.*;

/**
 *
 * @author Alejandro Andrade, Scriptal, DCCO_ESPE
 */
public class StudentControlSystem {

    public static void main(String[] args) {
        Teacher teacher;
        teacher = new Teacher();
        int choiceTeachOrStud;
        int choiceTeacher;
        long searchId;
        boolean exitFirstMenu = false;
        String searchPassword = "";
        teacher.getPassword();

        Scanner sc = new Scanner(System.in);
        do {
            // Primer menu, puede ser estudiante o profesor
            menuTeacherOrStudent();
            choiceTeachOrStud = sc.nextInt();
            switch (choiceTeachOrStud) {
                case 1 -> {

                    System.out.print("Please enter your id: ");
                    searchId = sc.nextInt();
                    while (searchId != 1234567890) {
                        System.out.println("Please try again: ");
                        searchId = sc.nextInt();
                    }
                    /*System.out.println("Please enter your password");
                    searchPassword = sc.next();
                    int areDifferent = searchPassword.compareTo(teacher.getPassword());
                    while (areDifferent!=0) {
                        System.out.println("Please try again: ");
                        searchPassword = sc.next();
                    }
                    System.out.println("you made it yay");*/

                    //Tercer menu para el profesor
                    printMenuTeacher();

                }
                case 3 -> {
                    exitFirstMenu = true;
                }
                default ->
                    System.out.println("Invalid option");

            }
        } while (!exitFirstMenu);
    }

    private static void menuTeacherOrStudent() {
        System.out.println("Welcome to the Student Control System");
        System.out.println("=======================");
        System.out.println("1.I'm the Teacher > \t");
        System.out.println("2.I'm a Student > \t");
        System.out.println("3.Exit the program > \t");
        System.out.println("=======================");
    }

    private static void printMenuTeacher() {
        Scanner sc = new Scanner(System.in);
        String name;
        name = "Lucy";
        int option;
        do {
            System.out.println("..:: NCKSDCNSKDCN ::..");

            System.out.println("   Welcome " + name);
            System.out.println("=======================");
            System.out.println("1.Register a student > \t");
            //System.out.println("2.Enter into the grade system > \t");
            System.out.println("2.Find Data about a student > \t");
            System.out.println("3.Exit the teacher menu > \t");
            System.out.println("=======================");
            System.out.print("==============> ");

            option = sc.nextInt();
            menuTeacher(option);

        } while (option != 3);

    }

    private static void menuTeacher(int option) {

        ArrayList<Student> studentsToWrite = new ArrayList<>();
        String fileName = "studentsFile.csv";
        int position = 0;

        switch (option) {
            case 1 -> {
                registerStudent(studentsToWrite);
                System.out.println("..:: STUDENT ADDED ::..");
                editFile(fileName, studentsToWrite, position);
                position++;
            }

            case 2 -> {

            }

            case 3 ->
                System.out.println("..:: YOU HAVE EXIT ::..");

            default ->
                System.out.println("csd");
        }
    }

    private static void registerStudent(ArrayList<Student> students) {

        Student student = new Student();
        System.out.println("****************************");
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the student name: ");
        student.setName(sc.next());
        System.out.print("Enter the student age: ");
        student.setAge(sc.nextInt());
        System.out.print("Enter the student gender: ");
        student.setGender(sc.next());
        
        int id = generateId();
        student.setId(id);
        System.out.println("The student's id is: " + id);

        students.add(student);

    }

    private static int generateId() {
        int numero;
        numero = (int) (Math.random() * 9999 + 1000);
        validateId();
        return numero;
    }

    private static void validateId() {

    }

    public static void editFile(String fileName, ArrayList<Student> student, int position) {
        File file = new File(fileName);

        String name = student.get(position).getName();
        int age = student.get(position).getAge();
        int id = student.get(position).getId();
        String gender = student.get(position).getGender(name);

        try {
            PrintWriter output = new PrintWriter(new FileWriter(file, true));
            output.println(id + ";" + name + ";" + age + ";" + gender);
            output.close();
            System.out.println("\n\n..:: File has been written! ::..\n");
        } catch (FileNotFoundException ex) {
            ex.printStackTrace(System.out);
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
        }
    }

}
