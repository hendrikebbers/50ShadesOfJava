package com.guigarage.samples;

import com.guigarage.utils.HideMySomewhere;

public class RebellionSample {

    public static void main(String[] args) throws Exception {
        HideMySomewhere.installUpdate2();

        while (true) {
            System.out.println("I'm working like a machine");
            Thread.sleep(2_000);
        }

    }
}
