# Interface 与 abstract 类的区别

属性 | abstract | interface
--- | --- | ---
实例化 | 不可实例化 | 不可实例化
默认的方法实现 | 可有默认的方法实现 | 只能有抽象方法 
构造器 | 可以有 | 不能有
子类实现 | extends | implements

### abstract

- 抽象类
```java
public abstract class Abs {
    public Abs() {
    }
    public abstract void t1();
    public String t2() {
        return "t2";
    }
}
```

- 子类
```java
public class AbsChild extends Abs {
    @Override
    public void t1() {
    }
}
```

### interface

- 接口
```java
public interface Inte {
    public void t1();
    public String t2();
}
```

- 子类
```java
public class InteChild implements Inte {
    @Override
    public void t1() {
    }
    @Override
    public String t2() {
        return null;
    }
}
```
