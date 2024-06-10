
import java.util.Random;
import java.util.Scanner;

public class GuessTheNumber{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.println("Welcome to the Number Guessing Game!");

        boolean playAgain;
        do {
            
            System.out.println("Enter the number of rounds you want to play: ");
            int numberOfRounds = scanner.nextInt();
            System.out.println("You've 7 attempts to guess the number.Play Wise!!!!!");
            int maxAttempts = 7;

            int totalScore = 0;

            for (int round = 1; round <= numberOfRounds; round++) {
                int randNumber = random.nextInt(100) + 1; 
                boolean correct = false;
                int attempts = 0;

                System.out.println("Round " + round );

                while (attempts < maxAttempts) {
                    System.out.print("Enter your number to guess:");
                    int guess = scanner.nextInt();
                    attempts++;

                    if (guess == randNumber) {
                        System.out.println("Congratulations! You guessed the correct number.");
                      correct = true;
                        totalScore += (maxAttempts - attempts + 1); 
                        break;
                    } else if (guess < randNumber) {
                        System.out.println("Your guess is too low.");
                    } else {
                        System.out.println("Your guess is too high.");
                    }
                }

                if (!correct) {
                    System.out.println("Sorry, you ran out of attempts. The correct number was " + randNumber);
                }
            }

            // Display total score
            System.out.println("Your total score after " + numberOfRounds + " rounds is: " + totalScore);

            // Ask if the user wants to play again
            System.out.print("Do you want to play again? (yes/no): ");
            playAgain = scanner.next().equalsIgnoreCase("yes");

        } while (playAgain);

        System.out.println("Thank you for playing Guess The Number!");
        scanner.close();
    }
}
