package edu.whu.io;

import java.io.*;

/**
 * 使用OutputStream和InputStream进行文件读写
 */
public class FileStreamTest {

    public static void main(String[] args) {
        //写入文件
        try(OutputStream os = new FileOutputStream("test.txt")) {
            byte[] bWrite = {96, 97, 93, 90, 95};
            for (int x = 0; x < bWrite.length; x++) {
                os.write(bWrite[x]);
            }
            os.flush(); //文件是异步写入的。flush将buffer中的数据全部写入文件中。
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        //读取文件
        try ( InputStream is = new FileInputStream("test.txt")){
            int size = is.available();
            for (int i = 0; i < size; i++) {
                System.out.print((char) is.read() + "  ");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
