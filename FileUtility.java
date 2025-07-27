import java.io.*;
import java.util.Scanner;

/**
 * FileUtility is a Java class that demonstrates basic file handling operations:
 * 1. Writing to a file
 * 2. Reading from a file
 * 3. Modifying the content of a file
 * 
 * Instructions: This script handles file operations using core Java I/O classes.
 * Deliverable: Run this script to create, read, and update a text file.
 * Internship Completion Certificate will be issued on your end date by CODTECH.
 * 
 * Author: [Your Name]
 * Organization: CODTECH Internship
 */
public class FileUtility {

    private static final String FILE_PATH = "codtech_data.txt";

    // Method to write initial content to the file
    public static void writeToFile(String content) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH))) {
            writer.write(content);
            System.out.println("✅ File written successfully.");
        } catch (IOException e) {
            System.err.println("❌ Error writing to file: " + e.getMessage());
        }
    }

    // Method to read content from the file
    public static void readFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            System.out.println("📄 File Content:");
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.err.println("❌ Error reading from file: " + e.getMessage());
        }
    }

    // Method to modify the file content by appending new text
    public static void appendToFile(String newText) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH, true))) {
            writer.newLine(); // add a new line before appending
            writer.write(newText);
            System.out.println("✏️ Content appended successfully.");
        } catch (IOException e) {
            System.err.println("❌ Error appending to file: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Step 1: Write initial content
        System.out.println("🔹 Step 1: Writing initial data to the file...");
        String initialContent = """
                CREATE A JAVA PROGRAM TO READ,
                WRITE, AND MODIFY TEXT FILES.
                COMPLETION CERTIFICATE WILL BE
                ISSUED ON YOUR INTERNSHIP
                END DATE.
                CODTECH
                """;
        writeToFile(initialContent);

        // Step 2: Read and display content
        System.out.println("\n🔹 Step 2: Reading file content...");
        readFromFile();

        // Step 3: Modify file by appending content
        System.out.print("\n🔹 Step 3: Enter content to append to the file: ");
        String additionalContent = scanner.nextLine();
        appendToFile(additionalContent);

        // Step 4: Show updated file
        System.out.println("\n🔹 Step 4: Updated file content:");
        readFromFile();

        scanner.close();
    }
}
