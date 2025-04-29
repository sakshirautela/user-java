public class BankWorking {

    private int accountId;
    private double balance;

    // Constructor
    public BankWorking(int accountId, double balance) {
        this.accountId = accountId;
        this.balance = balance;
    }

    // Method to show SBI Interest Rate
    public void sbiInterestRate() {
        System.out.println("SBI Interest Rate is 6.5%");
    }

    // Deposit method
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: " + amount + ", New Balance: " + balance);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    // Withdraw method
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn: " + amount + ", Remaining Balance: " + balance);
        } else {
            System.out.println("Insufficient funds or invalid amount.");
        }
    }

    // Display account details
    public void displayAccount() {
        System.out.println("Account ID: " + accountId + ", Balance: " + balance);
    }

    public static void main(String[] args) {
        BankWorking account = new BankWorking(12345, 5000);
        account.displayAccount();
        account.sbiInterestRate();
        account.deposit(1500);
        account.withdraw(2000);
        account.withdraw(10000);  // test insufficient funds
    }
}
