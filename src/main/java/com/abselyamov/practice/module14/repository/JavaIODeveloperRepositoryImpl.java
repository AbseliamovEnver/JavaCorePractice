package com.abselyamov.practice.module14.repository;

import com.abselyamov.practice.module14.model.Developer;
import com.abselyamov.practice.module14.model.Skill;
import com.abselyamov.practice.module14.utils.GetDeveloperList;
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
        File file = new File(Developer.DEVELOPER_FILE);
        Set<Developer> developers;

        if (file.exists() && file.length() != 0) {
            developers = GetDeveloperList.getDevelopers(file);
            for (Developer developer : developers) {
                if (developer.getId() == id) {
                    return developer;
                }
            }
        } else System.out.println("File with developers is empty");
        return null;
    }


    @Override
    public Developer getByName(String name) {
        File file = new File(Developer.DEVELOPER_FILE);
        Set<Developer> developers;

        if (file.exists() && file.length() != 0) {
            developers = GetDeveloperList.getDevelopers(file);
            for (Developer developer : developers) {
                if (developer.getName().equals(name))
                    return developer;
            }
        } else System.out.println("File with developers is empty");
        return null;
    }

    @Override
    public Set<Developer> getAll() {
        File file = new File(Developer.DEVELOPER_FILE);
        Set<Developer> developers = null;

        if (file.exists() && file.length() != 0) {
            developers = GetDeveloperList.getDevelopers(file);
        } else System.out.println("File with developers is empty");
        return developers;
    }

    @Override
    public void update(Developer developer, Long id) {
        Developer developer1;

        File file = new File(Developer.DEVELOPER_FILE);
        if (file.exists() && file.length() != 0) {
            Set<Developer> developers = GetDeveloperList.getDevelopers(file);
            for (Developer developerItem : developers) {
                if (developerItem.getId() == id)
                    developer1 = new Developer(developerItem);
            }
        }
    }

    @Override
    public Developer delete(Long id) {
        Set<Developer> developers = new HashSet<>();
        Developer developerDelete = null;
        boolean deleteDeveloper = false;

        File file = new File(Developer.DEVELOPER_FILE);
        if (file.exists() && file.length() != 0) {
            Set<Developer> developerList = GetDeveloperList.getDevelopers(file);
            for (Developer developer : developerList) {
                if (developer.getId() == id) {
                    developerDelete = new Developer(developer.getId(), developer.getName(), developer.getSurName(),
                            developer.getSkills(), developer.getAccount());
                    deleteDeveloper = true;
                    continue;
                }
                developers.add(new Developer(developer.getId(), developer.getName(), developer.getSurName(),
                        developer.getSkills(), developer.getAccount()));
            }
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(Developer.DEVELOPER_FILE, false))) {
            if (deleteDeveloper) {
                for (Developer developer : developers)
                    writer.write(developer.getId() + "\t" + developer.getName() + "\t" + developer.getSurName()
                            + "\t" + developer.getSkills() + "\t" + developer.getAccount() + "\n");
            }
        } catch (IOException e) {
            System.out.println("Exception writing file in method delete developer: " + e);
        }
        return developerDelete;
    }

    @Override
    public boolean addSkillDeveloper(Developer developer, Skill skill) {
        Set<Skill> skills = new HashSet<>();
        boolean addSkill = false;

        File file = new File(Developer.DEVELOPER_FILE);
        if (file.exists() && file.length() != 0) {
            Set<Developer> developerList = GetDeveloperList.getDevelopers(file);
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(Developer.DEVELOPER_FILE, false))) {
                for (Developer developerItem : developerList) {
                    if (developerItem.getId() == developer.getId()) {
                        skills = developer.getSkills();
                        skills.add(skill);
                        writer.write(developer.getId() + "\t" + developer.getName() + "\t" + developer.getSurName()
                                + "\t" + skills + "\t" + developer.getAccount() + "\n");
                        addSkill = true;
                        continue;
                    }
                    writer.write(developerItem.getId() + "\t" + developerItem.getName() + "\t" + developerItem.getSurName()
                            + "\t" + developerItem.getSkills() + "\t" + developerItem.getAccount() + "\n");
                }
            } catch (IOException e) {
                System.out.println("Exception writing file in method delete developer: " + e);
            }
        }
        return addSkill;
    }
}
