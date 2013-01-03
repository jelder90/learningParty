import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * User: michelle
 * Date: 1/2/13
 * Time: 11:10 AM
 * To change this template use File | Settings | File Templates.
 */
public class GameEngine {

    // criteria to bust: score > 21
    boolean isBust(int handSum) {

        if (handSum > 21) {
            System.out.println("Bust!");
            return true;
        } else {
            return false;
        }
    }


    // criteria to win: dealer busts, or you are closer to 21 than dealer is
    void chooseWinner (int yourScore, int dealerScore) {

       if (this.isBust(dealerScore) || yourScore > dealerScore) {
            System.out.println("You win!");
       } else {
            System.out.println("Dealer wins!");

       }
    }
}
