package util;
import java.util.Scanner;

public class Validation {
    public static int readValidInteger(String prompt, Scanner sc, int range1, int range2) {
        int attempts = 0;
        while (attempts < 4) {
            System.out.print(prompt);
            String input = sc.nextLine().trim();
            try {
                // tries to turn a character number into an integer
                int number = Integer.parseInt(input);
                if (number >= range1 && number <= range2) {
                    return number;
                } else {
                    System.out.println("Please enter an integer between " + range1 + 
                        " and " + range2);
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
