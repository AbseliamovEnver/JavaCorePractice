package com.abselyamov.practice.module12.task2;

public class Main {
    public static void main(String[] args) {
        AddToArrayList<Integer> arrayListDefault = new AddToArrayList<>();

        System.out.println("Initial default collection content: ");
        arrayListDefault.printList();

        System.out.println("Initial default collection size: " + arrayListDefault.size());

        arrayListDefault.add(5);
        arrayListDefault.add(18);
        arrayListDefault.add(55);

        System.out.println("The contents of the collection after adding items: ");
        arrayListDefault.printList();

        System.out.println("The size collection after adding items: " + arrayListDefault.size());

        System.out.println("***************************************************************");

        AddToArrayList<Integer> arrayListWithCapacity = new AddToArrayList<>(4);

        System.out.println("Initial collection content with capacity: ");
        arrayListWithCapacity.printList();

        System.out.println("Initial collection size with capacity: " + arrayListWithCapacity.size());

        arrayListWithCapacity.add(5);
        arrayListWithCapacity.add(18);
        arrayListWithCapacity.add(55);
        arrayListWithCapacity.add(152);
        arrayListWithCapacity.add(31);

        System.out.println("The contents of the collection after adding " + (arrayListWithCapacity.size() + 1) + " items: ");
        arrayListWithCapacity.printList();

        System.out.println("The size collection after adding items: " + arrayListWithCapacity.size());
    }
}
