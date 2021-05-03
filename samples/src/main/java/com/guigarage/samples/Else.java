package com.guigarage.samples;

public class Else {

    public static void main(String[] args) {

        final var name = "Hendrik";

        if(name == "Hendrik") {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }

        if(name.equals("Hendrik")) {
            System.out.println("YES");
        } {
            System.out.println("NO");
        }
    }
}
