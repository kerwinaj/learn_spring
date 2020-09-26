package com.crazyjava.codes.chapter07;

/**
 * instanceof运算符
 *      编译阶段(使用限制, 比运行时的范围宽):
 *          前面操作数的编译时类型, 必须和后面类型:
 *              相同/后面类型的父类/后面类型的子类, 这样编译通过;
 *              否则, 编译出错.
 *      运行阶段(返回结果):
 *          前面操作数实际引用对象的类型, 和后面类型:
 *              相同/后面类型的子类或实现类的实例, 返回true;
 *              其他, 返回false;
 * 强制转型
 *      编译阶段(使用限制, 比运行时的范围宽):
 *          被转型变量的编译时类型, 必须和目标类型:
 *              相同/目标类型的父类/目标类型的子类, 这样编译通过;
 *              否则, 编译出错.
 *      运行阶段(返回结果):
 *          被转型变量实际引用对象的类型, 和目标类型:
 *              相同/目标类型的子类或实现类的实例, 可以转换;
 *              其他, 报 ClassCastException 异常;
 *
 * 有用的结论:
 *      最佳实践是: 先使用 instanceof运算符, 然后再执行 强制转型;
 *      因为: instanceof运算符 可以保证是指定的类型, 而且不是null(null的话返回false了), 这样在强制转型的时候就能避免 NPE 和 ClassCastException了.
 */
public class Order1_InstanceOfTest{
    public static void main(String[] args) {
        test1();
        test2();
        test3();
        test4();
        test5();
    }

    public static void test1() {
        try {
            /**
             * hello 的编译时类型是 Object, 实际引用对象的类型为 String.
             */
            Object hello = "Hello";
            System.out.println("[test1]" + (hello instanceof Object));
            System.out.println("[test1]" + (hello instanceof String));
            System.out.println("[test1]" + (hello instanceof Math));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void test2() {
        try {
            /**
             * hello2 的编译时类型是 String, 实际引用对象的类型为 String.
             */
            String hello2 = "Hello";
            System.out.println("[test2]" + (hello2 instanceof Object));
            System.out.println("[test2]" + (hello2 instanceof String));
            // 编译时会报错!
//        System.out.println("" + (hello2 instanceof Math));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void test3() {
        try {
            Object str = "Hello";
            // str 的编译时类型是 Object
            // java.lang.ClassCastException: java.lang.String cannot be cast to java.lang.Math
            Math math = (Math) str;
            /**
             * math 的编译时类型是 Math, 实际引用对象的类型为 String.
             * 编译时会报错!
             */
//            System.out.println("" + (math instanceof String));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void test4() {
        try{
            /**
             * null可以作为所有引用型变量的值, 但它实际上并没有引用一个真正的String对象, 所以返回false.
             */
            String s = null;
            System.out.println("[test4]" + (s instanceof String));
            String casted = (String)s;
            System.out.println("[test4]casted:" + casted);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 最佳实践
     */
    public static void test5() {
        Object obj = "2asdfsafd";
        if (obj instanceof String) {
            String objStr = (String)obj;
            System.out.println("[test5]objStr:" + objStr);
        }
        if (obj instanceof Integer) { // return false;
            Integer objInt = (Integer)obj;
            System.out.println("[test5]objInt:" + objInt);
        }
    }
}