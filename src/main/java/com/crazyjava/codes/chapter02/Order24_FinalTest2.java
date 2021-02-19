package com.crazyjava.codes.chapter02;

/**
 * final修饰的变量必须要赋初始值, 不然编译不通过.
 */
public class Order24_FinalTest2 {
    final static int var1 = "疯狂java讲义".length();
    final static int var2;

    // 这里如果没有赋初始值的话, 编译都不会成功的!!
//    final static int var4;
    static {
        var2 = "轻量级JavaEE企业应用实战".length();
    }

    public static void main(String[] args) {
        System.out.println(Order24_FinalTest2.var1);
        System.out.println(Order24_FinalTest2.var2);
    }

}
