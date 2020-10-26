package com.guigarage.samples;

import com.guigarage.utils.HideMySomewhere;

public class BetterErrorHandling {

    public static void main(String[] args) {
        HideMySomewhere.installUpdate();

        throw new RuntimeException("Error in main method");
    }
}
