# Servlet常见API

#### ServletContext

```java
// 获取ServletContext初始参数， 通过在web.xml的<context-param设置>
public String getInitParameter(String name);
// 获取所有初始参数名称列表
public Enumeration<String> getInitParameterNames();
// 获取项目的根目录
public String getContextPath();
// 获取项目中某个文件的绝对路径, 传入的path是相对于根的路径, 返回计算机上的物理地址
public String getRealPath(String path);
// 记录日志信息
public void log(String msg);
// 记录严重日志错误
public void log(String msg, Throweable e);

// 应用域就是context， 是所有Servlet共享的区域
// 存储项目数据到应用域中
public void setAttribute(String name, Object o);
// 取出项目数据
public void getAttribute(String name);
// 移除项目数据从应用域中
public void removeAttribute(String name);
```

