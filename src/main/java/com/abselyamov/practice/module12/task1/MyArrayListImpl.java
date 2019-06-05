package com.abselyamov.practice.module12.task1;


/**
 * @author Enver on 04.06.2019 14:50.
 * @project javacorepractice
 */
public class MyArrayListImpl extends MyArrayList {

    private MyArrayList<Integer> list = new MyArrayList<>();
    private ConsoleMenu menu = new ConsoleMenu();

    public void addItem() {
        System.out.println("Add new integer in the array list: ");
        int item = menu.readData(Integer.MIN_VALUE, Integer.MAX_VALUE);
        list.add(item);
        for (int i = 0; i < list.size(); i++) {
            list.update(i, list.findByIndex(i) + item);
        }
        System.out.println("Array list after add element: ");
        list.printArrayList();
    }

    public void updateItem() {
        System.out.println("Enter index update item: ");
        int index = menu.readData(0, list.size());

        System.out.println("Enter new value: ");
        int newValue = menu.readData(Integer.MIN_VALUE, Integer.MAX_VALUE);
        list.update(index, newValue);
        list.printArrayList();
    }

    public void deleteItem() {
        System.out.println("Enter index for delete item: ");
        int index = menu.readData(0, list.size());
        int value = list.findByIndex(index);
        list.delete(index);
        for (int i = 0; i < list.size(); i++) {
            list.update(i, list.findByIndex(i) - value);
        }
        list.printArrayList();
    }

    public Integer findByValue() {
        System.out.println("Enter value for search: ");
        int value = menu.readData(Integer.MIN_VALUE, Integer.MAX_VALUE);
        list.findByValue(value);
        return value;
    }

    public Integer findByIndex() {
        System.out.println("Enter index for search: ");
        int index = menu.readData(0, list.size());
        list.findByIndex(index);
        return index;
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
        System.out.println("================================================");
        System.out.println("Maximum value of list: " + maxValue);
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
        System.out.println("================================================");
        System.out.println("Minimum value of list: " + minValue);
        return minValue;
    }

    public Double averageSumImp() {
        double sum = 0;
        double average;
        for (int i = 0; i < list.size(); i++) {
            sum += list.findByIndex(i);
        }
        average = sum / list.size();
        System.out.println("================================================");
        System.out.println("Average sum value of list: " + average);
        return average;
    }

    public void sizeImp() {
        System.out.println("Array list size: " + list.size());
    }

    public void printArrayListImp() {
        System.out.println("Array list content: ");
        System.out.println("index" + "\t  value");
        list.printArrayList();
    }
}
