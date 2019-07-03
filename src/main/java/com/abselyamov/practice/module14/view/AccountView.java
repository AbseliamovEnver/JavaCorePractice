package com.abselyamov.practice.module14.view;

import com.abselyamov.practice.module14.controller.AccountController;
import com.abselyamov.practice.module14.model.AccountStatus;
import com.abselyamov.practice.module14.utils.PrintMenu;
import com.abselyamov.practice.module14.utils.ReadInputData;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class AccountView {
    PrintMenu menu = new PrintMenu();
    ReadInputData readInputData = new ReadInputData();
    AccountController accountController = new AccountController();

    public long accountMenu() {
        Map<Integer, String> accountMenu = new TreeMap<>();

        accountMenu.put(1, "Create account");
        accountMenu.put(2, "Update account");
        accountMenu.put(3, "Delete account");
        accountMenu.put(0, "Main menu.");

        Set<Map.Entry<Integer, String>> accountMenuSet = accountMenu.entrySet();

        menu.printMenu(accountMenuSet, "\tA C C O U N T S  ", 0, 3);
        long select = readInputData.readInputData(0, 3);

        return select;
    }

    public void startAccountView() {
        boolean marker = true;
        while (marker) {
            long select = accountMenu();
            switch ((int) select) {
                case 0:
                    marker = false;
                    break;
                case 1:
                    System.out.println("Enter login:");
                    String login = readInputData.readInputString();
                    System.out.println("Enter password:");
                    String password = readInputData.readInputString();
                    accountController.getListStatus();
                    System.out.println("Chose account status:");
                    Long idStatus = readInputData.readInputData(0, AccountStatus.values().length);
                    accountController.add(login, password, idStatus);
                    break;
                case 2:
                    System.out.println("Accounts list:");
                    accountController.getAll();
                    System.out.println("Choose id account:");
                    long id = readInputData.readInputData(0, Long.MAX_VALUE);
                    System.out.println("Enter password:");
                    String pass = readInputData.readInputString();
                    if (accountController.checkAccount(id, pass)) {
                        System.out.println("Enter new login or press \'ENTER\' to leave old login: ");
                        String newLogin = readInputData.readInputString();
                        System.out.println("Enter new password or press \'ENTER\' to leave old password: ");
                        String newPass = readInputData.readInputString();
                        accountController.getListStatus();
                        System.out.println("Chose new STATUS: ");
                        Long newStatus = readInputData.readInputData(0, AccountStatus.values().length);
                        accountController.update(id, newLogin, newPass, newStatus);
                    } else System.out.println("You enter wrong password.");
                    break;
                case 3:
                    System.out.println("Accounts list:");
                    accountController.getAll();
                    System.out.println("Choose account id to remove:");
                    long idAccount = readInputData.readInputData(0, Long.MAX_VALUE);
                    accountController.delete(accountController.getById(idAccount));
                    break;
                default:
                    continue;
            }
        }
    }
}
