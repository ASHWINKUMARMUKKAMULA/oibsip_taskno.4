import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Login {

    private static Map<String, String> users = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Welcome to the Simple Authentication System");
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Exit");
            System.out.print("Please select an option: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    registerUser(scanner);
                    break;
                case 2:
                    loginUser(scanner);
                    break;
                case 3:
                    System.out.println("Goodbye!");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private static void registerUser(Scanner scanner) {
        System.out.print("Enter a username: ");
        String username = scanner.next();
        if (users.containsKey(username)) {
            System.out.println("Username already exists. Please choose a different one.");
            return;
        }

        System.out.print("Enter a password: ");
        String password = scanner.next();
        users.put(username, password);
        System.out.println("Registration successful!");
    }

    private static void loginUser(Scanner scanner) {
        System.out.print("Enter your username: ");
        String username = scanner.next();

        System.out.print("Enter your password: ");
        String password = scanner.next();
        if (users.containsKey(username)) {
            if (users.get(username).equals(password)) {
                System.out.println("Login successful! You can now access the secured page.");
            } else {
                System.out.println("Incorrect password. Please try again.");
            }
        } else {
            System.out.println("Username not found. Please register first.");
        }
    }
}
