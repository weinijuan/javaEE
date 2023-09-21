package edu.whu.annotation;

public class User {
    private String name;

    /**
     * age上添加ValidateAge注解，用于字段合法性验证
     */
    @ValidateAge(min = 20, max = 35)
    private int age;


    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
