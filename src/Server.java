import java.io.*;
import java.net.*;

public class Server {
    public static void main(String[] args) {
        final int portNumber = 12345;

        try {
            ServerSocket serverSocket = new ServerSocket(portNumber);
            System.out.println("Server started. Listening on port " + portNumber);

            Socket clientSocket = serverSocket.accept();
            System.out.println("Client connected: " + clientSocket);

            BufferedReader input = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter output = new PrintWriter(clientSocket.getOutputStream(), true);

            BufferedReader serverInput = new BufferedReader(new InputStreamReader(System.in));

            String inputLine;
            while ((inputLine = input.readLine()) != null) {
                System.out.println("Client: " + inputLine);
                System.out.print("Server: ");
                String response = serverInput.readLine();
                output.println(response);
            }
        } catch (IOException e) {
            System.out.println("Exception caught when trying to listen on port " + portNumber + " or listening for a connection");
            System.out.println(e.getMessage());
        }
    }
}
