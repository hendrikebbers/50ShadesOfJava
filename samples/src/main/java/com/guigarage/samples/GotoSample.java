package com.guigarage.samples;

public class GotoSample {

    public static void main(String[] args) {
        System.out.println("Start");
        OUTER_LOOP: for(int i = 0; i < 10; i++) {
            INNER_LOOP: for(int j = 0; j < 10; j ++) {
                System.out.println(i + ", " + j);
                if(i == 3) {
                    break INNER_LOOP;
                }
                if(i == 2) {
                    continue OUTER_LOOP;
                }
            }
        }
        System.out.println("End");
    }
}
