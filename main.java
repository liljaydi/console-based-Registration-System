import java.util.Scanner;
import service.RegistrationHandler;

public class main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        RegistrationHandler register = new RegistrationHandler(sc);

        System.out.println("TECH SUMMIT EVENT REGISTRATION\n");

        int choice;
        do {
            System.out.println("[1] Register Attendee (Queue)");
            System.out.println("[2] Process Registration");
            System.out.println("[3] View Attendee (Sorted Alphabetically)");
            System.out.println("[4] Search Attendee");
            System.out.println("[5] Undo Last Registration");
            System.out.println("[6] Exit");
            System.out.println("-----------------------------------------");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine();
            System.out.println();

            switch (choice) {
                case 1:
                    register.registerAttendee();
                    break;
                case 2:
                    register.processRegistration();
                    break;
                case 3:
                    register.viewAttendees();
                    break;
                case 4:
                    register.searchAttendee();
                    break;
                case 5:
                    register.undoLastRegistration();
                    break;
                case 6:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice\n");
            }
        } while (choice != 6);
    }
}