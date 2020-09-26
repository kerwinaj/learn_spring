package com.crazyjava.codes.chapter02;

class Person{
    String name;
    int age;
    static int eyeNum;
    public void info(){
        System.out.println("我的名字是:"+name+",我的年龄是:" + age);
    }
}

public class Order1_FieldTest{
    /**
     *
     // Person的实例对象里面只有 name 和 age 两个内存空间.
     // eyeNum的内存空间, 是和Person类所在的空间在一起的, 而且不管后面创建多少个Person的实例, 都不需要再分配内存了.
     * @param args
     */
    public static void main(String[] args) {

        Person.eyeNum=2;
        System.out.println("通过Person类访问 eyeNum 类变量:" + Person.eyeNum);

        Person p = new Person();
        p.name="猪八戒";
        p.age=300;
        System.out.println("通过p变量访问 eyeNum 类变量:" + p.eyeNum);
        p.info();

        Person p2 = new Person();
        p2.name="孙悟空";
        p2.age=500;
        System.out.println("通过p2变量访问 eyeNum 类变量:" + p2.eyeNum);
        p2.info();


    }
}