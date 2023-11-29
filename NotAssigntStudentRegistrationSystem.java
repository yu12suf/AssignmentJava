import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
class Student{
    private String name;
    private int age;
    private String registrationNumber;
    public Student(String name, int age, String registrationNumber){
        this.name = name;
        this.age = age;
        this.registrationNumber = registrationNumber;
       }
    public String getName(){
        return name;
       }
    public int getAge(){
        return age;
       }
    public String getRegistrationNumber(){
        return registrationNumber;
       }
    }
class StudentRegistrationSystem{
    private List<Student> studentList;
    public StudentRegistrationSystem(){
        studentList = new ArrayList<>();
       }
    public void registerStudent(String name, int age, String registrationNumber){
        Student student = new Student(name, age, registrationNumber);
        studentList.add(student);
        System.out.println("student registered successfully!");
       }
    public void deleteStudent(String registrationNumber){
        Iterator<Student> iterator = studentList.iterator();
        while(iterator.hasNext()){
            Student student = iterator.next();
            if(student.getRegistrationNumber().equals(registrationNumber)){
                  iterator.remove();
                  System.out.println("student deleted successfully!");
                  return;
                 }
               }
                System.out.println("student not found.");
             }
    public void displayStudents(){
       if(studentList.isEmpty()){
             System.out.println("No students registered.");
            }
       else
            {
            System.out.println("Registered students: ");
            for(Student student: studentList){
                 System.out.println("Name: "+student.getName());
                 System.out.println("Age: "+student.getAge());
                 System.out.println("Registration Number: "+student.getRegistrationNumber());
                 System.out.println("..............................................");
                }
              }
            }
         }
 public class Main{
     public static void main(String[] args){
        StudentRegistrationSystem registrationSystem = new StudentRegistrationSystem();
        Scanner scanner = new Scanner(System.in);
        while(true){
             System.out.println("...........Student Registration System................");
             System.out.println("1.Register Student");
             System.out.println("2.Delete Student");
             System.out.println("3.Display registered students");
             System.out.println("4.Exit");
             System.out.println("Enter your choice: ");
             int choice = scanner.nextInt();
             scanner.nextLine();  // consume the newline character
             switch(choice){
                 case 1:
                      System.out.print("Enter student name: ");
                      String name = scanner.nextLine();
                      System.out.print("Enter student age: ");
                      int age = scanner.nextInt();
                      scanner.nextLine();  // consume the newline character
                      System.out.print("Enter registration number: ");
                      String registrationNumber = scanner.nextLine();
                      registrationSystem.registerStudent(name, age, registrationNumber);
                      break;
                 case 2:
                      System.out.print("Enter registration number of student to delete: ");
                      String regNumber = scanner.nextLine();
                      registrationSystem.deleteStudent(regNumber);
                      break;
                 case 3:
                      registrationSystem.displayStudents();
                      break;
                 case 4:
                      System.out.println("Exiting program...");
                      System.exit(0);
                      break;
                 default:
                      System.out.println("Invalid choice. please try again.");
                  }
               }
            }
           } 
