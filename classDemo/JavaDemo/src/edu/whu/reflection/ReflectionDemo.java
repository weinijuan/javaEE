package edu.whu.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectionDemo {

    public static void main(String[] args) {
        try {
            Class userClass = Class.forName("edu.whu.reflection.User");
            System.out.println(userClass.getName());
            Class userClass2 = User.class;
            System.out.println(userClass2.getName());
            User user = new User();
            Class userClass3 = user.getClass();
            System.out.println(userClass3.getName());


            getFields(userClass);
            setFieldValue(userClass,user);
            getMethods(userClass);

            createObjectAndInvokeMethod(userClass);

        } catch (Exception e) {
          e.printStackTrace();
        }
    }

    private static void getFields(Class userClass) throws NoSuchFieldException {
        System.out.println("userClass.getFields():");
        Field[] fields = userClass.getFields(); //only public fields
        for (Field field : fields) {
            System.out.println("  "+field);
        }

        System.out.println("userClass.getDeclaredFields():");
        Field[] fields2 = userClass.getDeclaredFields(); //public and private fields
        for (Field field : fields2) {
            System.out.println("  "+field);
        }

        Field nameField = userClass.getDeclaredField("name");
        System.out.println("  "+nameField);
    }

    private static void setFieldValue(Class userClass,User user) throws NoSuchFieldException, IllegalAccessException {

        Field nameField = userClass.getDeclaredField("name");
        System.out.println(nameField);
        nameField.setAccessible(true); //允许私有属性读写

        System.out.println(nameField.get(user));
        nameField.set(user,"zhang wuji");
        System.out.println(nameField.get(user));
    }


    private static void getMethods(Class userClass) throws NoSuchMethodException {
        System.out.println("userClass.getMethods():");
        for (Method method : userClass.getMethods()) {
            System.out.println("  "+method);
        }
        System.out.println("userClass.getDeclaredMethods():");
        for (Method method : userClass.getDeclaredMethods()) {
            System.out.println("  "+method);
        }
        System.out.println("getMethod by name and types:");
        Method method = userClass.getMethod("setName", String.class);
        System.out.println("  "+method);
    }


    private static void createObjectAndInvokeMethod(Class userClass) throws NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException, NoSuchFieldException {
        User user1 = (User)userClass.newInstance();    //使用无参构造函数创建对象

        Constructor constructor = userClass.getConstructor(int.class, String.class);
        Object user2= constructor.newInstance(1, "Li");//使用有参数构造函数创建对象

        Field filed = userClass.getDeclaredField("name");
        filed.setAccessible(true);
        System.out.println(filed.get(user2));

        Method method = userClass.getMethod("setName", String.class);
        method.invoke(user2, "zhang"); //invoke a method
        System.out.println(filed.get(user2));

    }




}
