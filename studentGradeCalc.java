import java.util.*;
public class studentGradeCalc {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);

        //number of subjects
        System.out.println("Enter the number of subjects");
        int x= sc.nextInt();
        Float[] marks= new Float[x];

        // marks of each subject
        for(int i=0;i<x;i++){
        System.out.println("Enter marks for subject "+ (i+1));
        marks[i]= sc.nextFloat();
       }
       double  sumMarks =0;
       for(int i=0; i<x ; i++){
        sumMarks += marks[i];
       }
       double averagePercentage = (double) sumMarks / x;

       //marks and averagePercentage display
       System.out.println("\nTotal marks obtained: " + String.format( "%.2f",sumMarks));
       System.out.println("Average percentage is: " +  String.format( "%.2f", averagePercentage));
       
       //Grades assigned
       if (averagePercentage <= 90.00 && averagePercentage <= 100.00) {
        System.out.println("Grade: O" );
         }
         else if (averagePercentage >80.00  && averagePercentage <= 91.00) {
            System.out.println("Grade: E");
         }
         else if (averagePercentage > 70 && averagePercentage <= 81.00) {
            System.out.println("Grade: A");
         }
         else if (averagePercentage > 60 && averagePercentage <= 71.00) {
            System.out.println("Grade: B");
         }
         else if (averagePercentage > 50 && averagePercentage <= 61.00) {
            System.out.println("Grade: C");
         }
         else if (averagePercentage > 40 && averagePercentage <= 51.00) {
            System.out.println("Grade: D");
         }
         else{
            System.out.println("Fail");
         }
}
}