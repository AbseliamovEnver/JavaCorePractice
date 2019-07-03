package com.abselyamov.practice.module14.repository;

import com.abselyamov.practice.module14.controller.SkillController;
import com.abselyamov.practice.module14.model.Skill;

import java.io.*;
import java.util.Set;
import java.util.TreeSet;

public class JavaIOSkillRepositoryImpl implements SkillRepository {

    @Override
    public void add(Skill skill) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(SkillController.SKILLS_FILE, true))) {
            writer.write(skill.getId() + "\t" + skill.getSkillName() + "\n");
        } catch (IOException e) {
            System.out.println("Exception write skills file: " + e);
        }
    }

    @Override
    public Set<Skill> getData() {
        Set<Skill> setSkills = new TreeSet<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(SkillController.SKILLS_FILE))) {
            File file = new File(SkillController.SKILLS_FILE);
            if (file.exists() && file.length() != 0) {
                String data;
                while ((data = reader.readLine()) != null) {
                    String[] skill = data.split("\t");
                    for (int i = 0; i < skill.length; i++)
                        setSkills.add(new Skill(Long.parseLong(skill[0]), skill[1]));
                }
            }
        } catch (IOException e) {
            System.out.println("Exception read skills file: " + e);
        }
        return setSkills;
    }

    @Override
    public Skill getById(Long id) {
        return null;
    }

    @Override
    public Set<Skill> getAll() {
        return getData();
    }

    @Override
    public void delete(Skill skill) {
        TreeSet<Skill> skills = (TreeSet<Skill>) getData();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(new File(SkillController.SKILLS_FILE)))) {
            skills.removeIf(sk -> sk.equals(skill));
            for (Skill skillItem : skills) {
                writer.write(skillItem.getId() + "\t" + skillItem.getSkillName() + "\n");
            }
        } catch (FileNotFoundException e) {
            System.out.println("File don't found in delete method " + e);
        } catch (IOException e) {
            System.out.println("Exception delete skill in delete method " + e);
        }
    }
}
