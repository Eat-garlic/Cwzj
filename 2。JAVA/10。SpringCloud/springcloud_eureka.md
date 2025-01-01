
# eureka

注册中心都是通过序列化在网络上将地址进行传输的，不过现在 它是一个闭源的框架 ，我们 看不到它的内部代码是怎么运行的



spring cloud 

一切都是类库，没什么的









##  分布式和微服务，集群的概念

### 分布式

分布式概念可以 理解为：比如一个单体应用 的软件，我们可以将它拆分到不现的电脑上（服务器）上，然后进行通过http或者其他的协议进行远程rpc调用，这是分布式的基本概念，广义 的概念是 我分布式架构 ，比如说公司开发 一个项目 出来 ，这个分布式的架构的选型 ， 用什么 类库，组件，这些

### 微服务

微服务的概念是将一个项目分在不同的机器 上，或者分布在同台机器 上的不同进程 上，然后可以 独立运行，自己 自成一派。







## 两者区别 

分布式一定是微服务，微服务不一定是分布式

分布式和微服务 的区别 就是 微服务 是一个进程或者 一台机器负责这个服务，在同一个tomcat中， 

分布式 一定是微服务，微服务不一定 是分布式，因为 微服务可以在同台机器 上的不同进程上





### 集群

将一个服务 可以用的服务 布署在一台机器 上的不同端口上，称为集群







# eureka

## 使用

以idea创建 项目例

我们创建一个订单服务和商品服务 ， 订单调用 商品服务 ，  

首先要独立的创建一个eureka这个微服务 ，它也是一个基于springboot的项目骨架 ，然后 在这个项目 上勾选出Cloud Discover  —>eureka  server 这个注册中心的服务，   然后 就会下载依赖，在pom文件 中你只要勾选了，就会下载下来，在启动类上贴上一个 @EnableEurekaServer这个注解 ， 然后 在这个eureka项目 的yml文件写上一些配置 这个配置主要是用来确定 这个注册 中心服务端是可以 让其他组件发现 的，有这几个配置 

1. 自己在网络中供其他项目发现的地址 
2. 







![image-20240223160629739](https://raw.githubusercontent.com/Eat-garlic/picture/master/CWZJ/20240223160629.png)





其实springclou 就是一个基于springboot项目 的基础上开发出来 的一另外一个项目类库，并且 是一个老外 在地铁上开发出来 的，

eureka是这个整个类库中的一个小类库， 可以 理解 成一 个小项目 ，这个小项目 的源码是闭源的，虽然 是闭源的，但是实现 的功能 是可以 猜到的，就是它是一个程序，这个程序 是在网络 上用了一台机器 的资源，占用了机器 的资源 ，然后进行了 一个注册中心的程序 在这个资源上，  这个注册中心有  端口，有ip， 有很多 东西 ， 我们只需要进行一个使用就可以 了，   同时 也只需要在创建 springboot项目 时随便 勾选好后，Idea就直接给我们创建 了这个项目，所以 用起来很简单， 这就 是  这个的理解 





也是通过序列化在网络上将地址和ip传过去



springcloud，你可以 理解 这个框架的开发者就是基于springboot的类库来开发的的，你要使用这个框架的组件，导入这个框架，然后自动会依赖springbooT,

 eureka这个注册中心我们通过，使用时，是需要单独 的当成一个服务来启动，当成一个微服务的项目 一样来启动

这个是一个项目 ，不像 zookeeper









![image-20240218101508877](https://raw.githubusercontent.com/Eat-garlic/picture/master/CWZJ/20240218101509.png)

只要在创建项目时一勾  ，可以 理解为这个项目 已经有了cloud的组件，然后，我们就可以 使用了，然后创建另外一个项目 时，项目 会读取我们的配置 中心，然后 通过网络 直接 加载对应 的地址，到地址中进行发现与注册 

大概的逻辑 就是这样的





![image-20240218101840256](https://raw.githubusercontent.com/Eat-garlic/picture/master/CWZJ/20240218101840.png)

客户端在启动时从配置中心配置了eurka的地址，所以 在启动时直接通过网络 注册 到了客户端端的tabe表中，所以会显示  









![image-20240222112208032](https://raw.githubusercontent.com/Eat-garlic/picture/master/CWZJ/20240222112208.png)

之所以在注册中心可以 发现这个server服务，是因为 这个服务 本身 就是一个springboot项目 ，在启动时要加载yml，文件，然后这个项目 就会通过这个文件 来进行这个boot项目 启动配置，自然就知道 了了这个注册中心的地址 ，然后 ，在启动server项目时，通过网络 和序例化，将地址读到eureka中，在网络 上连接 ，进行一个 联动







fuzaijunheng

![image-20240222113859823](https://raw.githubusercontent.com/Eat-garlic/picture/master/CWZJ/20240222113859.png)





![image-20240222115230284](https://raw.githubusercontent.com/Eat-garlic/picture/master/CWZJ/20240222115230.png)





## 调用 服务的方式 

当我们的一个服务（比如说订单服务的调用 另一个商品详情服务 ）

怎么调用 啊，可以 用几种方法来调用 ，一般 且rsetmplat  是spring 5 中的 类库，也可以 用其他方式来调用 ，但是如果 在微服务中调用 是用硬编码调用 的，![image-20240222175032178](https://raw.githubusercontent.com/Eat-garlic/picture/master/CWZJ/20240222175032.png)这样很low，不行，得用另外一种可以 替换的方式来调用 ，



还是硬编码 

怎么解决 





这是最原始的调用 

![image-20240222172550627](https://raw.githubusercontent.com/Eat-garlic/picture/master/CWZJ/20240222172550.png)

这样肯定不行，太Low





紧接着就有了另外一种方式了，在resttmplat中的 容器上面贴上一个注解 ，这个注解 的作用就是告诉这个微服务，当容器中加载到这个注解时，程序if else就会去读取之前从注册中心缓存到本地的ip,然后 进行一个随机的fuzaijun  hen   









![image-20240222174442493](https://raw.githubusercontent.com/Eat-garlic/picture/master/CWZJ/20240222174442.png)



![image-20240223065743544](https://raw.githubusercontent.com/Eat-garlic/picture/master/CWZJ/20240223065743.png)





![image-20240222174623059](https://raw.githubusercontent.com/Eat-garlic/picture/master/CWZJ/20240222174623.png)





![image-20240222174606268](https://raw.githubusercontent.com/Eat-garlic/picture/master/CWZJ/20240222174606.png)





