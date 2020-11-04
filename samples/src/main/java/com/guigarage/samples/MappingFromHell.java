package com.guigarage.samples;

import com.guigarage.utils.AnotherObject;

import java.util.HashMap;
import java.util.Map;

public class MappingFromHell {

    public static void main(String[] args) {
        final AnotherObject anotherObject = new AnotherObject();

        final Map<AnotherObject, String> names  = new HashMap<>();
        names.put(anotherObject, "Hugo");

    }
}
