package com.guigarage.samples;

import com.guigarage.utils.HideMySomewhere;

public class SimpleLoopSample {

    public static void main(String[] args) throws Exception {
        HideMySomewhere.installUpdate3();

        for (int i = 0; i < 10; i++) {
            step(i);
        }

    }

    private static void step(Integer step) {
        System.out.println("THIS IS STEP " + step);
        try {
            Thread.sleep(1_000);
        } catch (final Exception e) {}
    }
}
