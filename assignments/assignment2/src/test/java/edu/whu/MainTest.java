package edu.whu;

import java.lang.annotation.Target;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MainTest
{


    @Test
    public void createObjTest() throws ClassNotFoundException, InstantiationException, IllegalAccessException
    {
        assertThrows(ClassNotFoundException.class,()->{
             MyClass.createObj("/no.properties");
        });
        assertNotNull(MyClass.createObj("/myapp.properties"));
    }

    @Test
    public void checkInitTest()
    {
        MyClass myClass1 = new MyClass();
        MyClass2 myClass2 = new MyClass2();
        int[] executeMethod1 = {1};
        int[] executeMethod2 = {1,2,3};
        assertArrayEquals(executeMethod1,myClass1.checkInit(myClass1));
        assertArrayEquals(executeMethod2,myClass2.checkInit(myClass2));

    }

}
