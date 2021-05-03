package com.guigarage.gotoo;

public class GotoException extends RuntimeException {

    private final GotoLines line;

    public GotoException(final GotoLines line) {
        this.line = line;
    }

    public GotoLines getLine() {
        return line;
    }
}
