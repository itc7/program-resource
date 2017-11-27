# RPC 通信和 RMI 区别

### RPC

- 方式

    RPC（Remote  Procedure Call Protocol）远程过程调用协议：通过网络从远程计算机请求某种服务。
    简单来说就像调用本地服务一样调用远程服务。通常指不在一个内存空间，不能直接调用，需要通过网络来表达通用的语意和传达调用的数据。

### RMI
 
- 方式
    
    RMI(Remote Method Invocation) 远程方法调用：是java的一组维护开发分布式程序的api。RMI使用java语言接口定义了远程对象，它集合了java序列化
    和java远程方法协议（Java Remote Method Protocol）。简单的说，这样使原先的程序在同一操作系统的方法调用，变成了不用操作系统之间的方法调用。
    java RMI可以看作是RPC的java特殊版，但是传统rpc并不能很好地应用与分布式对象系统。java RMI则支持存储于不同地址空间的程序级对象之间的彼此通信。
    
    
    