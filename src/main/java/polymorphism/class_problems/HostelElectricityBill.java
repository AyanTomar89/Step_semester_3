import java.util.*;

public class HostelElectricityBill {
    static abstract class Room {
        double units;
        Room(double u) { units = u; }
        abstract double bill();
    }

    static class Single extends Room {
        Single(double u) { super(u); }
        double bill() { return units * 8; }
    }

    static class Shared extends Room {
        int occupants;
        Shared(double u, int o) {
            super(u);
            occupants = o;
        }
        double bill() { return units * 6 / occupants; }
    }

    static class AC extends Room {
        AC(double u) { super(u); }
        double bill() { return units * 10 + 200; }
    }

    static Room create(String t, double u, int o) {
        if (t.equals("SINGLE")) return new Single(u);
        if (t.equals("SHARED")) return new Shared(u, o);
        return new AC(u);
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        Room[] rooms = new Room[n];
        String[] type = new String[n];

        for (int i = 0; i < n; i++) {
            type[i] = s.next();
            double u = s.nextDouble();
            int o = type[i].equals("SHARED") ? s.nextInt() : 0;
            rooms[i] = create(type[i], u, o);
        }

        double total = 0;
        for (int i = 0; i < n; i++) {
            double x = rooms[i].bill();
            System.out.printf("%s: %.2f%n", type[i], x);
            total += x;
        }
        System.out.printf("Total: %.2f%n", total);
    }
}