package edu.whu.collection;

import java.util.*;

public class ListDemo {
    public static void main(String[] args) {
        ArrayList<String> list=new ArrayList<>();
        list.add("Hello"); //在尾部添加
        list.add("World");
        list.add(0,"HAHAHAHA"); //在头部插入
        System.out.println(list.size());
        System.out.println(list.get(0));
        //判断是否包含某个元素,将逐个元素调用Equals方法对比
        System.out.println(list.contains("World"));

        //第一种遍历方法使用 For-Each 遍历 List
        for (String str : list) {
            System.out.println(str);
        }

        //第二种遍历 使用迭代器进行相关遍历，和第一种等价
        Iterator<String> ite=list.iterator();
        while(ite.hasNext()) { //判断下一个元素之后有值
            System.out.println(ite.next());
        }

        //第三种遍历 按下标循环List
        for(int i=0;i<list.size();i++){
            System.out.println(list.get(i));
        }

        //关于Stream和Lambda，参见 https://www.runoob.com/java/java8-new-features.html
        //第四种遍历 使用stream和lambda表达式进行遍历
        list.stream().forEach(item-> System.out.println(item));

        //排序，使用lambda作为比较器
        Collections.sort(list,(i1,i2)-> i2.compareTo(i1));
        list.stream().forEach(item-> System.out.println(item));

    }

}
