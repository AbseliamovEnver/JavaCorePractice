package com.abselyamov.practice.module14.view;

import com.abselyamov.practice.module14.controller.SkillController;
import com.abselyamov.practice.module14.utils.PrintMenu;
import com.abselyamov.practice.module14.utils.ReadInputData;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class SkillView {
    public long skillMenu() {
        Map<Integer, String> skillMenu = new TreeMap<>();

        skillMenu.put(1, "Create skill");
        skillMenu.put(2, "Get skill by ID");
        skillMenu.put(3, "Get skill by name");
        skillMenu.put(4, "Get all skills");
        skillMenu.put(5, "Delete skill by ID");
        skillMenu.put(0, "Main menu");

        Set<Map.Entry<Integer, String>> skillMenuSet = skillMenu.entrySet();

        PrintMenu.printMenu(skillMenuSet, "\tS K I L L S  ", 0, 5);
        long select = ReadInputData.readInputData(0, 5);

        return select;
    }

    public void skillView() {
        SkillController skillController = new SkillController();
        boolean marker = true;
        while (marker) {
            long select = skillMenu();
            switch ((int) select) {
                case 0:
                    marker = false;
                    break;
                case 1:
                    System.out.println("Enter skill name:");
                    skillController.add(ReadInputData.readInputString());
                    break;
                case 2:
                    System.out.println("Enter skill ID: ");
                    System.out.println(skillController.getById(ReadInputData.readInputData(0, Long.MAX_VALUE)));
                    break;
                case 3:
                    System.out.println("Enter skill name: ");
                    System.out.println(skillController.getByName(ReadInputData.readInputString()));
                    break;
                case 4:
                    System.out.println("List skills: \nID\tSKILLS");
                    skillController.getListSkills();
                    break;
                case 5:
                    System.out.println("Enter skill ID to delete: ");
                    skillController.delete(ReadInputData.readInputData(0, Long.MAX_VALUE));
                    break;
                default:
                    continue;
            }
        }
    }
}

