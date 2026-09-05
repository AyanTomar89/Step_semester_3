import java.util.*;

class Top3PodiumFinder {
    static int[] findTopThreeScores(int[] scores) {
        int first = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;
        int third = Integer.MIN_VALUE;

        for (int x : scores) {
            if (x >= first) {
                third = second;
                second = first;
                first = x;
            } else if (x >= second) {
                third = second;
                second = x;
            } else if (x > third) {
                third = x;
            }
        }

        return new int[]{first, second, third};
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        System.out.print("Enter number of scores: ");
        int n = s.nextInt();

        int[] scores = new int[n];

        System.out.println("Enter scores:");
        for (int i = 0; i < n; i++)
            scores[i] = s.nextInt();

        System.out.println("Top 3 Scores: " +
                Arrays.toString(findTopThreeScores(scores)));
    }
}