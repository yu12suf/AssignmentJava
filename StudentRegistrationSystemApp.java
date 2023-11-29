import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Abstract class representing a student
abstract class Student {
    private String name;
    private String idNumber;
    private int age;
    private String sex;
    private String department;

    public Student(String name, String idNumber, int age, String sex, String department) {
        this.name = name;
        this.idNumber = idNumber;
        this.age = age;
        this.sex = sex;
        this.department = department;
    }

    public String getName() {
        return name;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public int getAge() {
        return age;
    }

    public String getSex() {
        return sex;
    }

    public String getDepartment() {
        return department;
    }

    // Abstract method to be implemented by subclasses
    abstract String getStudentType();

    @Override
    public String toString() {
        return "Name: " + name + ", ID: " + idNumber + ", Age: " + age + ", Sex: " + sex + ", Department: " + department;
    }
}

// Subclass for undergraduate students
class UndergraduateStudent extends Student {
    public UndergraduateStudent(String name, String idNumber, int age, String sex, String department) {
        super(name, idNumber, age, sex, department);
    }

    @Override
    String getStudentType() {
        return "Undergraduate Student";
    }
}

// Subclass for graduate students
class GraduateStudent extends Student {
    public GraduateStudent(String name, String idNumber, int age, String sex, String department) {
        super(name, idNumber, age, sex, department);
    }

    @Override
    String getStudentType() {
        return "Graduate Student";
    }
}

// Class representing the student registration system
class StudentRegistrationSystem {
    private List<Student> students;

    public StudentRegistrationSystem() {
        students = new ArrayList<>();
    }

    public void registerStudent(Student student) {
        students.add(student);
        System.out.println("Student registered successfully.");
    }

    public void deleteStudent(String idNumber) {
        for (Student student : students) {
            if (student.getIdNumber() == idNumber) {
                students.remove(student);
                System.out.println("Student deleted successfully.");
                return;
            }
        }
        System.out.println("Student with ID " + idNumber + " not found.");
    }

    public void displayAllStudents() {
        if (students.isEmpty()) {
            System.out.println("No students registered.");
        } else {
            System.out.println("Registered Students:");
            for (Student student : students) {
                System.out.println(student);
            }
        }
    }
}
// user defined exception class InvalidAgeException
class InvalidAgeException extends Exception {
      public InvalidAgeException(String s){
          // calling constructor of Exception superclass
             super(s);
        }
     }

public class StudentRegistrationSystemApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentRegistrationSystem registrationSystem = new StudentRegistrationSystem();

        while (true) {
            System.out.println("1. Register Student");
            System.out.println("2. Delete Student");
            System.out.println("3. Display All Students");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Enter student name: ");
                    String name = scanner.next();
                    System.out.print("Enter student ID: ");
                    String idNumber = scanner.next();
                    System.out.print("Enter student age: ");
                       int age = scanner.nextInt();
                    try {
                       if(age <= 15)
                              throw new InvalidAgeException("invalid age");
                     }
                    catch(Exception ex){
                        System.out.println("please enter age above or equal to 15");
                        System.out.println("Enter student age:");
                        age = scanner.nextInt();
                    }
                    System.out.print("Enter student sex: ");
                    String sex = scanner.next();
                    System.out.print("Enter student department: ");
                    String department = scanner.next();

                    System.out.print("Enter student type (U for Undergraduate, G for Graduate): ");
                    String studentType = scanner.next();
                    Student student;
                    if (studentType.equalsIgnoreCase("U")) {
                        student = new UndergraduateStudent(name, idNumber, age, sex, department);
                    } else if (studentType.equalsIgnoreCase("G")) {
                        student = new GraduateStudent(name, idNumber, age, sex, department);
                    } else {
                        System.out.println("Invalid student type.");
                        continue;
                    }
                    registrationSystem.registerStudent(student);
                    break;

                case 2:
                    System.out.print("Enter student ID to delete: ");
                    String idToDelete = scanner.next();
                    registrationSystem.deleteStudent(idToDelete);
                    break;

                case 3:
                    registrationSystem.displayAllStudents();
                    break;

                case 4:
                    System.out.println("Exiting program.");
                    System.exit(0);

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
