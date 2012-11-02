/**
 * Created with IntelliJ IDEA.
 * User: michelle
 * Date: 11/1/12
 * Time: 8:07 PM
 * To change this template use File | Settings | File Templates.
 */
class Link {
    public int data1;
    public double data2;
    public Link nextLink;

    //Link constructor
    public Link(int d1, double d2) {
        data1 = d1;
        data2 = d2;
    }

    //Print Link data
    public void printLink() {
        System.out.print("{" + data1 + ", " + data2 + "} ");
    }
}
