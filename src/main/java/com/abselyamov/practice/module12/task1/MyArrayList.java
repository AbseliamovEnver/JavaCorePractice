package com.abselyamov.practice.module12.task1;

import java.util.Iterator;

/**
 * @author Enver on 04.06.2019 3:46.
 * @project javacorepractice
 */
public class MyArrayList<E> implements Collectible<E> {

    private E[] values;

    public MyArrayList() {
        values = (E[]) new Object[0];
    }

    @Override
    public boolean add(E element) {
        try {
            E[] tempArray = values;
            values = (E[]) new Object[tempArray.length + 1];
            System.arraycopy(tempArray, 0, values, 0, tempArray.length);
            values[values.length - 1] = element;
            System.out.println("Item \"" + element + "\" added in list.");
            return true;
        } catch (ClassCastException ex) {
            System.out.println("Exception in the method Add.");
        }
        return false;
    }

    @Override
    public boolean update(int index, E e) {
        try {
            if (index < values.length) {
                values[index] = e;
                System.out.println("Update successful");
                return true;
            } else System.out.println("Index " + index + " not correct.");
        } catch (IllegalArgumentException ex) {
            System.out.println("Index " + index + " not correct.");
        }
        return false;
    }

    @Override
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

    @Override
    public E findByValue(E value) {
        E valueItem = null;
        boolean state = true;
        for (int i = 0; i < values.length; i++) {
            if (value.equals(values[i])) {
                valueItem = values[i];
                System.out.println("Index: " + i + " = " + value + ";");
                state = false;
            }
        }
        if (state)
            System.out.println("Item value \"" + value + "\" not found.");
        return valueItem;
    }

    @Override
    public E findByIndex(int index) {
        E value = null;
        if (values.length > index) {
            value = values[index];
            System.out.println("Index: \'" + index + "\" have value: \"" + value + "\".");
        } else System.out.println("Index " + index + " not correct.");
        return value;
    }

    @Override
    public E maxElementValue() {
        return null;
    }

    @Override
    public E minElementValue() {
        return null;
    }

    @Override
    public E averageSum() {
        return null;
    }

    @Override
    public int size() {
        return values.length;
    }

    public E[] printArrayList() {
        for (int i = 0; i < values.length; i++) {
            System.out.println("  " + i + "   -   " + values[i]);
        }
        return values;
    }

    public E[] getArrayList() {
        return values;
    }

    @Override
    public Iterator<E> iterator() {
        return new MyIterator<E>(values);
    }
}
