# Object

> object 是所有类的基类，8种基本类型不属于类的范畴

#### toString 方法

将列表用其元素表示

```java
public class MyList
{
    public String toString()
    {
        List<String> ld = new ArrayList<>();
        for (T item : this)
        {
            ld.add(item.toString());
        }
        return "{" + String.join(", ",ld) + "}";
    }
} 
```

方法二

```java
public String toString()
{
    List<String> ld = new ArrayList<>();
    StringBuilder sb = new StringBuilder();
    sb.append("{")
        for (int i = 0; i < size - 1 ; i++)
        {
            sb.append(get(i)); // 增加第i 个元素
            sb.append(", ");
        }
    sb.append(get(size)); // 增加最后一个元素
    sb.append("}");
    return sb.toString();
}
```

**不能用字符串的 + 运算，因为每次都会新建一个字符串，太浪费时间**

#### equals方法

> 任何Object 对象之间，任何泛型之间的相等都只能用equals 方法， 不能用 == 号

> 自己写的类需要自己重写equals方法 @Override

