class BankAccount {
    public static void main(String[] args) {
        BankAccount account = new BankAccount("agam chauhan");
        account.deposit(1000);
        account.withdraw(500);
        System.out.println("Balance: " + account.getBalance());
    }

    private String name;
    private double balance;

    public BankAccount(String name) {
        this.name = name;
        this.balance = 0;
    }

    public void deposit(double amount) {
        balance += amount;
    }
    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
        }
            else {  System.out.println("Insufficient funds!");}
        
    }

    public double getBalance() {
        return balance;
    }
}