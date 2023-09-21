# Junit

> Junit 是一个单元测试的包，单元测试是测试基本单元--函数、方法

对每个单元进行单元测试能确保类的功能完整正确，减少bug

### 语法

```java
public class ClassNameTest
{
    @Test
    public void testMethodName()
    {
        // pass
        Assert.assertEqual(target, fact);
        Assert.assertTrue(target, fact);
    }
}
```

**使用时需要确保有相应的jar包，可以使用maven管理**