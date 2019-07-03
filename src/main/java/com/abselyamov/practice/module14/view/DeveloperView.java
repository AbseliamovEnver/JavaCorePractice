package com.abselyamov.practice.module14.view;

import com.abselyamov.practice.module14.utils.PrintMenu;
import com.abselyamov.practice.module14.utils.ReadInputData;

import java.util.*;

public class DeveloperView {
    PrintMenu menu = new PrintMenu();
    ReadInputData readInputData = new ReadInputData();

    public long developerMenu() {
        Map<Integer, String> developerMenu = new TreeMap<>();

        developerMenu.put(1, "Create developer.");
        developerMenu.put(2, "Update developer.");
        developerMenu.put(3, "Delete developer by ID.");
        developerMenu.put(4, "Get all developers.");
        developerMenu.put(0, "Main menu.");

        Set<Map.Entry<Integer, String>> mainMenuSet = developerMenu.entrySet();

        menu.printMenu(mainMenuSet, " D E V E L O P E R S  ", 0, 4);
        long select = readInputData.readInputData(0, 4);

        return select;
    }

    public void startDeveloperView() {
        boolean marker = true;
        while (marker) {
            long select = developerMenu();
            switch ((int) select) {
                case 0:
                    marker = false;
                    break;
                case 1:
//                    developerView.startDeveloperView();
                    break;
                case 2:
//                    accountView.startAccountView();
                    break;
                case 3:
//                    skillView.startSkillView();
                default:
                    continue;
            }
        }
    }

    //    public String readInputString() {
//        String data;
//        while (true) {
//            data = scanner.nextLine();
//            if (data.equals(null))
//                break;
//            else
//                System.out.println("Value cannot be an empty string.");
//        }
//        return data;
//    }
}
