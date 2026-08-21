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

    Account account1 = new Account("Bishesh", 1000);
    Account account2 = new Account("Bishesh2", 90000);

    Scanner scanner = new Scanner(System.in);
    
      System.out.println("Users are: ");
      System.out.println("1. Bishesh ");
      System.out.println("2. Bishesh2 ");

      int choice = scanner.nextInt();

    switch(choice){
      case 1 -> account1.displayDetails();
      case 2 -> account2.displayDetails();
      default -> System.out.println("Wrong input");
    }

    scanner.close();

  }
  
}
