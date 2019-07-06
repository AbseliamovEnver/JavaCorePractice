package com.abselyamov.practice.module14.controller;

import com.abselyamov.practice.module14.model.Account;
import com.abselyamov.practice.module14.model.Developer;
import com.abselyamov.practice.module14.model.Skill;
import com.abselyamov.practice.module14.repository.DeveloperRepository;
import com.abselyamov.practice.module14.repository.JavaIODeveloperRepositoryImpl;

import java.util.HashSet;
import java.util.Set;

public class DeveloperController {
    DeveloperRepository developerRepository = new JavaIODeveloperRepositoryImpl();

    public void add(long id, String name, String surname, Set<Skill> skills, Account account) {
        Developer developer = new Developer(id, name, surname, skills, account);
        developerRepository.add(developer);
    }

    public String getById(long id) {
        Developer developer = developerRepository.getById(id);
        if (developer != null)
            return "Developer with id = \'" + id + "\' have:\nname = \'" + developer.getName() + "\'\nsurname = \'"
                    + developer.getSurName() + "\'\nskill(s):\n\t" + developer.getSkills() + "\naccount:\n"
                    + developer.getAccount();
        return "Developer with id = \'" + id + "\' not found.";
    }

    public String getByName(String name) {
        Developer developer = developerRepository.getByName(name);
        if (developer != null)
            return "Developer with name = \'" + developer.getName() + "\' have:\nid = \'" + developer.getId()
                    + "\'\nsurname = \'" + developer.getSurName() + "\'\nskill(s):\n\t" + developer.getSkills()
                    + "\naccount:\n\t" + developer.getAccount();
        return "Developer with name = \'" + name + "\' not found.";
    }

    public Set<Developer> getListDeveloper() {
        Set<Developer> developers = developerRepository.getAll();
        if (developers != null) {
            for (Developer developer : developers)
                System.out.println(developer);
            return developers;
        } else System.out.println("List developers is empty.");
        return null;
    }

    public void update(String name, String surname) {

    }

    public void delete(long id) {
        Developer developer = developerRepository.delete(id);
        if (developer != null)
            System.out.println("Developer with id \'" + developer.getId() + "\' and name \'"
                    + developer.getName() + "\' deleted successfully.");
        else
            System.out.println("Developer with id \'" + id + "\' not found.");
    }

    public boolean checkDeveloper(long id) {
        boolean result = false;
        Developer developer = developerRepository.getById(id);
        if (developer != null)
            return true;
        else
            System.out.println("Developer with id \'" + id + "\' not found.");
        return result;
    }

    public boolean checkDeveloperSkill(Set<Skill> skills, long id) {
        Developer developer = developerRepository.getById(id);
        Set<Skill> developerSkills = developer.getSkills();
        boolean addSkill = true;
        Skill skillItem = null;

        for (Skill skill : skills) {
            if (skill.getId() == id) {
                skillItem = new Skill(skill.getId(), skill.getSkillName());
                for (Skill skill1 : developerSkills) {
                    if (skill1.getId() == id) {
                        System.out.println("This skill already exist.");
                        addSkill = false;
                    }
                }
            }
        }
        if (addSkill)
            return developerRepository.addSkillDeveloper(developer, skillItem);
        return false;
    }
}
