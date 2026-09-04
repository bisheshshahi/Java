/*
Add contacts
Display contacts
Search contacts
Delete contacts
Save contacts to a file
Load contacts when the program starts again
*/

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

class Contact{
  String name;
  String number;

  Contact(String name, String number){
    this.name = name;
    this.number = number;
  }
}

public class ContactBook {

  static ArrayList<Contact> contacts = new ArrayList<>(); 
  static Scanner scanner = new Scanner(System.in);

  public static void main(String[] args){

    boolean isTrue = true;

    while(isTrue){
      
      System.out.println("1. Add contact");
      System.out.println("2. Display contacts");
      System.out.println("3. Search contact");
      System.out.println("4. Delete contact");
      System.out.println("5. Save contacts");
      System.out.println("6. Load contacts");
      System.out.println("7. Exit");

      System.out.print("Enter your choice: ");

      try{
        int choice = scanner.nextInt();
        scanner.nextLine();

        switch(choice){

        case 1:
          addContact();
          break;

        case 2:
          displayContacts();
          break;
        
        case 7:
          isTrue = false;
      }

      }
      catch(InputMismatchException e){
        System.out.println("Invalid choice");
        scanner.nextLine();
      }
      
    }

    scanner.close();

  }

  static void addContact(){

    System.out.print("Enter name: ");
    String name = scanner.nextLine();

    System.out.print("Enter number: ");
    String number = scanner.nextLine();

    contacts.add(new Contact(name , number));
    System.out.println("Contact added successfully");
  }

  static void displayContacts(){
    
    for(Contact contact: contacts){
      System.out.println("Name: " + contact.name);
      System.out.println("Number: " + contact.number);
      System.out.println();
    }
  }
  
}
