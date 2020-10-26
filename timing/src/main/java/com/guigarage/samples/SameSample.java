package com.guigarage.samples;

import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Map;
import java.util.UUID;

public class SameSample {

    public static void main(String[] args) {
        final String a = UUID.randomUUID().toString().substring(0, 4);

        final String key = a;
        final String value = new String(a);

        final Map<String, String> map1 = createMap(key, value);
        final Map<String, String> map2 = createAnotherMap(key, key);

        System.out.println(map1);
        System.out.println(map2);

        if(map1.equals(map2)) {
            System.out.println("Sind gleich");
        } else {
            System.out.println("Sind nicht gleich");
        }
    }

    public static Map<String, String> createMap(String key, String value) {
        // Kommentar damit man den Inhalt nicht sieht...
        return new HashMap<>(Map.of(key, value));
    }

    public static Map<String, String> createAnotherMap(String key, String value) {
        // Kommentar damit man den Inhalt nicht sieht...
        return new IdentityHashMap<>(Map.of(key, value));
    }
}
