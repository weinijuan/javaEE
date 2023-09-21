package edu.whu.oo;

public class Mouse extends Animal{

    public Mouse() {
        super();
        name="Mouse";
    }

    @Override
    public void eat() {
        System.out.println(name+"正在吃米");
    }
}
