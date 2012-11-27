/**
 * Created with IntelliJ IDEA.
 * User: michelle
 * Date: 11/26/12
 * Time: 9:06 PM
 * To change this template use File | Settings | File Templates.
 */

import java.util.ArrayList;
import java.util.List;

public class WhatQueue<T> implements Queue<T> {
    private List<T> data;

    public WhatQueue() {
        data = new ArrayList<T>();
    }

    @Override
    public void enqueue(T item) {
        if (item != null) {
            synchronized(data) {
                data.add(item);
            }
        }
    }

    @Override
    public T dequeue() {
        if (data.size() == 0) {
            return null;
        }
        synchronized(data) {
            return data.remove(0);
        }
    }

    @Override
    public void clear() {
        data.clear();
    }

    @Override
    public int size() {
        return data.size();
    }

    @Override
    public boolean equals(Object other) {
        // Object is always equal to itself
        if (this == other) {
            return true;
        }

        // Different type cannot be equal
        if (!(other instanceof WhatQueue)) {
            return false;
        }

        @SuppressWarnings("rawtypes")
        WhatQueue otherQueue = (WhatQueue) other;

        // Different sizes; cannot be equal
        if (size() != otherQueue.size()) {
            return false;
        }

        // Compare each item for equality
        for (int i = 0; i < data.size(); i++) {
            if (!(data.get(i).equals(otherQueue.data.get(i)))) {
                return false;
            }
        }

        // To get this far the two queues must have same items
        return true;
    }

    @Override
    public int hashCode() {
        int result = 0;

        for (T item : data) {
            result = 31 * result + item.hashCode();
        }

        return result;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("[");

        int lastIndex = data.size() - 1;
        for (int i = 0; i < data.size(); i++) {
            result.append(data.get(i).toString());
            if (i < lastIndex) {
                result.append(", ");
            }
        }
        result.append("]");

        return result.toString();
    }
}
