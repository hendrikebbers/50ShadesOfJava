package com.guigarage.samples;

public class BetterErrorHandling {

    public static void main(String[] args) {
        // Same old trick ;)
        // \u000d com.guigarage.utils.HideMySomewhere.installUpdate();

        throw new RuntimeException("Error in main method");
    }
}
