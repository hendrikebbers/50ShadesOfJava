package com.guigarage.samples;

import java.util.List;

public class SameSample2 {

    public static void main(String[] args) {
        final int i = 7;

        final List listA = wrapInList(i);
        final List listB = wrapInAnotherList(i);

        System.out.println(listA);
        System.out.println(listB);

        if (listA.equals(listB)) {
            System.out.println("Sind gleich");
        } else {
            System.out.println("Sind nicht gleich");
        }
    }

    public static List wrapInList(int i) {
        // Kommentar damit man den Inhalt nicht sieht...
        return List.of(i);
    }

    public static List wrapInAnotherList(int i) {
        // Kommentar damit man den Inhalt nicht sieht...
        return List.of((long) i);
    }
}
