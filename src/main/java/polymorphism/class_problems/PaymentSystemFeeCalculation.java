import java.util.*;

public class PaymentSystemFeeCalculation {
    static abstract class Payment {
        double amount;
        Payment(double amount) { this.amount = amount; }
        abstract double calculate();
    }

    static class Card extends Payment {
        Card(double a) { super(a); }
        double calculate() { return amount * 1.02; }
    }

    static class Wallet extends Payment {
        Wallet(double a) { super(a); }
        double calculate() { return amount * 1.01; }
    }

    static class BankTransfer extends Payment {
        BankTransfer(double a) { super(a); }
        double calculate() { return amount; }
    }

    static Payment create(String type, double amount) {
        switch (type) {
            case "CARD": return new Card(amount);
            case "WALLET": return new Wallet(amount);
            default: return new BankTransfer(amount);
        }
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("Enter number of payments: ");
        int n = s.nextInt();
        Payment[] p = new Payment[n];
        String[] type = new String[n];
        double total = 0;

        for (int i = 0; i < n; i++) {
            type[i] = s.next();
            p[i] = create(type[i], s.nextDouble());
        }

        for (int i = 0; i < n; i++) {
            double x = p[i].calculate();
            System.out.printf("%s: %.2f%n", type[i], x);
            total += x;
        }
        System.out.printf("Total: %.2f%n", total);
    }
}