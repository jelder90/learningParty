/**
 * Created with IntelliJ IDEA.
 * User: michelle
 * Date: 12/13/12
 * Time: 8:22 AM
 * To change this template use File | Settings | File Templates.
 */
public class TestBlackJack {

    public static void main(String[] args) {

        System.out.println("Let's play BlackJack!");
        System.out.println("Here are two cards to begin the game.");

        Dealer newDealer = new Dealer();
        int[] userHand = new int[10];

        // start the game with two random cards
        userHand[0] = newDealer.dealCard();
        userHand[1] = newDealer.dealCard();

        // display the user's hand
        System.out.println("Your hand: ");
        for (int i = 0; i < userHand.length; i++) {
            System.out.print(userHand[i] + " ");
        }

        /*
        next steps:
        -dealer needs a hand
        -hit method to add cards to hand
        -logic for a bust
        ...
         */
    }
}
