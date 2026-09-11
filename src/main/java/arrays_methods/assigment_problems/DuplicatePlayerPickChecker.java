import java.util.*;

class DuplicatePlayerPickChecker {

    static String findDuplicatePick(String[] playerNames) {
        for (int i = 0; i < playerNames.length; i++) {
            for (int j = i + 1; j < playerNames.length; j++) {
                if (playerNames[i].equals(playerNames[j]))
                    return "Duplicate Found: " + playerNames[i];
            }
        }

        return "No Duplicates Found";
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        System.out.print("Enter number of players: ");
        int n = s.nextInt();

        String[] players = new String[n];

        System.out.println("Enter player names:");
        for (int i = 0; i < n; i++)
            players[i] = s.next();

        System.out.println(findDuplicatePick(players));
    }
}