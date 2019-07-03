package com.abselyamov.practice.module12.task1;

/**
 *  function test for IntegerArrayList class methods
 */
public class Main {
    public static void main(String[] args) {

        IntegerArrayList arrayList = new IntegerArrayList();

        arrayList.addItem(1);
        arrayList.addItem(2);
        arrayList.addItem(3);
        arrayList.addItem(4);

        System.out.println("Initialise list:");
        arrayList.printArrayListImp();
        System.out.println("========================================");

        arrayList.updateItem(2, 5);
        System.out.println("Array list after checkAccount:");
        arrayList.printArrayListImp();
        System.out.println("========================================");

        arrayList.deleteItem(3);
        System.out.println("Array list after delete:");
        arrayList.printArrayListImp();
        System.out.println("========================================");

        System.out.println("Find by index 2: ");
        arrayList.findByIndex(2);
        System.out.println("========================================");

        System.out.println("Find by value 3: ");
        arrayList.findByValue(3);
        System.out.println("========================================");

        System.out.println("MAXIMUM element of the array list: " + arrayList.maxElementValue());
        System.out.println("========================================");

        System.out.println("MINIMUM element of the array list: " + arrayList.minElementValue());
        System.out.println("========================================");

        System.out.println("AVERAGE sum of the array list: " + arrayList.averageSum());
        System.out.println("========================================");

        System.out.println("Size array list: " + arrayList.sizeImp());
        System.out.println("========================================");
    }
}
