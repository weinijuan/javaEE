package edu.whu;

import java.util.Arrays;
import java.util.Iterator;

public class ArrayDemo {
    public static void main(String[] args) {
        String[] bikes;
        String[] cars = {"Volvo", "BMW", "Ford", "Mazda"};
        int[] myNum = {10, 20, 30, 40};
        System.out.println(cars.length);

        //for-each循环
        for (String car : cars) {
            System.out.println(car);
        }
        //for-each循环和下面的迭代器循环是等价的
        Iterator<String> itr = Arrays.stream(cars).iterator();
        while(itr.hasNext()){
            System.out.println(itr.next());
        }

        //二维数组，实际上是数组的数组
        int[][] myNumbers = { {1, 2, 3, 4}, {5, 6,7} };
        System.out.println("myNumbers.length："+myNumbers.length);
        for (int[] lines:myNumbers) {
            for (int num:lines) {
                System.out.println(num);
            }
        }


    }
}
