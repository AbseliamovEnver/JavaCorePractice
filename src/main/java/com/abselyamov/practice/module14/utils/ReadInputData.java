package com.abselyamov.practice.module14.utils;

import com.abselyamov.practice.module14.controller.SkillController;
import com.abselyamov.practice.module14.model.Skill;

import java.io.*;
import java.util.Set;
import java.util.TreeSet;

public class ReadInputData {
    private BufferedReader reader;

    public ReadInputData() {
        this.reader = new BufferedReader(new InputStreamReader(System.in));
    }

    public String readInputString() {
        String data = null;
        try {
            data = reader.readLine();
        } catch (IOException e) {
            System.out.println("I/O Exception in readInputString method: " + e);
        }
        return data;
    }

    public long readInputData(long min, long max) {
        boolean marker = true;
        long select = 0;
        while (marker) {
            try {
                select = Long.parseLong(reader.readLine());
                if (select >= min && select <= max)
                    marker = false;
                else
                    System.out.println("Please enter correct value: ");
            } catch (Exception ex) {
                System.out.println("Invalid value: " + select);
                System.out.println("Please enter correct integer value: ");
            }
        }
        return select;
    }

//    public Set getData(String path) {
//        Set set = new TreeSet<>();
//
//        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
//            File file = new File(path);
//            if (file.exists() && file.length() != 0) {
//                String data;
//                while ((data = reader.readLine()) != null) {
//                    String[] arrayStr = data.split("\t");
//                    for (int i = 0; i < arrayStr.length; i++)
//                        set.add(arrayStr[0]);
//                }
//            }
//        } catch (IOException e) {
//            System.out.println("Exception read the file: " + e);
//        }
//        return set;
//    }
}
