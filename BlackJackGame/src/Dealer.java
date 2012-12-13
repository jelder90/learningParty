/**
 * Created with IntelliJ IDEA.
 * User: michelle
 * Date: 12/13/12
 * Time: 8:10 AM
 * To change this template use File | Settings | File Templates.
 */
public class Dealer {

    /*
    Dealer can:
    -shuffleCards
    -dealCards
    -hit
     */

    public int dealCard () {
        return new Card().getFaceValue();
    }
}
