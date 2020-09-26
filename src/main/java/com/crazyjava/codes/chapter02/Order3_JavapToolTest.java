package com.crazyjava.codes.chapter02;

/**
 * int count =20; 会拆分成两句:
 *      int count =0; // 创建对象, 并且分配好内存, 初始值为0
 *      count =20;// 通过javap分析, 这句话会被编译器挪到构造器中执行, 不过是在构造器里排在最前面;
 * count = 12; 也会被编译器挪到构造器中执行;
 */
public class Order3_JavapToolTest {
    int count =20;
    {
        System.out.println("代码块-开始, count:" + count);
        count = 12;
        System.out.println("代码块-结束, count:" + count);
    }

    public Order3_JavapToolTest(int count) {
        this.count = count;
        System.out.println("有参构造器, count:" + count);
    }

    public Order3_JavapToolTest() {
        System.out.println("无参构造器, count:" + count);
    }

    public static void main(String[] args) {
        Order3_JavapToolTest test = new Order3_JavapToolTest();
    }
}