import java.util.Arrays;

public class Question5 {

    static class Player implements Comparable<Player> {

        private String name;
        private int matchesPlayed;
        private double battingAverage;
        private boolean injured;

        public Player(String name, int matchesPlayed,
                      double battingAverage, boolean injured) {

            this.name = name;
            this.matchesPlayed = matchesPlayed;
            this.battingAverage = battingAverage;
            this.injured = injured;
        }

        // Rule 1: Experienced players
        static boolean isDraftable(int matchesPlayed) {
            return matchesPlayed >= 10;
        }

        // Rule 2: Less experienced but fit players
        static boolean isDraftable(int matchesPlayed, boolean injured) {
            return matchesPlayed >= 5 && !injured;
        }

        @Override
        public int compareTo(Player other) {

            // Sort by batting average, highest first
            return Double.compare(
                    other.battingAverage,
                    this.battingAverage
            );
        }

        static String draftAndRank(Player[] players) {

            Player[] draftable = new Player[players.length];
            int count = 0;

            for (int i = 0; i < players.length; i++) {

                if (isDraftable(players[i].matchesPlayed) ||
                    isDraftable(players[i].matchesPlayed,
                                players[i].injured)) {

                    draftable[count] = players[i];
                    count++;
                }
            }

            // Keep only the draftable players
            draftable = Arrays.copyOf(draftable, count);

            // Sort using compareTo()
            Arrays.sort(draftable);

            String result = "";

            for (int i = 0; i < draftable.length; i++) {

                result += (i + 1) + ". " + draftable[i].name;

                if (i < draftable.length - 1) {
                    result += " | ";
                }
            }

            return result;
        }
    }

    public static void main(String[] args) {

        Player[] players = {
            new Player("Virat", 15, 48.0, false),
            new Player("Rahul", 7, 55.0, false),
            new Player("Sameer", 3, 60.0, false),
            new Player("Dev", 12, 20.0, true)
        };

        System.out.println(Player.draftAndRank(players));
    }
}