package com.abselyamov.practice.module14.view;

import com.abselyamov.practice.module14.controller.SkillController;
import com.abselyamov.practice.module14.utils.PrintMenu;
import com.abselyamov.practice.module14.utils.ReadInputData;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class SkillView {
    PrintMenu menu = new PrintMenu();
    SkillController skill = new SkillController();
    ReadInputData readInputData = new ReadInputData();

    public long skillMenu() {
        Map<Integer, String> skillMenu = new TreeMap<>();

        skillMenu.put(1, "Create skill.");
        skillMenu.put(2, "Get skill by ID.");
        skillMenu.put(3, "Get skill by name.");
        skillMenu.put(4, "Get all skills.");
        skillMenu.put(5, "Delete skill by ID.");
        skillMenu.put(0, "Main menu.");

        Set<Map.Entry<Integer, String>> skillMenuSet = skillMenu.entrySet();

        menu.printMenu(skillMenuSet, "\tS K I L L S  ", 0, 5);
        long select = readInputData.readInputData(0, 5);

        return select;
    }

    public void startSkillView() {
        boolean marker = true;
        while (marker) {
            long select = skillMenu();
            switch ((int) select) {
                case 0:
                    marker = false;
                    break;
                case 1:
                    System.out.println("Enter skill name:");
                    skill.add(readInputData.readInputString());
                    break;
                case 2:
                    System.out.println("Enter skill ID: ");
                    System.out.println(skill.getById(readInputData.readInputData(0, Long.MAX_VALUE)));
                    break;
                case 3:
                    System.out.println("Enter skill name: ");
                    System.out.println(skill.getByName(readInputData.readInputString()));
                    break;
                case 4:
                    System.out.println("List skills: ");
                    System.out.println("ID\tSKILLS");
                    skill.getListSkills();
                    break;
                case 5:
                    System.out.println("Enter skill ID to delete: ");
                    skill.delete(readInputData.readInputData(0, Long.MAX_VALUE));
                    break;
                default:
                    continue;
            }
        }
    }
}

