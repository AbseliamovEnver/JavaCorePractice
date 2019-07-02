package com.abselyamov.practice.module14.controller;

import java.util.List;

public interface GenericInterface<T> {
    void add(T t);

    void update(T t);

    void delete(int id);

    T getItemById(int id);

    List<T> listItem();
}
