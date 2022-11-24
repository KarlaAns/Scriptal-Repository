
package studentcontrolsystem.view;
import java.util.Scanner;
import studentcontrolsystem.model.Teacher;
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
        String searchPassword = "";
        teacher.getPassword();
        Scanner sc = new Scanner(System.in);
        do {
            // Primer menu, puede ser estudiante o profesor
            menuTeacherOrStudent();
            choiceTeachOrStud = sc.nextInt();
            choiceVerifier(choiceTeachOrStud);
            switch (choiceTeachOrStud) {
                case 1 -> {

                    System.out.print("Please enter your id: ");
                    searchId = sc.nextInt();
                    while (searchId != 1234567890) {
                        System.out.println("Please try again: ");
                        searchId = sc.nextInt();
                    }
                    System.out.println("Please enter your password");
                    searchPassword = sc.next();
                    int areDifferent = searchPassword.compareTo(teacher.getPassword());
                    while (areDifferent!=0) {
                        System.out.println("Please try again: ");
                        searchPassword = sc.next();
                    }
                    System.out.println("you made it yay");
                    do {
                        //Tercer menu para el profesor
                        menuTeacher();
                        choiceTeacher = sc.nextInt();
                        choiceVerifier(choiceTeacher);

                    }while(choiceTeacher !=4);
                }
            }
        } while (choiceTeachOrStud != 3);
    }

    private static void menuTeacherOrStudent() {
        System.out.println("Welcome to the Student Control System");
        System.out.println("=======================");
        System.out.println("1.I'm the Teacher > \t");
        System.out.println("2.I'm a Student > \t");
        System.out.println("3.Exit the program > \t");
        System.out.println("=======================");
    }
    private static void choiceVerifier(int choice) {
        while (choice < 1 || choice > 3) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Invalid option, please enter again:  ");
            choice = sc.nextInt();
        }
    }
    private static void menuTeacher() {
        String name;
        name="Lucy";
        System.out.println("   Welcome " +name);
        System.out.println("=======================");
        System.out.println("1.Register a student > \t");
        System.out.println("2.Enter into the grade system > \t");
        System.out.println("3.Find Data about a student > \t");
        System.out.println("4.Exit the teacher menu > \t");
        System.out.println("=======================");
    }
}


