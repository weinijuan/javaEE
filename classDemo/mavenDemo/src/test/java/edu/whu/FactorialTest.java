package edu.whu;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class FactorialTest {


    /**
     * 测试正常情况
     */
    @Test
    public void testFact() {
        assertEquals(1, Factorial.factorial(1));
        assertEquals(2, Factorial.factorial(2));
        assertEquals(6, Factorial.factorial(3));
        assertEquals(3628800, Factorial.factorial(10));
        assertEquals(2432902008176640000L, Factorial.factorial(20));
    }

    /**
     * 测试异常情况
     */
    @Test
    public void testException(){
        assertThrows(IllegalArgumentException.class,()->{
            Factorial.factorial(-1);
        });
    }





}
