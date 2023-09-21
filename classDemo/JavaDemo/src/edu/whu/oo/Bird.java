package edu.whu.oo;

/**
 * Bird类，继承Animal，实现Flyable接口
 */
public class Bird extends Animal implements Flyable{

    public Bird() {
        super();
        this.name="Bird";
    }

    @Override
    public void eat() {
        System.out.println(name+"正在吃虫子");
    }

    @Override
    public void fly() {
        System.out.println(name+"正在飞");
    }

}
