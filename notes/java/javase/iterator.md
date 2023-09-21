# 迭代器

> 迭代器能够实现增强的for 循环

```java
List<Integer> list = new List<>();
list.add(5);
list.add(6);
for (int x:list)
{
    System.out.println(x);
}
```

上述代码等同于下面这一段

```java
List<Integer> list = new List<>();
list.add(5);
list.add(6);
Iterator iterator = list.iterator();
while (iterator.hasNext())
{
     System.out.println(iterator.next());
}
```

要实现增强的for循环需要以下几步：

1. 实现iterator方法
2. 写个类继承Iterator ,并实现hasNext() 和next() 方法
3. 本类实现Iterable接口 ，说明有iterator方法

```java
public class ArrayList<T> implements Iterable
{
    int size;
    T[] items;
    private static class ArrayListIterator implements Iterator
    {
        int pauseIndex;
        // default construct is enough
        public boolean hasNext()
        {
            return pauseIndex < size;
        }
        public T next()
        {
            return items[pauseIndex];
        }
    }
    
    public static Iterator iterator()
    {
        return new ArrayListIterator();
    }
}
```

