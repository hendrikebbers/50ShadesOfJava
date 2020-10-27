package com.guigarage.samples;

public class TwoLittleIntegers {

    public static void main(String[] args) {

        final var a = parseInt("1");
        final var b = parseInt("1");

        System.out.println(a);
        System.out.println(b);

        System.out.println(a == b);
    }

    private static Integer parseInt(final String value) {
        return Integer.valueOf(Integer.parseInt(value));
    }
}
