/**
 * Created with IntelliJ IDEA.
 * User: michelle
 * Date: 11/1/12
 * Time: 8:19 PM
 * To change this template use File | Settings | File Templates.
 */


public class MyQueue {

    private Node front;
    private Node back;


    public MyQueue() {
        front = back = null;
    }

    public void enqueue(int x) {
        if(front == null)
            back = front = new Node(x);
        else
            back = back.next = new Node(x);
    }

    public Object dequeue() {
        if(front == null) {
            // there has to be a better way to do this
            throw new RuntimeException("Underflow!");
        }

        Object dequeuedNode = front.val;
        front = front.next;
        return dequeuedNode;
    }

    public int getFront() {

        if(front == null) {
            // there has to be a better way to do this
            throw new RuntimeException("getFront Underflow!");
        }

        return front.val;
    }

    public int getBack() {

        if(back == null) {
            // there has to be a better way to do this
            throw new RuntimeException("getBack Underflow!");
        }

        return back.val;
    }

    public void empty() {
        front = null;
        back = null;
    }


}
