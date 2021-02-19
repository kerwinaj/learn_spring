package com.crazyjava.codes.chapter02;

class Price {
    static {
        System.out.println("静态代码块1");
    }

    {
        System.out.println("代码块1, INSTANCE:" + INSTANCE + ",INIT_PRICE:" + INIT_PRICE + ",TEST_1:" + TEST_1);
    }

    final static Integer TEST_1 = 3;

    final static Price INSTANCE = new Price(2.8);

    static {
        System.out.println("静态代码块2, INSTANCE:" + INSTANCE);
    }

    static double INIT_PRICE = 20;

    static {
        System.out.println("静态代码块3, INSTANCE:" + INSTANCE);
    }

    double currentPrice;

    {
        System.out.println("代码块2, currentPrice:" + currentPrice + ", INSTANCE:" + INSTANCE + ",INIT_PRICE:" + INIT_PRICE);
    }

    public Price(double discount) {
        System.out.println("构造方法-开始, currentPrice:" + currentPrice + ", INSTANCE:" + INSTANCE + ",INIT_PRICE:" + INIT_PRICE + ",discount:" + discount);
        currentPrice = INIT_PRICE - discount;
        System.out.println("构造方法-结束, currentPrice:" + currentPrice + ", INSTANCE:" + INSTANCE + ",INIT_PRICE:" + INIT_PRICE + ",discount:" + discount);
    }

    @Override
    public String toString() {
        return "Price{" +
                "INIT_PRICE=" + INIT_PRICE +
                ",currentPrice=" + currentPrice +
                ",TEST_1=" + TEST_1 +
                '}';
    }
}

/**
 * 用到这个类之前, 这个类的所有静态变量(TEST_1, INSTANCE和INIT_PRICE)都完成了内存空间分配, 只不过此时值为默认值(0, null和0.0)
 * 按代码先后, 执行静态变量定义 和 静态代码块: 会分别设置初始化值, 即赋值为 3, new Price(2.8)和20;
 * 在赋值为 new Price(2.8) 的过程中, 按代码先后, 执行初始化的方法(代码块和实例变量定义按书写顺序, 构造方法最后);
 */
public class Order22_PriceTest {
    public static void main(String[] args) {
        // -2.8
        System.out.println("Price.INSTANCE.currentPrice:" + Price.INSTANCE.currentPrice);
        Price p = new Price(2.8);
        // 17.2
        System.out.println("p.currentPrice:" + p.currentPrice);
        // -2.8
        System.out.println("Price.INSTANCE.currentPrice:" + Price.INSTANCE.currentPrice);
    }
}