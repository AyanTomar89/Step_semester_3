import java.util.*;

class HackathonScoreCurveBooster {
    static void curveScores(int[] scores, int bonus) {
        for (int i = 0; i < scores.length; i++)
            scores[i] += bonus;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        System.out.print("Enter number of scores: ");
        int n = s.nextInt();

        int[] scores = new int[n];

        System.out.println("Enter scores:");
        for (int i = 0; i < n; i++)
            scores[i] = s.nextInt();

        System.out.print("Enter bonus: ");
        int bonus = s.nextInt();

        curveScores(scores, bonus);

        System.out.println("Updated Scores: " + Arrays.toString(scores));
    }
}