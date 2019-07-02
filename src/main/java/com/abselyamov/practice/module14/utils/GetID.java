package com.abselyamov.practice.module14.utils;

import com.abselyamov.practice.module14.controller.SkillController;

import java.io.*;
import java.util.SortedSet;
import java.util.TreeSet;

public class GetID {
    public int getID() {
        SortedSet<String> skills = new TreeSet<>();
        int lastId = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader(SkillController.SKILLS_TXT))) {
            File file = new File(SkillController.SKILLS_TXT);
            String data;
            while ((data = reader.readLine()) != null)
                skills.add(data);

            if (file.exists() && file.length() != 0) {
                lastId = Integer.parseInt(skills.last().split("\t")[0]);
                return ++lastId;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lastId;
    }
}
