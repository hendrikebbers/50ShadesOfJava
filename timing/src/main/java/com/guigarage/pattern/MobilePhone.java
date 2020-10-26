package com.guigarage.pattern;

public class MobilePhone extends Infrastructure {

    public MobilePhone(final String name) {
        super(name);
    }

    public void sendSMS() {
        System.out.println("SMS has been send");
    }
}
