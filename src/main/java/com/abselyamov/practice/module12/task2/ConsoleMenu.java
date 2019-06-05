package com.abselyamov.practice.module12.task2;

import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

/**
 * @author Enver on 05.06.2019 17:34.
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
        menuList.put(2, "Size array list.");
        menuList.put(3, "Print array list.");
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
        System.out.println("Please select menu item from \"0\" to \"3\": ");
        System.out.println("************************************************");

        int select = readData(0, 3);

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
        CustomListImpl arrayList = new CustomListImpl();

        while (true) {
            int select = menu();
            switch (select) {
                case 0:
                    System.exit(0);
                    break;
                case 1:
                    arrayList.add();
                    break;
                case 2:
                    arrayList.size();
                    break;
                case 3:
                    arrayList.printArrayListImpl();
                    break;
                default:
                    continue;
            }
        }
    }
}
