import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/***
 * SportsServer sets up a server socket to listen for client connections on a specified port.
 * Upon receiving a connection, it reads requests from the client, processes these requests using a SportsService instance,
 * and sends back responses. The server handles multiple client connections by continuously listening for new connections
 * and processes client requests in a loop until a "QUIT" command is received.
 *
 * @author Abdul Rahmani
 * @version 1.0
 */

public class SportsServer
{

    // Server port number to listen on for incoming connections.
    private static final int PORT = 12345;

    public static void main(String[] args) throws IOException
    {
        League league = new League(); // Initialize league and teams here
        SportsService service = new SportsService(league);


        // Try-with-resources statement to automatically manage the server socket resource.
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("SportsServer listening on port " + PORT);

            // Server enters an infinite loop, continuously accepting client connections.
            while (true)
            {
                // Accept a client connection and set up streams for communication.
                try (Socket clientSocket = serverSocket.accept();
                     BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                     PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true)) {

                    String inputLine;
                    // Read and process client requests until a "QUIT" command or null input is received.
                    while ((inputLine = in.readLine()) != null)
                    {
                        String response = service.processRequest(inputLine);
                        out.println(response); // Send the response back to the client.

                        if ("QUIT".equals(response))
                        {
                            break; // Exit the loop if "QUIT" is received.
                        }
                    }
                }
                catch (IOException e)
                {
                    // Log any exceptions encountered during the connection handling.
                    System.out.println("Exception caught when trying to listen on port "
                            + PORT + " or listening for a connection");
                    System.out.println(e.getMessage());
                }
            }
        }
    }
}
