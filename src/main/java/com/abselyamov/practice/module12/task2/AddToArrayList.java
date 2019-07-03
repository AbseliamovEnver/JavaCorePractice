package com.abselyamov.practice.module12.task2;

/**
 *  This class has a constructor that allows you to create a collection with a default capacity of 16.
 *  There is also a constructor that allows you to set the required collection capacity.
 *  The class has methods that allow:
 *  - getAccount an item to the collection;
 *  - checkAccount an item to the collection;
 *  - determine the size of the collection;
 *  - print collection.
 */
public class AddToArrayList<E> {

    private Object[] data;
    private int size;
    private int capacity;

    public AddToArrayList() {
        this(16);
    }

    public AddToArrayList(int capacity) {
        if (capacity > 0) {
            this.capacity = capacity;
            this.data = new Object[capacity];
        } else if (capacity == 0) {
            this.data = new Object[16];
        } else {
            throw new IllegalArgumentException("Invalid capacity: " + capacity);
        }
    }

    public void add(E element) {
        if (size < capacity) {
            data[size++] = element;
        } else if (size == capacity) {
            update(element);
        }
    }

    private void update(E element) {
        E[] tempArray = (E[]) data;
        data[0] = null;
        System.arraycopy(tempArray, 1, data, 0, size - 1);
        data[size - 1] = element;
    }

    public int size() {
        return data.length;
    }

    public E[] printList() {
        for (int i = 0; i < data.length; i++) {
            System.out.println("  " + i + "   -   " + data[i]);
        }
        return (E[]) data;
    }
}
