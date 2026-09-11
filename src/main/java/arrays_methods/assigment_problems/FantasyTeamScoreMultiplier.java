import java.util.*;

class FantasyTeamScoreMultiplier {

    static void applyMultipliers(double[] playerScores, int captainIndex, int viceCaptainIndex) {
        playerScores[captainIndex] *= 2;
        playerScores[viceCaptainIndex] *= 1.5;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        System.out.print("Enter number of players: ");
        int n = s.nextInt();

        double[] scores = new double[n];

        System.out.println("Enter scores:");
        for (int i = 0; i < n; i++)
            scores[i] = s.nextDouble();

        System.out.print("Enter captain index: ");
        int captain = s.nextInt();

        System.out.print("Enter vice-captain index: ");
        int viceCaptain = s.nextInt();

        applyMultipliers(scores, captain, viceCaptain);

        System.out.println("Updated Scores: " + Arrays.toString(scores));
    }
}