import java.util.*;
class Question{
    String question;
    String options[];
    int correctAnswer;

    public Question(String question,String options[], int correctAnswer){
    this.question = question;
    this.options = options;
    this.correctAnswer = correctAnswer;
    }
}

public class quizQuestion {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
       

        //Question and options
        String questions[]= {"What is the full form of CU? ",
                            "What is the capital of India? ", 
                            " What is the colour of sky? "};
       
        String options[][]={
                       {"1.Central University","2.Control Unit","3.Computing Unit","4.Command Unit"},
                       {"1.Mumbai","2.Kolkata","3.New Delhi","4.Chennai"},
                       {"1.Blue","2.Yellow","3.Red","4.Green"} 
                       };
        int ans[]={2,3,1};
                       
        int score=0;
        Question[] ques = new Question[questions.length];

        for(int i=0;i<questions.length;i++){
            ques[i]=new Question(questions[i], options[i], ans[i]);
        }
    //Display both parts

     for(int i=0;i<questions.length;i++){
        System.out.println("Question " + (i+1) +": " + ques[i].question );
        for(int j=0;j<ques[i].options.length;j++){   
        System.out.println(ques[i].options[j]);
      }  

      //Timer 

      Timer t=new Timer();
      t.schedule(new TimerTask() {
        public void run(){
            System.out.println("\nTime's up!");
            t.cancel();
            System.exit(0);
        } 
      }, 10*1000);
    
      System.out.println("Enter your answer: ");
      int userAnswer= sc.nextInt();
      t.cancel();

      if (userAnswer==ques[i].correctAnswer) {
         System.out.println("Correct Answer!!");
         score++;
        }
        else{
            System.out.println("Incorrect Answer!!");
        }
    }
     System.out.println("Total Score: " + score + "/3");
      }
}

