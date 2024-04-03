import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        final String hostName = "127.0.0.1";
        final int portNumber = 12345;

        try {
            Socket socket = new Socket(hostName, portNumber);
            System.out.println("Connected to server.");

            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter output = new PrintWriter(socket.getOutputStream(), true);

            BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));

            String userInputLine;
            while ((userInputLine = userInput.readLine()) != null) {
                output.println(userInputLine);
                System.out.println("Server: " + input.readLine());
            }
        } catch (IOException e) {
            System.err.println("Couldn't get I/O for the connection to " + hostName);
            System.exit(1);
        }
    }
}
