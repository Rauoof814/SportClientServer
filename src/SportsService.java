import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * This class provides services related to sports data by handling client requests
 * and formatting responses accordingly. It interacts with a League model to
 * retrieve sports statistics and information.
 * It acts as a middleman between the SportsServer and the League model, processing commands like getting scores, wins, losses, and standings.
 *
 * @author Abdul Rahmani
 * @version 1.0
 * Date: 03/15/2024
 */

public class SportsService
{
    // The league instance to access sports data
    private League league;


    /**
     * Constructor initializes the SportsService with a league.
     * @param league The league instance this service will work with.
     */
    public SportsService(League league) {
        this.league = league;
    }


    /**
     * Processes client requests by parsing the command and executing the corresponding action.
     * @param request The client request as a string.
     * @return A string response based on the executed command or an error message.
     */
    public String processRequest(String request) {
//        String[] tokens = request.split(" ");
//        String command = tokens[0];

        String[] tokens = request.trim().split("\\s+"); // Split by whitespace
        if (tokens.length == 0)
        {
            return "ERROR: Empty command";
        }

        String command = tokens[0].toUpperCase(); // To make command case-insensitive

        // Executes the command by calling the corresponding method
        switch (command) {
            case "GET_SCORE":
                return getScore(tokens[1], tokens[2]);
            case "GET_WINS":
                return getWins(tokens[1]);
            case "GET_LOSSES":
                return getLosses(tokens[1]);
            case "GET_STANDING":
                return getStanding();
            case "QUIT":
                return "QUIT";
            default:
                return "ERROR: Unknown command - " + command;
        }
    }

    /**
     * Retrieves the score of a specific game for a given team on a specified date.
     * @param teamName The name of the team.
     * @param date The date of the game in ISO date format.
     * @return A formatted string with the game result or an error message.
     */
    private String getScore(String teamName, String date)
    {
        Team team = league.getTeamByName(teamName);
        if (team == null) return "ERROR: Team not found";
        LocalDate parsedDate = LocalDate.parse(date, DateTimeFormatter.ISO_DATE);
        GameResult result = team.getGameResultByDate(parsedDate);
        if (result == null) return "ERROR: Game not found";
        return String.format("%s vs %s: %d - %d",
                teamName, result.getOpponentName(), result.getTeamScore(), result.getOpponentScore());
    }


    /**
     * Retrieves the number of wins for a specified team.
     *
     * @param teamName The name of the team.
     * @return A string showing the number of wins or an error message.
     */
    private String getWins(String teamName)
    {
        Team team = league.getTeamByName(teamName);
        if (team == null) return "ERROR: Team not found";
        return teamName + " Wins: " + team.getWins();
    }


    /**
     * Retrieves the number of losses for a specified team.
     *
     * @param teamName The name of the team.
     * @return A string showing the number of losses or an error message.
     */
    private String getLosses(String teamName) {
        Team team = league.getTeamByName(teamName);
        if (team == null) return "ERROR: Team not found";
        return teamName + " Losses: " + team.getLosses();
    }


    /**
     * Retrieves the current standing of all teams within the league.
     * @return A formatted string of the league standings.
     */
    private String getStanding() {
        StringBuilder standings = new StringBuilder();
        for (Team team : league.getStandings()) {
            standings.append(team.toString()).append("\n");
        }
        return standings.toString();
    }
}
