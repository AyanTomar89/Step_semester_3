
import java.util.*;

public class HomeApplianceEnergyReport {
    interface SaverMode {
        double reduceUnits(double units);
    }

    static abstract class Appliance {
        double hours;
        Appliance(double h) { hours = h; }
        abstract double power();
        double units(boolean saver) {
            double u = power() * hours / 1000;
            return saver && this instanceof SaverMode
                    ? ((SaverMode)this).reduceUnits(u) : u;
        }
        boolean supportsSaver() { return this instanceof SaverMode; }
    }

    static class Fridge extends Appliance {
        Fridge(double h) { super(h); }
        double power() { return 150; }
    }

    static class AC extends Appliance implements SaverMode {
        AC(double h) { super(h); }
        double power() { return 1500; }
        public double reduceUnits(double u) { return u * 0.75; }
    }

    static class TV extends Appliance {
        TV(double h) { super(h); }
        double power() { return 100; }
    }

    static class Washer extends Appliance implements SaverMode {
        Washer(double h) { super(h); }
        double power() { return 500; }
        public double reduceUnits(double u) { return u * 0.75; }
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = s.next();
            double hours = s.nextDouble();
            boolean saver = s.hasNext("SAVER");
            if (saver) s.next();

            Appliance a = type.equals("FRIDGE") ? new Fridge(hours)
                    : type.equals("AC") ? new AC(hours)
                    : type.equals("TV") ? new TV(hours)
                    : new Washer(hours);

            if (saver && !a.supportsSaver()) {
                System.out.println(type + ": saver mode not supported");
                continue;
            }

            double u = a.units(saver), cost = u * 8;
            total += cost;
            System.out.printf("%s: Units=%.2f Cost=%.2f%n", type, u, cost);
        }
        System.out.printf("Total Cost: %.2f%n", total);
    }
}
