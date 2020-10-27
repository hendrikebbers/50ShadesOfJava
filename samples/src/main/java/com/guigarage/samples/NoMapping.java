package com.guigarage.samples;

import com.guigarage.utils.AnyObject;

import java.util.HashMap;

public class NoMapping {

    public static void main(String[] args) {
        final AnyObject object = new AnyObject();

        final HashMap<AnyObject, String> names = new HashMap<>();
        names.put(object, "Hugo");
    }
}
