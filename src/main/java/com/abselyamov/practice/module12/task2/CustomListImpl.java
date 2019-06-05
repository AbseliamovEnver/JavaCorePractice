package com.abselyamov.practice.module12.task2;

/**
 * @author Enver on 05.06.2019 17:48.
 * @project javacorepractice
 */
public class CustomListImpl extends CustomList {

    private CustomList<Integer> list = new CustomList<>(3);
    private ConsoleMenu menu = new ConsoleMenu();

    public void add() {
        System.out.println("Add new integer in the array list: ");
        int item = menu.readData(Integer.MIN_VALUE, Integer.MAX_VALUE);
        list.add(item);
        System.out.println("Array list after add element: ");
        list.printArrayList();
    }

    public int size() {
        System.out.println("Array list size: " + list.size());
        return list.size();
    }

    public void printArrayListImpl() {
        System.out.println("Array list content: ");
        System.out.println("index" + "\t  value");
        list.printArrayList();
    }
}
