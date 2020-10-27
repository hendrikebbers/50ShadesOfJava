package com.guigarage.samples;

import com.guigarage.utils.ConsoleUtils;

public class HelloWorldSample {

    public static void main(final String[] args) {
        // This is the first sample
        // In following samples we want to execute this first:
        // \u000d com.guigarage.utils.HideMySomewhere.installUpdate();
        // But let's a look at a plain Java sample first :)


        ConsoleUtils.printAppStarter();


        System.out.println("Guten Tag Welt!");


        ConsoleUtils.printAppEnd();
    }
}
