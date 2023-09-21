# JDBC 
[toc]
### 概述
> jdbc 是java提供的一套接口，应用程序员根据该接口完成对数据库的操作而不用关心底层原理的
> 实现，数据库厂家的程序员根据该接口进行具体的实现。   
> 作为jdbc的使用者，我们只需要会用jdbc提供的各种方法即可
### 环境配置
编程工具:记事本  
>* 数据库驱动:到maven中央仓库中寻找相关的jar包，拷贝到自己的目录下
>* 配置环境变量:在系统环境变量中加入classPath = .;pathOfJar;(其中.表示先在当前目录下搜索)  

驱动是什么？
>对接口的实现成为驱动，一般是许多个class文件然后打包成jar包  
### JDBC编程六步  
> 1.注册驱动    
> 2.获取连接  
> 3.创造数据库操作对象  
> 4.执行sql语句  
> 5.处理查询结果集  
> 6.关闭资源  

具体代码实现

```java
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

class JdbcTest {
    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;
        try {
            // 1.注册驱动 ，注意，后面的类名可以通过对jar包解压缩然后找到,cj可以去掉
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            // 2.获取连接对象  ,url 中的whu 是数据库名,password自己写
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/whu","root","password");
            // 3.获取数据库操作对象
            statement = connection.createStatement();
            // 4.先写sql语句再执行sql语句  
            String sql = "insert into t_class(className,classN) values(1,'高三一班')";// sql中字符串可以用单引号和双引号,jdbc中sql语句不用分号结尾
            int rowChanged = statement.executeUpdate(sql);// DML语言用executeUpdate能返回改变的行数
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 6.关闭资源
            // 从小到大，先是statement 再是 connection
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) // 可以用Exception 替换，后者是父类
                {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) // 可以用Exception 替换，后者是父类
                {
                    e.printStackTrace();
                }
            }
        }
    }
}
```
### 更通用的JDBC编程模板  
>1.新建一个文件，以properties为后缀名，比如jdbcPro.properties里面的 格式如下,注意键值对的思想即可

```properties
className = com.mysql.cj.jdbc.Driver
url = jdbc:mysql://localhost:3306/whu
user = root
password = 123456789
```
>2.通过资源绑定器加载该文件的信息

```java
import java.util.ResourceBundle;

public class JdbcTest {
    public static void main(String[] args) {
        ResourceBundle bundle = ResourceBundle.getBundle("jdbcPro");//参数是properties文件的名字，不带后缀  
        String className = bundle.getString("className"); // 参数为key,注意是字符串类型,不能直接写className,className ！= ”className“，前者是变量  
        String url = bundle.getString("url");
        String password = bundle.getString("password");
        
    }
}
```
> 3.利用反射机制执行类加载静态代码块实现驱动注册  
```java
import java.util.ResourceBundle;

public class JdbcTest {
    public static void main(String[] args) {
        ResourceBundle bundle = ResourceBundle.getBundle("jdbcPro");//参数是properties文件的名字，不带后缀  
        String className = bundle.getString("className"); // 参数为key,注意是字符串类型,不能直接写className,className ！= ”className“，前者是变量  
        String url = bundle.getString("url");
        String password = bundle.getString("password");
        try {
            Class.forName(className);
        }catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        }
    }
}
```
>4 处理查询结果集

```java
import java.sql.*;

class JdbcTest {
    public static void main(String[] args) {
        ResourceBundle bundle = ResourceBundle.getBundle("jdbcPro");//参数是properties文件的名字，不带后缀  
        String className = bundle.getString("className"); // 参数为key,注意是字符串类型,不能直接写className,className ！= ”className“，前者是变量  
        String url = bundle.getString("url");
        String password = bundle.getString("password");
        Connection connection = null;
        Statement statement = null;
        try {
            // 1.注册驱动
            Class.forName(className);
            // 2.获取连接对象  ,url 中的whu 是数据库名,password自己写
            connection = DriverManager.getConnection(url, user, password);
            // 3.获取数据库操作对象
            statement = connection.createStatement();
            // 4.先写sql语句再执行sql语句  
            String sql = "select classNo, className from t_class";// sql中字符串可以用单引号和双引号
            // 5.获取查询结果集并读取数据
            ResultSet rs =  statement.executeQuery(sql);// 使用executeQuery能得到查询结果集  
            while (rs.next()) // 当下一行有数据时
            {
                String className2 = rs.getString("className"); // 列名也可以改用select 时的下标，注意下标从1开始（同sql语法）
                int classNo = rs.getInt("classNo"); // 这里也可以用getString ,但用getInt 更准确
                System.out.println(className2 + " " + classNo);
            }
        } catch (Exception e) {
            // 使用Exception 能捕获所有异常
            e.printStackTrace();
        } finally {
            // 6.关闭资源
            // 从小到大，先是statement 再是 connection
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) // 可以用Exception 替换，后者是父类
                {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) // 可以用Exception 替换，后者是父类
                {
                    e.printStackTrace();
                }
            }
        }
    }
}
```
### 使用IDEA工具配置jdbc
>首选:创建maven项目:只需要在pom.xml中添加驱动的依赖,点一下maven的图标就会自动下载依赖到中央仓库   
> 创建普通项目：在模块中选择open module setting 然后点击+号，把jar包添加进去就可以了

### 案例：登录验证
```java
package org.example;
import java.sql.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Login {
    public static void main(String[] args) {
         Map<String,String> map = initUI();
         login(map);
    }

    /**
     *
     * @param map 用户名和密码
     * @return 返回是否成功登录
     */
    private static boolean login(Map<String, String> map) {
        boolean isLogin = false;
        String name = map.get("name");
        String password = map.get("password");
        Connection connection = null;
        // 使用PrepareStatement 预编译的Statement对象能防止sql注入
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/user","root","hwj11133334");
            // 使用preparedStatement需要先准备sql语句，并且使用？作为占位符
            String sql = "select * from login where name = ? and password = ?";
            // 将sql 作为参数,用来prepareStatement
            ps = connection.prepareStatement(sql);
            // set方法用来传参，第一个参数是第几个占位符，从1开始,第二个是value
            ps.setString(1,name);
            ps.setInt(2,Integer.parseInt(password));
            // 此处不可将sql传入！
            rs = ps.executeQuery();
            if (rs.next())
            {
                isLogin = true;
                System.out.println("login successfully");
            }
            else
            {
                System.out.println("login error");
            }
        }catch (Exception e)
        {
            e.printStackTrace();
        }finally {
            if (rs != null)
            {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (ps != null)
            {
                try {
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null)
            {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        return isLogin;
    }

    /**
     * 获取用户名和密码
     */
    private static Map<String,String> initUI() {
        System.out.println("请输入用户名：");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        System.out.println("请输入密码：");
        String pwd = scanner.nextLine();
        Map<String,String> map = new HashMap<>();
        map.put("name",name);
        map.put("password",pwd);
        return map;
    }
}

```
### PreparedStatement 对象
与Statement的对比
> PrepareStatement 执行效率高，能防止SQL注入，能进行类型检查  
> Statement 能进行Sql注入  
##### 使用PreparedStatement对象
```java
//1.写sql语句
String sql = "delete from t_student where id = ?";
// 2.prepare statement
PreparedStatement ps = connection.prepareStatement(sql);
// 3.传值
ps.setInt(1,1); // 给第一个参数传1 
// 4.执行        
ps.executeUpdate();
```
### 事务  
>三行代码  
> 1.connection.setAutoCommit(false);// 关闭自动提交  
> 2.connection.Commit();//在sql事务执行以后提交
> 3.connection.rollback(); // 遇到异常则rollback


案例   
```java
package org.example;

import com.mysql.jdbc.Driver;

import java.sql.*;

public class JdbcTest01 {
    public static void main(String[] args) {
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            // 1.注册驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
            // 2.连接数据库
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/whu","root","hwj11133334");
            connection.setAutoCommit(false);
            // 3.创造数据库操作对象
//            String sql = "insert into t_student(id,name,stuNo) values(?,?,?)";
//            ps = connection.prepareStatement(sql);
//            ps.setInt(1,4);
//            ps.setString(2,"hwj");
//            ps.setInt(3,1005);
            String sql = "delete from t_student where id = ?";
            ps = connection.prepareStatement(sql);
            ps.setInt(1,3);
            // 4.执行sql 语句
            int count = ps.executeUpdate();
//            Connection a = null;
//            a.toString();
            String newsql = "update t_student set name = ? where id = ?";
            ps = connection.prepareStatement(newsql);
            ps.setString(1,"hwj");
            ps.setInt(2,4);
            // 4.执行sql 语句
            count += ps.executeUpdate();
            System.out.println(count == 2? "成功":"失败");
            connection.commit();

        }catch (Exception e)
        {
            if (connection != null)
            {
                try {
                    connection.rollback();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
            e.printStackTrace();
        }finally {
            // 6.释放资源
            if (rs != null)
            {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (ps != null)
            {
                try {
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null)
            {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}

```
