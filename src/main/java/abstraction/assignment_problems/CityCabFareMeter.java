
import java.util.*;

public class CityCabFareMeter {
    interface NightService {
        double nightFare(double fare);
    }

    static abstract class Cab {
        double km;
        Cab(double k) { km = k; }
        abstract double rate();
        double fare() { return Math.max(100, km * rate()); }
    }

    static class Mini extends Cab {
        Mini(double k) { super(k); }
        double rate() { return 10; }
    }

    static class Sedan extends Cab implements NightService {
        Sedan(double k) { super(k); }
        double rate() { return 14; }
        public double nightFare(double f) { return f * 1.2; }
    }

    static class SUV extends Cab implements NightService {
        SUV(double k) { super(k); }
        double rate() { return 18; }
        public double nightFare(double f) { return f * 1.2; }
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = s.next();
            double km = s.nextDouble();
            String time = s.next();
            Cab c = type.equals("MINI") ? new Mini(km)
                    : type.equals("SEDAN") ? new Sedan(km)
                    : new SUV(km);

            if (time.equals("NIGHT") && !(c instanceof NightService)) {
                System.out.println(type + ": night service not available");
                continue;
            }

            double fare = c.fare();
            if (time.equals("NIGHT")) fare = ((NightService)c).nightFare(fare);
            total += fare;
            System.out.printf("%s: %.2f%n", type, fare);
        }
        System.out.printf("Total: %.2f%n", total);
    }
}
