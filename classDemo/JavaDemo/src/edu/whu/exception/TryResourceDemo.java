package edu.whu.exception;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TryResourceDemo {

    public static void main(String[] args) {
        String line;
        //在try(resource)中resource，无论是否发生异常，结束后都会自动释放
        try (BufferedReader br = new BufferedReader(new FileReader("test.txt"))) {
            while ((line = br.readLine()) != null) {
                System.out.println("Line =>" + line);
            }
        } catch (IOException e) {
            System.out.println("IOException in try block =>" + e.getMessage());
        }

        //如果不使用try(resource)，需要这么写代码，在finally中释放资源
        BufferedReader br = null;
        String line2;
        try {
            br = new BufferedReader(new FileReader("test.txt"));
            while ((line2 = br.readLine()) != null) {
                System.out.println("Line =>" + line2);
            }
        } catch (IOException e) {
            System.out.println("IOException in try block =>" + e.getMessage());
        } finally {
            try {
                if (br != null) {
                    br.close();
                }
            } catch (IOException e) {
                System.out.println("IOException in finally block =>" + e.getMessage());
            }
        }
    }

}
