package edu.whu.annotation;

public class Main {
    public static void main(String[] args) {
        try {
            User user=new User("Li",23);
            Validator.checkUser(user);
            user.setAge(100);
            Validator.checkUser(user);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
