package com.guigarage.utils;

import java.util.Random;

public class AnotherObject {

    private final static Random r = new Random(System.currentTimeMillis());

    @Override
    public int hashCode() {
        return r.nextInt();
    }
}
