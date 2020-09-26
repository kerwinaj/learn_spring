package com.crazyjava.codes.chapter02;

class Cat{
    {
        System.out.println("执行非静态初始化块0");
    }
    String name;
    int age;

    {
        System.out.println("执行非静态初始化块1, name:" + name + ", age:" + age);
    }
    public Cat(String name, int age) {
        System.out.println("执行构造器开始, name:" + name + ", age:" + age + ",weight:" + weight);
        this.name= name;
        this.age=age;
        System.out.println("执行构造器结束, name:" + name + ", age:" + age + ",weight:" + weight);
    }

    {
        System.out.println("执行非静态初始化块2, name:" + name + ", age:" + age);
    }
    double weight = 2.3;
    {
        System.out.println("执行非静态初始化块3-开始, name:" + name + ", age:" + age + ", weight:" + weight);
        weight = 2.5;
        System.out.println("执行非静态初始化块3-结束, name:" + name + ", age:" + age + ", weight:" + weight);
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", weight=" + weight +
                '}';
    }
}

public class Order22_InitTest {
    /**
     * 实例变量初始化的3个时机(按顺序的):
     * a. 定义时指定初始值;
     * b. 非静态代码块中指定初始值;
     * c. 构造器中指定初始值;
     * @param args
     */
    public static void main(String[] args) {
        Cat cat = new Cat("kitty",  2);
        System.out.println(cat);
        Cat cat2 = new Cat("JerField",  3);
        System.out.println(cat2);
    }
}