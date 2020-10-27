package com.guigarage.samples;

import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Map;

public class SameSampleMap {

    public static void main(String[] args) {
        final char[] chars = {'H', 'e', 'l', 'l', 'o'};

        String key = new String(chars);
        String value = new String(chars);

        Map<String, String> map1 = createMap(key, value);
        Map<String, String> map2 = createAnotherMap(key, key);

        System.out.println(map1);
        System.out.println(map2);

        if(map2.equals(map1)) {
            System.out.println("Sind gleich");
        } else {
            System.out.println("Sind nicht gleich");
        }
    }

    public static Map<String, String> createMap(String key, String value) {
        return new HashMap<>(Map.of(key, value));
    }

    public static Map<String, String> createAnotherMap(String key, String value) {
        return new IdentityHashMap<>(Map.of(key, value));
    }
}
