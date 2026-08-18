import java.util.Scanner;

public class GuessMyNumber {
  public static void main(String[] args) {
    int myNumber = (int) (Math.random() * 101);
    Scanner sc = new Scanner(System.in);
    int yourNumber = 0;
    int attempts = 0;

    do {
      System.out.println("Guess my number:(0-100) or type a negative number to quit.");
      yourNumber = sc.nextInt();
      attempts++;

      if (yourNumber < 0) {
        System.out.println("You quit the game. The number was " + myNumber);
        System.out.println("Total attempts: " + attempts);
        break;
      }

      else if (yourNumber > myNumber) {
        System.out.println(yourNumber + " is greater than my number.");
        System.out.println("Attempt number: " + attempts)
      }

      else if (yourNumber < myNumber) {
        System.out.println(yourNumber + " is smaller than my number.");
        System.out.println("Attempt number: " + attempts);
      }

      else {
        System.out.println("WooHooo!!! " + yourNumber + " is the correct number.");
        System.out.println("You've guessed it in " + attempts + " tries.");
        break;
      }
    } while (yourNumber >= 0);

    sc.close();

  }
}
