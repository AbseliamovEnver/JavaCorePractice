package com.abselyamov.practice.module14.view;

import com.abselyamov.practice.module14.controller.AccountController;
import com.abselyamov.practice.module14.model.AccountStatus;
import com.abselyamov.practice.module14.utils.PrintMenu;
import com.abselyamov.practice.module14.utils.ReadInputData;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class AccountView {
    public long accountMenu() {
        Map<Integer, String> accountMenu = new TreeMap<>();

        accountMenu.put(1, "Create account");
        accountMenu.put(2, "Get account by ID");
        accountMenu.put(3, "Get account by login");
        accountMenu.put(4, "Get all accounts");
        accountMenu.put(5, "Update account");
        accountMenu.put(6, "Delete account");
        accountMenu.put(0, "Main menu.");

        Set<Map.Entry<Integer, String>> accountMenuSet = accountMenu.entrySet();

        PrintMenu.printMenu(accountMenuSet, "\tA C C O U N T S  ", 0, 6);
        long select = ReadInputData.readInputData(0, 6);

        return select;
    }

    public void accountView() {
        AccountController accountController = new AccountController();
        boolean marker = true;
        while (marker) {
            long select = accountMenu();
            switch ((int) select) {
                case 0:
                    marker = false;
                    break;
                case 1:
                    System.out.println("Enter login:");
                    String login = ReadInputData.readInputString();
                    System.out.println("Enter password:");
                    String password = ReadInputData.readInputString();
                    accountController.getListStatus();
                    System.out.println("Chose account status:");
                    long idStatus = ReadInputData.readInputData(0, AccountStatus.values().length - 1);
                    accountController.add(login, password, idStatus);
                    break;
                case 2:
                    System.out.println("Enter account ID: ");
                    System.out.println(accountController.getById(ReadInputData.readInputData(0, Long.MAX_VALUE)));
                    break;
                case 3:
                    System.out.println("Enter account login: ");
                    System.out.println(accountController.getByName(ReadInputData.readInputString()));
                    break;
                case 4:
                    System.out.println("List accounts: \nID\tACCOUNTS");
                    accountController.getListAccounts();
                    break;
                case 5:
                    System.out.println("Accounts list:");
                    accountController.getListAccounts();
                    System.out.println("Choose id account:");
                    long id = ReadInputData.readInputData(0, Long.MAX_VALUE);
                    System.out.println("Enter password:");
                    String pass = ReadInputData.readInputString();
                    if (accountController.checkAccount(id, pass)) {
                        System.out.println("Enter new login or press \'ENTER\' to leave old login: ");
                        String newLogin = ReadInputData.readInputString();
                        System.out.println("Enter new password or press \'ENTER\' to leave old password: ");
                        String newPass = ReadInputData.readInputString();
                        accountController.getListStatus();
                        System.out.println("Chose new STATUS: ");
                        long newStatus = ReadInputData.readInputData(0, AccountStatus.values().length - 1);
                        accountController.update(id, newLogin, newPass, newStatus);
                    } else System.out.println("You enter wrong password.");
                    break;
                case 6:
                    System.out.println("Accounts list:");
                    accountController.getListAccounts();
                    System.out.println("Choose account id to remove:");
                    long idAccount = ReadInputData.readInputData(0, Long.MAX_VALUE);
                    accountController.delete(idAccount);
                    break;
                default:
                    continue;
            }
        }
    }
}
