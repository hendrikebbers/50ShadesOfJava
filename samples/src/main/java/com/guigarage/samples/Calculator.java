package com.guigarage.samples;

/**
 * See https://javabeginners.de/Grundlagen/Modifikatoren/strictfp.php or https://www.baeldung.com/java-strictfp
 * Write-Once-Get-Equally-Wrong-Results-Everywhere
 * https://stackoverflow.com/questions/517915/when-should-i-use-the-strictfp-keyword-in-java
 *
 */
public class Calculator {

    public double diff(double value1, double value2) {
        return value1 - value2;
    }

    strictfp double strictDiff(double value1, double value2) {
        return value1 - value2;
    }

    public static void main(String[] args) {
        //
        final double result1 = new Calculator().diff(Double.MAX_VALUE, 1.56);
        final double result2 = new Calculator().strictDiff(Double.MAX_VALUE, 1.56);
        if(result1 == result2) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
