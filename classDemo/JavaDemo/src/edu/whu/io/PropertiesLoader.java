package edu.whu.io;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesLoader {

    public static void main(String[] args) {
        Properties props = new Properties();
        try (InputStream input =
                     PropertiesLoader.class.getResourceAsStream("/default.properties")) {
            if (input == null) {return;}
            props.load(input);
            System.out.println(props.getProperty("name"));
            System.out.println(props.getProperty("text"));
        } catch (IOException e) {
            System.out.println("Load properties error!");
        }

    }
}
