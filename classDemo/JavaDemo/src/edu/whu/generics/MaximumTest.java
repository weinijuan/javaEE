package edu.whu.generics;

public class MaximumTest {

    /**
     * 比较三个值并返回最大值. 类型参数必需实现Comparable接口
     */
    public static <T extends Comparable<T>> T maximum(T x, T y, T z) {
        T max = x;
        if (y.compareTo(max) > 0) {
            max = y;
        }
        if (z.compareTo(max) > 0) {
            max = z;
        }
        return max;
    }

    public static void main(String args[]) {
        System.out.println("最大整数为:"
                + maximum(3, 4, 5));

        System.out.println("最大浮点数为:"
                +maximum(6.6, 8.8, 7.7));

        System.out.println("最大字符串为:"
                + maximum("pear", "apple", "orange"));
    }
}
