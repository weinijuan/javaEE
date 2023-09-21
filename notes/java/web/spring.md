# Spring  
##### 简介：
是一个javaee开发简化的框架，可以理解为更好用的javaee  
##### 如何学习框架
>1.学习框架能干什么  
> 2.学习框架的语法  
> 3.查看框架的内部实现  
> 4.自己制作一个框架

##### 特性  
1.IOC(inversion of control 控制反转)  

### IOC 
##### 简介:
> 控制指的是创建对象，对象属性赋值，对象之间的关系等一系列对对象的操作  
> 反转指的是将原本由程序员负责的控制流程交给容器来实现  
> 容器可以是一个服务器软件，也可以是一个框架  
> 最终目的是减少对源代码的改变，解耦合

**例子:servlet对象的创建就是由tomcat容器完成的**
##### 依赖注入(DI)
只需要在相应的配置文件中提供对象名称和对象的类名，便可由容器创造出相应的对象了  
```xml
<bean id = "objectName" class = "ClassName"></bean>
<!--一个bean对应一个对象,id制定了对象名,class指定了对象的类型（类名,不可以是接口名，底层是反射机制）-->
```
### IDEA中使用spring 框架  
1.新建一个空项目  
2.新建一个maven模块,可以选中从模板/骨架 (arch***) quickstart  
3.在main和test下面新建maven资源文件目录  
4.在main的源代码中写相应的类  (实现类的源代码文件)
5.在配置文件中加入一个xml文件（选中spring的xml文件）,加入bean,即可  
6.在测试类的源代码文件中
```java
package com.bjpowernode;
import com.bjpowernode.service.myservice;
import com.bjpowernode.service.myserviceImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class myTest {
    @Test
    public void test01()
    {
        // 只是控制不反转的使用  
        myservice ms = new myserviceImpl();
        ms.doSome();
    }
    @Test
    public void test02()
    {
        // 使用spring框架
        String config = "beans.xml"; //这里改为相应的xml文件名
        //ApplicationContext就是源代码中的spring的容器,本质是一个接口 
        //ClassPathXmlApplicationContext是上述的实现类，构造函数的参数是配置文件名
        ApplicationContext ac = (ApplicationContext) new ClassPathXmlApplicationContext(config);
        // 通过容器的getBean获取对象,参数为对象的id
        myservice ms = (myservice) ac.getBean("newService");
        // 现在可以使用对象的各种方法了
        ms.doSome();
    }
}


```
### ApplicationContext的相应方法  
getBeanDefinitionCount:获取容器中对象的数目  
getBeanDefinitionNames:获取容器中对象的名字，返回数组
```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd">
<bean id="newService" class="com.bjpowernode.service.myserviceImpl"></bean>
<bean id="newService2" class="com.bjpowernode.service.myserviceImpl"></bean>
</beans>
```
```java
package com.bjpowernode;
import com.bjpowernode.service.myservice;
import com.bjpowernode.service.myserviceImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class myTest {
    @Test
    public void test03()
    {
        String config = "beans.xml";
        ApplicationContext ac = (ApplicationContext) new ClassPathXmlApplicationContext(config);
        int num = ac.getBeanDefinitionCount();
        String[] strings = ac.getBeanDefinitionNames();
        System.out.println(num);
        for (String str:strings)
        {
            System.out.println(str);
        }
    }
}

```