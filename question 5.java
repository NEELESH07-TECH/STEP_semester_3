import java.util.Arrays;

class Player implements Comparable<Player> {
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

    static boolean isDraftable(int matchesPlayed) {
        return matchesPlayed >= 10;
    }

    static boolean isDraftable(int matchesPlayed, boolean injured) {
        return matchesPlayed >= 5 && !injured;
    }

    public int compareTo(Player other) {
        return Double.compare(other.battingAverage, this.battingAverage);
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

        for (int i = 0; i < count; i++) {
            if (i > 0) {
                result += " | ";
            }

            result += (i + 1) + ". " + draftable[i].name;
        }

        return result;
    }
}

class Main {
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