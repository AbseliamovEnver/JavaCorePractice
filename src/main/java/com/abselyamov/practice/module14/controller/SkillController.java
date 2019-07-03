package com.abselyamov.practice.module14.controller;

import com.abselyamov.practice.module14.model.Skill;
import com.abselyamov.practice.module14.repository.JavaIOSkillRepositoryImpl;
import com.abselyamov.practice.module14.utils.GetID;

import java.util.Set;
import java.util.TreeSet;

public class SkillController {
    public static final String SKILLS_FILE = "src/main/java/com/abselyamov/practice/module14/database/skills.txt";

    JavaIOSkillRepositoryImpl skillRepository = new JavaIOSkillRepositoryImpl();
    GetID id = new GetID();
    TreeSet<Skill> skills;

    public void add(String skillName) {
        Skill skill = new Skill(id.getID(SKILLS_FILE), skillName);
        skillRepository.add(skill);
    }

    public String getById(long id) {
        skills = (TreeSet<Skill>) skillRepository.getData();
        for (Skill skill : skills) {
            if (skill.getId() == id) {
                System.out.println("Skill with id \'" + id + "\' is: ");
                return skill.getSkillName();
            }
        }
        System.out.println("Skill with id \'" + id + "\' not found.");
        return null;
    }

    public String getByName(String name) {
        skills = (TreeSet<Skill>) skillRepository.getData();
        for (Skill skill : skills) {
            if (skill.getSkillName().equalsIgnoreCase(name)) {
                System.out.println("Skill with name \'" + name + "\' exists.");
                return skill.getSkillName();
            }
        }
        System.out.println("Skill with name \'" + name + "\' not found.");
        return null;
    }

    public Set<Skill> getListSkills() {
        skills = (TreeSet<Skill>) skillRepository.getData();
        for (Skill skill : skills)
            System.out.println(skill.getId() + "\t" + skill.getSkillName());
        return skills;
    }

    public void delete(long id) {
        skills = (TreeSet<Skill>) skillRepository.getData();
        for (Skill skill : skills) {
            if (skill.getId() == id) {
                skillRepository.delete(skill);
                System.out.println("Skill with id \'" + id + "\' was delete.");
                return;
            }
        }
        System.out.println("Skill with id \'" + id + "\' not found.");
    }
}
