import java.util.Scanner;
import java.util.ArrayList;

// ─────────────────────────────────────────────
//  BankAccount class  –  core OOP component
// ─────────────────────────────────────────────
class BankAccount {

    // Private data members (Encapsulation / Data Hiding)
    private String accountHolderName;
    private String accountNumber;
    private double balance;
    private ArrayList<String> transactionHistory;

    // ── Constructors ──────────────────────────

    // Default constructor
    public BankAccount() {
        this.accountHolderName = "Unknown";
        this.accountNumber     = "000000";
        this.balance           = 0.0;
        this.transactionHistory = new ArrayList<>();
        transactionHistory.add("Account created with balance: Rs. 0.0");
    }

    // Parameterised constructor
    public BankAccount(String accountHolderName, String accountNumber, double initialBalance) {
        this.accountHolderName  = accountHolderName;
        this.accountNumber      = accountNumber;
        this.transactionHistory = new ArrayList<>();

        if (initialBalance >= 0) {
            this.balance = initialBalance;
            transactionHistory.add("Account created with initial balance: Rs. " + initialBalance);
        } else {
            this.balance = 0.0;
            transactionHistory.add("Account created with balance: Rs. 0.0 (invalid initial amount provided)");
            System.out.println("  [Warning] Initial balance cannot be negative. Balance set to Rs. 0.0");
        }
    }

    // ── Getter methods (Controlled Access) ────

    public String getAccountHolderName() { return accountHolderName; }
    public String getAccountNumber()     { return accountNumber;      }
    public double getBalance()           { return balance;            }

    // ── Banking Operations ─────────────────────

    /**
     * Deposit money into the account.
     * Validates that amount > 0 before updating balance.
     */
    public void deposit(double amount) {
        System.out.println("\n  --- Deposit Operation ---");
        if (amount <= 0) {
            System.out.println("  [Error] Invalid amount! Deposit amount must be greater than zero.");
        } else {
            balance += amount;
            String record = "Deposited: Rs. " + amount + " | Balance after deposit: Rs. " + balance;
            transactionHistory.add(record);
            System.out.println("  Rs. " + amount + " deposited successfully.");
            System.out.println("  Current Balance: Rs. " + balance);
        }
    }

    /**
     * Withdraw money from the account.
     * Validates positive amount AND sufficient balance.
     */
    public void withdraw(double amount) {
        System.out.println("\n  --- Withdrawal Operation ---");
        if (amount <= 0) {
            System.out.println("  [Error] Invalid amount! Withdrawal amount must be greater than zero.");
        } else if (amount > balance) {
            System.out.println("  [Error] Insufficient balance!");
            System.out.println("  Requested: Rs. " + amount + " | Available: Rs. " + balance);
        } else {
            balance -= amount;
            String record = "Withdrawn: Rs. " + amount + " | Balance after withdrawal: Rs. " + balance;
            transactionHistory.add(record);
            System.out.println("  Rs. " + amount + " withdrawn successfully.");
            System.out.println("  Current Balance: Rs. " + balance);
        }
    }

    /**
     * Display current account balance.
     */
    public void checkBalance() {
        System.out.println("\n  --- Balance Inquiry ---");
        System.out.println("  Account Holder : " + accountHolderName);
        System.out.println("  Account Number : " + accountNumber);
        System.out.println("  Current Balance: Rs. " + balance);
    }

    /**
     * Display full transaction history.
     */
    public void displayTransactionHistory() {
        System.out.println("\n  --- Transaction History ---");
        System.out.println("  Account: " + accountHolderName + " (" + accountNumber + ")");
        System.out.println("  ----------------------------------------");
        if (transactionHistory.isEmpty()) {
            System.out.println("  No transactions found.");
        } else {
            for (int i = 0; i < transactionHistory.size(); i++) {
                System.out.println("  " + (i + 1) + ". " + transactionHistory.get(i));
            }
        }
        System.out.println("  ----------------------------------------");
    }

    /**
     * Display full account details.
     */
    public void displayAccountDetails() {
        System.out.println("\n  ╔══════════════════════════════════════╗");
        System.out.println("  ║        ACCOUNT DETAILS               ║");
        System.out.println("  ╠══════════════════════════════════════╣");
        System.out.printf ("  ║  Name   : %-27s║%n", accountHolderName);
        System.out.printf ("  ║  Acc No : %-27s║%n", accountNumber);
        System.out.printf ("  ║  Balance: Rs. %-23.2f║%n", balance);
        System.out.println("  ╚══════════════════════════════════════╝");
    }
}


// ─────────────────────────────────────────────
//  Main class  –  entry point & menu
// ─────────────────────────────────────────────
public class BankAccountManagementSystem {

    // Display welcome banner
    static void showBanner() {
        System.out.println("  ╔══════════════════════════════════════════════╗");
        System.out.println("  ║                                              ║");
        System.out.println("  ║      BANK ACCOUNT MANAGEMENT SYSTEM          ║");
        System.out.println("  ║     Using Core Java & OOP Concepts           ║");
        System.out.println("  ║                                              ║");
        System.out.println("  ║  Submitted By : Harsh Kumar (10550)          ║");
        System.out.println("  ║  University   : Rungta International Skills  ║");
        System.out.println("  ║  Guide        : Mr. Soumik Karmakar          ║");
        System.out.println("  ║                                              ║");
        System.out.println("  ╚══════════════════════════════════════════════╝");
        System.out.println();
    }

    // Display main menu
    static void showMenu() {
        System.out.println("\n  ════════════════════════════════");
        System.out.println("             MAIN MENU            ");
        System.out.println("  ════════════════════════════════");
        System.out.println("  1. Create New Account");
        System.out.println("  2. Deposit Money");
        System.out.println("  3. Withdraw Money");
        System.out.println("  4. Check Balance");
        System.out.println("  5. View Account Details");
        System.out.println("  6. View Transaction History");
        System.out.println("  7. Exit");
        System.out.println("  ════════════════════════════════");
        System.out.print("  Enter your choice: ");
    }

    // ── main() ────────────────────────────────
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        BankAccount account = null;
        int choice;

        showBanner();

        // ── Demonstrate hard-coded test cases first ──────────────────
        System.out.println("  ══════════════════════════════════════════════");
        System.out.println("     DEMONSTRATION: Sample Transactions          ");
        System.out.println("  ══════════════════════════════════════════════");

        // Test 1: Create account with initial balance
        System.out.println("\n[TEST 1] Creating account for 'Harsh Kumar' with Rs. 5000 initial balance");
        BankAccount demoAccount = new BankAccount("Harsh Kumar", "RU-10550", 5000.00);
        demoAccount.displayAccountDetails();

        // Test 2: Valid deposit
        System.out.println("\n[TEST 2] Depositing Rs. 3000");
        demoAccount.deposit(3000);

        // Test 3: Invalid deposit (negative)
        System.out.println("\n[TEST 3] Attempting to deposit Rs. -500 (invalid)");
        demoAccount.deposit(-500);

        // Test 4: Valid withdrawal
        System.out.println("\n[TEST 4] Withdrawing Rs. 2000");
        demoAccount.withdraw(2000);

        // Test 5: Withdrawal exceeding balance (overdraft prevention)
        System.out.println("\n[TEST 5] Attempting to withdraw Rs. 50000 (exceeds balance)");
        demoAccount.withdraw(50000);

        // Test 6: Zero withdrawal (invalid)
        System.out.println("\n[TEST 6] Attempting to withdraw Rs. 0 (invalid)");
        demoAccount.withdraw(0);

        // Test 7: Check balance
        demoAccount.checkBalance();

        // Test 8: Transaction history
        demoAccount.displayTransactionHistory();

        System.out.println("\n  ══════════════════════════════════════════════");
        System.out.println("     Demonstration complete. Entering Live Menu. ");
        System.out.println("  ══════════════════════════════════════════════");

        // ── Interactive menu loop ────────────────────────────────────
        do {
            showMenu();

            // Safe integer read
            while (!scanner.hasNextInt()) {
                System.out.print("  [Error] Please enter a valid number: ");
                scanner.next();
            }
            choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {

                case 1: // Create new account
                    System.out.print("\n  Enter Account Holder Name : ");
                    String name = scanner.nextLine();
                    System.out.print("  Enter Account Number      : ");
                    String accNo = scanner.nextLine();
                    System.out.print("  Enter Initial Balance (Rs.): ");
                    while (!scanner.hasNextDouble()) {
                        System.out.print("  [Error] Enter a valid amount: ");
                        scanner.next();
                    }
                    double initBal = scanner.nextDouble();
                    account = new BankAccount(name, accNo, initBal);
                    System.out.println("\n  Account created successfully!");
                    account.displayAccountDetails();
                    break;

                case 2: // Deposit
                    if (account == null) {
                        System.out.println("\n  [Error] No account found. Please create an account first (Option 1).");
                        break;
                    }
                    System.out.print("\n  Enter amount to deposit (Rs.): ");
                    while (!scanner.hasNextDouble()) {
                        System.out.print("  [Error] Enter a valid amount: ");
                        scanner.next();
                    }
                    double depositAmt = scanner.nextDouble();
                    account.deposit(depositAmt);
                    break;

                case 3: // Withdraw
                    if (account == null) {
                        System.out.println("\n  [Error] No account found. Please create an account first (Option 1).");
                        break;
                    }
                    System.out.print("\n  Enter amount to withdraw (Rs.): ");
                    while (!scanner.hasNextDouble()) {
                        System.out.print("  [Error] Enter a valid amount: ");
                        scanner.next();
                    }
                    double withdrawAmt = scanner.nextDouble();
                    account.withdraw(withdrawAmt);
                    break;

                case 4: // Check balance
                    if (account == null) {
                        System.out.println("\n  [Error] No account found. Please create an account first (Option 1).");
                    } else {
                        account.checkBalance();
                    }
                    break;

                case 5: // Account details
                    if (account == null) {
                        System.out.println("\n  [Error] No account found. Please create an account first (Option 1).");
                    } else {
                        account.displayAccountDetails();
                    }
                    break;

                case 6: // Transaction history
                    if (account == null) {
                        System.out.println("\n  [Error] No account found. Please create an account first (Option 1).");
                    } else {
                        account.displayTransactionHistory();
                    }
                    break;

                case 7: // Exit
                    System.out.println("\n  Thank you for using the Bank Account Management System.");
                    System.out.println("  Submitted by: Harsh Kumar | Rungta International Skills University");
                    System.out.println("  Goodbye!\n");
                    break;

                default:
                    System.out.println("\n  [Error] Invalid choice! Please select a number between 1 and 7.");
            }

        } while (choice != 7);

        scanner.close();
    }
}