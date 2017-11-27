# 什么是竞态条件？ 举个例子说明。

### 竞态条件
> 当两个线程竞争同一资源时，如果对资源的访问顺序敏感，就存在静态条件。

### 临界区
> 导致竞态条件发生的代码区称作。

多线程执行下面代码可能会出错：
```java
public class Counter {
    protected long count = 0;
    public void add(long value) {
        this.count += value;
    }
}
```
假如有两个线程执行这段代码，这两个线程同时读到 this.count的值为零，然后分别将，自己线程中的value与this.count相加，
没有依次进行的话，最后count的值为两个线程中某一个value的值，而不是两个线程的value值相加，这种情况就需要保证一定的顺序，才能正确得到结果。