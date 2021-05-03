package com.guigarage.gotoo;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class AbstractGoto {

    private Map<String, Object> values = new HashMap<>();

    private int[] memory = new int[65535];

    protected final void GOTO(final GotoLines i) {
        throw new GotoException(i);
    }

    protected final void STOP() {
        throw new StopException();
    }

    protected final void SET(final String name, final Object value) {
        values.put(name, value);
    }

    protected final void ADD(final String name, final int value) {
        final int currentValue = GET(name);
        SET(name, currentValue + 1);
    }

    protected final void IF(final boolean check, Runnable runnable) {
        if(check) {
            runnable.run();
        }
    }

    protected final <V> V GET(final String name) {
        return (V) values.get(name);
    }

    protected final <V> boolean IS(final String name, V v2) {
        final V value = GET(name);
        return Objects.equals(value, v2);
    }

    protected final void POKE(final int address, final int value) {
        memory[address] = value;
    }

    protected final int PEEK(final int address) {
        return memory[address];
    }

    protected static void PRINT(final int i) {
        System.out.println("" + i);
    }

    protected static void PRINT(final String i) {
        System.out.println(i);
    }

    public void run(GotoLines line) {
    }

    public void start() {
        GotoLines line = GotoLines.LINE_10;
        while (line != GotoLines.END) {
            try {
                run(line);
            } catch (final GotoException gotoException) {
                line = gotoException.getLine();
            } catch (final StopException stopException) {
                line = GotoLines.END;
            }
        }
    }
}
