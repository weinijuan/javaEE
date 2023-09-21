package edu.whu.io;

import java.io.File;

/**
 *
 */
public class FileDemo {

    public static void main(String[] args) {
        String dirname = ".";
        File f1 = new File(dirname);
        if(!f1.exists()) {return;}
        listFiles(f1);
    }

    public static void listFiles(File file) {
        if (!file.isDirectory()) {
            System.out.println(file.getPath() + " is a file");
            return;
        }
        System.out.println(file.getPath() + " is a directory");
        for (File sub : file.listFiles()) {
            listFiles(sub);
        }
    }

}
