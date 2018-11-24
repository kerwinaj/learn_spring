package com.yuk.java;

public class DoubleTest {
    public static void main(String[] args) {
        Double d1 = 1.5D;
        Double d2 = 0.2D;
        System.out.println("campare result:"+ Double.compare(d1, d2));
        System.out.println("campare result:"+ d1.compareTo(d2));
        System.out.println("d1 int result:"+ d1.intValue());
        System.out.println("d2 int result:"+ d2.intValue());

    }
}
