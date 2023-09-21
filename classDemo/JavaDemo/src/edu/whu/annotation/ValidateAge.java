package edu.whu.annotation;

import java.lang.annotation.*;

/**
 * 年龄校验的注解
 *
 * Documented 注解表明这个注解应该被 javadoc工具记录. 默认情况下,javadoc是不包括注解的.
 * Retention(保留)注解说明,这种类型的注解会被保留到那个阶段. 有三个值:
 *   1.RetentionPolicy.SOURCE —— 在源代码级别保留,编译时就会被忽略
 *   2.RetentionPolicy.CLASS ——  编译时被保留,在class文件中存在,但JVM将会忽略
 *   3.RetentionPolicy.RUNTIME —— 将被JVM加载到内容,可以使用反射机制读取和使用.
 * Target 指定被标注的元素类型。如果没有明确指明，可以在任意的位置使用
 * Inherited 如果用Inherited的注解来标注另一个父类, ,则父类的所有注解属性将被继承到它的子类中
 * @author jia
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD,ElementType.METHOD})
@Inherited
public @interface ValidateAge {
    /**
     * 最小值
     */
    int min() default 18;
    /**
     * 最大值
     */
    int max() default 99;
}
