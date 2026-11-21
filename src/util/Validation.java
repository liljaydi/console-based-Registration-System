package util;
import java.util.Scanner;

public class Validation {
    public static int readValidInteger(Scanner sc, int minRange, int maxRange) {
        int attempts = 0;
        while (attempts < 5) {
            System.out.print("Enter choice: ");
            // receive user input as a string
            String input = sc.nextLine().trim();
            try {
                // Convert the input string into an integer
                int number = Integer.parseInt(input);
                if (number >= minRange && number <= maxRange) {
                    return number;
                } else {
                    System.out.println("Please enter an integer between " 
                        + minRange + " and " + maxRange);
                }
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid integer");
            }
            attempts++;
        }
        System.out.println("Too many failed attempts");
        System.out.println("Exiting...");
        System.exit(0); // terminate program
        return 0;
    }
}
