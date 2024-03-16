import java.time.LocalDate;

/**
 * Represents the result of a game involving a team. This class stores details about the game such as the date,
 * the opponent's name, the scores of both the team and the opponent. It serves as a way to track the performance
 * of a team over time by recording the outcomes of its games.
 *
 * @author Abdul Rahmani
 * @version 1.0
 *  Date: 03/15/2024
 */

public class GameResult
{

    // The date on which the game was played.
    private LocalDate date;

    // The name of the opponent team.
    private String opponentName;

    // The score achieved by the team.
    private int teamScore;

    // The score achieved by the opponent team.
    private int opponentScore;


    /**
     * Constructs a GameResult object with the provided details of the game.
     *
     * @param date The date of the game.
     * @param opponentName The name of the opponent team.
     * @param teamScore The score of the team.
     * @param opponentScore The score of the opponent team.
     */
    public GameResult(LocalDate date, String opponentName, int teamScore, int opponentScore)
    {
        this.date = date;
        this.opponentName = opponentName;
        this.teamScore = teamScore;
        this.opponentScore = opponentScore;
    }



    public LocalDate getDate() {
        return date;
    }

    public String getOpponentName() {
        return opponentName;
    }

    public int getTeamScore() {
        return teamScore;
    }

    public int getOpponentScore() {
        return opponentScore;
    }
}
