package edu.whu;

public class DataTypeDemo {
    public static void main(String[] args) {
        float myFloatNum = 5.99f;
        int myInt = 5;
        boolean myBool = true;
        char myLetter = 'D';
        char myVar1 = 65;

        //每个基本类型都有对应的封装类
        Float myFloatNum2= 5.99f;
        Integer myInt2= myInt;

        //自动转型
        double myDouble = myInt;
        System.out.println(myDouble+":"+myInt);
        //强制转型
        double myDouble2 = 12.2d;
        int myInt3 = (int) myDouble2;
        System.out.println(myDouble2+"："+myInt3);

        //String类型
        String greeting = "Hello world"; //java.Lang.String不是基本类型，不能小写
        System.out.println(greeting);
        System.out.println("myInt="+ myInt); //字符串连接
    }
}
