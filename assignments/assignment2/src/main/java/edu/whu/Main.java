package edu.whu;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

import static edu.whu.MyClass.checkInit;
import static edu.whu.MyClass.createObj;

public class Main
{
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException
    {
        Object app = createObj("/myapp.properties");
        checkInit(app);
    }


}
