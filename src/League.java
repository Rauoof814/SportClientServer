import java.util.ArrayList;
import java.util.List;

/**
 * Manages a collection of teams within a league. This class allows for the addition of teams to the league
 * and supports retrieval of team information, such as getting a team by name or generating standings. It acts as a central
 * repository for managing team-related operations within the league context.
 *
 * @author Abdul Rahmani
 * @version 1.0
 *  Date: 03/15/2024
 */

public class League
{
    // A list to hold the teams within the league.
    private List<Team> teams;


    /**
     * Constructor for the League class. Initializes the list of teams.
     */
    public League() {
        this.teams = new ArrayList<>();
    }


    /**
     * Adds a new team to the league.
     *
     * @param team The team to be added to the league.
     */
    public void addTeam(Team team) {
        this.teams.add(team);
    }


    /**
     * Retrieves a team by its name.
     *
     * @param name The name of the team to find.
     * @return The Team object if found, null otherwise.
     */
    public Team getTeamByName(String name)
    {
        for (Team team : this.teams)
        {
            if (team.getName().equals(name))
            {
                return team;
            }
        }
        return null; // or throw an exception if the team is not found
    }

    /**
     * Generates the current standings of all teams within the league.
     * This method can be extended to sort teams according to their wins, losses, or other criteria.
     * Currently, it returns the list of teams without sorting.
     *
     * @return A list of teams in the league.
     */

    // Optionally, to get standings, you might want to sort teams by wins or other criteria
    public List<Team> getStandings() {
        // This method could return a list of teams sorted by wins, for example
        // For simplicity, returning the unsorted list for now
        return this.teams;
    }
}
