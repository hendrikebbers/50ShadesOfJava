package com.guigarage.pattern;

public class BaremetalServer extends Infrastructure {

    public BaremetalServer(final String name) {
        super(name);
    }

    public void start100DockerContainer() {
        System.out.println("Container started");
    }
}
