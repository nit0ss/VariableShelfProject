package debugger;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Debugger {

    public static void main(String[] args) {
        // Specify the path to the result.txt file
        String filePath = "result.txt";

        // Check if the file follows the OBJ format
        boolean isValidFormat = checkOBJFormat(filePath);

        // Display success or error message based on the format check
        if (isValidFormat) {
            System.out.println("Success! The file follows the OBJ format.");
        } else {
            System.out.println("Error! The file does not follow the OBJ format.");
            System.out.println("First line of error: " + getFirstErrorLine(filePath));
        }
    }

    private static boolean checkOBJFormat(String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (!line.startsWith("v") && !line.startsWith("f")) {
                    return false;
                }
            }
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    private static String getFirstErrorLine(String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (!line.startsWith("v") && !line.startsWith("f")) {
                    return line;
                }
            }
            return "";
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }
}
