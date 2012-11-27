/**
 * Created with IntelliJ IDEA.
 * User: michelle
 * Date: 11/26/12
 * Time: 9:05 PM
 * To change this template use File | Settings | File Templates.
 */

public interface Queue<T> {
    public void enqueue(T item);
    public T dequeue();
    public void clear();
    public int size();
}
