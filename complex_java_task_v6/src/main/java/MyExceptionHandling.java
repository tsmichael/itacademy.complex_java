import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MyExceptionHandling {
    public static InputStreamReader stream_Reader = new InputStreamReader(System.in);
    public static BufferedReader keyboard = new BufferedReader(stream_Reader);

    public static int handlingOFIncorrectExitFromMenu() throws IOException {
        int console;
        try {
            console = Integer.parseInt(keyboard.readLine());
        } catch (Exception NumberFormatException) {
            // special out from exception
            console = 481;

        }
        return console;
    }

}
