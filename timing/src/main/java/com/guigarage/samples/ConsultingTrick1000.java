package com.guigarage.samples;

public class ConsultingTrick1000 {

    public static void main(final String[] args) {

        for (int i = 0; i < 100; i++) {
            System.out.println("Hallo WJAX " + i);
            try {
                Thread.sleep(1_000);
            } catch (final Exception e) {}
        }
    }
}
