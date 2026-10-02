import java.util.*;

public class FestivalBonusCalculator {
    static abstract class Employee {
        String name;
        double salary;

        Employee(String n, double s) {
            name = n;
            salary = s;
        }

        abstract double bonus();
    }

    static class FullTime extends Employee {
        FullTime(String n, double s) { super(n, s); }
        double bonus() { return salary * .10; }
    }

    static class PartTime extends Employee {
        PartTime(String n, double s) { super(n, s); }
        double bonus() { return salary * .05; }
    }

    static class Intern extends Employee {
        Intern(String n, double s) { super(n, s); }
        double bonus() { return 2000; }
    }

    static Employee create(String t, String n, double s) {
        if (t.equals("FULLTIME")) return new FullTime(n, s);
        if (t.equals("PARTTIME")) return new PartTime(n, s);
        return new Intern(n, s);
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        Employee[] a = new Employee[n];

        for (int i = 0; i < n; i++)
            a[i] = create(s.next(), s.next(), s.nextDouble());

        double total = 0;
        for (Employee e : a) {
            double x = e.bonus();
            System.out.printf("%s: %.2f%n", e.name, x);
            total += x;
        }

        System.out.printf("Total Bonus: %.2f%n", total);
    }
}
