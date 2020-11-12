package com.yuk.java.jdk8;

import java.util.function.Function;

public class FunctionTest {
    public static void main(String[] args) {
        applyTest();
        andThenTest();
        composeTest();
        test();
    }

    /**
     * 1、apply 示例
     */
    private static void applyTest() {
        //示例1：定义一个funciton,实现将String转换为Integer
        Function<String, Integer> function = x -> Integer.parseInt(x);
        Integer a = function.apply("100");
        System.out.println(a.getClass());
        // 结果：class java.lang.Integer
    }

    /**
     * 2、andThen 示例
     */
    private static void andThenTest() {
        //示例2：使用andThen() 实现一个函数 y=10x + 10;
        //先执行 10 * x
        Function<Integer, Integer> function2 = x -> 10 * x;
        //通过andThen在执行 这里的x就等于上面的10 * x的值
        function2 = function2.andThen(x -> x + 10);
        System.out.println(function2.apply(2));
        //结果：30

    }

    /**
     * 3、compose 示例
     */
    private static void composeTest() {
        //示例3：使用compose() 实现一个函数 y=(10+x)2;
        Function<Integer, Integer> function3 = x -> x * 2;
        //先执行 x+10 在执行(x+10)*2顺序与上面相反
        function3 = function3.compose(x -> x + 10);
        System.out.println(function3.apply(2));
        //结果：24
    }

    /**
     * 4、综合示例
     */
    private static void test() {

//示例4：使用使用compose()、andThen()实现一个函数 y=(10+x)*2+10;
        //执行第二步
        Function<Integer, Integer> function4 = x -> x * 2;
        //执行第一步
        function4 = function4.compose(x -> x + 10);
        //执行第三步
        function4 = function4.andThen(x -> x + 10);
        System.out.println(function4.apply(2));
        //结果：34

    }
}
