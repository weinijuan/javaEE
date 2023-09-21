package edu.whu.oo;

/**
 * Animal基类
 */
public abstract class Animal {
     String name;

    public Animal() {
        name = "Animal";
    }
    public abstract void eat();

    public void sleep(){
        System.out.println(name+"正在睡");
    }

}
