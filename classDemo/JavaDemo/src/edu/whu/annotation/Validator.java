package edu.whu.annotation;

import java.lang.reflect.Field;

/**
 * 利用反射读取注解信息，对对象进行验证
 * @author jiaxy
 */
public class Validator {
    static boolean checkUser(User user) throws IllegalArgumentException, IllegalAccessException {
        Field[] fields = User.class.getDeclaredFields();
        boolean result = true;
        for (Field field : fields) {
            if (field.isAnnotationPresent(ValidateAge.class)) {
                ValidateAge validateAge = field.getAnnotation(ValidateAge.class);
                field.setAccessible(true);
                int age = (int) field.get(user);
                if (age < validateAge.min() || age > validateAge.max()) {
                    throw  new IllegalArgumentException("年龄值不符合条件");
                }
            }
        }
        return result;
    }
}
