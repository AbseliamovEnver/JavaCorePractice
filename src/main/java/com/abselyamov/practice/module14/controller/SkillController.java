package com.abselyamov.practice.module14.controller;

import com.abselyamov.practice.module14.model.Skill;
import com.abselyamov.practice.module14.repository.SkillRepository;
import com.abselyamov.practice.module14.utils.GetID;

import java.util.Set;
import java.util.TreeSet;

public class SkillController {
    public static final String SKILLS_TXT = "src/main/java/com/abselyamov/practice/module14/database/skills.txt";

    SkillRepository skillRepository = new SkillRepository();
    GetID id = new GetID();
    TreeSet<Skill> skills;

    public void add(String skillName) {
        Skill skill = new Skill(id.getID(), skillName);
        skillRepository.save(skill);
    }

    public String getById(int id) {
        skills = (TreeSet<Skill>) skillRepository.getSource();
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
        skills = (TreeSet<Skill>) skillRepository.getSource();
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
        skills = (TreeSet<Skill>) skillRepository.getSource();
        for (Skill skill : skills)
            System.out.println(skill.getId() + "\t" + skill.getSkillName());
        return skills;
    }

    public void delete(int id) {
        skills = (TreeSet<Skill>) skillRepository.getSource();
        if (skillRepository.remove(id)) {
            System.out.println("Skill with id \'" + id + "\' was remove.");
            return;
        }
        System.out.println("Skill with id \'" + id + "\' not found.");
    }
}
