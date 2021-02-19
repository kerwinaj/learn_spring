package com.crazyjava.codes.chapter02;

/**
 * 介绍了super的另一个用途:就是调用上一个父类(而不是更远的父类)的方法
 */
public class Order23_SuperTest02 {
    public static void main(String[] args) {
        Apple a = new Apple();
        Fruit f = a.getSuper();

        System.out.println("a==f : " + (a == f));

        System.out.println(a.color);
        System.out.println(f.color);
        a.info();
        f.info();

        a.accessSuperMethod();
        f.accessSuperMethod();

        a.accessSuperMethod2();
        f.accessSuperMethod2();
    }
}

class Basic {
    public void info() {
        System.out.println("[Basic.info]");
    }
}

class Fruit extends Basic {
    String color = "未定义的颜色";

    @Override
    public void info() {
        System.out.println("[Fruit.info]");
    }

    public Fruit getThis() {
        System.out.println("[Fruit.getThis]");
        return this;
    }

    public void accessSuperMethod() {
        super.info();
    }

    public void accessSuperMethod2() {
        super.info();
    }
}

class Apple extends Fruit {
    String color = "红色";

    @Override
    public void info() {
        System.out.println("[Apple.info]");
    }

    /**
     * 这个方法用来: 返回super关键字代表的内容
     * 注意, 是不允许直接用 return super;这样的语句的.
     * super不能被当作一个引用变量(this就可以), 它只是一个关键字(用法也就那几种)!!
     */
    public Fruit getSuper() {
        return super.getThis();
    }

    @Override
    public Fruit getThis() {
        System.out.println("[Apple.getThis]");
        return this;
    }

    @Override
    public void accessSuperMethod() {
        super.info();
    }
}