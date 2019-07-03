package com.abselyamov.practice.module14.utils;

import java.io.*;
import java.util.Set;
import java.util.TreeSet;

public class FileIO<T> {
    public void fileWriter(T t, String path) {
        try (ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(path))) {
            output.writeObject(t);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Set<T> fileReader(String path) {
        Set<T> setList = new TreeSet();
        try (ObjectInputStream inpit = new ObjectInputStream(new FileInputStream(path))) {
            setList = (TreeSet<T>) inpit.readObject();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return setList;
    }
}
