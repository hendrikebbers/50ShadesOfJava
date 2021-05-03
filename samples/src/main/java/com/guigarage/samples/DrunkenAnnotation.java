package com.guigarage.samples;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

/**
 * https://docs.oracle.com/javase/specs/jls/se14/html/jls-9.html#jls-9.7.4
 *
 */
@Target(ElementType.TYPE_USE)
public @interface DrunkenAnnotation {
}
