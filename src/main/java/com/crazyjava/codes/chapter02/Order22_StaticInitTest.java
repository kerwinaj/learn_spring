package com.crazyjava.codes.chapter02;

/**
 * 类变量初始化的2个时机(按顺序的):
 * a. 定义时指定初始值;
 * b. 静态代码块中指定初始值;
 */
public class Order22_StaticInitTest {
    static int count = 2;

    static {
        System.out.println("静态初始化块1, count:" + count);
    }

    static String name = "疯狂java讲义";

    static {
        System.out.println("静态初始化块2-开始, count:" + count + ", name:" + name);
        name ="java编程";
        System.out.println("静态初始化块2-结束, count:" + count + ", name:" + name);
    }

    public static void main(String[] args) {
        System.out.println("类变量的值, count:" + Order22_StaticInitTest.count);
        System.out.println("类变量的值, name:" + Order22_StaticInitTest.name);
    }
}