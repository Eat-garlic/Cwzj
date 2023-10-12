## RMI(java)分布式的核心



###  rmi 概述

 简单的demo

这是基本的业务逻辑

![Snipaste_2023-10-11_15-38-11](https://raw.githubusercontent.com/Eat-garlic/picture/master/CWZJ/20231011154025.png)





![Snipaste_2023-10-11_15-44-30](https://raw.githubusercontent.com/Eat-garlic/picture/master/img/20231011154816.png)



方法之间要怎么调用呢





客户端调用服务端， 服务端上有很多对象，客户端没有办法知道调用哪个对象开在哪个端口上，所以得有个注册中心告诉 客户端自己 要的对象在服务端的哪个端口上，只有这样客户端才能明确的调用到服务端的对象 



之所以能达到这个效果 ，是因为注册中心的地址是明确的，我们客户端调用服务端的过程中查找注册中心这台机器的ip端口都是确定的知道确定的端口后，注册中心端实质就是一个table表， key  value存储对象 ，存储着很多键值对，服务器将自己要被客户端可能要要调用 的对象 都 一 一 的通过key value绑定到注册中心端上了![image-20231011163200790](C:\Users\AeatGarlic\AppData\Roaming\Typora\typora-user-images\image-20231011163200790.png)，所以这时客户端找到注册 中心后，需要通过key（String类型的字符串eg:IremoteObject） 就能找到对应 的value， 这个value就是服务端类RMIServe中new出来接口实现类的这个对象，也即这个对象 是绑定到注册中心端的某个键值对中的键上（也可以理解为绑定到绑定到注册中心端），java rmi中服务端和注册 中心是在同台机器 上，其实在有些语言中注册中心端和服务端是两台电脑上，这里我模拟都在同一台电脑，希望你能理解

![image-20231011162055413](https://raw.githubusercontent.com/Eat-garlic/picture/master/img/20231011162055.png)



查找后返回的是接口类型的，那个查找方法的源码返回的就是接口类型的对象  





![image-20231011155526439](https://raw.githubusercontent.com/Eat-garlic/picture/master/img/20231011155526.png)







![image-20231011160758728](https://raw.githubusercontent.com/Eat-garlic/picture/master/img/20231011160758.png)

概念就是一台机器 想执行另一台机器 上的java代码









如果两端的接口不一样，结果是怎样的呢

如果两端接口不一样，我们那么服务端的接口实现  绑定到到注册端上来，

客户端找到注册端后进行调用接口的方法 ，因为接口不一样，所以 压根就没办法调用到想要的业务逻辑代码

![image-20231011173749931](https://raw.githubusercontent.com/Eat-garlic/picture/master/img/20231011173750.png)



比方说这个remoteObj.sayhello方法  是客户端的  如果 服务端的是其他 接口，rmoteddsawe接口，这没法调用，因为方法 方法找不到，sayhello的方法 找不到。













通用 的远程对象 UnicastRemotObject   rmi就这一个远程对象  想用RMI这个功能就要继承 这个对象 





![image-20231012092343014](https://raw.githubusercontent.com/Eat-garlic/picture/master/img/20231012092343.png)







![image-20231008195146418](https://raw.githubusercontent.com/Eat-garlic/picture/master/CWZJ/20231008200634.png)







![image-20231012084011931](https://raw.githubusercontent.com/Eat-garlic/picture/master/img/20231012084012.png)

你的服务端必须要运行起来可知道 











![img](https://raw.githubusercontent.com/Eat-garlic/picture/master/CWZJ/20231009144024.png)





#### stub代理对象

https://blog.csdn.net/liupeifeng3514/article/details/78998127





![image-20231012092221004](https://raw.githubusercontent.com/Eat-garlic/picture/master/img/20231012092221.png)



这两个代理对象都是代理的是网络请求连接的功能 ，我们都知道 客户端和服务端不可能就只想调用自己 的调用 代码而已，至于网络请求连接，我们不可能也写在两端代码之中，专业的事情给专业的人去做，这时候就需要代理，将业务之外的代码给代理去做，这个skeleton和 stub就是这个专业的代理的角色，封装网络的请求的

代理的作用和意义就是将业务逻辑之外的东西提取出来



但是实现代理的前提是有接口， 有相同的方法，这里面是怎么实现出来的呢，也就是说stub 和skeb 都有和各自端的相同的接口和方法

代理对象要和被代理的两端要实现相同的接口

![image-20231012103059479](https://raw.githubusercontent.com/Eat-garlic/picture/master/img/20231012103059.png)



实现 相同的接口，

![image-20231012122441345](https://raw.githubusercontent.com/Eat-garlic/picture/master/img/20231012122441.png)



非常抱歉，我的之前的回答可能有些误导。在RMI中，实际上是客户端代码直接调用本地存根的方法，然后由存根将调用转化为网络请求发送给服务器。存根是客户端的代表，它持有与服务器通信的引用。当客户端代码调用存根的方法时，这个调用会被转化为网络消息，发送到服务器。在客户端看来，存根就像一个本地对象。在客户端生成存根的过程中，RMI会为远程对象生成一个接口的本地实现类，并为这个本地实现类生成一个实例，这个实例持有一个指向服务器的引用。所以当客户端代码像调用本地对象一样调用这个本地实现类的方法时，实际上是将这个调用转化为网络请求，通过持有服务器引用的存根发送给服务器。



![image-20231012123010483](https://raw.githubusercontent.com/Eat-garlic/picture/master/img/20231012123010.png)



![image-20231012123359100](https://raw.githubusercontent.com/Eat-garlic/picture/master/img/20231012123359.png)



所以这里 你要搞清楚 ， 你3 月份的理解是完全错误的，3月份的理解什么 将服务端的对象一把拉到客户端来， 

然后在客户端本地调用 ，这不扯嘛，然后在纠结怎么拉到客户端， 想尽办法能不能通过代理 对象拉到客户端 ，搞了一晚上都不明白，想破了头，原来结果是在这里 











问题来了，客户端是怎么操作注册中心的呢，找到注册 中心后直接调用其中 的方法 ， 它和注册 中心这之间又是怎么通信 的，找到注册 中心后，注册 中心的代码 凭什么 就可以 直接 在客户端上来操作



逻辑 是什么 

：看下面，直接将对象搞到本机上来了（通过序列化）





![image-20231012140451992](https://raw.githubusercontent.com/Eat-garlic/picture/master/img/20231012140452.png)









![image-20231012161237638](https://raw.githubusercontent.com/Eat-garlic/picture/master/img/20231012161237.png)









![img](https://raw.githubusercontent.com/Eat-garlic/picture/master/CWZJ/20231009144044.jpeg)





![img](https://raw.githubusercontent.com/Eat-garlic/picture/master/CWZJ/20231009144103.png)



![img](https://raw.githubusercontent.com/Eat-garlic/picture/master/CWZJ/20231009144148.png)





![img](https://raw.githubusercontent.com/Eat-garlic/picture/master/CWZJ/20231009144135.png)



![img](https://raw.githubusercontent.com/Eat-garlic/picture/master/CWZJ/20231009144205.png)





UnicastServerRef实现 了Dispatche就证明这个可以 对象 是可以转发请求的

这个类有转发传输的功能 将数据转发到一些地方去，或者传输







target



![img](https://raw.githubusercontent.com/Eat-garlic/picture/master/CWZJ/20231009144434.png)



一模一样















![image-20231011175844650](https://raw.githubusercontent.com/Eat-garlic/picture/master/img/20231011175844.png)










