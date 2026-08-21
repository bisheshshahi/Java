/*Different users should have different accounts
  Every account should have deposit and withdraw
  Balance should be tracked
*/

import java.util.Scanner;

class Account{

  private String name;
  private double balance;

  Account(String name, double balance){
    this.name = name;
    this.balance = balance;
  }

  void displayDetails(){
    System.out.println("Name: " + name + " Balance: " + balance);
  }

  void deposit(double amount){
     balance += amount;
  }

  void withdraw(double amount){
    if(amount <= balance){
      balance -= amount;
    }  else{
      System.out.println("Balance is not enough");
    }
  }

}

public class BankAccountSystem {
  public static void main(String[] args){
    
    boolean isTrue = true;    //to run the while loop

    Account account1 = new Account("Bishesh", 1000);
    Account account2 = new Account("Bishesh2", 90000);

    Scanner scanner = new Scanner(System.in);

    while(isTrue){
      System.out.println("Enter (1-3) ");

      System.out.println("1. View bishesh's details");
      System.out.println("2. View bishesh2's details ");
      System.out.println("3. Exit");
      
      System.out.println("Enter your choice: ");
      int choice = scanner.nextInt();

      switch(choice){
        case 1 -> account1.displayDetails();
        case 2 -> account2.displayDetails();
        case 3 -> isTrue = false;
        default -> System.out.println("Wrong input");
      }
    }

    System.out.println("Thank you have a nice day");
    scanner.close();

  }
  
}
