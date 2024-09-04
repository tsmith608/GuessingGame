import java.util.Random;
import java.util.Scanner;

public class GuessingGame {

    static int easyHighScore = Integer.MAX_VALUE;
    static int mediumHighScore = Integer.MAX_VALUE;
    static int hardHighScore = Integer.MAX_VALUE;

    public static void main(String[] args) {
        System.out.println("welcome to the number guessing game (｡◕‿‿◕｡)");
        System.out.println("guess the number between 1 and 100... if you dare (ง •̀_•́)ง ");
        System.out.println("choose your difficulty");
        System.out.println("1. easy (15 attempts)");
        System.out.println("2. medium (10 attempts)");
        System.out.println("3. hard (5 attempts)");

        Scanner scanner = new Scanner(System.in);
        int userGuess = 0;
        int attempts = 0;
        int maxAttempts = 0;
        int difficultyLevel = 0;

        Random random = new Random();
        int targetNumber = random.nextInt(100) + 1;



        while(true){
            //start new game
            playGame(scanner)
            break;
        }
        //switch statement to choose difficulty
        while (true) {
            System.out.println("choose 1,2,3: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1: maxAttempts = 15;
                    difficultyLevel = 1;
                    System.out.println("easy");
                    break;
                case 2: maxAttempts = 10;
                difficultyLevel = 2;
                    System.out.println("medium");
                    break;
                case 3: maxAttempts = 5;
                difficultyLevel = 3;
                    System.out.println("hard");
                    break;
                default:
                    System.out.println("wrong choice choose 1,2 or 3");
            }
            break;
        }

        //start timer
        long sartTime = System.currentTimeMillis();


        //game loop
        while (attempts < maxAttempts) {
            System.out.println("enter guess, (or type -1 for a hint)");
            userGuess = scanner.nextInt();
            attempts++;

            if (userGuess == -1) {
                provideHint(targetNumber, attempts);
                continue;
            }

            switch (Integer.compare(userGuess, targetNumber)) {
                case 0:
                    long endTime = System.currentTimeMillis();
                    long elapsedTime = (endTime - sartTime) / 1000;
                    System.out.println("Congratulations! You guessed the number, " + userGuess + ". in " + attempts +
                            " attempts, and " + elapsedTime + " seconds. (✿◠‿◠)");
                    updateHighscore(difficultyLevel, attempts);
                    diplayHighScore();
                    return;
                case -1:
                    System.out.println("The number is greater than your guess.");
                    break;
                case 1:
                    System.out.println("The number is less than your guess.");
                    break;

            }
        }

        if (attempts == maxAttempts) {
            System.out.println("Sorry, you're out of attempts ୧༼ಠ益ಠ╭∩╮༽ the number was " + targetNumber + ".");
            diplayHighScore();
        }

        }

    //method for giving out hints
    private static void provideHint(int targetNumber, int attempts) {
        if (attempts >= 3) {
            // is it odd or even
            String parityHint = (targetNumber % 2 == 0) ? "even" : "odd";
            System.out.println("the number is " + parityHint);

            if (targetNumber <= 50) {
                System.out.println("the number is less than 50");
            } else {
                System.out.println("the number is greater than than 50");
            }
        } else {
                System.out.println("hints only after three attempts");
            }
        }
    //update high scores
    private static void updateHighscore(int difficultyLevel, int attempts) {
        switch (difficultyLevel) {
            case 1: //easy
                if (attempts < easyHighScore) {
                    easyHighScore = attempts;
                    System.out.println("\nnew high score for easy (╯°□°)╯");
                } break;
            case 2: //med
                if (attempts < mediumHighScore) {
                    mediumHighScore = attempts;
                    System.out.println("\nnew high score for medium (╯°□°)╯");
                } break;
            case 3: //hard
                if (attempts < hardHighScore) {
                    hardHighScore = attempts;
                    System.out.println("\nnew high score for hard (╯°□°)╯");
                } break;
        }
    }
    public static void diplayHighScore() {
        System.out.println("\n--- high scores (⌐■_■) ---");
        System.out.println("easy: " + (easyHighScore == Integer.MAX_VALUE ? "no score" : easyHighScore + " attempts"));
        System.out.println("medium: " + (mediumHighScore == Integer.MAX_VALUE ? "no score" : mediumHighScore + " attempts"));
        System.out.println("hard: " + (hardHighScore == Integer.MAX_VALUE ? "no score" : hardHighScore + " attempts"));
        System.out.println("--------------------------\n");
    }
}


