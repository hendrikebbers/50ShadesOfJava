package com.guigarage.samples;

public class ConsultingTrick1000 {

    public static void main(final String[] args) {

        for (int i = 0; i < 100; i++) {
            printAndSleep(i);
        }
    }

    private static void printAndSleep(Integer v) {
        System.out.println("Hallo WJAX " + v);
        try {
            Thread.sleep(1_000);
        } catch (final Exception e) {}
    }
}
