
import java.util.*;

public class LibraryLateFineCounter {
    static abstract class Item {
        String title;
        int days;
        Item(String t, int d) { title = t; days = d; }
        abstract double fine();
    }

    static class Book extends Item {
        Book(String t, int d) { super(t, d); }
        double fine() { return days * 2.0; }
    }

    static class DVD extends Item {
        DVD(String t, int d) { super(t, d); }
        double fine() { return Math.min(days * 5.0, 50); }
    }

    static class Magazine extends Item {
        Magazine(String t, int d) { super(t, d); }
        double fine() { return days; }
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = s.next(), title = s.next();
            int days = s.nextInt();
            Item item = type.equals("BOOK") ? new Book(title, days)
                    : type.equals("DVD") ? new DVD(title, days)
                    : new Magazine(title, days);
            double f = item.fine();
            total += f;
            System.out.printf("%s: %.2f%n", title, f);
        }
        System.out.printf("Total Fines: %.2f%n", total);
    }
}
