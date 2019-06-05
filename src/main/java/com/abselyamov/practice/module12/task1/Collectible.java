package com.abselyamov.practice.module12.task1;

/**
 * @author Enver on 03.06.2019 2:34.
 * @project javacorepractice
 */
public interface Collectible<E> extends Iterable<E> {

    boolean add(E element);

    boolean update(int index, E e);

    boolean delete(int index);

    E findByValue(E value);

    E findByIndex(int index);

    E maxElementValue();

    E minElementValue();

    E averageSum();

    int size();
}
