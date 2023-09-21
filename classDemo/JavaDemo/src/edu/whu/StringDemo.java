package edu.whu;

public class StringDemo {
    public static void main(String[] args) {
        String str1 = "hello world";
        String str2 = "hello world";
        Object str3= str1;
        String str4 = "Hello world";

        //字符串比较
        System.out.println( str1 == str2);//referential equality instead of comparing content
        System.out.println( str1 == str3);//true
        System.out.println( str1.equals(str2)); //true
        System.out.println( str1.compareTo(str2)); //0
        System.out.println( str1.compareTo(str4));//32
        //字符串匹配
        System.out.println(str1.indexOf("world")); //6
        System.out.println(str1.indexOf("haha")); //-1
        System.out.println(str1.startsWith("hello")); //true
        System.out.println(str1.endsWith("hello")); //false
        System.out.println(str1.contains(" ")); //true
        //子串
        int i=str1.indexOf(" ");
        String str5= str1.substring(0,i)+str1.substring(i+1);
        System.out.println(str5);

        //字符串替换
        String str6= str1.replace("o","x");//基于子字符串的字符串替换
        System.out.println(str6);
        String str7= str1.replaceFirst("\\W","-");//基于正则表达式，把第一个空白字符替换为-
        System.out.println(str7);
        String str8= str1.replaceAll("\\W","-"); //基于正则表达式，把所有空白字符替换为-
        System.out.println(str8);

        //大量的字符串连接，使用StringBuilder来提高效率,https://www.runoob.com/java/java-stringbuffer.html
        StringBuilder stringBuilder=new StringBuilder();
        stringBuilder.append("[");
        for(char c='A';c<='Z';c++){
            stringBuilder.append(c);
        }
        stringBuilder.append("]");
        System.out.println(stringBuilder.toString());


    }
}
