package ru.mirea.ivashchenko.pr11.second;

public interface Queue {
    void enqueue(Object element);
    Object  dequeue();
    Object[] toArray();
    Object element();
    int size();
    boolean isEmpty();
    void clear();
}