package edu.whu;


import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Properties;

public class MyClass2
{
    @InitMethod
    public int init1()
    {
        System.out.println("this is init1");
        return 1;
    }
    @InitMethod
    public int init2()
    {
        System.out.println("this is init2");
        return 2;
    }

    @InitMethod
    public int init3()
    {
        System.out.println("this is init3");
        return 3;
    }
    public static Object createObj(String propPath) throws ClassNotFoundException, InstantiationException, IllegalAccessException
    {
        Properties props = new Properties();
        String clazz = "";
        try (InputStream input = Main.class.getResourceAsStream("myapp.properties"))
        {
            if (input == null)
            {
                return null;
            }
            props.load(input);
            clazz = props.getProperty("bootstrapClass");
        } catch (IOException e)
        {
            throw new RuntimeException(e);
        }
        Class<?> myClass = Class.forName(clazz);
        Object app = myClass.newInstance();
        return app;
    }

        public static int[] checkInit(Object o)
    {
        Method[] declaredMethods = o.getClass().getDeclaredMethods();
        ArrayList<Integer> ar = new ArrayList<>();
        for (Method method : declaredMethods)
        {
            if (method.isAnnotationPresent(InitMethod.class))
            {
                try
                {
                    ar.add((Integer) method.invoke(o));
                } catch (IllegalAccessException e)
                {
                    throw new RuntimeException(e);
                } catch (InvocationTargetException e)
                {
                    throw new RuntimeException(e);
                }
            }
        }
        int[] arr = new int[ar.size()];
        for (int i = 0; i < ar.size();i++)
        {
            arr[i] = ar.get(i);
        }
        return arr;
    }
}
