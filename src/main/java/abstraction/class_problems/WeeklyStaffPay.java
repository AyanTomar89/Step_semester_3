
import java.util.*;

public class WeeklyStaffPay {
    static abstract class Staff {
        String name;
        Staff(String n) { name = n; }
        abstract double pay();
    }

    static class FullTime extends Staff {
        double salary;
        FullTime(String n, double s) { super(n); salary = s; }
        double pay() { return salary; }
    }

    static class Hourly extends Staff {
        double hours, rate;
        Hourly(String n, double h, double r) { super(n); hours = h; rate = r; }
        double pay() { return Math.min(hours, 40) * rate + Math.max(0, hours - 40) * rate * 1.5; }
    }

    static class Intern extends Staff {
        double stipend;
        Intern(String n, double p) { super(n); stipend = p; }
        double pay() { return stipend; }
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        Staff[] staff = new Staff[n];
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = s.next(), name = s.next();
            if (type.equals("FULLTIME")) staff[i] = new FullTime(name, s.nextDouble());
            else if (type.equals("HOURLY")) staff[i] = new Hourly(name, s.nextDouble(), s.nextDouble());
            else staff[i] = new Intern(name, s.nextDouble());

            double p = staff[i].pay();
            total += p;
            System.out.printf("%s: %.2f%n", name, p);
        }
        System.out.printf("Total Payroll: %.2f%n", total);
    }
}
