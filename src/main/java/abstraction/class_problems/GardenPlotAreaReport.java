
import java.util.*;

public class GardenPlotAreaReport {
    static abstract class Plot {
        String owner;
        Plot(String o) { owner = o; }
        abstract double area();
        abstract String shape();
    }

    static class Circle extends Plot {
        double r;
        Circle(String o, double r) { super(o); this.r = r; }
        double area() { return Math.PI * r * r; }
        String shape() { return "CIRCLE"; }
    }

    static class Rectangle extends Plot {
        double l, w;
        Rectangle(String o, double l, double w) { super(o); this.l = l; this.w = w; }
        double area() { return l * w; }
        String shape() { return "RECTANGLE"; }
    }

    static class Triangle extends Plot {
        double b, h;
        Triangle(String o, double b, double h) { super(o); this.b = b; this.h = h; }
        double area() { return b * h / 2; }
        String shape() { return "TRIANGLE"; }
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        Plot[] plots = new Plot[n];
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = s.next(), name = s.next();
            if (type.equals("CIRCLE")) plots[i] = new Circle(name, s.nextDouble());
            else if (type.equals("RECTANGLE")) plots[i] = new Rectangle(name, s.nextDouble(), s.nextDouble());
            else plots[i] = new Triangle(name, s.nextDouble(), s.nextDouble());

            double a = plots[i].area();
            total += a;
            System.out.printf("%s (%s): %.2f%n", name, type, a);
        }
        System.out.printf("Total Area: %.2f%n", total);
    }
}
