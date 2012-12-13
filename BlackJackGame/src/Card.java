import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 * User: michelle
 * Date: 12/13/12
 * Time: 8:04 AM
 * To change this template use File | Settings | File Templates.
 */

public class Card {

    /*Card values in Blackjack are 1-11.
    Ignoring card symbol, colour, and royalty
    for now.  (Royal values are 11s.)
     */

    public Card () {
        Random generator = new Random();
        int shuffledFaceValue = generator.nextInt(11) + 1;
        faceValue = shuffledFaceValue;
    }

    public int faceValue;


    public int getFaceValue () {
        return faceValue;
    }

    // will I need to set the value of the card? cards have static values...
    public void setFaceValue (int newValue) {
        faceValue = newValue;
    }
}
