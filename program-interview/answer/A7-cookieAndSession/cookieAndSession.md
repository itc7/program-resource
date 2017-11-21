# Cookie 和 Session的区别

### 机制
   - cookie机制 
    
        > 网络服务器用HTTP头向客户端发送cookies，在客户终端，浏览器解析这些cookies并将它们保存为一个本地文件，它会自动将同一服务器的任何请求缚上这些cookies 。
   
   - session机制
   
        > 是一种服务器端的机制，服务器使用一种类似于散列表的结构（也可能就是使用散列表）来保存信息。

### 存取方式
   - cookie
    
        > 只能保管ASCII字符串，假如需求存取Unicode字符或者二进制数据，需求先进行编码。Cookie中也不能直接存取Java对象。若要存储略微复杂的信息，运用Cookie是比拟艰难的。
    
   - session
   
        > 能够存取任何类型的数据，包括而不限于String、Integer、List、Map等。Session中也能够直接保管Java Bean乃至任何Java类，对象等，运用起来十分便当。能够把Session看做是一个Java容器类。
        
        
### 隐私策略
   - cookie
    
        > 存储在客户端阅读器中，对客户端是可见的，客户端的一些程序可能会窥探、复制以至修正Cookie中的内容。而Session存储在服务器上，对客户端是透明的，不存在敏感信息泄露的风险。
    
   - session
   
        > 是放在服务器上，Session里任何隐私都能够有效的保护。
    
### 有效期       

   - cookie
    
        > 过期时间可以设置很大。
    
   - session
   
        > 不能设置Session的超时时间过长，服务器累计的Session就会越多，越容易招致内存溢出。