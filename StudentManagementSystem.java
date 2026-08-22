/*Add student
Remove student
Search student by ID/name
Update student information
Display all students
Calculate/display average marks
Find highest/lowest scorer */

import java.util.ArrayList;
import java.util.Scanner;

class Student{
  String name;
  int id;
  double marks;

  Student(String name, int id, double marks){
    this.name = name;
    this.id = id;
    this.marks = marks;
  }
}

public class StudentManagementSystem {
  public static void main(String[] args){

    boolean isTrue = true;
    ArrayList<Student> students = new ArrayList<>();

    Scanner scanner = new Scanner(System.in);

    while(isTrue){
        System.out.println("\n===== STUDENT MANAGEMENT SYSTEM =====");
        System.out.println("1. Add Student");
        System.out.println("2. Remove Student");
        System.out.println("3. Search Student");
        System.out.println("4. Update Student");
        System.out.println("5. Display All Students");
        System.out.println("6. Calculate Average Marks");
        System.out.println("7. Find Highest Scorer");    
        System.out.println("8. Find Lowest Scorer");
        System.out.println("9. Exit");

        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine();

        switch(choice){
          case 1:
            System.out.print("Enter student name: ");
            String name = scanner.nextLine();

            System.out.print("Enter student id: ");
            int id = scanner.nextInt();

            System.out.print("Enter student marks: ");
            double marks = scanner.nextDouble();

            students.add(new Student(name, id, marks));
            break;

          case 2:
            System.out.print("Enter the id of the student you want to remove: ");
            int removeId = scanner.nextInt();
            boolean found = false;

            
            for(int i=0; i<students.size(); i++){

              if(students.get(i).id == removeId){

                students.remove(i);
                found = true;

                System.out.println("Student removed successfully");
                break;

              }
            }

            if(!found){
              System.out.println("Student of this " + removeId + " id not found");
            }
            break;

          case 5:
            for(Student student : students){
              System.out.println("Name: " + student.name);
              System.out.println("Id: " + student.id);
              System.out.println("Marks: " + student.marks);
              System.out.println();
            }
            break;

          case 9:
            isTrue = false;
            break;

          default:
            System.out.println("Invalid choice. PLease try again.");
            
        }
    }

    scanner.close();

  }
  
}
