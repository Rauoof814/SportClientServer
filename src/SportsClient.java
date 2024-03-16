import java.io.*;
import java.net.Socket;
import java.util.Scanner;

/***
 * SportsClient allows users to connect to the SportsServer, send requests, and receive responses.
 * It facilitates interaction with the sports information system through a command-line interface.
 * Users can input commands to retrieve sports data, and the client communicates with the server to process these commands.
 *
 * @author Abdul Rahmani
 * @version 1.0
 *
 * Date: 03/15/2024
 */

public class SportsClient
{

    // Server address to connect to. Here it's set to localhost for demonstration.
    private static final String SERVER_ADDRESS = "127.0.0.1";

    // Port number on which the server is listening.
    private static final int SERVER_PORT = 12345;

    public static void main(String[] args)
    {
        // Establish a connection to the server using the server address and port.
        try (Socket socket = new Socket(SERVER_ADDRESS, SERVER_PORT);

             // Output stream to send messages to the server.
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             // Input stream to receive messages from the server.
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             Scanner scanner = new Scanner(System.in)) {

            String userInput;
            System.out.println("Connected to SportsServer. Type your commands:");

            // Loop to read user commands from the console until "QUIT" is entered.
            while (!(userInput = scanner.nextLine()).equalsIgnoreCase("QUIT")) {
                out.println(userInput);
                System.out.println("Server says: " + in.readLine());
            }

            // Continuation from the previously provided code snippet
            System.out.println(userInput); // Send the QUIT command to the server
            String response = in.readLine(); // Read the server's final response
            System.out.println("Server says: " + response);
        }
        catch (IOException e)
        {
            // Catch and display any errors encountered while trying to connect or communicate with the server.
            System.out.println("Unable to connect to the server at " + SERVER_ADDRESS + ":" + SERVER_PORT);
            System.out.println("Please make sure the server is running and try again.");
            System.out.println(e.getMessage());
        }
        System.out.println("Disconnected from SportsServer.");
    }
}

