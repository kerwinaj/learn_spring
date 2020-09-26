package com.crazyjava.codes.chapter02;

class Base {
    {
        System.out.println("[Base.{}]");
    }
    private int i=2;
    {
        System.out.println("[Base.{}]i:"+i);
    }
    public Base() {
        System.out.println("[Base.init]i:"+i + "," + this.getClass());
        this.display();
    }

    public void display(){
        System.out.println("[Base.display]i:"+i);
    }
}
class Derived extends Base{

    {
        System.out.println("[Derived.{}]");
    }

    private int i=22;

    {
        System.out.println("[Derived.{}]i:"+i);
    }
    public Derived() {
        System.out.println("[Derived.init]1, i:"+i);
        i=222;
        System.out.println("[Derived.init]2, i:"+i);
    }

    @Override
    public void display(){
        System.out.println("[Derived.display]i:"+i);
    }
}
public class Test{
    public static void main(String[] args) {
        new Derived();
    }
}