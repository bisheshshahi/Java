/*Add student
Remove student
Search student by ID/name
Update student information
Display all students
Calculate/display average marks
Find highest/lowest scorer */

import java.util.ArrayList;
import java.util.Scanner;
import java.util.InputMismatchException;

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
      try{
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

          case 3:
            System.out.print("Enter 1 to search the student via id: ");
            System.out.print("Enter 2 to search the student via name: ");
            int searchStudent = scanner.nextInt();
            scanner.nextLine();

           if (searchStudent == 1){
            System.out.print("Enter the id of the student: ");
            int studentId = scanner.nextInt();
            scanner.nextLine(); 
            boolean studentFound = false;

            for(Student student : students){
              if(student.id == studentId){
                System.out.println("Name: " + student.name);
                System.out.println("Id: " + student.id);
                System.out.println("Marks: " + student.marks);
                studentFound = true;
                break;
              }
            }
            if(!studentFound){
              System.out.println("Student of " + studentId + " id not found");
            }
           } else if (searchStudent == 2) {
              System.out.print("Enter the name of the student: ");
              String studentName = scanner.nextLine();
              boolean studentFound = false;

              for(Student student : students){
                if(student.name.equalsIgnoreCase(studentName)){
                  System.out.println("Name: " + student.name);
                  System.out.println("Id: " + student.id);
                  System.out.println("Marks: " + student.marks);
                  studentFound = true;
                  break;
                }
              }
              if(!studentFound){
              System.out.println("Student of " + studentName + " name not found");
            }
           }
           break;

          case 4:
            System.out.print("Enter the id of the student you want to update: ");
            int updateId = scanner.nextInt();
            scanner.nextLine();
            boolean update = false;

            for(Student student : students){
              if(student.id == updateId){
                System.out.print("Enter new name: ");
                student.name = scanner.nextLine();

                System.out.print("Enter new marks: ");
                student.marks = scanner.nextDouble();
                scanner.nextLine();
                update = true;
                break;
              }
            }
            if(!update){
              System.out.println("Student of id " + updateId + " not found");
            }
            break;

          case 5:
            if(students.isEmpty()){
              System.out.println("No students available");
            }else{
              for(Student student : students){
                  System.out.println("Name: " + student.name);
                  System.out.println("Id: " + student.id);
                  System.out.println("Marks: " + student.marks);
                  System.out.println();
                }
             }
            break;

          case 6:
             if(students.isEmpty()){
               System.out.println("No students available");
              }else{
               double totalMarks = 0;
        
               for(Student student : students){
                  totalMarks += student.marks;
               }
                double average = totalMarks / students.size();
                System.out.println("Average marks: " + average);
              }
           break;

          case 7:
            if(students.isEmpty()){
              System.out.println("No students available");
            }else{
                Student highest = students.get(0);
               for(Student student : students){
                 if(student.marks > highest.marks){
                    highest = student;
                    }
                }
            System.out.println("Highest Scorer:");
            System.out.println("Name: " + highest.name);
            System.out.println("Id: " + highest.id);
            System.out.println("Marks: " + highest.marks);
           }
           break;

          case 8:
            if(students.isEmpty()){
             System.out.println("No students available");
             }else{
               Student lowest = students.get(0);
                  for(Student student : students){
                    if(student.marks < lowest.marks){
                      lowest = student;
                        }
                  }
            System.out.println("Lowest Scorer:");
            System.out.println("Name: " + lowest.name);   
            System.out.println("Id: " + lowest.id);
            System.out.println("Marks: " + lowest.marks);
           }
          break;

          case 9:
            isTrue = false;
            break;

          default:
            System.out.println("Invalid choice. PLease try again.");
            
        }
    }
      catch(InputMismatchException e){
        System.out.println("Please enter valid integer(1-9)");
        scanner.nextLine();
  }
  }



    scanner.close();

  }
  
}
