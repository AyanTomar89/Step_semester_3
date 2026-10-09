
import java.util.*;

public class MovieTicketCounter {
    static abstract class Ticket {
        static final double FEE = 20;
        int count;
        Ticket(int c) { count = c; }
        abstract double price();
        double total() { return count * (price() + FEE); }
    }

    static class Regular extends Ticket {
        Regular(int c) { super(c); }
        double price() { return 150; }
    }

    static class Premium extends Ticket {
        Premium(int c) { super(c); }
        double price() { return 250; }
    }

    static class Recliner extends Ticket {
        Recliner(int c) { super(c); }
        double price() { return 400; }
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = s.next();
            int count = s.nextInt();
            Ticket t = type.equals("REGULAR") ? new Regular(count)
                    : type.equals("PREMIUM") ? new Premium(count)
                    : new Recliner(count);
            double cost = t.total();
            total += cost;
            System.out.printf("%s: %.2f%n", type, cost);
        }
        System.out.printf("Total: %.2f%n", total);
    }
}
