package com.crazyjava.codes.chapter02;

/**
 * 另一种访问父类成员变量的方法, 初步引入了super这个关键字
 * 并且解释了, 其实就1个对象, super并不是指向父对象(因为就1个对象, 只不过这个变量里有3个count变量罢了)
 */
public class Order23_SuperTest {
    public static void main(String[] args) {
        Sub s = new Sub();
        System.out.println(s.count);

        Mid s2m = s;
        System.out.println(s2m.count);

        Order23_Base s2b = s;
        System.out.println(s2b.count);


        s.useSuperInMid();
        s.useSuperInSub();
        s2m.useSuperInMid();
//        s2m.useSuperInSub(); // 编译失败
    }
}

class Order23_Base{
    int count = 2;
}

class Mid extends Order23_Base{
    int count = 20;
    public void useSuperInMid(){
        System.out.println("[Mid.accessMid]super.count:"+super.count);
    }
}

class Sub extends Mid{
    int count = 200;
    {
        System.out.println("for look there are 3 count in this");
    }

    public void useSuperInSub(){
        System.out.println("[Sub.accessMid]super.count:"+super.count);
    }
}