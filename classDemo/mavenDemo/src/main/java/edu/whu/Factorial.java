package edu.whu;

public class Factorial {

    /**
     * 求阶乘
     * @param num 输入数字
     * @return 计算结果
     */
    public static long factorial(long num) {
        if(num<0){
            throw new IllegalArgumentException("参数不能为负数!");
        }
        long result = 1;
        for (long i = 1; i <= num; i++) {
            result = result * i;
        }
        return result;
    }

}
