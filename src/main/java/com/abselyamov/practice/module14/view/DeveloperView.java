package com.abselyamov.practice.module14.view;

import com.abselyamov.practice.module14.controller.AccountController;
import com.abselyamov.practice.module14.controller.DeveloperController;
import com.abselyamov.practice.module14.controller.SkillController;
import com.abselyamov.practice.module14.model.Account;
import com.abselyamov.practice.module14.model.Skill;
import com.abselyamov.practice.module14.utils.PrintMenu;
import com.abselyamov.practice.module14.utils.ReadInputData;

import java.util.*;

public class DeveloperView {
    public long developerMenu() {
        Map<Integer, String> developerMenu = new TreeMap<>();

        developerMenu.put(1, "Create developer");
        developerMenu.put(2, "Get developer by ID");
        developerMenu.put(3, "Get developer by name");
        developerMenu.put(4, "Get all developers");
        developerMenu.put(5, "Update developer");
        developerMenu.put(6, "Delete developer by ID");
        developerMenu.put(0, "Main menu");

        Set<Map.Entry<Integer, String>> mainMenuSet = developerMenu.entrySet();

        PrintMenu.printMenu(mainMenuSet, " D E V E L O P E R S  ", 0, 4);
        long select = ReadInputData.readInputData(0, 4);

        return select;
    }

    public void developerView() {
        DeveloperController developerController = new DeveloperController();
        SkillController skill = new SkillController();
        AccountController account = new AccountController();
        Set<Account> accounts = new TreeSet<>();
        Account accountItem = null;
        Set<Skill> skills = new TreeSet<>();
        boolean marker = true;

        while (marker) {
            long select = developerMenu();
            switch ((int) select) {
                case 0:
                    marker = false;
                    break;
                case 1:
                    System.out.println("Enter developer name:");
                    String name = ReadInputData.readInputString();
                    System.out.println("Enter developer surname:");
                    String surname = ReadInputData.readInputString();
                    System.out.println("List skills: \nID\tSKILLS");
                    Set<Skill> skillSet = skill.getListSkills();
                    System.out.println("Select developer skills or enter \'-1\': ");
                    long idSkill;
                    while ((idSkill = ReadInputData.readInputData(-1, Long.MAX_VALUE)) != -1) {
                        boolean status = false;
                        for (Skill skillItem : skillSet) {
                            if (skillItem.getId() == idSkill) {
                                skills.add(skillItem);
                                System.out.println("Skill with id " + idSkill + " added.");
                                status = true;
                                break;
                            }
                        }
                        if (status) {
                            System.out.println("Add more skills or click \'-1\'");
                            continue;
                        } else {
                            System.out.println("Skill with id \'" + idSkill + "\' not found.");
                            System.out.println("Choose id skill or enter \'-1\':");
                        }
                    }
                    accounts = account.getListAccounts();
                    long idAccount;
                    System.out.println("Choose id account or enter \'-1\':");
                    while ((idAccount = ReadInputData.readInputData(-1, Long.MAX_VALUE)) != -1) {
                        boolean flag = false;
                        for (Account acc : accounts) {
                            if (acc.getId() == idAccount) {
                                accountItem = acc;
                                System.out.println("Account with id \'" + idAccount + "\' added.");
                                flag = true;
                                break;
                            }
                        }
                        if (flag)
                            break;
                        else {
                            System.out.println("Account with id \'" + idAccount + "\' not found.");
                            System.out.println("Choose id account or enter \'-1\':");
                        }
                    }
                    developerController.add(0, name, surname, skills, accountItem);
                    break;
                case 2:
                    System.out.println("Enter developer ID: ");
                    System.out.println(developerController.getById(ReadInputData.readInputData(0, Long.MAX_VALUE)));
                    break;
                case 3:
                    System.out.println("Enter developer name: ");
                    System.out.println(developerController.getByName(ReadInputData.readInputString()));
                    break;
                case 4:
                    System.out.println("List skills: \nID\tSKILLS");
                    developerController.getListDeveloper();
                    break;
                default:
                    continue;
            }
        }
    }
}
