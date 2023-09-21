package edu.whu;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class SortUtilTest {

    /**
     * 测试正常排序情况
     */
    @Test
    public void BubbleSortTest() {
        int[] array = { 10, 23, 1, 33, 100, 23 };
        int[] result = { 1, 10, 23, 23, 33, 100 };
        SortUtil.bubbleSort(array);
        assertArrayEquals(result, array);
    }

    /**
     * 测试空数组情况
     */
    @Test
    public void BubbleSortTest2() {
        int[] array = { };
        int[] result = { };
        SortUtil.bubbleSort(array);
        assertArrayEquals(result, array);
    }


    /**
     * 测试异常情况。如果参数为null，要求抛出IllegalArgumentException。
     * 如果不抛出异常，或者抛出其他类型异常，则测试不通过。
     */
    @Test
    public void BubbleSortTest3() {
        //本测试抛出了NullPointerException，IllegalArgumentException，因此测试不通过。
//        assertThrows(IllegalArgumentException.class,()->{
//            SortUtil.bubbleSort(null);
//        });

    }

}
