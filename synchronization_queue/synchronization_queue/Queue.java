package com.sunghotsai.datastructure;

public interface Queue<T> {
    public void enqueue(T item);
    public T dequeue();
    public void clear();
    public int size();
}
