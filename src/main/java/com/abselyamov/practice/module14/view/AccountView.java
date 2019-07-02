package com.abselyamov.practice.module14.view;

import com.abselyamov.practice.module14.controller.AccountController;
import com.abselyamov.practice.module14.utils.PrintMenu;
import com.abselyamov.practice.module14.utils.ReadInputData;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class AccountView {
    PrintMenu menu = new PrintMenu();
    ReadInputData readInputData = new ReadInputData();
    AccountController accountController = new AccountController();

    public int accountMenu() {
        Map<Integer, String> accountMenu = new TreeMap<>();

        accountMenu.put(1, "Create account.");
        accountMenu.put(2, "Get all accounts.");
        accountMenu.put(3, "Delete account.");
        accountMenu.put(0, "Main menu.");

        Set<Map.Entry<Integer, String>> accountMenuSet = accountMenu.entrySet();

        menu.printMenu(accountMenuSet, "\tA C C O U N T S  ", 0, 3);
        int select = readInputData.readInputInt(0, 3);

        return select;
    }

    public void startAccountView() {
        boolean marker = true;
        while (marker) {
            int select = accountMenu();
            switch (select) {
                case 0:
                    marker = false;
                    break;
                case 1:
                    accountController.add("account");
                    break;
                case 2:
                    break;
                case 3:
                    break;
                default:
                    continue;
            }
        }
    }
}
