package com.abselyamov.practice.module14.view;

import com.abselyamov.practice.module14.utils.PrintMenu;
import com.abselyamov.practice.module14.utils.ReadInputData;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class MainMenu {
    PrintMenu menu = new PrintMenu();
    DeveloperView developerView = new DeveloperView();
    AccountView accountView = new AccountView();
    SkillView skillView = new SkillView();
    ReadInputData readInputData = new ReadInputData();

    public int mainMenu() {
        Map<Integer, String> mainMenu = new TreeMap<>();

        mainMenu.put(1, "Developers");
        mainMenu.put(2, "Accounts");
        mainMenu.put(3, "Skills");
        mainMenu.put(0, "Exit");

        Set<Map.Entry<Integer, String>> mainMenuSet = mainMenu.entrySet();

        menu.printMenu(mainMenuSet, "\t M A I N  ", 0, 3);
        int select = readInputData.readInputInt(0, 3);

        if (select == 0)
            System.out.println(" THANKS FOR USING OUR APPLICATION!");

        return select;
    }

    public void start() {
        while (true) {
            int select = mainMenu();
            switch (select) {
                case 0:
                    System.exit(0);
                    break;
                case 1:
                    developerView.startDeveloperView();
                    break;
                case 2:
                    accountView.startAccountView();
                    break;
                case 3:
                    skillView.startSkillView();
                default:
                    continue;
            }
        }
    }
}
