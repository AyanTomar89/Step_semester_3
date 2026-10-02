import java.util.*;

public class PublicTransportFareCalculator {
    static abstract class Transport {
        double d;
        Transport(double d) { this.d = d; }
        abstract double fare();
    }

    static class Bus extends Transport {
        Bus(double d) { super(d); }
        double fare() { return Math.min(2 + .1 * d, 10); }
    }

    static class Train extends Transport {
        Train(double d) { super(d); }
        double fare() { return 3 + .15 * d; }
    }

    static class Metro extends Transport {
        double factor;
        Metro(double d, double f) {
            super(d);
            factor = f;
        }
        double fare() { return (1.5 + .2 * d) * factor; }
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        Transport[] a = new Transport[n];
        String[] type = new String[n];

        for (int i = 0; i < n; i++) {
            type[i] = s.next();
            double d = s.nextDouble();

            if (type[i].equals("BUS")) a[i] = new Bus(d);
            else if (type[i].equals("TRAIN")) a[i] = new Train(d);
            else a[i] = new Metro(d, s.nextDouble());
        }

        double total = 0;
        for (int i = 0; i < n; i++) {
            double x = a[i].fare();
            System.out.printf("%s: %.2f%n", type[i], x);
            total += x;
        }
        System.out.printf("Total: %.2f%n", total);
    }
}