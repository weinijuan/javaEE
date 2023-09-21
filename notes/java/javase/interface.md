# interface

> 接口：高度抽象，外部接口

1. 高度抽象： 不可以创建new对象，因此没有构造方法，所有默认方法都是abstract的，
2. 也就是没有方法体{}
3. 外部接口：接口是外部调用与内部实现之间的一层，对外调用方便，对内隐藏复杂，因此其方法都是 public 的

注意事项：

1. 接口与接口，接口与类之间都支持多继承，前者用extends关键字，后着是implements
2. 实现类必须全部实现接口的方法，除非是抽象类
3. 接口中方法默认省去 public abstract，属性省去 public static final 公用常量
4. 特殊的接口方法：加上default 关键字以后接口就可以有自己的实现 {}，子类会继承接口的实现，也可以重写 
5. 接口的方法重写应加上@Overide 便于阅读防止打错
6. 普通接口的称之为接口继承，default方法的继承称之为实现继承，前一种简单优美更好
7. 实现接口的方法访问运算符级别只能更高不能更低



下面的例子说明了继承了 “可比较” 接口的类就能进行比较了，并且使用自实现的方法

```java
/**T is generize type */
public interface Comparable<T>
{
    /**return 1 while bigger ,0 while equal ,-1 while lesser*/
	int compareTo(T o);
}
/**must use generize class to implements a generize class */
public class Dog implements Comparable<Dog>
{
    private int size;
    int compareTo(Dog o)
    {
        if (this.size > o.size)
        {
            return 1;
        } 
        else if (this.size == o.size)
        {
            return 0;
        } 
        else
        {
            return -1;
        }
    }
}
// Every class implements interface will can compare , function equal to "> " "< " "=""
```



