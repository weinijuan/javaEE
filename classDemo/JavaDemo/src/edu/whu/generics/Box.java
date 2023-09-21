package edu.whu.generics;

import java.util.ArrayList;
import java.util.List;

public class Box<T> {
    private T t;
    public void add(T t) {
        this.t = t;
    }
    public T get() {
        return t;
    }

    public static void main(String[] args) {
        Box<Integer> integerBox = new Box<Integer>();
        integerBox.add(10);
        System.out.printf("整型值为 :%d\n\n", integerBox.get());
        //integerBox.add("Hello");

        Box<String> stringBox = new Box<>();
        stringBox.add("菜鸟教程");
        System.out.printf("字符串为 :%s\n", stringBox.get());
    }
}
