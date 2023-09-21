package edu.whu.io;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileReaderAndWritter {

    public static void main(String[] args) {

        File file = new File("Hello1.txt");

        try(FileWriter writer = new FileWriter(file)){
            writer.write("This\n is\n an\n example\n");
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try(FileReader fr = new FileReader(file)){
            char[] a = new char[50];
            fr.read(a);
            for (char c : a){
                System.out.print(c);
            }
        }catch (IOException e) {
            e.printStackTrace();
        }

    }
}
