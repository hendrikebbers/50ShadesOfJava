package com.guigarage.samples;

import com.guigarage.pattern.Alexa;
import com.guigarage.pattern.BaremetalServer;
import com.guigarage.pattern.Infrastructure;
import com.guigarage.pattern.MobilePhone;

public class ModernPatternMatchingSample {

    public static void main(String[] args) {












        //Modern pattern matching in future Java versions
        // Object obj = ....
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



        Infrastructure i = null;

        try {
            throw i;
        } catch (Alexa a) {
            a.tellMeAJoke();
        } catch (BaremetalServer b) {
            b.start100DockerContainer();
        } catch (MobilePhone m) {
            m.sendSMS();
        }




        if(i instanceof Alexa) {
            ((Alexa) i).tellMeAJoke();
        }
        if(i instanceof BaremetalServer) {
            ((BaremetalServer) i).start100DockerContainer();
        }





   //     executeWithUglyCasting(new Alexa("Hendriks Alexa"));
   //     executeWithoutCasting(new Alexa("Hendriks Alexa"));












        //        Infrastructure i = new MobilePhone("Hendriks Telefon");
//        try {
//            throw i;
//        } catch (Alexa a) {
//            a.tellMeAJoke();
//        } catch (MobilePhone p) {
//            p.sendSMS();
//        } catch (BaremetalServer s) {
//            s.start100DockerContainer();
//        }




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
