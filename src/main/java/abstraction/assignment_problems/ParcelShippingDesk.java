
import java.util.*;

public class ParcelShippingDesk {
    interface Insurable {
        double insurance(double value);
    }

    static abstract class Parcel {
        double weight, value;
        Parcel(double w, double v) { weight = w; value = v; }
        abstract double charge();
        double insurance() {
            return this instanceof Insurable ? ((Insurable)this).insurance(value) : 0;
        }
    }

    static class Standard extends Parcel {
        Standard(double w, double v) { super(w, v); }
        double charge() { return 40 + 10 * weight; }
    }

    static class Express extends Parcel implements Insurable {
        Express(double w, double v) { super(w, v); }
        double charge() { return 80 + 15 * weight; }
        public double insurance(double v) { return v * 0.02; }
    }

    static class Fragile extends Parcel implements Insurable {
        Fragile(double w, double v) { super(w, v); }
        double charge() { return 40 + 10 * weight + 50; }
        public double insurance(double v) { return v * 0.02; }
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        double grand = 0;

        for (int i = 0; i < n; i++) {
            String type = s.next();
            double w = s.nextDouble(), v = s.nextDouble();
            Parcel p = type.equals("STANDARD") ? new Standard(w, v)
                    : type.equals("EXPRESS") ? new Express(w, v)
                    : new Fragile(w, v);
            double c = p.charge(), ins = p.insurance(), sum = c + ins;
            grand += sum;
            System.out.printf("%s: Charge=%.2f Insurance=%.2f Total=%.2f%n", type, c, ins, sum);
        }
        System.out.printf("Grand Total: %.2f%n", grand);
    }
}
