
# eureka

注册中心都是通过序列化在网络上将地址进行传输的，不过现在 它是一个闭源的框架 ，我们 看不到它的内部代码是怎么运行的



以idea创建 项目例

我们创建一个订单服务和商品服务 ， 订单调用 商品服务 ，  

首先要独立的创建一个eureka这个微服务 ，它也是一个基于springboot的项目骨架 ，然后 在这个项目 上勾选出Cloud Discover  —>eureka  server 这个注册中心的服务，   然后 就会下载依赖，在pom文件 中你只要勾选了，就会下载下来，在启动类上贴上一个 @EnableEurekaServer这个注解 ， 然后 在这个eureka项目 的yml文件写上一些配置 这个配置主要是用来确定 这个注册 中心服务端是可以 让其他组件发现 的，有这几个配置 

1. 自己在网络中供其他项目发现的地址 
2. 是否向注册中心注册自己 这个服务         
3. 是否拉取注册中心的地址 

对应下图

这个拉取的默认是true，如果 你不需要拉取时才需要配置为false



![](https://raw.githubusercontent.com/Eat-garlic/picture/master/CWZJ/20240223161522.png)







![image-20240223160629739](https://raw.githubusercontent.com/Eat-garlic/picture/master/CWZJ/20240223160629.png)












![image-20240218101840256](https://raw.githubusercontent.com/Eat-garlic/picture/master/CWZJ/20240218101840.png)

客户端在启动时从配置中心配置了eurka的地址，所以 在启动时直接通过网络 注册 到了客户端端的tabe表中，所以会显示  









![image-20240222112208032](https://raw.githubusercontent.com/Eat-garlic/picture/master/CWZJ/20240222112208.png)

之所以在注册中心可以发现这个order-server服务，是因为 这个order-server服务 本身 就是一个springboot项目 ，在启动时要加载yml，文件，然后这个项目 就会通过这个文件 来进行这个boot项目 启动配置，自然就知道 了了这个注册中心的地址 ，然后 ，在启动order-server项目时，通过网络 和序例化，将地址读到eureka中，在网络 上连接 ，进行一个 联动， 自然 注册中心就可以 看到 了这个服务









### @EnableEurekaServer

可以理解为程序在扫苗到这个注解 后，然后 才在局域网上进行一个公开 ，如果 没有这个注解 ，其他 组件 无法发现这个注册中心程序 



![image-20240223163252742](https://raw.githubusercontent.com/Eat-garlic/picture/master/CWZJ/20240223163252.png)





客户端要发送心跳

![image-20240223163339907](https://raw.githubusercontent.com/Eat-garlic/picture/master/CWZJ/20240223163340.png)







![image-20240223164533255](https://raw.githubusercontent.com/Eat-garlic/picture/master/CWZJ/20240223164533.png)
























