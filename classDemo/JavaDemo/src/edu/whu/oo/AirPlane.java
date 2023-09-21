package edu.whu.oo;

/**
 * 飞机类
 */
public class AirPlane implements Flyable{
    @Override
    public void fly() {
        System.out.println("AirPlane正在飞");
    }
}
