
import java.util.*;

public class TravelBookingWithCommonFee {
    static abstract class Booking {
        double distance;
        Booking(double d) { distance = d; }
        abstract double fare();
        double total() { return fare() + 50; }
    }

    static class Bus extends Booking {
        Bus(double d) { super(d); }
        double fare() { return distance * 2; }
    }

    static class Train extends Booking {
        Train(double d) { super(d); }
        double fare() { return distance * 1.5; }
    }

    static class Flight extends Booking {
        Flight(double d) { super(d); }
        double fare() { return 2500 + distance * 4; }
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String mode = s.next();
            double d = s.nextDouble();
            Booking b = mode.equals("BUS") ? new Bus(d)
                    : mode.equals("TRAIN") ? new Train(d)
                    : new Flight(d);
            double cost = b.total();
            total += cost;
            System.out.printf("%s: %.2f%n", mode, cost);
        }
        System.out.printf("Total: %.2f%n", total);
    }
}
