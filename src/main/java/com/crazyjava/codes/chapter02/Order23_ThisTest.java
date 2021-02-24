package com.crazyjava.codes.chapter02;

/**
 * 这个例子验证了:
 *      this 调用 实例变量和方式时, 和 Order6_FieldAndMethodTest 中一样
 */
public class Order23_ThisTest {
    public static void main(String[] args) {
        new Derived();
    }
}

class Base {

    static {
        System.out.println("[Base.static.{}.1]");
    }

    public static int NUM_1;

    {
        System.out.println("[Base.{}]");
    }

    private int i = 2;

    {
        System.out.println("[Base.{}]i:" + i);
    }

    public Base() {
        System.out.println("[Base.init]i:" + i + "," + this.getClass());
        this.display();
    }

    public void display() {
        System.out.println("[Base.display]i:" + i);
    }

    static {
        System.out.println("[Base.static.{}.2], NUM_1:" + NUM_1);
    }

    static {
        NUM_1 = 11;
    }

    static {
        System.out.println("[Base.static.{}.3], NUM_1:" + NUM_1);
    }

    public static int NUM_2 = 12;

}

class Derived extends Base {

    static {
        System.out.println("[Derived.static.{}.1], Base.NUM_1:" + Base.NUM_1 +",Derived.NUM_1:" + Derived.NUM_1 + ",NUM_2:" + NUM_2);
    }

    public static int NUM_1;

    {
        System.out.println("[Derived.{}]");
    }

    private int i = 22;

    {
        System.out.println("[Derived.{}]i:" + i);
    }

    public Derived() {
        System.out.println("[Derived.init]1, i:" + i);
        i = 222;
        System.out.println("[Derived.init]2, i:" + i);
    }

    @Override
    public void display() {
        System.out.println("[Derived.display]i:" + i);
    }

    static {
        System.out.println("[Derived.static.{}.2], Base.NUM_1:" + Base.NUM_1 + ",NUM_1:" + NUM_1 + ",Derived.NUM_1:" + Derived.NUM_1 +",NUM_2:" + NUM_2);
    }

    static {
        NUM_1 = 101;
    }

    static {
        System.out.println("[Derived.static.{}.3], Base.NUM_1:" + Base.NUM_1 +",NUM_1:" + NUM_1 + ",Derived.NUM_1:" + Derived.NUM_1 +",NUM_2:" + NUM_2);
    }
}