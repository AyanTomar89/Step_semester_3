import java.util.*;

public class CampusParkingChargeCalculator {
    static abstract class Vehicle {
        int hours;
        Vehicle(int h) { hours = h; }
        abstract double charge();
    }

    static class Bike extends Vehicle {
        Bike(int h) { super(h); }
        double charge() { return hours * 10; }
    }

    static class Car extends Vehicle {
        Car(int h) { super(h); }
        double charge() { return 30 + (hours - 1) * 20; }
    }

    static class Truck extends Vehicle {
        Truck(int h) { super(h); }
        double charge() { return Math.max(100, hours * 50); }
    }

    static Vehicle create(String t, int h) {
        if (t.equals("BIKE")) return new Bike(h);
        if (t.equals("CAR")) return new Car(h);
        return new Truck(h);
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        Vehicle[] a = new Vehicle[n];
        String[] type = new String[n];

        for (int i = 0; i < n; i++) {
            type[i] = s.next();
            a[i] = create(type[i], s.nextInt());
        }

        double total = 0;
        for (int i = 0; i < n; i++) {
            double x = a[i].charge();
            System.out.printf("%s: %.2f%n", type[i], x);
            total += x;
        }
        System.out.printf("Total: %.2f%n", total);
    }
}