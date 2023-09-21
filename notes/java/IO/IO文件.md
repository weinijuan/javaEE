
#### 读取
使用Scanner类
```java
Scanner scanner = new Scanner(输入流);
```


从文件中读取
```java
Scanner scanner = new Scanner(new FileInputStream(文件路径))；
while (scanner.hasnextLine())
{
	scanner.nextLine();
}
```


使用字节缓冲读取
```java
byte[] buffer = new byte[1024];
int readlen = 0;
while((readlen = inputstream.read(buf)) != -1)
{
	System.out.println(new String(buf, 0, readlen));
}
```

#### 输出
```java
PrintStream out = new PrintStream(输入流)；
```

输出到文件
```java
PrintStream fout = new PrintStream(newe FileOutputStream(文件路径))；
fout.println("要输出的内容")；
```

写入到输出流
```java
outputStream.write("some thing");
```