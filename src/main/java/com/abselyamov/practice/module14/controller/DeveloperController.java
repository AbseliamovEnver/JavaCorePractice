package com.abselyamov.practice.module14.controller;

import java.util.List;

public class DeveloperController<Developer> implements GenericInterface<Developer> {

    private List<Developer> developerList;

    @Override
    public void add(Developer developer) {
        developerList.add(developer);
    }

    @Override
    public void update(Developer developer) {

    }

    @Override
    public void delete(int id) {
        if (developerList.contains(getItemById(id)))
            developerList.remove(id);
        else
            System.out.println("User with id = " + id + " not found");
    }

    @Override
    public Developer getItemById(int id) {
        return developerList.get(id);
    }

    @Override
    public List<Developer> listItem() {
        return developerList;
    }
}
