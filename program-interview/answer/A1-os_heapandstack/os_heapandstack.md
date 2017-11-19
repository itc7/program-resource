操作系统中堆(stack)和堆(heap)的区别
====

``` cpp
　　int a = 0; 全局初始化区
　　char *p1; 全局未初始化区
　　main()
　　{
    　　int b; 栈
    　　char *p2; 栈
    　　char *p3 = "123456"; 123456\0在常量区，p3在栈上。
    　　static int c =0； 全局（静态）初始化区
    　　p1 = (char *)malloc(10);  堆
    　　p2 = (char *)malloc(20);  堆
　　}
```

* 第一个区别是申请方式不同：
    1. 栈(stack)， 是操作系统自动分配的空间，定义一个变量系统自动在栈上开辟空间  
    2. 堆(heap) ，是程序程序员根据需要自己申请空间,例如malloc(10) 开辟10个字节的空间
* 数据生命周期不同
    1. 栈，栈上的上的空间是系统自动分配的，上面的数据在函数运行结束就释放掉
    2. 堆，上的数据只要程序员不释放就一直存在，会造成内存泄漏
* 申请后系统的响应速度
    1. 栈，只要剩余空间大于剩余空间就直接分配，否则栈溢出，快
    2. 堆，操作系统有一个记录空闲内存地址的链表，当操作系统接收到堆空间申请之后首先遍历该链表，寻找第一个空间大于申请空间的堆节点，然后把这个
 空闲节点删除，并将该空闲节点的空间分配给程序。（另外分配完堆空间后还可能进行一些操作，这样效率就肯定会慢）
* 申请大小限制
    1. 栈，在windows系统中，栈是向低地址扩展的的数据结构，是一块连续的区域。这句话说明栈顶的地址是已经设定好的所以容量也是一定的（1Mb，http://www.cnblogs.com/zmlctt/p/3987181.html），如果申请超过剩余空间就会stackoverflow
    2. 堆，对是向高地址位扩展的数据结果，空间不是连续的，因为系统用链表存储空闲的内存地址值的（链表的遍历方向是从低地址向高地址方向），堆的大小限制于计算机中有效的虚拟内存大小，有次可见堆获得的空间比较灵活，也比较大。
* 存储内容的区别
    1. 栈，函数的下一条可执行语句、参数(大多数c语言编译器从右往左)、局部变量。先入后出
    2. 堆，一般在堆的头部用一个记录堆的大小，堆中具体内容有程序员安排。

内容地址：http://www.cnblogs.com/jsean/articles/1599799.html