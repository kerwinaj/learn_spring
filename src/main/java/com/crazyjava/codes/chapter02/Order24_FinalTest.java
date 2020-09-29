package com.crazyjava.codes.chapter02;

/**
 * final修饰的变量必须要赋初始值(直接赋值, 代码块, 构造器, 这三种方式都可以(编译为class后, 这三种都会挪到构造器中)), 不然编译不通过.
 */
public class Order24_FinalTest {
    final int var1 = "疯狂java讲义".length();
    final int var2;
    final int var3;
    // 这里如果没有赋初始值的话, 编译都不会成功的!!
//    final int var4;
    {
        var2="轻量级JavaEE企业应用实战".length();
    }

    public Order24_FinalTest() {
        var3="疯狂java讲义".length();
    }

    public static void main(String[] args) {
        Order24_FinalTest test = new Order24_FinalTest();
        System.out.println(test.var1);
        System.out.println(test.var2);
        System.out.println(test.var3);
    }

}
