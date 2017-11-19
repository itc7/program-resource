什么是基于注解的切面实现
====
注：这里只谈spring aop

AOP （Aspect Oriented Programming，面向切面编成）是spring框架的两大特性之一
* 他能做到

    `在程序运行过程中动态添加一些代码到特定的位置`
* 知识点 
    1. 增强(advice，有的说通知)：在特定连接点执行的动作。
    2. 切点(pointcut)：一组连接点的总称，用于指定某个增强应该在何时被调用。
    3. 连接点(join point)：在应用执行过程中能够插入切面的一个点。（就是抽象的「切点」声明所指代的那些具体的点。）
    4. 切面(aspect)：通知(即增强)和切点的结合。

* 实现方式
    1. xml配置方式
        
        1. 出现时间
        
    2. 注解方式
        1. 出现时间
        
            ？
        2. 有什么注解
        
            name | description
            --- | ---
            @After | 通知方法会在目标方法返回或抛出异常后调用
            @AfterRetruening | 通常方法会在目标方法返回后调用
            @AfterThrowing | 通知方法会在目标方法抛出异常后调用
            @Around | 通知方法将目标方法封装起来
            @Before | 通知方法会在目标方法执行之前执行
            @Pointcut | 声明一个通用的切点

    3. aspectj
    
        ？
        
* demo

    见 `pers.fpj.answer.a2`        
        
引用:

http://www.jianshu.com/p/6f40dddd71a5 https://www.zhihu.com/question/24863332