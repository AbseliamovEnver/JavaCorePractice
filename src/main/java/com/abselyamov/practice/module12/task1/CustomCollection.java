package com.abselyamov.practice.module12.task1;

/**
 *  class that implements work with data array
 */
public class CustomCollection<E> {

    private E[] values;

    public CustomCollection() {
        values = (E[]) new Object[0];
    }

    public boolean add(E element) {
        try {
            E[] tempArray = values;
            values = (E[]) new Object[tempArray.length + 1];
            System.arraycopy(tempArray, 0, values, 0, tempArray.length);
            values[values.length - 1] = element;
            return true;
        } catch (ClassCastException ex) {
            System.out.println("Exception in the method Add.");
        }
        return false;
    }

    public boolean update(int index, E value) {
        try {
            if (index < values.length) {
                values[index] = value;
                return true;
            } else System.out.println("Index " + index + " not correct.");
        } catch (IllegalArgumentException ex) {
            System.out.println("Index " + index + " not correct.");
        }
        return false;
    }

    public boolean delete(int index) {
        try {
            E[] temp = values;
            values = (E[]) new Object[temp.length - 1];
            System.arraycopy(temp, 0, values, 0, index);
            int elementAfterIndex = temp.length - index - 1;
            System.arraycopy(temp, index + 1, values, index, elementAfterIndex);
            return true;
        } catch (ClassCastException ex) {
            System.out.println("Index " + index + " not correct.");
        }
        return false;
    }

    public E findByValue(E value) {
        E valueItem = null;
        boolean state = true;
        for (int i = 0; i < values.length; i++) {
            if (value.equals(values[i])) {
                valueItem = values[i];
                System.out.println("Value: \'" + value + "\' have index: \"" + i + "\".");
                state = false;
            }
        }
        if (state)
            System.out.println("Item value \"" + value + "\" not found.");
        return valueItem;
    }

    public E findByIndex(int index) {
        E value = null;
        if (values.length > index) {
            value = values[index];
        } else System.out.println("Index " + index + " not correct.");
        return value;
    }

    public int size() {
        return values.length;
    }

    public E[] printArrayList() {
        for (int i = 0; i < values.length; i++) {
            System.out.println("  " + i + "   -   " + values[i]);
        }
        return values;
    }
}
