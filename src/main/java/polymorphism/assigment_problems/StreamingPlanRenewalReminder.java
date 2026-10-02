import java.util.*;
import java.time.*;

public class StreamingPlanRenewalReminder {
    static abstract class Plan {
        LocalDate date;
        Plan(String d) { date = LocalDate.parse(d); }
        abstract LocalDate renewal();
    }

    static class Basic extends Plan {
        Basic(String d) { super(d); }
        LocalDate renewal() { return date.plusDays(30); }
    }

    static class Standard extends Plan {
        Standard(String d) { super(d); }
        LocalDate renewal() { return date.plusDays(90); }
    }

    static class Premium extends Plan {
        Premium(String d) { super(d); }
        LocalDate renewal() { return date.plusDays(365); }
    }

    static Plan create(String t, String d) {
        if (t.equals("BASIC")) return new Basic(d);
        if (t.equals("STANDARD")) return new Standard(d);
        return new Premium(d);
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        Plan[] a = new Plan[n];
        String[] names = new String[n];

        for (int i = 0; i < n; i++) {
            String type = s.next();
            names[i] = s.next();
            a[i] = create(type, s.next());
        }

        for (int i = 0; i < n; i++)
            System.out.println(names[i] + ": " + a[i].renewal());
    }
}