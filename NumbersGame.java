import java.util.Random;

public class NumbersGame {
    public static void main(String[] args) {
        System.out.println("Hello, human. I am thinking of a number between 0 and 10.");
        System.out.println("*********************************************************");
        System.out.println("Can you guess the number?\n");
        System.out.println("If you are not up to the task, you can always type 'q' to quit.\n");

        int attempts = 0; // Keeps track of the number of attempts the user has made
        boolean hasGuessedCorrectly = false; // Indicates if the user has guessed the correct number
        Random random = new Random();
        int answer = random.nextInt(11); // Generates a random number between 0 and 10 (inclusive)
        //System.out.println(answer); // Prints the answer to the console for testing purposes

        while (attempts < 3 && !hasGuessedCorrectly) { // Allows the user to guess up to three times
            String guess = System.console().readLine();

            if (guess.equals("q")) {
                System.out.println("I knew you didn't have it in you.");
                System.out.println("Shutting down...");
                return; // Exits the program if the user chooses to quit
            }

            try {
                int parsedGuess = Integer.parseInt(guess);

                if (parsedGuess < 0 || parsedGuess > 10) { // Checks if the user's guess is within the range
                    System.out.println("\nInvalid guess! The number should be between 0 and 10."); // Checks if the user's guess is within the range
                } else if (parsedGuess == answer) { // Checks if the user's guess is correct
                    System.out.println("\nLucky guess! But can you do it again?"); 
                    hasGuessedCorrectly = true; // Sets the flag to true if the user guesses the correct number
                } else { // Executes if the user's guess is incorrect
                    System.out.println("\nSeriously? That's not even close!");
                    attempts++; // Increments the number of attempts if the user guesses incorrectly
                }
            } catch (NumberFormatException e) {
                System.out.println("\nInvalid input! Please enter a number or 'q' to quit.\n");
            }
        }

        if (hasGuessedCorrectly) {
            System.out.println("\nYou win!");
        } else {
            System.out.println("\nYou failed! Better luck next time.");
        }

        System.out.println("\nDo you want to play again? (y/n)");
        String playAgain = System.console().readLine();

        if (playAgain.equals("y")) {
            main(args); // Recursively calls the main method to start a new game if the user wants to play again
        } else {
            System.out.println("Game over. Shutting down...");
        }
    }
}
