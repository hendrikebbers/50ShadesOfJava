package com.guigarage.samples;

public class DrunkAnnotationUsage {

    @Deprecated
    public String getDescription() {
        return null;
    }

    @Deprecated
    public java.lang.String getDescription1() {
        return null;
    }

    @DrunkenAnnotation
    public String getName() {
        return "Hendrik";
    }

    //@DrunkAnnotation
    public java.lang.String getName2() {
        return "Hendrik";
    }
}
