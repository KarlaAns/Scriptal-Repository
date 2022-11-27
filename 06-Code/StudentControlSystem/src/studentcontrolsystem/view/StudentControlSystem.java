package studentcontrolsystem.view;

import java.io.*;
import java.util.*;
import studentcontrolsystem.model.*;

/**
 *
 * @author Scriptal, DCCO_ESPE
 */
public class StudentControlSystem {

    public static void main(String[] args) {
        
        int choiceTeachOrStud;
        boolean exitFirstMenu = false;
        Scanner sc = new Scanner(System.in);
        String fileName = "studentsFile.csv";
        do
        {
            try {
                menuTeacherOrStudent();
                choiceTeachOrStud = sc.nextInt();
                switch (choiceTeachOrStud) {
                    case 1 -> {
                        
                        
                        login();
                        printMenuTeacher();
                    }
                    case 2 -> {
                        System.out.println("======================================");
                        System.out.println("This section will be available soon :D");
                        System.out.println("======================================");
                    }
                    case 3 -> {
                        exitFirstMenu = true;
                    }
                    default ->
                        System.out.println("Invalid option");

                }
            } catch (Exception e) {
                System.out.println("..:: INVALID DATA ::..");
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
        
        try {
            do {

                System.out.println("   Welcome " + name);
                System.out.println("=======================");
                System.out.println("1. Create a classroom > \t");
                System.out.println("2. View students list > \t");
                System.out.println("3. Enter in a classroom >");
                System.out.println("4. Exit the teacher menu > \t");
                System.out.println("=======================");
                System.out.print("==============> ");

                option = sc.nextInt();
                menuTeacher(option);

            } while (option != 4);

        } catch (Exception e) {
            System.out.println("..:: INVALID DATA, CLOSING... ::..");
        }
        
    }

    private static void menuTeacher(int option) {

        switch (option)
        {
            case 1 ->
            {
                createClassroom();
            }

            case 2 ->
            {
                printFile("studentsFile.csv");
            }

            case 3 ->
            {
                enterToClass();
            }

            case 4 ->
                System.out.println("..:: YOU HAVE EXIT ::..");

            default ->
                System.out.println("Invalid option");
        }
    }

    private static void createClassroom() {
        String fileName = "";
        Scanner sc = new Scanner(System.in);
        String classId = "";

        try
        {

            System.out.print("Enter the ID of class: ");
            classId = sc.next();
            fileName = classId + ".csv";
            File file = new File(fileName);
            file.createNewFile();
            System.out.println("\n\n..:: Classroom has been created! ::..\n");
            
        } catch (IOException ex)
        {
            ex.printStackTrace(System.out);
        }
    }
    
    public static void editFile(String fileName, ArrayList<Student> student, int position) {
        File file = new File(fileName);

        String name = student.get(position).getName();
        int age = student.get(position).getAge();
        int id = student.get(position).getId();
        String gender = student.get(position).getGender(name);
        String DNI = student.get(position).getDNI();

        try
        {
            PrintWriter output = new PrintWriter(new FileWriter(file, true));
            output.println(id + ";" + name + ";" + DNI + ";" + age + ";" + gender);
            output.close();
            System.out.println("\n\n..:: File has been written! ::..\n");
        } catch (FileNotFoundException ex)
        {
            System.out.println("The file has not found, but it will be created");
        } catch (IOException ex)
        {
            System.out.println("The file has not found, but it will be created");
        }
    }

    private static void enterToClass() {
        Scanner sc = new Scanner(System.in);
        String classId;
        
        System.out.println("Enter the id of the class you wish to join");
        classId = sc.next();

        menuClassroom(classId);
    }

    private static void menuClassroom(String classId) {
        
        ArrayList<Student> studentsToWrite = new ArrayList<>();
        String studentsFile = "studentsFile.csv";
        String fileClass = classId + ".csv";
        Scanner sc = new Scanner(System.in);
        boolean exit = false;
        int position = 0;
        int option = 0;
        
        while (!exit)
        {

            try
            {
                System.out.println("=================");
                System.out.println("Select any option");
                System.out.println("=================");
                System.out.println("1. Register new student");
                System.out.println("2. Print students list");
                System.out.println("3. Exit menu");
                option = sc.nextInt();

                switch (option)
                {
                    case 1 ->
                    {
                        registerStudent(studentsToWrite);
                        editFile(fileClass, studentsToWrite, position);
                        editFile(studentsFile, studentsToWrite, position);
                        System.out.println("..:: STUDENT ADDED ::..");
                        position++;
                    }
                    case 2 ->
                    {
                        printFile(fileClass);
                    }
                    case 3 ->
                    {
                        System.out.println("..:: You have successfully exited");
                        exit = true;
                    }
                    default ->
                        System.out.println("Option is not valid");
                }

            } catch (Exception e)
            {
                System.out.println("!!! Error !!!");
            }

        }
    }

    private static void registerStudent(ArrayList<Student> students) {

        String fileName = "studentsFile.csv";

        Student student = new Student();
        System.out.println("****************************");
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the student name: ");
        student.setName(sc.next());
        System.out.print("Enter the DNI: ");
        String DNI = sc.next();

        while(!validatorOfDNI(DNI)){
            System.out.print("TRY AGAIN: ");
            DNI = sc.next();
        }
        student.setDNI(DNI);
        
        System.out.print("Enter the student age: ");
        int age = sc.nextInt();
        age = validateAge(age);
        student.setAge(age);
        System.out.print("Enter the student gender: ");
        student.setGender(sc.next());

        int id = generateId();
        boolean validationId = validateIfIdExist(fileName, id);
        if (validationId)
        {
            id = generateId();
        }

        student.setId(id);

        System.out.println("The student's id is: " + id);

        students.add(student);

    }

    private static int generateId() {
        int numero;
        numero = (int) (Math.random() * 9999 + 1000);
        return numero;
    }

    private static void login() {
        
        Teacher teacher;
        teacher = new Teacher();
        
        Scanner sc = new Scanner(System.in);
        String readPassword;
        int searchId;
        
        try {
            System.out.print("Please enter your id: ");
            searchId = sc.nextInt();

            while (searchId != teacher.getId()) {
                System.out.println("Incorrect ID, please try again: ");
                searchId = sc.nextInt();
            }

            System.out.print("..:: Please enter your password: ");
            readPassword = sc.next();

            while (!readPassword.equals(teacher.getPassword())) {
                System.out.print("..:: Incorrect password, please try again: ");
                readPassword = sc.next();
            }

            System.out.println("\n\n**** You made it yay ****\n\n");
            
        } catch (Exception e) {
            System.out.println("..:: INVALID DATA, CLOSING PROGRAM ::..");
        }
    }

    private static boolean validatorOfDNI(String DNI) {
        boolean correctDNI = false;

        try
        {

            if (DNI.length() == 10)
            {
                int thirdDigit = Integer.parseInt(DNI.substring(2, 3));
                if (thirdDigit < 6)
                {
                    int[] arrayDNI =
                    {
                        2, 1, 2, 1, 2, 1, 2, 1, 2
                    };
                    int verificator = Integer.parseInt(DNI.substring(9, 10));
                    int addition = 0;
                    int digit = 0;
                    for (int i = 0; i < (DNI.length() - 1); i++)
                    {
                        digit = Integer.parseInt(DNI.substring(i, i + 1)) * arrayDNI[i];
                        addition += ((digit % 10) + (digit / 10));
                    }

                    if ((addition % 10 == 0) && (addition % 10 == verificator))
                    {
                        correctDNI = true;
                    } else if ((10 - (addition % 10)) == verificator)
                    {
                        correctDNI = true;
                    } else
                    {
                        correctDNI = false;
                    }
                } else
                {
                    correctDNI = false;
                }
            } else
            {
                correctDNI = false;
            }
        } catch (NumberFormatException nfe)
        {
            correctDNI = false;
        } catch (Exception err)
        {
            System.out.println("An exception has ocurred in the process of validation");
            correctDNI = false;
        }

        if (!correctDNI)
        {
            System.out.println("The DNI entered is incorrect");
        }
        return correctDNI;
    }

    public static boolean validateIfIdExist(String fileName, int id) {
        File file = new File(fileName);

        String[] data;
        String idToString = id + "";
        try
        {
            var input = new BufferedReader(new FileReader(file));
            var line = input.readLine();
            while (line != null)
            {
                data = line.split(";");

                if (idToString.equals(data[0]))
                {
                    return true;
                }

                line = input.readLine();
            }
            input.close();
            return false;
        } catch (FileNotFoundException ex)
        {
            System.out.println("The file has not found, but it will be created");
            return false;
        } catch (IOException ex)
        {
            ex.printStackTrace(System.out);
            return false;
        }

    }

    public static void printLine(String[] data) {
        //for-each use
        for (String fact : data)
        {
            System.out.print(fact + "\t|");
        }
    }

    public static void printFile(String fileName) {
        File file = new File(fileName);
        String[] data;
        try
        {
            var input = new BufferedReader(new FileReader(file));
            var line = input.readLine();
            System.out.println("\nID\t|NAME\t|DNI\t\t|AGE\t|GENDER\t|");
            while (line != null)
            {
                data = line.split(";");
                printLine(data);
                line = input.readLine();
                System.out.println();
            }
            input.close();
        } catch (FileNotFoundException ex)
        {
            System.out.println("The file has not found, but it will be created");
        } catch (IOException ex)
        {
            ex.printStackTrace(System.out);
        }
    }

    private static int validateAge(int age) {
        Scanner sc = new Scanner(System.in);
        while (age < 14 || age > 20)
        {
            System.out.print("Age invalid, enter age again: ");
            age = sc.nextInt();
        }
        return age;
    }
}
