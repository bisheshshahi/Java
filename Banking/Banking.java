import java.util.Scanner;

public class Banking {

  // so every method can access it
  static Scanner scanner = new Scanner(System.in);
  public static void main(String[] args){

    double balance = 0;
    boolean isRunning = true;
    int choice; 

    System.out.println("Banking program");
    System.out.println("1. Show balance");
    System.out.println("2. Deposit");
    System.out.println("3. Withdraw");
    System.out.println("4. Exit");

    while(isRunning){

      System.out.print("Enter a choice(1-4): ");
    choice = scanner.nextInt();

    switch(choice){
      case 1 -> showBalance(balance);
      case 2 -> balance += deposit();
      case 3 -> balance -= withdraw(balance);
      case 4 -> isRunning = false;
      default -> System.out.println("Invalid choice");
    }
    
  }
  System.out.println("Thank you have a nice day!");
  scanner.close();

  }

  static void showBalance(double balance){
    System.out.printf("Rs. %.2f\n", balance);
  }

  static double deposit(){

    double amount;

    System.out.print("Enter the amount to be deposited: ");
    amount = scanner.nextDouble();

    if(amount <= 0){
      System.out.println("Amount can't be deposited");
      return 0;
    }
    else{
      return amount;
    }
  }

  static double withdraw(double balance){

    double amount;

    System.out.print("Enter amount to be withdrawn: ");
    amount = scanner.nextDouble();

    if(amount<0){
      System.out.println("Withdrawal amount can' be negative");
      return 0;
    }
    
    else if(amount == 0){
      System.out.println("Withdrawal amount can't be zero");
      return 0;
    }

    else if(amount>balance){
      System.out.println("Insufficient balance");
      return 0;
    }

    else{
      return amount;
    }
  }


}
