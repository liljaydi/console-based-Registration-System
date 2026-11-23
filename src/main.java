import java.util.Scanner;
import service.RegistrationHandler;
import util.Validation;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        RegistrationHandler register = new RegistrationHandler(sc);

        System.out.println("     ===============================");
        System.out.println("     |                             |");
        System.out.println("     |  EVENT REGISTRATION SYSTEM  |");
        System.out.println("     |                             |");
        System.out.println("     ===============================\n");

        int choice;
        do {
            System.out.println("\n--------------- Main Menu ---------------");
            System.out.println("[1] Register Attendee (Queue)");
            System.out.println("[2] Process Registration");
            System.out.println("[3] View Attendee (Sorted Alphabetically)");
            System.out.println("[4] Search Attendee");
            System.out.println("[5] View Registration History");
            System.out.println("[6] Undo Last Registration");
            System.out.println("[7] Exit");
            System.out.println("-----------------------------------------");
            choice = Validation.readValidInteger(sc, 1, 7);
            System.out.println("\n");

            if (choice == 1) register.registerAttendee();
            if (choice == 2) register.processRegistration();
            if (choice == 3) register.viewAttendees();
            if (choice == 4) register.searchAttendee();
            if (choice == 5) register.displayStack();
            if (choice == 6) register.undoLastRegistration();
        } while (choice != 7);

        System.out.println("Exiting...");
    }
}