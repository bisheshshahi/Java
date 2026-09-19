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
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;

// Represents one contact with a name and a number
class Contact{
  String name;
  String number;

  Contact(String name, String number){
    this.name = name;
    this.number = number;
  }

  @Override 
  public String toString(){
    return "Name: " + name + "\nNumber: " + number;
  }
}

public class ContactBook {

  // Holds all contacts while the program is running
  static ArrayList<Contact> contacts = new ArrayList<>(); 
  static Scanner scanner = new Scanner(System.in);

  public static void main(String[] args){

    loadContacts();
    boolean isTrue = true;

    // Keeps showing the menu until the user chooses to exit
    while(isTrue){
      
      System.out.println("1. Add contact");
      System.out.println("2. Display contacts");
      System.out.println("3. Search contact");
      System.out.println("4. Delete contact");
      System.out.println("5. Update contact");
      System.out.println("6. Exit");

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

        case 5:
          updateContact();
          break;

        case 6:
          isTrue = false;
          System.out.println("Bye bye!!!");
          break;

        default:
          System.out.println("Invalid choice");
          System.out.println("Please enter a number from 1 to 6");
       }

      }
      // Catches it if the user types letters/symbols instead of a number
      catch(InputMismatchException e){
        System.out.println("Wrong input!!!");
        System.out.println("Please enter integer from (1-6)");
        scanner.nextLine();
      }
      
    }

    scanner.close();

  }

  // Keeps asking until the user types something that isn't blank
  static String readNonEmptyLine(String prompt){
    String input;
    while(true){
      System.out.print(prompt);
      input = scanner.nextLine().trim();

      if(input.isEmpty()){
        System.out.println("This field can't be empty. Please try again.");
      }
      else{
        return input;
      }
    }
  }

  // Name should contain only letters and spaces
  static String readValidName(String prompt){
    String input;
    while(true){
      input = readNonEmptyLine(prompt);

      if(!input.matches("[a-zA-Z ]+")){
        System.out.println("Name should only contain letters and spaces.");
      }
      else{
        return input;
      }
    }
  }

  // Number should be digits only, exactly 10 digits
  static String readValidNumber(String prompt){
    String input;
    while(true){
      input = readNonEmptyLine(prompt);

      if(!input.matches("[0-9]{10}")){
        System.out.println("Invalid number. Use digits only, exactly 10 digits long,");
        System.out.println("e.g. 9812345678");
      }
      else{
        return input;
      }
    }
  }

  // Checks if a contact with this name is already saved, so we don't add it twice
  static boolean nameExists(String name){
    for(Contact contact : contacts){
      if(contact.name.equalsIgnoreCase(name)){
        return true;
      }
    }
    return false;
  }

  // Asks for a name and number, then adds the new contact to the list
  static void addContact(){

    String name;

  while(true){
    name = readValidName("Enter name: ");

    if(nameExists(name)){
      System.out.println("A contact with this name already exists. Contact not added.");
    }
    else{
      break;
    }
  }

    String number = readValidNumber("Enter number: ");

    contacts.add(new Contact(name , number));
    System.out.println("Contact added successfully");

    saveContacts();
  }

  // Prints every contact currently in the list
  static void displayContacts(){
    
    if(contacts.isEmpty()){
      System.out.println("No contacts are here");
      System.out.println("Add contacts to see them");
    }
    else{
      for(Contact contact: contacts){
        System.out.println(contact);
        System.out.println();
      }  
    }
  }

  // Looks for contacts whose name contains what the user typed (partial match allowed)
  static void searchContact(){

    if(contacts.isEmpty()){
      System.out.println("Zero contacts found");
      System.out.println("Please first add contacts before searching them");
    }

    else{
    String name = readNonEmptyLine("Enter the name of the person: ");
    boolean found = false;

    for(Contact contact : contacts){
      if(contact.name.toLowerCase().contains(name.toLowerCase())){
        System.out.println("Contact found!!!");
        System.out.println(contact);
        System.out.println();
        found = true;
      }
    }
    if(!found){
      System.out.println("Contact not found");
    }
  }
}

  // Finds a contact by exact name and removes it from the list
  static void removeContact(){

    if(contacts.isEmpty()){
      System.out.println("Zero contacts found");
    }

    else{

    boolean found = false;

    String name = readNonEmptyLine("Enter the name of the contact: ");

    for(int i = 0 ; i < contacts.size() ; i++){
        if(name.equalsIgnoreCase(contacts.get(i).name)){
          contacts.remove(i);
          found = true;
          System.out.println("Contacts removed successfully");
          saveContacts();
          break;
        }
      }
      if(!found){
        System.out.println("Contact not found");
      }
    }
  }

  //updates an existing contact's name and number
  static void updateContact(){
    if(contacts.isEmpty()){
      System.out.println("Zero contacts found!!!");
      return;
    }

    String oldName = readValidName("Enter the name of the contact you want to update: ");
    boolean found = false;

    for(Contact contact : contacts){
      if(contact.name.equalsIgnoreCase(oldName)){
        System.out.println("Contact found!!!");
        System.out.println(contact);
        System.out.println();

        String newName = readValidName("Enter new name: ");

        boolean isDuplicate = false;
        for(Contact c : contacts){
          if(c != contact && c.name.equalsIgnoreCase(newName)){
            isDuplicate = true;
            break;
          }
        }

        if(isDuplicate){
          System.out.println("A contact with this name already exists! Update cancelled.");
          return;
        }

        String newNumber = readValidNumber("Enter new number: ");

        contact.name = newName;
        contact.number = newNumber;

        System.out.println("Contact updated successfully!!!");

        saveContacts();

        found = true;
        break;
      }
    }

    if(!found){
      System.out.println("Contact not found!!!");
    }
}

  // Writes all current contacts to contacts.txt so they aren't lost when the program closes
  static void saveContacts(){

    try{
    BufferedWriter writer = new BufferedWriter(new FileWriter  ("contacts.txt"));

    for(Contact contact : contacts){
      writer.write("Name: " + contact.name);
      writer.newLine();

      writer.write("Number: " + contact.number);
      writer.newLine();

      writer.newLine();
    }
    
    writer.close();
    System.out.println("Contacts saved successfully!!!");
  } 
  catch(IOException e){
    System.out.println("Error while saving contacts");
   }
  }

  // Reads contacts.txt when the program starts, so old contacts show up again
  static void loadContacts(){

    try{
    BufferedReader reader = new BufferedReader(new FileReader("contacts.txt"));

    String nameLine;

    while((nameLine = reader.readLine()) != null){
      if(nameLine.isEmpty()){
        continue;
      }

      String numberLine = reader.readLine();

      // Cuts off the "Name: " and "Number: " labels to keep just the actual value
      String name = nameLine.substring(6);
      String number = numberLine.substring(8);

      contacts.add(new Contact(name, number));
    }

    reader.close();

    System.out.println("Contacts loaded successfully!!!");
  }
  // Happens the very first time the program runs, before contacts.txt exists yet
  catch(FileNotFoundException e){
    System.out.println("No contacts file found");
  }

  catch(IOException e){
    System.out.println("Error while loading contacts");
    }
  }
}