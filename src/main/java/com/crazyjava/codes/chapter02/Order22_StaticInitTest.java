package com.crazyjava.codes.chapter02;

/**
 * 类变量初始化的2个时机(按代码写的顺序执行):
 * a. 定义时指定初始值;
 * b. 静态代码块中指定初始值;
 */
public class Order22_StaticInitTest {
    static int COUNT = 2;

    static {
        System.out.println("静态初始化块1, COUNT:" + COUNT);
    }

    static String NAME = "疯狂java讲义";

    static {
        System.out.println("静态初始化块2-开始, COUNT:" + COUNT + ", NAME:" + NAME);
        NAME = "java编程";
        System.out.println("静态初始化块2-结束, COUNT:" + COUNT + ", NAME:" + NAME);
    }

    public static void main(String[] args) {
        System.out.println("COUNT:" + Order22_StaticInitTest.COUNT);
        System.out.println("NAME:" + Order22_StaticInitTest.NAME);
    }
}