import java.util.*;

public class DeliveryFeeCalculator {
    static abstract class Delivery {
        double w, d;
        Delivery(double w, double d) { this.w = w; this.d = d; }
        abstract double fee();
    }

    static class Standard extends Delivery {
        Standard(double w, double d) { super(w, d); }
        double fee() { return 5 + .5 * w + .1 * d; }
    }

    static class Express extends Delivery {
        Express(double w, double d) { super(w, d); }
        double fee() { return 15 + w + .2 * d; }
    }

    static class International extends Delivery {
        double c;
        International(double w, double d, double c) {
            super(w, d);
            this.c = c;
        }
        double fee() { return 25 + 2 * w + .5 * d + c; }
    }

    static Delivery create(String t, double w, double d, double c) {
        if (t.equals("STANDARD")) return new Standard(w, d);
        if (t.equals("EXPRESS")) return new Express(w, d);
        return new International(w, d, c);
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        Delivery[] a = new Delivery[n];
        String[] type = new String[n];

        for (int i = 0; i < n; i++) {
            type[i] = s.next();
            double w = s.nextDouble(), d = s.nextDouble();
            double c = type[i].equals("INTERNATIONAL") ? s.nextDouble() : 0;
            a[i] = create(type[i], w, d, c);
        }

        double total = 0;
        for (int i = 0; i < n; i++) {
            double x = a[i].fee();
            System.out.printf("%s: %.2f%n", type[i], x);
            total += x;
        }
        System.out.printf("Total: %.2f%n", total);
    }
}