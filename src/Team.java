import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * Represents a team in a sports league. This class stores information about the team's name,
 * the number of wins and losses, and a list of game results. It provides methods to modify and
 * access these fields, including recording wins and losses, adding game results, and retrieving a
 * game result by a specific date.
 * @author Abdul Rahmani
 * @version 1.0
 *  Date: 03/15/2024
 */

public class Team
{

    // The name of the team.
    private String name;

    // The number of games the team has won.
    private int wins;

    // The number of games the team has lost.
    private int losses;

    // A list of results for this team.
    private List<GameResult> games;


    /**
     * Constructs a Team object with the specified name. Initializes wins and losses to 0
     * and creates an empty list for storing game results.
     *
     * @param name The name of the team.
     */
    public Team(String name)
    {
        this.name = name;
        this.wins = 0;
        this.losses = 0;
        this.games = new ArrayList<>();
    }

    /**
     * Records a win by incrementing the team's win count.
     */

    public void recordWin() {
        this.wins++;
    }

    /**
     * Records a loss by incrementing the team's loss count.
     */

    public void recordLoss() {
        this.losses++;
    }


    /**
     * Returns the number of wins the team has.
     *
     * @return The win count.
     */
    public int getWins() {
        return this.wins;
    }


    /**
        Returns the number of losses the team has.

        @return The loss count.
     */
    public int getLosses() {
        return this.losses;
    }

    public String getName()
    {
        return this.name;
    }


    /**
     * Adds a game result to the team's record.
     *
     * @param result The game result to add.
     */
    public void addGameResult(GameResult result) {
        this.games.add(result);
    }


    /**
     * Retrieves a game result by its date.
     *
     * @param date The date of the game.
     * @return The game result for the specified date, or null if not found.
     */

    public GameResult getGameResultByDate(LocalDate date) {
        for (GameResult result : this.games) {
            if (result.getDate().equals(date)) {
                return result;
            }
        }
        return null; // or throw an exception if the game result is not found
    }

    // Optionally, a toString method for debugging purposes
    @Override
    public String toString() {
        return name + " Wins: " + wins + ", Losses: " + losses;
    }
}
