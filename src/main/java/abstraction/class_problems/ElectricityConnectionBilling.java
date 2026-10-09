
import java.util.*;

public class ElectricityConnectionBilling {
    static abstract class Connection {
        double units;
        Connection(double u) { units = u; }
        abstract double bill();
    }

    static class Home extends Connection {
        Home(double u) { super(u); }
        double bill() { return Math.min(units, 100) * 5 + Math.max(0, units - 100) * 7; }
    }

    static class Shop extends Connection {
        Shop(double u) { super(u); }
        double bill() { return units * 8 + 100; }
    }

    static class Factory extends Connection {
        Factory(double u) { super(u); }
        double bill() { return Math.max(1000, units * 6); }
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = s.next();
            double units = s.nextDouble();
            Connection c = type.equals("HOME") ? new Home(units)
                    : type.equals("SHOP") ? new Shop(units)
                    : new Factory(units);
            double b = c.bill();
            total += b;
            System.out.printf("%s: %.2f%n", type, b);
        }
        System.out.printf("Total: %.2f%n", total);
    }
}
