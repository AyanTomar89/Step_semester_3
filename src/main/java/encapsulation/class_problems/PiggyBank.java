class PiggyBankAccount {
    private double savings;
    private final String id;

    PiggyBankAccount(String id) {
        this.id = id;
    }

    void deposit(double x) {
        if (x > 0) savings += x;
    }

    void withdraw(double x) {
        if (x > 0 && x <= savings) savings -= x;
    }

    double getSavings() {
        return savings;
    }
}

public class PiggyBank {
    public static void main(String[] args) {
        PiggyBankAccount p = new PiggyBankAccount("PB-1");
        p.deposit(100);
        p.withdraw(30);
        p.withdraw(500);
        System.out.println(p.getSavings());
    }
}