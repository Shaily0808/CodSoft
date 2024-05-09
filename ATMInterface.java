import java.util.*;
class BankAcc{
    private double balance;

    public BankAcc(double balance){
        this.balance= balance;
    }
    // deposit
    public void  amountDeposit(double amount){
        balance= balance + amount;
    System.out.println("Deposit of Rs" + amount + " successful");
    System.out.println("Current balance: Rs" + balance);
    }
    // withdraw
    public void withdraw(double amount){
        if (balance >= amount) {
            balance = balance - amount;
        System.out.println("Withdraw of Rs" + amount + " successful.");
        System.out.println("Current balance: Rs" + balance);
        }
        else{
        System.out.println("Insufficient balance in account. Withdraw unsuccessful.");
        }    
    }
      //check balance
    public double checkBalance(){
    return balance;
        }
    } 
   
class ATM{
   
    private BankAcc account;

    public ATM(BankAcc account){
        this.account= account;
    }
    Scanner sc= new Scanner(System.in);
    
    // Menu of methods
    public void displayMenu(){
        System.out.println("\n1. Deposit Amount");
        System.out.println("2. Withdraw Amount");
        System.out.println("3. Check balance");
        System.out.println("4. Exit");
    }

    // methods to be performed in each case
    public void handleChoice(int choice){
        switch (choice) {
            case 1:
               System.out.println("Enter the amount you want to deposit");
                double depositAmount= sc.nextDouble();
                account.amountDeposit(depositAmount);
                break;
             
             case 2:
               System.out.println("Enter the amount you want to withdraw");
                 double withdrawalAmount = sc.nextDouble();
                 account.withdraw(withdrawalAmount); 
                 break;
                  
             case 3:
               System.out.println("Available balance is Rs" + account.checkBalance());    
              break;

             case 4: 
             System.out.println("Thank you!!");
             System.exit(0);
             break;

            default:
            System.out.println("Invalid choice. Try again!");
                break;
        }
    }

}

     class ATMInterface{
        public static void main(String[] args) {
            BankAcc bankAcc = new BankAcc(1000.0);
            ATM atm = new ATM(bankAcc);
            Scanner sc = new Scanner(System.in);
            while (true) {
            atm.displayMenu();
            System.out.println("\nEnter your choice: ");
            int choice = sc.nextInt();
            atm.handleChoice(choice);

        }
     }
    }
    
