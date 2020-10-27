package com.guigarage.pattern;

public class Alexa extends Infrastructure {

    public Alexa(final String name) {
        super(name);
    }

    public void tellMeAJoke() {
        System.out.println("What’s the best time of year to go skydiving? Fall.");
    }
}
