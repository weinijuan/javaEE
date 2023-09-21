package edu.whu.exception;

public class TryCatchDemo {
    public static void main(String[] args) {
        int a[] = new int[2];
        try { //保护区，所有本区域的语句发生异常都会在catch部分寻找处理语句
            System.out.println("Access element three :" + a[3]);
        } catch (ArrayIndexOutOfBoundsException e) { //只是演示，正式代码中不要捕获数组越界异常
            System.out.println("Exception thrown  :" + e);
        } finally { //清理区，无论是否发送异常，该部分代码都会执行
            a[0] = 6;
            System.out.println("First element value: " + a[0]);
            System.out.println("The finally statement is executed");
        }
    }
}
