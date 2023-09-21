package edu.whu;

public class SortUtil {

    /**
     * 冒泡排序
     * @param list 被排序的数组
     */

    public static void bubbleSort(int[] list){

        for (int i = 0; i < list.length - 1; i++) {
            boolean flag = true;
            for (int j = 0; j < list.length - i - 1; j++)
            {
                if (list[j] > list[j + 1])
                {
                    int temp = list[j];
                    list[j] = list[j + 1];
                    list[j + 1] = temp;
                    flag = false;
                }
            }
            if (flag) {break;}
        }
    }
}
