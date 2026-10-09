
import java.util.*;

public class CollegeFeeCounter {
    interface BusUser {
        double transportFee();
    }

    static abstract class Student {
        String name;
        Student(String n) { name = n; }
        abstract double tuition();
        double fee() {
            return tuition() + (this instanceof BusUser ? ((BusUser)this).transportFee() : 0);
        }
    }

    static class DayScholar extends Student implements BusUser {
        DayScholar(String n) { super(n); }
        double tuition() { return 40000; }
        public double transportFee() { return 12000; }
    }

    static class Hosteller extends Student {
        Hosteller(String n) { super(n); }
        double tuition() { return 100000; }
    }

    static class Scholar extends Student implements BusUser {
        Scholar(String n) { super(n); }
        double tuition() { return 20000; }
        public double transportFee() { return 12000; }
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = s.next(), name = s.next();
            Student st = type.equals("DAY_SCHOLAR") ? new DayScholar(name)
                    : type.equals("HOSTELLER") ? new Hosteller(name)
                    : new Scholar(name);
            double fee = st.fee();
            total += fee;
            System.out.printf("%s: %.2f%n", name, fee);
        }
        System.out.printf("Total Collected: %.2f%n", total);
    }
}
