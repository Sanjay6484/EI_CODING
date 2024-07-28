import java.util.Scanner;

public class SportsLobby {
    
    private static final Scanner scanner = new Scanner(System.in);
    private static final Commentary cricketMatch = new Commentary();

    public static void main(String[] args) {
        boolean running = true;
        while (running) {
            System.out.println("Select an option:");
            System.out.println("1. Register users");
            System.out.println("2. Enter match commentaries");
            System.out.println("3. Exit");

            int choice = getValidIntegerInput();

            switch (choice) {
                case 1:
                    registerUsers();
                    break;
                case 2:
                    enterCommentaries();
                    break;
                case 3:
                    running = false;
                    System.out.println("Exiting the application.");
                    break;
                default:
                    System.out.println("Invalid choice. Please select a valid option.");
                    break;
            }
        }

        scanner.close();
    }

    private static void registerUsers() {
        System.out.println("Enter the number of users to subscribe: ");
        int numberOfUsers = getValidIntegerInput();
        
        for (int i = 0; i < numberOfUsers; i++) {
            String name = getValidName(i + 1);
            String phoneNumber = getValidPhoneNumber(i + 1);
            
            User user = new User(name, phoneNumber);
            cricketMatch.registerObserver(user);
        }
    }

    private static void enterCommentaries() {
        System.out.println("Start entering match commentaries (type 'exit' to stop):");
        while (true) {
            String commentary = scanner.nextLine();
            if (commentary.equalsIgnoreCase("exit")) {
                break;
            }
            cricketMatch.setCommentary(commentary);
        }
    }

    private static int getValidIntegerInput() {
        while (true) {
            try {
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");
            }
        }
    }

    private static String getValidName(int userIndex) {
        while (true) {
            System.out.println("Enter name for user " + userIndex + ": ");
            String name = scanner.nextLine();
            if (name.matches("[a-zA-Z]+")) {
                return name;
            } else {
                System.out.println("Invalid name. Please enter a name with only characters.");
            }
        }
    }

    private static String getValidPhoneNumber(int userIndex) {
        while (true) {
            System.out.println("Enter phone number for user " + userIndex + ": ");
            String phoneNumber = scanner.nextLine();
            if (phoneNumber.matches("\\d+")) {
                return phoneNumber;
            } else {
                System.out.println("Invalid phone number. Please enter a phone number with only digits.");
            }
        }
    }
}
