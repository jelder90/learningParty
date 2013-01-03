import java.util.ArrayList;
import java.util.Scanner;




/**
 * Created with IntelliJ IDEA.
 * User: Michelle Leonhart
 * Date: 12/13/12
 * Time: 8:22 AM
 * To change this template use File | Settings | File Templates.
 */


/* This BlackJack game makes some assumptions for simplicity's sake:
   - Only two players: One human, one AI Dealer
   - Only card values of 1-11 shown.
   - Game is won by player whose cards in hand sum to a value <= 21. Sum of > 21 = bust.
 */

public class TestBlackJack {

    public static void main(String[] args) {
        ArrayList<Integer> usersHand = new ArrayList<Integer>();
        ArrayList<Integer> dealersHand = new ArrayList<Integer>();
        GameEngine evaluateHand = new GameEngine();
        Scanner in  = new Scanner(System.in);

        // Game initialized with two cards for every player
        for (int i = 0; i < 2; i++) {
            usersHand.add(new Card().getCardValue());
            dealersHand.add(new Card().getCardValue());
        }

        displayHands(usersHand, dealersHand);

        Boolean yourTurn = true;
        String hitOrStay = "";

        while (yourTurn) {
            System.out.println("\nType hit or stay.");
            hitOrStay = in.nextLine();

            if (hitOrStay.equals("hit")) {
                usersHand.add(new Card().getCardValue());
                displayHands(usersHand, dealersHand);

                // bust = game over
                if (evaluateHand.isBust(sumHand(usersHand))) System.exit(0);

            } else if (hitOrStay.equals("stay")) {
                displayHands(usersHand, dealersHand);
                yourTurn = false;
            }
        }

        // Very simple AI for Dealer:
        // If sum of cards in hand < 18, hit.
        while (sumHand(dealersHand) < 18) {
            System.out.println("The Dealer chooses to hit.");
            dealersHand.add(new Card().getCardValue());
            displayHands(usersHand, dealersHand);
        }

        evaluateHand.chooseWinner(sumHand(usersHand), sumHand(dealersHand));
    }

    public static int sumHand(ArrayList<Integer> hand) {
        int sumTot = 0;
        for (Integer cardVal:hand) {
            sumTot = sumTot + cardVal;
        }

        return sumTot;
    }

    public static void displayHands(ArrayList usersHand, ArrayList dealersHand) {
        System.out.println("\nYour hand " + usersHand + " total: " + sumHand(usersHand));
        System.out.println("Dealer's hand " + dealersHand + " total: " + sumHand(dealersHand) + "\n");
    }
}



