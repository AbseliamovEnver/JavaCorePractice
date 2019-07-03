package com.abselyamov.practice.module14.controller;

import com.abselyamov.practice.module14.model.Developer;
import com.abselyamov.practice.module14.repository.JavaIODeveloperRepositoryImpl;

import java.util.Set;

public class DeveloperController implements GenericInterface<Developer> {
    public static final String DEVELOPER_FILE = "src/main/java/com/abselyamov/practice/module14/database/developers.txt";
    JavaIODeveloperRepositoryImpl developerRepository = new JavaIODeveloperRepositoryImpl();

    @Override
    public void add(Developer developer) {
        developerRepository.add(developer);
    }

    @Override
    public void update(Developer developer) {

    }

    @Override
    public void delete(long id) {
        System.out.println("User with id = " + id + " not found");
    }

    @Override
    public Developer getItemById(long id) {
        return null;
    }

    @Override
    public Set<Developer> listItem() {
        return null;
    }
}
