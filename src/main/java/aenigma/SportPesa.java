package aenigma;

import java.util.Scanner;

/**
 * Package: aenigma
 * Created by lusinabrian on 01/08/16 or 01 Aug of 2016,
 * Time: 08:43.
 * Project: JxProjects
 * Description: come up with a small program which has an algorithm that computes the bonus rewards for a sportpesa jackpot. Let your program pick input from the user and then awards a cash bonus for 10, 11, and 12 correct predictions. For 13 correct predictions, your algorithm should inform the user that the jackpot has been won, and it should then generate a new value for the jackpot.
 */
public class SportPesa {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter your predictions ");
        int userPred = scan.nextInt();
        System.out.println(bonus(userPred));
    }

    /**
     * Create percentages for the number of predictions.
     * 10 predictions bonus must be less than 11 and 11 less than 12 and 12 less than 13
     * if the user inputs 13, they win the jackpot and generates a new jackpot
     * if the user inputs 10, they win 10% of the jackpot, but jackpot increases in amount
     * Using the Math.random() method, randomize the jackpot and randomize the winnings for each choice
     * then randomize the jackpot and increase the amount of the jackpot
     */
    public static String bonus(int number) {
        String message;
        double jackpot = Math.floor((Math.random() * 10000000));
        System.out.println("Jackpot for today: " + jackpot);
        double winnings;
        String numStr = String.valueOf(number);
        switch (number) {
            case 10:
                winnings = Math.floor(jackpot * Math.random());
                jackpot += Math.floor(Math.random() * jackpot);
                message = "You have made " + numStr + " correct predictions. Your winnings Ksh. " + String.valueOf((int) winnings) + ". New jackpot Ksh. " + String.valueOf((int) jackpot);
                break;
            case 11:
                winnings = Math.floor(jackpot * Math.random());
                jackpot += Math.floor(Math.random() * jackpot);
                message = "You have made " + numStr + " correct predictions. Your winnings Ksh. " + String.valueOf((int) winnings) + ". New jackpot Ksh. " + String.valueOf((int) jackpot);
                break;
            case 12:
                winnings = Math.floor(jackpot * Math.random());
                jackpot += Math.floor(Math.random() * jackpot);
                message = "You have made " + numStr + " correct predictions. Your winnings Ksh. " + String.valueOf((int) winnings) + ". New jackpot Ksh. " + String.valueOf((int) jackpot);
                break;
            case 13:
                winnings = jackpot;
                jackpot += Math.floor(Math.random() * jackpot);
                message = "You have made " + String.valueOf(number) + " correct predictions. You have won the jackpot " + String.valueOf((int) winnings) + ". New jackpot " + String.valueOf((int) jackpot);
                break;
            default:
                jackpot += Math.floor(Math.random() * jackpot);
                message = "Sorry, better luck next time" + ". New jackpot " + String.valueOf((int) jackpot);
                break;
        }

        return message;
    }/*end*/

/*CLASS END*/
}