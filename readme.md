**Sports Scores Access Protocol (SSAP)**

**Overview**

The Sports Scores Access Protocol (SSAP) is a simple client-server communication protocol designed for tracking and 
retrieving sports scores, specifically for basketball teams. This protocol allows clients to interact with the server to 
query game scores, team wins, losses, and league standings.

Author: Abdul Rahmani

Application Domain: Sports Score Tracking for Basketball Teams

Protocol Commands
GET_SCORE teamName date: Retrieves the score for a specific game by date for teamName.
GET_WINS teamName: Retrieves the number of wins for teamName.
GET_LOSSES teamName: Retrieves the number of losses for teamName.
GET_STANDING: Retrieves the standing of all teams by wins and losses.
QUIT: Quits the connection.

**Server Response**

For GET_SCORE: Responds with teamName opponentName teamScore opponentScore.
For GET_WINS: Responds with teamName wins.
For GET_LOSSES: Responds with teamName losses.
For GET_STANDING: Responds with teamName wins losses for all teams.
For QUIT: No response as the connection is terminated.

**Description**

This protocol is designed to serve as an intermediary for clients to obtain up-to-date sports scores and team standings. 
Using SSAP, clients can send specific commands to the server and receive the desired sports information in return.

**Data Structures**

**Team Class**

Private fields:

String name: The name of the team.
int wins: The number of games won.
int losses: The number of games lost.
ArrayList<GameResult> games: A list of game results.


Public methods:

Team(String teamName): Constructs a team with the given name, 0 wins, and 0 losses.
void recordWin(): Records a win for the team.
void recordLoss(): Records a loss for the team.
int getWins(): Returns the number of wins.
int getLosses(): Returns the number of losses.
void addGameResult(GameResult result): Adds a game result to the games list.
GameResult getGameResultByDate(LocalDate date): Returns the game result for the specified date.

**GameResult Class**

**Fields:**
LocalDate date: The date of the game.
String opponentName: The name of the opponent team.
int teamScore: The score of the team.
int opponentScore: The score of the opponent team.

**Teams Collection**

An ArrayList<Team> of Team objects that allows for the dynamic addition of teams as the league expands or contracts.

**Usage**

The SSAP is designed for ease of use. Clients can connect to the server and issue text-based commands following the 
SSAP format. The server processes these commands and returns the results in a predefined format.