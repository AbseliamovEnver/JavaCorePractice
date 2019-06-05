package com.abselyamov.practice.module12.task1;

import java.util.Iterator;

/**
 * @author Enver on 04.06.2019 4:06.
 * @project javacorepractice
 */
public class MyIterator<E> implements Iterator<E> {

    private int index = 0;
    E[] values;

    public MyIterator(E[] values) {
        this.values = values;
    }

    @Override
    public boolean hasNext() {
        return index < values.length;
    }

    @Override
    public E next() {
        return values[index++];
    }
}
