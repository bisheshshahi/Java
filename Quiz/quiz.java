import java.util.Scanner;

public class quiz {
  public static void main(String[] args){
    String[] questions = {
                          "1. What is the capital city of Nepal?",
                          "2. Which keyword is used to create a class in Java?",
                          "3. Which of these is a primitive data type in Java?",                                 
                          "4. Which symbol is used to end most Java statements?"
                          };

     String[][] options = {
            {"A. Pokhara", "B. Kathmandu", "C. Biratnagar", "D. Bharatpur"},
            {"A. define", "B. class", "C. create", "D. new"},
            {"A. String", "B. Array", "C. int", "D. Scanner"},
            {"A. :", "B. ,", "C. .", "D. ;"}
        };

      char answers[] = {'B','B','C','D'};
      int score = 0;
      char guess[] = new char[4];
      Scanner scanner = new Scanner(System.in);

      for (int i = 0 ; i < questions.length ; i++){

        System.out.println(questions[i]);

        for (String option : options[i]){
          System.out.println(option);
        }

        System.out.println(" ");

        guess[i] = scanner.next().toUpperCase().charAt(0);

        if (guess[i] == answers[i]){
          score++;
        }
      }
      
      System.out.println("Your score is " + score + "/" + questions.length);
    
      scanner.close();
    
  }
}
