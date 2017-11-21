什么是java的反射
====

### 反射在维基百科中的描述
> 在计算机学科中，反射是指计算机程序在运行时可以访问、检测和修改他本身状态或行为的一种能力。用比喻来说，就是程序在运行的时候能够“观察”并修改自己的行为。

### java中的反射

反射机制是java语言的特性之一，它允许运行中的java程序获取自身信息，并且可
以操作类或者对象内部的属性。

简而言之，通过反射，我们可以在运行时获得程序或者程序集中每一个类型的成员和成员信息。程序中一般的对象的类型都是在编译器就确定下来的，而java反射机制可以动态的创建对象并调用其属性，这样的对象的类型在编译期是未知的。所有我们可以通过反射机制直接创建对象，即使这个对象的类型在编译器是未知的。
反射的核心是jvm在运行时动态加载类或调用方法或访问属性。

### java的反射框架主要提供以下功能：
    - 在运行时判断任意一个对象所属的类；
    - 在运行时构造一类个任意的对象；
    - 在运行时判断任意一个类所具有的成员变量和方法；
    - 在运行时调用任意一个对象的方法。

### 反射的用途
    - 反射最常见的就是开发各种通用框架
        1. 比如spring的ioc核心实现就是通过反射创建对象；
        2. 比如一些处理json的类库，通过获取类的属性，生成json串。

### 反射的基本运用

1. 获取Class对象
    - 使用Class类的 ** forName() ** 静态方法加载一个类

        ``` java
             public static Class<?> forName(String className) {}
    
            //在JDBC开发中常用此方法加载数据库驱动:
            Class<?> driver = Class.forName("driver");
        ```
    - 直接获取一个对象的Class
        ``` java
        Class<?> klass = int.class;
        Class<?> classInt = Integer.TYPE;
        ```
    - 调用某个对象的 **getClass()** 方法
        ``` java
        StringBuilder str = new StringBuilder("123");
        Class<?> klass = str.getClass();
        ```
2. 判断是否为某个类的实例
    - 一般地，我们用instanceof关键字来判断是否为某个类的实例。同时我们也可以借助反射中Class对象的isInstance()方法来判断是否为某个类的实例，它是一个Native方法
        ``` java
        public native boolean isInstance(Object obj);
        ```
3. 创建实例
    - 使用Class对象的 ** newInstance() ** 方法来创建Class对象对应类的实例。
        ``` java
        Class<?> class = String.class();
        Object str = class.newInstance();
        ```
    - 先通过Class对象获取指定的Constructor对象，再调用Constructor对象的newInstance()方法来创建实例。这种方法可以用指定的构造器构造类的实例。

4. 获取方法
    - 获取某个Class对象的方法集合，主要有以下几个方法： ** getDeclaredMethods() ** 方法返回类或接口声明的所有方法，包括公共、保护、默认（包）访问和私有方法，但不包括继承的方法。
      
5. 获取构造器信息
6. 获取类的成员变量（字段）信息
    - getFiled: 访问公有的成员变量
    - getDeclaredField：所有已声明的成员变量。但不能得到其父类的成员变量
    - getFileds 和 getDeclaredFields用法同上（参照Method）
7. 调用方法
8. 利用反射创建数组





引用:  http://www.sczyh30.com/posts/Java/java-reflection-1/#%E4%B8%80%E3%80%81%E5%9B%9E%E9%A1%BE%EF%BC%9A%E4%BB%80%E4%B9%88%E6%98%AF%E5%8F%8D%E5%B0%84%EF%BC%9F
