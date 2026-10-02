import java.util.*;
import java.util.regex.*;

public class ExaminationQuestionGrader {
    static abstract class Question {
        String correct, student;
        double points;

        Question(String c, String s, double p) {
            correct = c;
            student = s;
            points = p;
        }

        abstract double score();
    }

    static class MCQ extends Question {
        MCQ(String c, String s, double p) { super(c, s, p); }
        double score() { return student.equals(correct) ? points : 0; }
    }

    static class TF extends Question {
        TF(String c, String s, double p) { super(c, s, p); }
        double score() { return student.equals(correct) ? points : 0; }
    }

    static class Essay extends Question {
        Essay(String c, String s, double p) { super(c, s, p); }

        double score() {
            String a = student.toLowerCase();
            int count = 0;
            for (String k : correct.split(","))
                if (a.contains(k.trim().toLowerCase())) count++;

            if (count >= 2) return points * .75;
            if (count == 1) return points * .50;
            return 0;
        }
    }

    static Question create(String t, String c, String s, double p) {
        if (t.equals("MCQ")) return new MCQ(c, s, p);
        if (t.equals("TF")) return new TF(c, s, p);
        return new Essay(c, s, p);
    }

    static ArrayList<String> parse(String line) {
        ArrayList<String> a = new ArrayList<>();
        Matcher m = Pattern.compile("\"([^\"]*)\"|(\\S+)").matcher(line);
        while (m.find()) a.add(m.group(1) != null ? m.group(1) : m.group(2));
        return a;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = Integer.parseInt(s.nextLine());
        Question[] q = new Question[n];
        String[] type = new String[n];

        for (int i = 0; i < n; i++) {
            ArrayList<String> a = parse(s.nextLine());
            type[i] = a.get(0);
            q[i] = create(type[i], a.get(2), a.get(3),
                    Double.parseDouble(a.get(4)));
        }

        double total = 0;
        for (int i = 0; i < n; i++) {
            double x = q[i].score();
            System.out.printf("%s: %.2f%n", type[i], x);
            total += x;
        }
        System.out.printf("Total Score: %.2f%n", total);
    }
}