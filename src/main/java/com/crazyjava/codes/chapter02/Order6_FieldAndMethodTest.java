package com.crazyjava.codes.chapter02;

/**
 * 和 Test 一样, new Derived1()的时候, 也是有2个count变量的, 虽然这里不是private修饰的.
 */
public class Order6_FieldAndMethodTest {
    public static void main(String[] args) {
        /**
         * b.count:2
         * 2
         */
        Base1 b = new Base1();
        System.out.println("b.count:" + b.count);
        b.display();

        /**
         * d.count:20
         * 20
         */
        Derived1 d = new Derived1();
        System.out.println("d.count:" + d.count);
        d.display();

        /**
         * bd.count:2
         * 20
         *
         * 上面两个结论还算好理解, 这个的原因如下:
         * 通过bd访问实例变量count时, 输出的是Base1(声明时的类型)对象的count值;
         * 通过db访问方法display时,   输出的是Derived1(运行时类型)对象的count值;
         */
        Base1 bd = new Derived1();
        System.out.println("bd.count:" + bd.count);
        bd.display();

        /**
         * d2b.count:2
         * 20
         *
         * 分析同上
         */
        Base1 d2b = d;
        System.out.println("d2b.count:" + d2b.count);
        d2b.display();

        /**
         * 这里即使强制转型了, 实际上还是 Derived1 对象.
         */
        Base1 bbbb = (Base1)d;
        System.out.println("bbbb.count:" + bbbb.count);
        bbbb.display();
    }
}

class Base1 {
    int count =2;

    public void display(){
        System.out.println(this.count);
    }
}

class Derived1 extends Base1 {
    int count =20;

    @Override
    public void display(){
        System.out.println(this.count);
    }
}
