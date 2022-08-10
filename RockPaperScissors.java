import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors {
    static boolean keepPlaying = true;
    static int rounds = -1;
    static Scanner scan = new Scanner(System.in);
    static Random rand = new Random(3);
    // ! 1 = Rock, 2 = paper, 3 = scissors
    static private int playerHand = -1;
    static private int computerHand = -1;
    static private int ties;
    static private int playerWins;
    static private int computerWins;

    public static void main(String[] args) {
        do {
            ties = 0;
            playerWins = 0;
            computerWins = 0;

            howManyRounds();

            for (int i = 0; i < rounds; i++) {
                chooseHand();
                playGame();
            }

            endGame();
            System.out.println("Would you like to play again? Yes or No");
            String again = scan.next();
            if (again.toLowerCase().equals("No") || again.toLowerCase().equals("n")) {
                keepPlaying = false;
            }

        } while (keepPlaying);

        System.out.println("Thank you for playing");
    }

    /**
     * Works out who won round, informs player then increase corresponding tally
     */
    private static void playGame() {
        if (playerHand == computerHand) {
            System.out.println("round was a tie");
            ties++;
        } else if ((playerHand == 2 && computerHand == 1) || (playerHand == 3 && computerHand == 2)
                || (playerHand == 1 && computerHand == 3)) {
            System.out.println("Player Wins round");
            playerWins++;
        } else {
            System.out.println("Computer Wins round");
            computerWins++;
        }
    }

    /**
     * Converts given int into the string rock,paper or scissors
     * @param i player's or computer's hand
     * @return String of either Rock, Paper or Scissors
     */
    private static String handToString(int i) {
        return switch (i) {
            case 1 -> "Rock";
            case 2 -> "Paper";
            case 3 -> "Scissors";
            default -> throw new IllegalArgumentException();
        };
    }

    /**
     * Asks the player how many rounds and sets global variable rounds to given number
     * won't accept any value outside of 1-10, else it will exit program
     */
    private static void howManyRounds() {
        System.out.println("How many rounds would you like to play?");
        int playerRounds = scan.nextInt();

        if (playerRounds > 10 || playerRounds < 1) {
            throw new IllegalArgumentException("Rounds can only be between 1 and 10");
        } else {
            rounds = playerRounds;
        }
    }

    /**
     * Asks the user to choose their next hand, either 1, 2 or 3 and sets variable
     * Set's computer's hand based off random 
     * won't accept any int outside of 1,2,3 and will crash if non-int is entered
     */
    private static void chooseHand() {
        while (true) {
            System.out.println("Choose 1:rock, 2:paper or 3:scissors");
            int x = scan.nextInt();

            if (x == 1 || x == 2 || x == 3) {
                playerHand = x;
                computerHand = rand.nextInt(3) + 1;
                System.out.println("Player chose:\t" + handToString(playerHand) +
                        "\nComputer chose:\t" + handToString(computerHand));
                return;
            } else {
                System.out.println("Please only enter 1, 2 or 3");
            }
        }
    }

    /**
     * Works out who won the game, informing the user then resets tallies to 0
     */
    private static void endGame() {
        if (playerWins > ties && playerWins > computerWins) {
            System.out.println("Player won game");
        } else if (computerWins > playerWins && computerWins > ties) {
            System.out.println("Computer won game");
        } else if ((ties > computerWins && ties > playerWins) || playerWins == computerWins) {
            System.out.println("The game was a tie");
        }

        ties = 0;
        playerWins = 0;
        computerWins = 0;
    }
}
