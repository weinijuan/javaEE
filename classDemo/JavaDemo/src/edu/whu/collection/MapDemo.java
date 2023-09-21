package edu.whu.collection;

import java.util.*;

public class MapDemo {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<String, String>();
        map.put("1", "google");
        map.put("2", "runoob");
        map.put("3", "value3");
        //第一种：普遍使用，二次取值
        for (String key : map.keySet()) {
            System.out.println("key= "+ key + " and value= " + map.get(key));
        }
        //第二种：迭代器
        Iterator<Map.Entry<String, String>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, String> entry = it.next();
            System.out.println("key= " + entry.getKey() + " and value= " + entry.getValue());
        }
        //第三种：推荐，尤其是容量大时
        for (Map.Entry<String, String> entry : map.entrySet()) {
            System.out.println("key= " + entry.getKey() + " and value= " + entry.getValue());
        }
        //第四种：只想取value的时候使用
        for (String v : map.values()) {
            System.out.println("value= " + v);
        }
    }

}
