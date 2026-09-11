import java.util.*;

class FantasyLeagueAutoDraftRankingEngine {

    static class Player implements Comparable<Player> {

        private String name;
        private int matchesPlayed;
        private double battingAverage;
        private boolean injured;

        public Player(String name, int matchesPlayed, double battingAverage, boolean injured) {
            this.name = name;
            this.matchesPlayed = matchesPlayed;
            this.battingAverage = battingAverage;
            this.injured = injured;
        }

        public int compareTo(Player other) {
            return Double.compare(other.battingAverage, battingAverage);
        }

        String getName() {
            return name;
        }
    }

    static boolean isDraftable(int matchesPlayed) {
        return matchesPlayed >= 10;
    }

    static boolean isDraftable(int matchesPlayed, boolean injured) {
        return matchesPlayed >= 5 && !injured;
    }

    static String draftAndRank(Player[] players) {
        Player[] draftable = new Player[players.length];
        int count = 0;

        for (Player p : players) {
            if (isDraftable(p.matchesPlayed) ||
                    isDraftable(p.matchesPlayed, p.injured)) {
                draftable[count++] = p;
            }
        }

        draftable = Arrays.copyOf(draftable, count);

        Arrays.sort(draftable);

        String result = "";

        for (int i = 0; i < draftable.length; i++) {
            if (i > 0)
                result += " | ";

            result += (i + 1) + ". " + draftable[i].getName();
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        System.out.print("Enter number of players: ");
        int n = s.nextInt();

        Player[] players = new Player[n];

        for (int i = 0; i < n; i++) {
            System.out.println("Player " + (i + 1));

            System.out.print("Enter name: ");
            String name = s.next();

            System.out.print("Enter matches played: ");
            int matches = s.nextInt();

            System.out.print("Enter batting average: ");
            double average = s.nextDouble();

            System.out.print("Is injured (true/false): ");
            boolean injured = s.nextBoolean();

            players[i] = new Player(name, matches, average, injured);
        }

        System.out.println(draftAndRank(players));
    }
}