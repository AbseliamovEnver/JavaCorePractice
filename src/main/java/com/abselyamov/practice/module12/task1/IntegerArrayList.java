package com.abselyamov.practice.module12.task1;

/**
 *  Implementation of the CustomCollection for an ArrayList of integers.
 *  This class allows you to perform operations with an array of integers:
 *  - add
 *  - delete
 *  - search item by value
 *  - search for an item by index
 *  - search for the maximum element
 *  - search for the minimum element
 *  - search arithmetic average of all elements
 *  Wherein:
 *  - when adding a new item, all items increase their value by the added item
 *  - when deleting - decrease their value by the deleted element
 */
public class IntegerArrayList extends CustomCollection {

    private CustomCollection<Integer> list = new CustomCollection<>();

    public void addItem(Integer item) {
        list.add(item);
        for (int i = 0; i < list.size(); i++) {
            list.update(i, list.findByIndex(i) + item);
        }
    }

    public void updateItem(Integer index, Integer value) {
        list.update(index, value);
    }

    public void deleteItem(Integer index) {
        int value = list.findByIndex(index);
        list.delete(index);
        for (int i = 0; i < list.size(); i++) {
            list.update(i, list.findByIndex(i) - value);
        }
    }

    public Integer findByValue(int value) {
        list.findByValue(value);
        return value;
    }

    public Integer findByIndex(int index) {
        int value = 0;
        if (list.findByIndex(index) != null) {
            value = list.findByIndex(index);
            System.out.println("Index: \'" + index + "\' have value: \"" + value + "\".");
        } else
            System.out.println("Index: \'" + index + "\' have value: \"null\".");
        return value;
    }

    public Integer maxElementValue() {
        int maxValue = list.findByIndex(0);
        int item;
        for (int i = 0; i < list.size(); i++) {
            item = list.findByIndex(i);
            if (item > maxValue) {
                maxValue = item;
            }
        }
        return maxValue;
    }

    public Integer minElementValue() {
        int minValue = list.findByIndex(0);
        int item;
        for (int i = 0; i < list.size(); i++) {
            item = list.findByIndex(i);
            if (item < minValue) {
                minValue = item;
            }
        }
        return minValue;
    }

    public double averageSum() {
        double sum = 0;
        double average;
        for (int i = 0; i < list.size(); i++) {
            sum += list.findByIndex(i);
        }
        average = sum / list.size();
        return average;
    }

    public Integer sizeImp() {
        return list.size();
    }

    public void printArrayListImp() {
        System.out.println("index" + "\t  value");
        list.printArrayList();
    }
}
