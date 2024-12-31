import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {

    public static void main(String[] args) {
        final int LOWER_BOUND = 1;
        final int UPPER_BOUND = 100;

        Scanner scanner = new Scanner(System.in);
        boolean playAgain = true;

        System.out.println("Welcome to the Number Guessing Game!");

        while (playAgain) {
            // Generate a random number for the new game
            Random random = new Random();
            int randomNumber = random.nextInt(UPPER_BOUND - LOWER_BOUND + 1) + LOWER_BOUND;

            int trys;

            System.out.println("""
                    I'm thinking of a number between 1 and 100.  

                    Please select the difficulty level:  
                    1. Easy (10 chances)  
                    2. Medium (5 chances)  
                    3. Hard (3 chances)  

                    Enter your choice:  
                    """);

            int difficulty = scanner.nextInt();

            switch (difficulty) {
                case 1:
                    trys = 10;
                    break;
                case 2:
                    trys = 5;
                    break;
                case 3:
                    trys = 3;
                    break;
                default:
                    System.out.println("Error! Invalid option. Restarting the game.");
                    continue; // Restart the loop if invalid input
            }

            // Start the guessing game
            Guess(randomNumber, trys, scanner);

            // Ask if the user wants to play again
            System.out.println("Do you want to play again? (yes/no)");
            String response = scanner.next();
            playAgain = response.equalsIgnoreCase("yes") || response.equalsIgnoreCase("y");
        }

        System.out.println("Thank you for playing! Goodbye!");
        scanner.close();
    }

    public static void Guess(int num, int trys, Scanner scanner) {
        int attempts = 1;

        while (attempts < trys) {
            System.out.println("Enter your guess: ");
            int guess = scanner.nextInt();
            attempts++;

            if (num > guess) {
                System.out.println("Incorrect! The number is greater than " + guess);
            } else if (num < guess) {
                System.out.println("Incorrect! The number is less than " + guess);
            } else {
                System.out.println("Congratulations! You guessed the correct number in " + attempts + " attempts.");
                return; // Exit the method after a correct guess
            }

            if (attempts >= trys) {
                System.out.println("Sorry, you've run out of attempts! The correct number was: " + num);
                return;
            }
        }
    }
}
