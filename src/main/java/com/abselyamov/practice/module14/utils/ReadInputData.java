package com.abselyamov.practice.module14.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

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

    public int readInputInt(int min, int max) {
        boolean marker = true;
        int select = 0;
        while (marker) {
            try {
                select = Integer.parseInt(reader.readLine());
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
}
