class Price{
    static {
        System.out.println("静态代码块0");
    }
    final static Price INSTANCE = new Price(2.8);
    static {
        System.out.println("静态代码块1, INSTANCE:" + INSTANCE);
    }
    static double initPrice = 20;
    static {
        System.out.println("静态代码块2, INSTANCE:" + INSTANCE + ",initPrice:" + initPrice);
    }
    double currentPrice;
    {
        System.out.println("代码块, currentPrice:" + currentPrice + ", INSTANCE:" + INSTANCE + ",initPrice:" + initPrice);
    }
    public Price(double discount) {
        System.out.println("构造方法-开始, currentPrice:" + currentPrice + ", INSTANCE:" + INSTANCE + ",initPrice:" + initPrice + ",discount:" + discount);
        currentPrice = initPrice - discount;
        System.out.println("构造方法-结束, currentPrice:" + currentPrice + ", INSTANCE:" + INSTANCE + ",initPrice:" + initPrice + ",discount:" + discount);
    }

    @Override
    public String toString() {
        return "Price{" +
                "currentPrice=" + currentPrice +
                '}';
    }
}

/**
 *
 *  按代码先后, 为两个类变量(INSTANCE和initPrice)分配内存空间, 这时候值为默认值(null和0.0); (这个时候其实是系统默认执行, 我们看不到任何输出的)
 *  按代码先后, 执行静态变量定义 和 静态代码块:
 *         按代码先后为两个类变量(INSTANCE和initPrice)分设置初始化值, 即赋值为 new Price(2.8) 和 20;
 */
public class Order5_PriceTest{
    public static void main(String[] args) {
        // -2.8
        System.out.println(Price.INSTANCE.currentPrice);
        Price p = new Price(2.8);
        // 17.2
        System.out.println(p.currentPrice);
    }
}