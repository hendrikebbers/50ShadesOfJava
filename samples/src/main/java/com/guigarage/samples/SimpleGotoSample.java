package com.guigarage.samples;

public class SimpleGotoSample {

    public static void main(String[] args) throws Exception {
        System.out.println("Start");

        http://www.google.de

        HUHU: System.out.println("huhu");

        LINE_10: for (int i = 0; i < 10; i++) {
            LINE_11: for (int j = 0; j < 10; j++) {
                LINE_12: for (int k = 0; k < 10; k++) {
                    System.out.println(i + "," + j + "," + k);
                    Thread.sleep(100);
                    if(k > 3 && j >= 2) {
                        continue LINE_10;
                    }
                }
            }
        }

        System.out.println("End");
    }
}
