package com.abselyamov.practice.module14.repository;

import com.abselyamov.practice.module14.controller.DeveloperController;
import com.abselyamov.practice.module14.model.Developer;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Set;

public class JavaIODeveloperRepositoryImpl implements DeveloperRepository {

    @Override
    public void add(Developer developer) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(DeveloperController.DEVELOPER_FILE, true))) {
            writer.write(developer.getId() + "\t" + developer.getName() + "\t"
                    + developer.getSurName() + "\t" + developer.getSkills() + "\t" + developer.getAccount() + "\n");
        } catch (IOException e) {
            System.out.println("Exception write developers file: " + e);
        }
    }

    @Override
    public void update(Developer developer, Long id) {

    }

    @Override
    public Developer getById(Long aLong) {
        return null;
    }

    @Override
    public Developer getByName(String name) {
        return null;
    }

    @Override
    public Set<Developer> getAll() {
        return null;
    }

    @Override
    public void delete(Developer developer) {

    }
}
