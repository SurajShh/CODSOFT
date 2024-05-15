import java.util.Scanner;
import java.util.Random;

public class NumberGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        boolean playAgain = true;

        while (playAgain) {
            int minRange = 1;
            int maxRange = 100;
            int attempts = 0;
            int randomNumber = random.nextInt(maxRange - minRange + 1) + minRange;
            boolean guessedCorrectly = false;

            System.out.println("Welcome to Guess The Number!");
            System.out.println("I have chosen a number between " + minRange + " and " + maxRange + ". Try to guess it.");

            while (!guessedCorrectly) {
                System.out.print("Enter your guess: ");
                int userGuess = scanner.nextInt();
                attempts++;

                if (userGuess == randomNumber) {
                    System.out.println("Congratulations! You guessed the number " + randomNumber + " correctly in " + attempts + " attempts.");
                    guessedCorrectly = true;
                } else if (userGuess < randomNumber) {
                    System.out.println("Too low! Try again.");
                } else {
                    System.out.println("Too high! Try again.");
                }
            }

            System.out.print("Do you want to play again? (yes/no): ");
            String playAgainResponse = scanner.next().toLowerCase();
            if (!playAgainResponse.equals("yes")) {
                playAgain = false;
                System.out.println("Thank you for playing Guess The Number!");
            }
        }
        scanner.close();
    }
}
