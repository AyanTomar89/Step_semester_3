import java.util.*;

class HackathonSeatingGridOptimizer {
    private static double rowAverage(int[] row) {
        int sum = 0;

        for (int x : row)
            sum += x;

        return (double) sum / row.length;
    }

    static String classifyRows(int[][] seatingScores, int threshold) {
        String result = "";

        for (int i = 0; i < seatingScores.length; i++) {
            double avg = rowAverage(seatingScores[i]);

            if (i > 0)
                result += " | ";

            result += "Row " + i + ": " +
                    (avg < threshold ? "Quiet Zone" : "Buzzing Zone");
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        System.out.print("Enter number of rows: ");
        int rows = s.nextInt();

        int[][] seatingScores = new int[rows][];

        for (int i = 0; i < rows; i++) {
            System.out.print("Enter number of scores in row " + i + ": ");
            int n = s.nextInt();

            seatingScores[i] = new int[n];

            System.out.println("Enter scores:");
            for (int j = 0; j < n; j++)
                seatingScores[i][j] = s.nextInt();
        }

        System.out.print("Enter threshold: ");
        int threshold = s.nextInt();

        System.out.println(classifyRows(seatingScores, threshold));
    }
}