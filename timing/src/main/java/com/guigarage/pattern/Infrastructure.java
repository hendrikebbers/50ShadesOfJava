package com.guigarage.pattern;

public abstract class Infrastructure extends RuntimeException {

    public final String name;

    public Infrastructure(final String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
