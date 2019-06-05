package com.abselyamov.practice.module12.task1;

import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

/**
 * @author Enver on 04.06.2019 17:13.
 * @project javacorepractice
 */
public class ConsoleMenu {

    private Scanner scanner;

    public ConsoleMenu() {
        this.scanner = new Scanner(System.in);
    }

    public int menu() {
        Map<Integer, String> menuList = new TreeMap<>();

        menuList.put(1, "Add element.");
        menuList.put(2, "Update element.");
        menuList.put(3, "Delete element.");
        menuList.put(4, "Search item by value.");
        menuList.put(5, "Search item by index.");
        menuList.put(6, "Search the maximum element.");
        menuList.put(7, "Search the minimum element.");
        menuList.put(8, "Search arithmetic average of all elements.");
        menuList.put(9, "Size array list.");
        menuList.put(10, "Print array list.");
        menuList.put(0, "Exit");

        Set<Map.Entry<Integer, String>> setMenu = menuList.entrySet();

        System.out.println("************************************************");
        System.out.println("\t\t\t\tM E N U");
        System.out.println("************************************************");

        for (Map.Entry<Integer, String> list : setMenu) {
            System.out.print(list.getKey() + ": ");
            System.out.println(list.getValue());
        }

        System.out.println("************************************************");
        System.out.println("Please select menu item from \"0\" to \"10\": ");
        System.out.println("************************************************");

        int select = readData(0, 10);

        if (select == 0)
            System.out.println("\t   THANKS FOR USING OUR APPLICATION!");

        return select;
    }

    public int readData(int min, int max) {
        int select = 0;
        while (true) {
            try {
                select = Integer.parseInt(scanner.nextLine());
                if (select >= min && select <= max)
                    break;
                else
                    System.out.println("Please enter correct value: ");
            } catch (Exception ex) {
                System.out.println("Invalid value: " + select);
                System.out.println("Please enter correct integer value: ");
            }
        }
        return select;
    }

    public void start() {
        MyArrayListImpl arrayList = new MyArrayListImpl();

        while (true) {
            int select = menu();
            switch (select) {
                case 0:
                    System.exit(0);
                    break;
                case 1:
                    arrayList.addItem();
                    break;
                case 2:
                    arrayList.updateItem();
                    break;
                case 3:
                    arrayList.deleteItem();
                    break;
                case 4:
                    arrayList.findByValue();
                    break;
                case 5:
                    arrayList.findByIndex();
                    break;
                case 6:
                    arrayList.maxElementValue();
                    break;
                case 7:
                    arrayList.minElementValue();
                    break;
                case 8:
                    arrayList.averageSumImp();
                    break;
                case 9:
                    arrayList.sizeImp();
                    break;
                case 10:
                    arrayList.printArrayListImp();
                    break;
                default:
                    continue;
            }
        }
    }
}
