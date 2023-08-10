
import java.util.Scanner;
import java.util.Random;

public class RandomPasswordGenerator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Random Password Generator");

        System.out.print("Enter the desired password length: ");
        int length = scanner.nextInt();

        System.out.print("Use lowercase letters? (y/n): ");
        boolean useLowercase = scanner.next().equalsIgnoreCase("y");

        System.out.print("Use uppercase letters? (y/n): ");
        boolean useUppercase = scanner.next().equalsIgnoreCase("y");

        System.out.print("Use digits? (y/n): ");
        boolean useDigits = scanner.next().equalsIgnoreCase("y");

        System.out.print("Use special characters? (y/n): ");
        boolean useSpecialChars = scanner.next().equalsIgnoreCase("y");

        String password = generatePassword(length, useLowercase, useUppercase, useDigits, useSpecialChars);
        System.out.println("Generated Password: " + password);

        scanner.close();
    }

    public static String generatePassword(int length, boolean useLowercase, boolean useUppercase,
                                          boolean useDigits, boolean useSpecialChars) {
        String characters = "";
        if (useLowercase) {
            characters += "abcdefghijklmnopqrstuvwxyz";
        }
        if (useUppercase) {
            characters += "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        }
        if (useDigits) {
            characters += "0123456789";
        }
        if (useSpecialChars) {
            characters += "!@#$%^&*()-_=+[]{}|;:,.<>?";
        }

        if (characters.isEmpty()) {
            System.out.println("Error: You must select at least one character set.");
            return "";
        }

        Random random = new Random();
        StringBuilder password = new StringBuilder();
        for (int i = 0; i < length; i++) {
            int randomIndex = random.nextInt(characters.length());
            password.append(characters.charAt(randomIndex));
        }
        return password.toString();
    }
}
