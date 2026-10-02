import java.util.*;

public class CanteenBillingCounter {
    static abstract class Customer {
        double amount;
        Customer(double a) { amount = a; }
        abstract double finalAmount();
    }

    static class Student extends Customer {
        Student(double a) { super(a); }
        double finalAmount() { return amount * .90; }
    }

    static class Staff extends Customer {
        Staff(double a) { super(a); }
        double finalAmount() { return amount * .95; }
    }

    static class Guest extends Customer {
        Guest(double a) { super(a); }
        double finalAmount() { return amount + 10; }
    }

    static Customer create(String t, double a) {
        if (t.equals("STUDENT")) return new Student(a);
        if (t.equals("STAFF")) return new Staff(a);
        return new Guest(a);
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        Customer[] a = new Customer[n];
        String[] type = new String[n];

        for (int i = 0; i < n; i++) {
            type[i] = s.next();
            a[i] = create(type[i], s.nextDouble());
        }

        double total = 0;
        for (int i = 0; i < n; i++) {
            double x = a[i].finalAmount();
            System.out.printf("%s: %.2f%n", type[i], x);
            total += x;
        }
        System.out.printf("Total: %.2f%n", total);
    }
}