package com.abselyamov.practice.module14.repository;

import com.abselyamov.practice.module14.model.Developer;
import com.abselyamov.practice.module14.model.Skill;
import com.abselyamov.practice.module14.utils.GetID;

import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class JavaIODeveloperRepositoryImpl implements DeveloperRepository {

    @Override
    public void add(Developer developer) {
        boolean addDeveloper = true;

        try (BufferedReader reader = new BufferedReader(new FileReader(Developer.DEVELOPER_FILE));
             BufferedWriter writer = new BufferedWriter(new FileWriter(Developer.DEVELOPER_FILE, true))) {
            File file = new File(Developer.DEVELOPER_FILE);
            if (file.exists() && file.length() != 0) {
                String data;
                while ((data = reader.readLine()) != null) {
                    String[] developerData = data.split("\t");
                    if (developerData[4].equals(developer.getAccount()))
                        addDeveloper = false;
                }
            }

            if (addDeveloper) {
                developer.setId(GetID.getID(Developer.DEVELOPER_FILE));
                writer.write(developer.getId() + "\t" + developer.getName() + "\t"
                        + developer.getSurName() + "\t" + developer.getSkills() + "\t" + developer.getAccount() + "\n");
                writer.flush();
            } else System.out.println("This developer already exists");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Exception read/write file in method add developer: " + e);
        }
    }

    @Override
    public Developer getById(Long id) {
        try (BufferedReader reader = new BufferedReader(new FileReader(Developer.DEVELOPER_FILE))) {
            File file = new File(Developer.DEVELOPER_FILE);
            if (file.exists() && file.length() != 0) {
                String data;
                while ((data = reader.readLine()) != null) {
                    String[] developerData = data.split("\t");
                    if (Long.parseLong(developerData[0]) == id)
                        return new Developer(id, developerData[1], developerData[2], null, null);
                }
            } else System.out.println("File with developers is empty");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Exception reading file in method get developer by id: " + e);
        }
        return null;
    }

    @Override
    public Developer getByName(String name) {
        try (BufferedReader reader = new BufferedReader(new FileReader(Developer.DEVELOPER_FILE))) {
            File file = new File(Developer.DEVELOPER_FILE);
            if (file.exists() && file.length() != 0) {
                String data;
                while ((data = reader.readLine()) != null) {
                    String[] developerData = data.split("\t");
                    if (developerData[1].equalsIgnoreCase(name))
                        return new Developer(Long.parseLong(developerData[0]), developerData[1], developerData[2],
                                null, null);
                }
            } else System.out.println("File with developers is empty");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Exception reading file in method get developer by name: " + e);
        }
        return null;
    }

    @Override
    public Set<Developer> getAll() {
        Set<Developer> developers = new HashSet<>();
        Set<Skill> skills = null;
        try (BufferedReader reader = new BufferedReader(new FileReader(Developer.DEVELOPER_FILE))) {
            File file = new File(Developer.DEVELOPER_FILE);
            if (file.exists() && file.length() != 0) {
                String data;
                while ((data = reader.readLine()) != null) {
                    String[] developerData = data.split("\t");
//                    developers.add(new Developer(Long.parseLong(developerData[0]), developerData[1],
//                            developerData[2], ));
                }
                return developers;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Exception reading file in method get all accounts: " + e);
        }
        return null;
    }

    @Override
    public void update(Developer developer, Long id) {

    }

    @Override
    public Developer delete(Long id) {
        return null;
    }
}
