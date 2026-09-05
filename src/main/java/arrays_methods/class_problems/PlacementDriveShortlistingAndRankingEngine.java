import java.util.*;

class PlacementDriveShortlistingAndRankingEngine {
    static class Candidate implements Comparable<Candidate> {
        private String name;
        private double cgpa;
        private int codingScore;

        Candidate(String name, double cgpa, int codingScore) {
            this.name = name;
            this.cgpa = cgpa;
            this.codingScore = codingScore;
        }

        double compositeScore() {
            return cgpa * 10 + codingScore * 0.5;
        }

        public int compareTo(Candidate other) {
            return Double.compare(other.compositeScore(), compositeScore());
        }

        String getName() {
            return name;
        }
    }

    static boolean isEligible(double cgpa) {
        return cgpa >= 7.5;
    }

    static boolean isEligible(double cgpa, int codingScore) {
        return cgpa >= 6.5 && codingScore >= 60;
    }

    static String shortlistAndRank(Candidate[] candidates) {
        Candidate[] shortlisted = new Candidate[candidates.length];
        int count = 0;

        for (Candidate c : candidates)
            if (isEligible(c.cgpa) || isEligible(c.cgpa, c.codingScore))
                shortlisted[count++] = c;

        shortlisted = Arrays.copyOf(shortlisted, count);
        Arrays.sort(shortlisted);

        String result = "";

        for (int i = 0; i < shortlisted.length; i++) {
            if (i > 0)
                result += " | ";

            result += (i + 1) + ". " +
                    shortlisted[i].getName() + " (" +
                    shortlisted[i].compositeScore() + ")";
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        System.out.print("Enter number of candidates: ");
        int n = s.nextInt();

        Candidate[] candidates = new Candidate[n];

        for (int i = 0; i < n; i++) {
            System.out.println("Candidate " + (i + 1));

            System.out.print("Enter name: ");
            String name = s.next();

            System.out.print("Enter CGPA: ");
            double cgpa = s.nextDouble();

            System.out.print("Enter coding score: ");
            int codingScore = s.nextInt();

            candidates[i] = new Candidate(name, cgpa, codingScore);
        }

        System.out.println("Shortlisted Candidates:");
        System.out.println(shortlistAndRank(candidates));
    }
}