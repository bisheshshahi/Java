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
        
        case 3:
          searchContact();
          break;
        
        case 4:
          removeContact();
          break;
        
        case 7:
          isTrue = false;
          System.out.println("Bye bye!!!");
          break;

        default:
          System.out.println("Invalid choice");
       }

      }
      catch(InputMismatchException e){
        System.out.println("Wrong input!!!");
        System.out.println("Please enter integer from (1-7)");
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

  static void searchContact(){

    System.out.print("Enter the name of the person: ");
    String name = scanner.nextLine();
    boolean found = false;

    for(Contact contact : contacts){
      if(name.equals(contact.name)){
        System.out.println("Contact found!!!");
        System.out.println("Name: " + contact.name);
        System.out.println("Number: " + contact.number);
        found = true;
        break;
      }

    }
    if(!found){
      System.out.println("Contact not found");
    }
  }

  static void removeContact(){
    boolean found = false;

    System.out.print("Enter the name of the contact: ");
    String name = scanner.nextLine();

    for(int i = 0 ; i < contacts.size() ; i++){
        if(name.equals(contacts.get(i).name)){
          contacts.remove(i);
          found = true;
          System.out.println("Contacts removed successfully");
          break;
        }
      }
      if(!found){
        System.out.println("Contact not found");
      }
    }
  
}
