import java.util.Scanner;

// Class to represent the user's bank account
class BankAccount
{
private double balance;

// Constructor to initialize account balance
public BankAccount(double initialBalance)
{
this.balance = initialBalance;
}

// Method to get the current balance
public double getBalance()
{
return balance;
}

// Method to deposit money into the account
public void deposit(double amount)
{
if (amount > 0)
{
balance += amount;
System.out.println("Successfully deposited $" + amount);
}
else
{
System.out.println("Invalid deposit amount. Must be positive.");
}
}

// Method to withdraw money from the account
public Boolean withdraw(double amount)
{
if (amount > 0 && amount <= balance)
{
balance -= amount;
System.out.println("Successfully withdrew $" + amount);
return true;
}
else if (amount > balance)
{
System.out.println("Insufficient balance. Withdrawal failed.");
}
else
{
System.out.println("Invalid withdrawal amount.");
}
return false;
}
}

// Class to represent the ATM machine
class ATM
{
private BankAccount account;

// Constructor to initialize ATM with a linked bank account
public ATM(BankAccount account)
{
this.account = account;
}

// Method to display the ATM interface and handle user actions
public void start()
{
Scanner scanner = new Scanner(System.in);
int choice;
do
{
System.out.println("\n--- Welcome to the ATM ---");
System.out.println("1. Check Balance");
System.out.println("2. Deposit Money");
System.out.println("3. Withdraw Money");
System.out.println("4. Exit");
System.out.println("Enter your choice: ");
choice = scanner.nextInt();
switch (choice)
{
case 1:
    checkBalance();
    break;
case 2:
    depositMoney(scanner);
    break;
case 3:
    withdrawMoney(scanner);
    break;
case 4:
    System.out.println("Thank you for using the ATM. Goodbye");
    break;
default:
    System.out.println("Invalid option. Please try again.");
}
}
while (choice != 4);
scanner.close();
}

// Method to check and display the current balance
private void checkBalance()
{
System.out.println("Current Balance: $" + account.getBalance());
}

// Method to deposit money into the account
private void depositMoney(Scanner scanner)
{
System.out.print("Enter the amount to deposit: ");
double amount = scanner.nextDouble();
account.deposit(amount);
}

// Method to withdraw money from the account
private void withdrawMoney(Scanner scanner)
{
System.out.print("Enter the amount to withdraw: ");
double amount = scanner.nextDouble();
account.withdraw(amount);
}
}

// Main class to run the program
public class ATMInterface
{
public static void main(String[] args)
{
// Initialize a bank account with a starting balance of $1000
BankAccount userAccount = new BankAccount(1000);

// Create an ATM object with the linked user's bank account
ATM atm = new ATM(userAccount);

// Start the ATM interface
atm.start();
}
}








 

 
