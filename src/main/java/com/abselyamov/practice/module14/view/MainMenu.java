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

    public long mainMenu() {
        Map<Integer, String> mainMenu = new TreeMap<>();

        mainMenu.put(1, "Developers");
        mainMenu.put(2, "Skills");
        mainMenu.put(3, "Accounts");
        mainMenu.put(0, "Exit");

        Set<Map.Entry<Integer, String>> mainMenuSet = mainMenu.entrySet();

        menu.printMenu(mainMenuSet, "\t M A I N  ", 0, 3);
        long select = readInputData.readInputData(0, 3);

        if (select == 0)
            System.out.println(" THANKS FOR USING OUR APPLICATION!");

        return select;
    }

    public void start() {
        while (true) {
            long select = mainMenu();
            switch ((int) select) {
                case 0:
                    System.exit(0);
                    break;
                case 1:
                    developerView.startDeveloperView();
                    break;
                case 2:
                    skillView.startSkillView();
                    break;
                case 3:
                    accountView.startAccountView();
                default:
                    continue;
            }
        }
    }
}
