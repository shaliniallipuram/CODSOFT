import java.util.Random;
import java.util.Scanner;

public class GuessTheNumber {

    public static void main(String[] args) {
        // Step 1: Generate a random number within the specified range
        int lowerLimit = 1;
        int upperLimit = 100;
        Random random = new Random();
        int secretNumber = random.nextInt(upperLimit - lowerLimit + 1) + lowerLimit;

        int maxAttempts = 5;
        int roundsPlayed = 0;
        int totalAttempts = 0;
        boolean playAgain = true;

        Scanner scanner = new Scanner(System.in);

        while (playAgain) {
            System.out.println("\nRound " + (roundsPlayed + 1) + ": Guess the number between " + lowerLimit + " and " + upperLimit);

            // Step 2: Prompt the user to enter their guess
            for (int attempt = 0; attempt < maxAttempts; attempt++) {
                System.out.print("Enter your guess: ");
                int userGuess = scanner.nextInt();

                // Step 3: Compare the user's guess and provide feedback
                if (userGuess == secretNumber) {
                    System.out.println("Congratulations! You guessed the correct number in " + (attempt + 1) + " attempts.");
                    totalAttempts += attempt + 1;
                    break;
                } else if (userGuess < secretNumber) {
                    System.out.println("Too low! Try again.");
                } else {
                    System.out.println("Too high! Try again.");
                }

                if (attempt == maxAttempts - 1) {
                    System.out.println("Sorry, you've reached the maximum number of attempts. The correct number was " + secretNumber + ".");
                }
            }

            // Ask if the user wants to play again
            System.out.print("Do you want to play again? (yes/no): ");
            String playAgainInput = scanner.next().toLowerCase();
            playAgain = playAgainInput.equals("yes");

            roundsPlayed++;
        }

        System.out.println("Thanks for playing! Your average number of attempts: " + (totalAttempts / roundsPlayed));
        scanner.close();
    }
}
