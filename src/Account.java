import java.util.Scanner;

public class Account {
        String customerName;
        int balance;
        int previousTransaction;

    Scanner scanner = new Scanner(System.in);

    public Account(String customerName) {
        this.customerName = customerName;
    }
    //Deposit
    public void deposit(int amount){
        if(amount>0){
            balance = balance+amount;
            previousTransaction = amount;
            System.out.println("New balance : " + balance);
        }
        else {
            System.out.println("Deposit amount must be greater than 0");
        }
    }
    //Withdraw
    public void withdraw(int amount){
        if(amount>0){
            balance = balance-amount;
            previousTransaction = -amount;
            System.out.println("New balance : " + balance);
        }
        else {
            System.out.println("Withdraw amount must be greater than 0");
        }
    }
    //Show previous transaction
    public void getPreviousTransaction(){
        if (previousTransaction>0){
            System.out.println("Deposited : " + previousTransaction);
        } else if (previousTransaction<0) {
            System.out.println("Withdrew : " + previousTransaction );
        }
        else {
            System.out.println("No transaction");
        }
    }
    //Interest
    public void intereset(int years){
        double interestRate = 0.50;
        double newBalance = (balance * interestRate * years) + balance;
        System.out.println("Balance after " + years + " years : " + newBalance);
    }
    //Menu
    public void showMenu(){
        System.out.println("Welcome " + customerName);
        String options = "1.Deposit\n"
                +"2.Withdraw\n"
                +"3.Interest\n"
                +"4.Show balance\n"
                +"5.Show previous\n"
                +"6.Show options\n"
                +"7.Exit(press e)";
        System.out.println(options);
        while (true){
            System.out.print("Please select : ");
            String input = scanner.nextLine();
            if (input.equals("1")){
                System.out.print("Deposit amount : ");
                int amount = scanner.nextInt();
                deposit(amount);
                scanner.nextLine();
            } else if (input.equals("2")) {
                System.out.print("Withdraw amount : ");
                int amount = scanner.nextInt();
                if (amount>balance) {
                    System.out.println("Withdraw amount cannot be greater than total balance");
                    scanner.nextLine();
                    continue;
                }
                withdraw(amount);
                scanner.nextLine();
            } else if (input.equals("3")) {
                System.out.print("Number of years : ");
                int years = scanner.nextInt();
                intereset(years);
                System.out.println("New balance : " + balance);
                scanner.nextLine();
            } else if (input.equals("4")) {
                System.out.println("Your balance is : " + balance );
            } else if (input.equals("5")) {
                System.out.println("Previous transaction is :");
                getPreviousTransaction();
            } else if (input.equals("6")) {
                System.out.println(options);
            } else if (input.equals("e")) {
                System.out.println("Exiting the app");
                break;
            }
            else {
                System.out.println("Wrong input");
                break;
            }
        }
    }
}
