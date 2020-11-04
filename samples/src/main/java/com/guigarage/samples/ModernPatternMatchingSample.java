package com.guigarage.samples;

import com.guigarage.pattern.Alexa;
import com.guigarage.pattern.BaremetalServer;
import com.guigarage.pattern.Infrastructure;
import com.guigarage.pattern.MobilePhone;

public class ModernPatternMatchingSample {

    public static void main(String[] args) {

        //Modern pattern matching in future Java versions

//        String formatted = "unknown";
//        if (obj instanceof Integer i) {
//            formatted = String.format("int %d", i);
//        }
//        else if (obj instanceof String s) {
//            formatted = String.format("String %s", s);
//        }


//        switch (obj) {
//              case Integer i -> String.format("int %d", i);
//              case String s  -> String.format("String %s, s);
//              default        -> "unknown";
//         };



   //     executeWithUglyCasting(new Alexa("Hendriks Alexa"));
   //     executeWithoutCasting(new Alexa("Hendriks Alexa"));
    }

    private static void executeWithUglyCasting(final Infrastructure infrastructure) {
        if(infrastructure instanceof MobilePhone) {
            MobilePhone v = (MobilePhone) infrastructure;
            v.sendSMS();
        }
        if(infrastructure instanceof BaremetalServer) {
            BaremetalServer v = (BaremetalServer) infrastructure;
            v.start100DockerContainer();
        }
        if(infrastructure instanceof Alexa) {
            Alexa v = (Alexa) infrastructure;
            v.tellMeAJoke();
        }
    }

    private static void executeWithoutCasting(final Infrastructure infrastructure) {
        try {
            throw infrastructure;
        } catch (MobilePhone v) {
            v.sendSMS();
        } catch (BaremetalServer v) {
            v.start100DockerContainer();
        } catch (Alexa v) {
            v.tellMeAJoke();
        }
    }
}
