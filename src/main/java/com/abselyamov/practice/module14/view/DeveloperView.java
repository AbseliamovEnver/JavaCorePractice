package com.abselyamov.practice.module14.view;

import com.abselyamov.practice.module14.controller.AccountController;
import com.abselyamov.practice.module14.controller.DeveloperController;
import com.abselyamov.practice.module14.controller.SkillController;
import com.abselyamov.practice.module14.model.Account;
import com.abselyamov.practice.module14.model.Developer;
import com.abselyamov.practice.module14.model.Skill;
import com.abselyamov.practice.module14.utils.GetID;
import com.abselyamov.practice.module14.utils.PrintMenu;
import com.abselyamov.practice.module14.utils.ReadInputData;

import java.util.*;

public class DeveloperView {
    PrintMenu menu = new PrintMenu();
    ReadInputData readInputData = new ReadInputData();
    DeveloperController developerController = new DeveloperController();
    SkillController skill = new SkillController();
    AccountController account = new AccountController();
    GetID getItemID = new GetID();
    Set<Skill> skills = new TreeSet<>();
    Set<Account> accounts = new TreeSet<>();
    Account accountItem = null;

    public long developerMenu() {
        Map<Integer, String> developerMenu = new TreeMap<>();

        developerMenu.put(1, "Create developer.");
        developerMenu.put(2, "Update developer.");
        developerMenu.put(3, "Get all developers.");
        developerMenu.put(4, "Delete developer by ID.");
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
                    long id = getItemID.getID(DeveloperController.DEVELOPER_FILE);
                    System.out.println("Enter developer name:");
                    String name = readInputData.readInputString();
                    System.out.println("Enter developer surname:");
                    String surname = readInputData.readInputString();
                    System.out.println("List skills: \nID\tSKILLS");
                    Set<Skill> skillSet = skill.getListSkills();
                    System.out.println("Select developer skills or enter \'-1\': ");
                    long idSkill;
                    while ((idSkill = readInputData.readInputData(-1, Long.MAX_VALUE)) != -1) {
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
                    accounts = account.getAll();
                    long idAccount;
                    System.out.println("Choose id account or enter \'-1\':");
                    while ((idAccount = readInputData.readInputData(-1, Long.MAX_VALUE)) != -1) {
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
                    developerController.add(new Developer(id, name, surname, skills, accountItem));
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                default:
                    continue;
            }
        }
    }
}
