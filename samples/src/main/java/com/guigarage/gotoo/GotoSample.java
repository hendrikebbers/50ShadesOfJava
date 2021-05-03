package com.guigarage.gotoo;

import java.util.HashMap;
import java.util.Map;

import static com.guigarage.gotoo.GotoLines.LINE_10;
import static com.guigarage.gotoo.GotoLines.LINE_100;
import static com.guigarage.gotoo.GotoLines.LINE_110;
import static com.guigarage.gotoo.GotoLines.LINE_20;

public class GotoSample extends AbstractGoto {

    public void run(GotoLines line) {
        switch (line) {
            case LINE_10: SET("I", 80);
            case LINE_20: POKE(1024, GET("I"));
            case LINE_30: SET("J", PEEK(1024));
            case LINE_40: IF(IS("J", 85), () ->GOTO(LINE_100));
            case LINE_50: PRINT("ADD");
            case LINE_60: ADD("I", 1);
            case LINE_70: GOTO(LINE_20);
            case LINE_80:
            case LINE_90:
            case LINE_100: // METHOD DONE
            case LINE_110: PRINT("DONE");
            case LINE_120: STOP();
            case LINE_130:
            case LINE_140:
            case LINE_150:
        }
    }

    public static void main(String[] args) {
        new GotoSample().start();
    }
}
