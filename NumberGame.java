import java.util.*;
public class NumberGame {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        //random number
        Random r= new Random();
        //playAgain loop
        boolean playAgain= true;
        int totalScore=0;
        int roundsPlayed=0;
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
            System.out.println("Your guess was too low.");
            if (attempts< totalAttempts) {
            System.out.println("Try again!!");
           }
           else {
            System.out.println("You have reached the limit of attempts");
            int score = totalAttempts - attempts ;
            totalScore += score;
            roundsPlayed ++;
            System.out.println("Your score for this round is "+ score);
           }
             }
        else if (x>randNumber) {
            System.out.println("Your guess was too high");
            if (attempts< totalAttempts) {
                System.out.println("Try again!!");
               }
               else {
                System.out.println("You have reached the limit of attempts");
                int score = totalAttempts - attempts ;
                totalScore += score;
                roundsPlayed ++;
                System.out.println("Your score for this round is "+ score);
            }
            }
            else{
                System.out.println("Correct guess");
                int score = totalAttempts - attempts ;
                totalScore += score;
                roundsPlayed ++;
                System.out.println("Your score for this round is "+ score);
            break;
            }
        }
    
         System.out.println("Do you want to play again?(Y/N): ");
         String playAgainResponse= sc.next();
         playAgain= playAgainResponse.equals("Y");
}
}
}