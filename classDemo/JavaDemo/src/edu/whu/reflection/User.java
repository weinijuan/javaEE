package edu.whu.reflection;

public class User {
    public int id;
    private String name;

    public User(){
        id = 0;
    }

    public User(int id, String name){
        this.id = id;
        this.name =name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private void test(){
    }
}
