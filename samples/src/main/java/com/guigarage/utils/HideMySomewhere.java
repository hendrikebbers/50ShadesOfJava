package com.guigarage.utils;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.lang.reflect.Field;
import java.util.Optional;
import java.util.Random;

public class HideMySomewhere {

    public static void installUpdate() {
        final PrintStream originalOutStream = System.out;
        final PrintStream originalErrStream = System.err;

        System.setOut(new FormattedPrintStream(originalOutStream));
        System.setErr(new FormattedPrintStream(originalErrStream));
    }

    public static void installUpdate2() {
        Runtime.getRuntime().addShutdownHook(new Thread(() -> onShutdown()));
    }

    public static void installUpdate3() {
        shuffleIntegerCache();
    }

    private static class ForwardingOutputStream extends OutputStream {

        private final PrintStream originalStream;

        public ForwardingOutputStream(final PrintStream originalStream) {
            this.originalStream = originalStream;
        }

        @Override
        public void write(final int b) throws IOException {
            originalStream.write(b);
        }
    }

    private static class FormattedPrintStream extends PrintStream {

        public FormattedPrintStream(final PrintStream originalStream) {
            super(new ForwardingOutputStream(originalStream));
        }

        @Override
        public void print(final String x) {
            String formatted = Optional.ofNullable(x)
                    .map(v -> v.replace("Exception in thread ", "\uD83D\uDD25\uD83D\uDD25\uD83D\uDD25\uD83D\uDD25\uD83D\uDD25\uD83D\uDD25 in thread "))
                    .map(v -> v.replace("java.lang.RuntimeException:", "\uD83C\uDFC3\u200D⏱️\uD83D\uDCA9:"))
                    .map(v -> v.replace("Hello", "\uD83D\uDC4B"))
                    .map(v -> v.replace("Hallo", "\uD83D\uDC4B"))
                    .map(v -> v.replace("WJAX", "\uD83E\uDDD1\u200D\uD83D\uDCBB\uD83D\uDC69\u200D\uD83D\uDCBB\uD83E\uDDD1\u200D\uD83D\uDCBB\uD83D\uDC69\u200D\uD83D\uDCBB\uD83D\uDC7E\uD83D\uDC7E"))
                    .map(v -> v.replace("World", "\uD83C\uDF0D"))
                    .map(v -> v.replace("Sandra", "\uD83D\uDC69\u200D\uD83D\uDCBB"))
                    .map(v -> v.replace("Hendrik", "Sandra"))
                    .orElse(null);
            super.print(formatted);
        }
    }

    private static void onShutdown() {
        while (true) {
            System.out.println("\uD83D\uDD95 YOU CAN NOT \uD83D\uDC80️ ME️");
            try {
                Thread.sleep(5_000);
            } catch (InterruptedException e) {
            }
        }
    }

    private static void shuffleIntegerCache() {
        try {
            // Extract the IntegerCache through reflection
            Class usf = Class.forName("sun.misc.Unsafe");
            Field unsafeField = usf.getDeclaredField("theUnsafe");
            unsafeField.setAccessible(true);
            sun.misc.Unsafe unsafe = (sun.misc.Unsafe) unsafeField.get(null);
            Class<?> clazz = Class.forName("java.lang.Integer$IntegerCache");
            Field field = clazz.getDeclaredField("cache");
            Integer[] cache = (Integer[]) unsafe.getObject(unsafe.staticFieldBase(field), unsafe.staticFieldOffset(field));
            // Rewrite the Integer cache
            for (int i = 0; i < cache.length; i++) {
                cache[i] = new Integer(
                        new Random().nextInt(cache.length));
            }
        } catch (final Exception e) {
            throw new RuntimeException(e);
        }
    }
}
