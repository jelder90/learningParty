/**
 * Created with IntelliJ IDEA.
 * User: michelle
 * Date: 11/1/12
 * Time: 8:08 PM
 * To change this template use File | Settings | File Templates.
 */
class LinkListTest {
    public static void main(String[] args) {
        LinkList list = new LinkList();

        list.insert(1, 1.01);
        list.insert(2, 2.02);
        list.insert(3, 3.03);
        list.insert(4, 4.04);
        list.insert(5, 5.05);

        list.printList();

        while(!list.isEmpty()) {
            Link deletedLink = list.delete();
            System.out.print("deleted: ");
            deletedLink.printLink();
            System.out.println("");
        }
        list.printList();
    }
}
