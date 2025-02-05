
import java.nio.file.*;
import java.util.*;

public class FileHandlingUtility {

    // Method to read the contents of a text file
    public static void readFile(String filePath) {
        try {
            // Using BufferedReader to read the file line by line
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            String line;
            System.out.println("Reading the file contents:");
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
            reader.close();
        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        }
    }

    // Method to write to a text file
    public static void writeFile(String filePath, String content) {
        try {
            // Using BufferedWriter to write content to the file
            BufferedWriter writer = new BufferedWriter(new FileWriter(filePath));
            writer.write(content);
            writer.newLine();
            writer.close();
            System.out.println("Content successfully written to the file.");
        } catch (IOException e) {
            System.err.println("Error writing to the file: " + e.getMessage());
        }
    }

    // Method to append new content to an existing text file
    public static void appendToFile(String filePath, String content) {
        try {
            // Using FileWriter with 'append' mode to add new content to the file
            BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true));
            writer.write(content);
            writer.newLine();
            writer.close();
            System.out.println("Content successfully appended to the file.");
        } catch (IOException e) {
            System.err.println("Error appending to the file: " + e.getMessage());
        }
    }

    // Main method to demonstrate the file operations
    public static void main(String[] args) {
        String filePath = "example.txt";  // File path to perform operations

        // Writing content to the file
        String contentToWrite = "This is the initial content of the file.";
        writeFile(filePath, contentToWrite);

        // Reading the content of the file
        readFile(filePath);

        // Appending new content to the file
        String contentToAppend = "This is the appended content to the file.";
        appendToFile(filePath, contentToAppend);

        // Reading the updated content of the file
        readFile(filePath);
    }
}
