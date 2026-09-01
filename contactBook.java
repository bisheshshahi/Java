import java.util.ArrayList;
import java.util.Scanner;

class Contact{
  String name;
  int number;

  Contact(String name, int number){
    this.name = name;
    this.number = number;
  }
}

public class contactBook {

  static ArrayList<Contact> contacts = new ArrayList<>();
  static Scanner scanner = new Scanner(System.in);
  public static void main(String[] args){

    boolean isTrue = true;

    while(isTrue){
      System.out.println("1. Add contact");
      System.out.println("2. Display contacts");
      System.out.println("3. Remove contacts");
      System.out.println("4. Exit");

      System.out.print("Enter your choice: ");
      int choice = scanner.nextInt();
      scanner.nextLine();

      switch(choice){

        case 1{
          addContact();
          break;
        }

        case 2{
          diplayContacts();
          break;
        }

        case 3{
          removeContact();
          break;
        }

        case 4{
          isTrue = false;
          System.out.println("Goodbye!!");
        }

        default{
          System.out.println("Invalid choice");
        }
      }

      }


    }

  }

}
