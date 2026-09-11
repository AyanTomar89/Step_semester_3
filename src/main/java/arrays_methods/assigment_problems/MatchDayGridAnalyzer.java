import java.util.*;

class MatchDayGridAnalyzer {

    private static double rowAverage(int[] row) {
        int sum = 0;

        for (int x : row)
            sum += x;

        return (double) sum / row.length;
    }

    static String classifyMatches(int[][] runsPerOver, int threshold) {
        String result = "";

        for (int i = 0; i < runsPerOver.length; i++) {
            double average = rowAverage(runsPerOver[i]);

            if (i > 0)
                result += " | ";

            result += "Match " + i + ": ";

            if (average >= threshold)
                result += "Power Surge";
            else
                result += "Normal";
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        System.out.print("Enter number of matches: ");
        int matches = s.nextInt();

        int[][] runs = new int[matches][];

        for (int i = 0; i < matches; i++) {
            System.out.print("Enter number of overs for match " + i + ": ");
            int n = s.nextInt();

            runs[i] = new int[n];

            System.out.println("Enter runs:");
            for (int j = 0; j < n; j++)
                runs[i][j] = s.nextInt();
        }

        System.out.print("Enter threshold: ");
        int threshold = s.nextInt();

        System.out.println(classifyMatches(runs, threshold));
    }
}