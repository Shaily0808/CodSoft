import java.util.*;
public class NumberGame {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        //random number
        Random r= new Random();
        //playAgain loop
        boolean playAgain= true;
        int totalScore=5;
        while (playAgain) {
        int randNumber= r.nextInt(100);
        //prompt user
        int totalAttempts = 5;
        int attempts=0;
        while (attempts< totalAttempts) {
            attempts++;
        System.out.println("\nAttempt " + attempts+ " :Guess a number between 1 and 100");
        int x= sc.nextInt();
        if (x<randNumber) {
            System.out.println("Your guess was too low");
            totalScore --;
            if (attempts< totalAttempts) {
            System.out.println("Try again!!");
           }
           else {
            System.out.println("\nYou have reached the limit of attempts\n");
            System.out.println("Your score for this round is "+ totalScore);
           }
             }
        else if (x>randNumber) {
            System.out.println("Your guess was too high");
            totalScore --;
            if (attempts< totalAttempts) {
                System.out.println("Try again!!");
               }
               else {
                System.out.println("\nYou have reached the limit of attempts\n");
                System.out.println("Your score for this round is "+ totalScore);
            }
            }
            else{
                System.out.println("Correct guess");
                 System.out.println("Your score for this round is "+ totalScore);
            break;
            }
        }
    
         System.out.println("Do you want to play again?(Y/N): ");
         String playAgainResponse= sc.next();
         playAgain= playAgainResponse.equals("Y");
}
}
}
