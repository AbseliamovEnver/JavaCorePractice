package com.abselyamov.practice.module14.repository;

import com.abselyamov.practice.module14.controller.SkillController;
import com.abselyamov.practice.module14.model.Skill;

import java.io.*;
import java.util.Set;
import java.util.TreeSet;

public class SkillRepository {
    public void save(Skill skill) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(SkillController.SKILLS_TXT, true))) {
            writer.write(skill.getId() + "\t" + skill.getSkillName() + "\n");
        } catch (IOException e) {
            System.out.println("Exception write skills file: " + e);
        }
    }

    public Set<Skill> getSource() {
        Set<Skill> setSkills = new TreeSet<>();
        String data;

        try (BufferedReader reader = new BufferedReader(new FileReader(SkillController.SKILLS_TXT))) {
            File file = new File(SkillController.SKILLS_TXT);
            if (file.exists() && file.length() != 0) {
                while ((data = reader.readLine()) != null) {
                    String[] skill = data.split("\t");
                    for (int i = 0; i < skill.length; i++)
                        setSkills.add(new Skill(Integer.parseInt(skill[0]), skill[1]));
                }
            }
        } catch (IOException e) {
            System.out.println("Exception read skills file: " + e);
        }
        return setSkills;
    }

    public boolean remove(int id) {
        TreeSet<Skill> skills = (TreeSet<Skill>) getSource();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(new File(SkillController.SKILLS_TXT)))) {
            for (Skill skill : skills) {
                if (skill.getId() == id) {
                    skills.remove(skill);
                    for (Skill skillItem : skills) {
                        writer.write(skillItem.getId() + "\t" + skillItem.getSkillName() + "\n");
                    }
                    return true;
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File don't found in remove method " + e);
        } catch (IOException e) {
            System.out.println("Exception delete skill in remove method " + e);
        }
        return false;
    }
}
