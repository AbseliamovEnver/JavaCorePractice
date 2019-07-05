package com.abselyamov.practice.module14.controller;

import com.abselyamov.practice.module14.model.Account;
import com.abselyamov.practice.module14.model.Developer;
import com.abselyamov.practice.module14.model.Skill;
import com.abselyamov.practice.module14.repository.DeveloperRepository;
import com.abselyamov.practice.module14.repository.JavaIODeveloperRepositoryImpl;

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
            return "Developer with id \'" + id + "\' have name \'" + developer.getName() + "\', surname \'"
                    + developer.getSurName() + "\', skill(s) \'" + developer.getSkills() + "\', account \'"
                    + developer.getAccount() + "\'";
        return "Developer with id \'" + id + "\' not found.";
    }

    public String getByName(String name) {
        Developer developer = developerRepository.getByName(name);
        if (developer != null)
            return "Developer with name \'" + developer.getName() + "\' have id \'" + developer.getId()
                    + "\', surname \'" + developer.getSurName() + "\', skill(s) \'" + developer.getSkills()
                    + "\', account \'" + developer.getAccount() + "\'";
        return "Developer with name \'" + name + "\' not found.";
    }

    public Set<Developer> getListDeveloper() {
        Set<Developer> developers = developerRepository.getAll();
        if (developers != null) {
            for (Developer developer : developers)
                System.out.println(developer);
            return developers;
        } else System.out.println("List skills is empty.");
        return null;
    }

    public void update(Developer developer) {

    }

    public void delete(long id) {
        System.out.println("User with id = " + id + " not found");
    }
}
