package com.abselyamov.practice.module12.task2;

/**
 * @author Enver on 05.06.2019 15:33.
 * @project javacorepractice
 */
public class CustomList<E> {

    private Object[] data;
    private int size;
    private int capacity;

    public CustomList() {
        this(16);
    }

    public CustomList(int capacity) {
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
            updateList(element);
        }
    }

    private void updateList(E element) {
        E[] tempArray = (E[]) data;
        data[0] = null;
        System.arraycopy(tempArray, 1, data, 0, size - 1);
        data[size - 1] = element;
    }

    public int size() {
        return data.length;
    }

    public E[] printArrayList() {
        for (int i = 0; i < data.length; i++) {
            System.out.println("  " + i + "   -   " + data[i]);
        }
        return (E[]) data;
    }
}
