## RMI(java)分布式的核心

RMI全称是Remote Method Invocation-远程方法调用

代码：https://github.com/Eat-garlic/RMI.git

###  rmi 概述

 简单的demo

这是基本的业务逻辑

![Snipaste_2023-10-11_15-38-11](https://raw.githubusercontent.com/Eat-garlic/picture/master/CWZJ/20231011154025.png)





![Snipaste_2023-10-11_15-44-30](https://raw.githubusercontent.com/Eat-garlic/picture/master/img/20231011154816.png)



方法之间要怎么调用呢





客户端调用服务端， 服务端上有很多对象，客户端没有办法知道调用哪个对象开在哪个端口上，所以得有个注册中心告诉 客户端自己 要的对象在服务端的哪个端口上，只有这样客户端才能明确的调用到服务端的对象 



之所以能达到这个效果 ，是因为注册中心的地址是明确的，我们客户端调用服务端的过程中查找注册中心这台机器的ip端口都是确定的知道确定的端口后，

这里你可能 会问为什么有Ip就能找到 这个对象 ，

原因是因为 用了rmi， rmi底层已经 给你实现 了连接，也就是它的底层实现了socket 代理 的连接封装好的拿 来就用，也就是下章节我们自己 手写 的rpc代码，rmi作了一个封装而已 



注册中心端实质就是一个table表， key  value存储对象 ，存储着很多键值对，服务器将自己要被客户端可能要要调用 的对象 都 一 一 的通过key value绑定到注册中心端上了![image-20231011163200790](C:\Users\AeatGarlic\AppData\Roaming\Typora\typora-user-images\image-20231011163200790.png)，所以这时客户端找到注册 中心后，需要通过key（String类型的字符串eg:IremoteObject） 就能找到对应 的value， 这个value就是服务端类RMIServe中new出来接口实现类的这个对象，也即这个对象 是绑定到注册中心端的某个键值对中的键上（也可以理解为绑定到绑定到注册中心端），java rmi中服务端和注册 中心是在同台机器 上，其实在有些语言中注册中心端和服务端是两台电脑上，这里我模拟都在同一台电脑，能理解 

这个服务实现也就写给了客户端， 这个对象在客户端上也就有了

![image-20231011162055413](https://raw.githubusercontent.com/Eat-garlic/picture/master/img/20231011162055.png)



查找后返回的是接口类型的，那个查找方法的源码返回的就是接口类型的对象  





![image-20231011155526439](https://raw.githubusercontent.com/Eat-garlic/picture/master/img/20231011155526.png)







![image-20231011160758728](https://raw.githubusercontent.com/Eat-garlic/picture/master/img/20231011160758.png)

概念就是一台机器 想执行另一台机器 上的java代码









如果两端的接口不一样，结果是怎样的呢

如果两端接口不一样，我们那么服务端的接口实现  绑定到到注册端上来，

客户端找到注册端后进行调用接口的方法 ，因为接口不一样，所以 压根就没办法调用到想要的业务逻辑代码

![image-20231011173749931](https://raw.githubusercontent.com/Eat-garlic/picture/master/img/20231011173750.png)



比方说这个remoteObj.sayhello方法  是客户端的  如果 服务端的是其他 接口，rmoteddsawe接口，这没法调用，因为方法 方法找不到，sayhello的方法 找不到。接口不一样，也直接找到了













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

客户端代码，也就是自己 写的代码通过各调用 到，存根的方法上，

![image-20231012122441345](https://raw.githubusercontent.com/Eat-garlic/picture/master/img/20231012122441.png)

 

![image-20231018231900902](https://raw.githubusercontent.com/Eat-garlic/picture/master/img/20231018231901.png)

![image-20231018232006996](https://raw.githubusercontent.com/Eat-garlic/picture/master/img/20231018232007.png)

绑定的是接口，而不是实例，多态，服务器向注册器绑定的是这个接口类型的，客户器找到 的也是这个类型的，等于后面实现了这个接口，也就是这个接口的所有方法列表我都知道了，这时我的客户器生成一个skteb的代理对象自然自然就能调到服务端的上面来，然后就执行了服务器 的方法 ，服务器的方法做什么，那就是服务器的事情了，它可以自己 执行，也可以 将执行的结果通过rpc写给客户端，都行



非常抱歉，我的之前的回答可能有些误导。在RMI中，实际上是客户端代码直接调用本地存根的方法，然后由存根将调用转化为网络请求发送给服务器。存根是客户端的代表，它持有与服务器通信的引用。当客户端代码调用存根的方法时，这个调用会被转化为网络消息，发送到服务器。在客户端看来，存根就像一个本地对象。在客户端生成存根的过程中，RMI会为远程对象生成一个接口的本地实现类，并为这个本地实现类生成一个实例，这个实例持有一个指向服务器的引用。所以当客户端代码像调用本地对象一样调用这个本地实现类的方法时，实际上是将这个调用转化为网络请求，通过持有服务器引用的存根发送给服务器。



![image-20231012123010483](https://raw.githubusercontent.com/Eat-garlic/picture/master/img/20231012123010.png)



![image-20231012123359100](https://raw.githubusercontent.com/Eat-garlic/picture/master/img/20231012123359.png)

#  3 月的理解 是错误 的，一定要自己 搞清楚 



在 Java RMI 中，客户端代理是客户端程序中用于代表远程服务的对象。客户端代理通常通过 RMI 提供的 stub 类创建，stub 类实现了远程接口，并充当客户端与远程服务之间的桥梁。

客户端代理的主要作用是，当客户端调用远程服务的方法时，代理负责通过网络与远程服务进行通信，将客户端的请求发送给远程服务，并将远程服务的响应返回给客户端。

客户端代理的实现机制涉及到了 RMI 的动态代理和网络通信机制。客户端通过 stub 对象调用远程服务的方法时，实际上是在调用 stub 对象的方法。RMI 会将这个调用封装为一个网络请求，并通过 Java 序列化机制将请求发送到远程服务器。在服务器端，RMI 会接收到请求并找到对应的远程对象，执行相应的方法。执行结果会被序列化并返回给客户端。客户端收到结果后，RMI 会将结果反序列化为相应的对象，并返回给客户端。

通过客户端代理，Java RMI 实现了对远程服务的透明访问，使得客户端可以像调用本地对象一样调用远程服务的方法，而不需要关心底层的通信细节。



那服务端那边的代理对象是起什么作用呢



1. **通信代理**：服务端代理对象负责接收客户端的请求，并将这些请求转发给实际的远程对象。它通过RMI的内部机制将请求转换为网络通信协议，确保客户端和远程对象之间的通信能够顺利进行。
2. **序列化与反序列化**：当客户端发送请求时，这些请求需要被序列化为字节流以便在网络上传输。同样，从客户端接收到的响应也需要被反序列化为Java对象。服务端代理对象负责这一序列化和反序列化的过程。
3. **安全性控制**：服务端代理对象可以用于实施安全策略，例如对客户端的访问权限进行控制，或者对客户端请求的内容进行验证等。
4. 

![image-20240114124137680](https://raw.githubusercontent.com/Eat-garlic/picture/master/img/20240114124137.png)







实现 序例化接口的作用就是用来在网络中传输对象 的， ，不存在什么 两端通过实现 相同 的接口，然后a端执行b端时把b端对象 搞到a端上来 的，之前纠结怎样搞到a端上来，一直纠结这个  怎么搞呢，当时是想通过







所以这里 你要搞清楚 ， 你3 月份的理解是完全错误的，3月份的理解什么 将服务端的对象一把拉到客户端来， 

然后在客户端本地调用 ，这不扯嘛，然后在纠结怎么拉到客户端， 想尽办法能不能通过代理 对象拉到客户端 ，搞了一晚上都不明白，想破了头，原来结果是在这里 



![image-20240114114422951](https://raw.githubusercontent.com/Eat-garlic/picture/master/img/20240114114423.png)



## 





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















## 在回去相亲火车上的理解  清楚的理解rmi   





## 



![image-20240110145353381](https://raw.githubusercontent.com/Eat-garlic/picture/master/img/20240110145353.png)







![image-20240110145418046](https://raw.githubusercontent.com/Eat-garlic/picture/master/img/20240110145418.png)









![image-20240110145434061](https://raw.githubusercontent.com/Eat-garlic/picture/master/img/20240110145434.png)





存根就是代理对象 ，代理对象 用的就是java中的jdk的动态代理 ，为什











![](https://raw.githubusercontent.com/Eat-garlic/picture/master/img/20240112103552.png)







看到没有，然后这个老师也就说了我上面的想法 ，创建网络连接 

![image-20240112161703992](https://raw.githubusercontent.com/Eat-garlic/picture/master/img/20240112161704.png)





代理类里面的逻辑



![image-20240112161800605](https://raw.githubusercontent.com/Eat-garlic/picture/master/img/20240112161800.png)

