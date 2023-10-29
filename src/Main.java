import java.util.Random;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        Random random = new Random();
        String trash = "";
        boolean playAgain = true;

        while (playAgain)
        {
            int point = 0;
            int rollCount = 0;

            int dice1 = rollDice(random);
            int dice2 = rollDice(random);
            int sum = dice1 + dice2;
            rollCount++;

            System.out.println("Roll " + rollCount + ": " + dice1 + " + " + dice2 + " = " + sum);

            if (sum == 2 || sum == 3 || sum == 12)
            {
                System.out.println("You Crapped out! You lose!");
                playAgain = promptToPlayAgain(in);
                continue;
            }
            else if (sum == 7 || sum == 11)
            {
                System.out.println("Its Natural! You win!");
                playAgain = promptToPlayAgain(in);
                continue;
            }
            else
            {
                point = sum;
                System.out.println("Point are " + point);
            }

            while (true)
            {
                dice1 = rollDice(random);
                dice2 = rollDice(random);
                sum = dice1 + dice2;
                rollCount++;

                System.out.println("Roll " + rollCount + ": " + dice1 + " + " + dice2 + " = " + sum);

                if (sum == point)
                {
                    System.out.println("You Made point! You win!");
                    playAgain = promptToPlayAgain(in);
                    break;
                }
                else if (sum == 7)
                {
                    System.out.println("You got a seven! You lose!");
                    playAgain = promptToPlayAgain(in);
                    break;
                }
                else
                {
                    System.out.println("Trying for points");
                }
            }

            System.out.println();
        }

    }

    private static int rollDice(Random random)
    {
        return random.nextInt(6) + 1;
    }

    private static boolean promptToPlayAgain(Scanner scanner)
    {
        while (true)
        {
            System.out.print("Play again? (Y/N): ");
            String playAgainInput = scanner.nextLine().trim().toUpperCase();

            if (playAgainInput.equals("Y"))
            {
                return true;
            }
            else if (playAgainInput.equals("N"))
            {
                return false;
            }

            System.out.println("Invalid input. Please enter 'Y' or 'N'.");
        }
    }
}