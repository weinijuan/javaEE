/**
 * 类所在的包，包的层次与classpath下的文件夹层次保持一致
 */
package edu.whu;

/**
 * HelloWorld类。
 * 每个Java文件中，只有一个public类，这个类名和Java文件名相同。
 */
public class HelloWorld {

    /**
     * 每个类都可以有且最多有一个静态main方法。有main方法的类可以直接运行。
     * @param args
     */
    public static void main(String[] args) {
        //System是一个类，out是System类中PrintStream类型的字段，println是一个方法
        System.out.println("Hello world!");
    }
}