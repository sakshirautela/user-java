
public class BankWorking {

    private int id;
    private int trans;

    public static void main(String[] args) {
        BankWorking bank = new BankWorking(12345, 5000);
        bank.sbiInterestRate();
    }

    // Constructor
    public BankWorking(int id, int trans) {
        this.id = id;
        this.trans = trans;
    }

    // Method to show SBI Interest Rate
    public void sbiInterestRate() {
        System.out.println("SBI Interest Rate is 6.5%");
    }
}
