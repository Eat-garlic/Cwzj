# 序前言

在eurka中注册好了微服务后，然后 就是相互之间通过 网络 将数据序例化在网络 上进行一个传输， 这时要通过 网络上发送请求的方式来进行一个数据 的交换 ，按之前 的方式 spring 5  可以 通过一个resteplate的类或者 httpClientconnect 的类来进行一个请求，然后 服务 端通过 这个请求来进行一个交互，但是这两个 服务 如果 都是在项目中通过 写上一个死地址 进行通信 的话，以后 公司的业务 项目 做的很大 时，就会特别的麻烦 ，如果我们可以在这上面进行一个优化 ，会提高很多效率 ， 这时， 这个在地铁 上开发 Cloud的牛人又写了一个组件 ，这个组件的 类库我们可以 直接 在pom文件 上导下来就用， 这个用的是可以 ，但是还是要写上注册中心服务 的名字 ，还是有些硬编码， 不能chedi的解决 问题，  于是在ribbon的基础上又引进了一个feign组件 ，这个组件是可以 直接 通过 一些注解 和  被调用 端和调用 端的配置 直接 进行一个调用 ，不用在项目 编码 上写很多的硬编码 ， 达到了一个低耦合性的 方式 









负载均衡



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





紧接着就有了另外一种方式了，在resttmplat中的 容器上面贴上一个注解 ，这个注解 的作用就是告诉这个微服务，当容器中加载到这个注解时，程序if else就会去读取之前从注册中心缓存到本地的ip,然后 进行一个随机的负载均hen









![image-20240222174442493](https://raw.githubusercontent.com/Eat-garlic/picture/master/CWZJ/20240222174442.png)



![image-20240223065743544](https://raw.githubusercontent.com/Eat-garlic/picture/master/CWZJ/20240223065743.png)





![image-20240222174623059](https://raw.githubusercontent.com/Eat-garlic/picture/master/CWZJ/20240222174623.png)





![image-20240222174606268](https://raw.githubusercontent.com/Eat-garlic/picture/master/CWZJ/20240222174606.png)












# Ribbon

硬编码

这个还是硬编码





![image-20240223195356120](https://raw.githubusercontent.com/Eat-garlic/picture/master/CWZJ/20240223195356.png)







![image-20240223195602501](https://raw.githubusercontent.com/Eat-garlic/picture/master/CWZJ/20240223195602.png)



## ribbon的 基本逻辑 

从客户端和服务 端的层面上 理解 

订单服务  调用  商品服务  

# 源码分析 最根本的还是一具Jdk的动态 代理 

https://www.jianshu.com/p/e89c693f19d2





##  负载均衡的策略

有几种 

* 轮询
* 随机





## 还是没解决 硬编码 的问题



# Feign



![image-20240223200348902](https://raw.githubusercontent.com/Eat-garlic/picture/master/CWZJ/20240223200348.png)





![image-20240223075700482](https://raw.githubusercontent.com/Eat-garlic/picture/master/CWZJ/20240223075700.png)

![image-20240223094459545](https://raw.githubusercontent.com/Eat-garlic/picture/master/CWZJ/20240223094459.png)









## 服务提供

![image-20240223103103801](https://raw.githubusercontent.com/Eat-garlic/picture/master/CWZJ/20240223103103.png)







## 服务调用 

先在api中写一个接口，这个接口是实现





![image-20240223103407567](https://raw.githubusercontent.com/Eat-garlic/picture/master/CWZJ/20240223103407.png)



直接 这样调用  

![image-20240223103437312](https://raw.githubusercontent.com/Eat-garlic/picture/master/CWZJ/20240223103437.png)

完全 没有硬编码 







## 大概流程

为什么 说fegin 就是用ribbon来调用 

![image-20240223120308127](https://raw.githubusercontent.com/Eat-garlic/picture/master/CWZJ/20240223120308.png)





![image-20240223120848103](https://raw.githubusercontent.com/Eat-garlic/picture/master/CWZJ/20240223120848.png)

![image-20240223121032659](https://raw.githubusercontent.com/Eat-garlic/picture/master/CWZJ/20240223121032.png)

![image-20240223121139541](https://raw.githubusercontent.com/Eat-garlic/picture/master/CWZJ/20240223121139.png)







![image-20240223122554949](https://raw.githubusercontent.com/Eat-garlic/picture/master/CWZJ/20240223122555.png)







![image-20240223122607820](https://raw.githubusercontent.com/Eat-garlic/picture/master/CWZJ/20240223122607.png)







### 为什么 feign说是用的ribbon



因为 调到最后，还是用了ribbon的源码

![image-20240223122750413](https://raw.githubusercontent.com/Eat-garlic/picture/master/CWZJ/20240223122750.png)





![image-20240223123736490](https://raw.githubusercontent.com/Eat-garlic/picture/master/CWZJ/20240223123736.png)







调用 步骤

![image-20240223123815452](https://raw.githubusercontent.com/Eat-garlic/picture/master/CWZJ/20240223123815.png)

![image-20240223123904872](https://raw.githubusercontent.com/Eat-garlic/picture/master/CWZJ/20240223123904.png)

![image-20240223123921445](https://raw.githubusercontent.com/Eat-garlic/picture/master/CWZJ/20240223123921.png)







观察者模式 

![image-20240223123937826](https://raw.githubusercontent.com/Eat-garlic/picture/master/CWZJ/20240223123937.png)

进入 exexute



看到ribbon

![image-20240223124016258](https://raw.githubusercontent.com/Eat-garlic/picture/master/CWZJ/20240223124016.png)

获取参数后

执行请求

![image-20240223124137119](https://raw.githubusercontent.com/Eat-garlic/picture/master/CWZJ/20240223124137.png)

![image-20240223124202077](https://raw.githubusercontent.com/Eat-garlic/picture/master/CWZJ/20240223124202.png)

然后 就是发送请求了 







# 接口幂等性的问题





当feign调用 超时重罢次数很多时，被调用 服务 是接口的，我们一定不要调用 多次，因为 如果 是存储或者更改数据库中的东西时，多次操作会出现很多问题



## 超时时间 的设置 

当feign调用服务时，超时是可以 设置 的

## 并且是在调用端设置的





![image-20240223201958121](https://raw.githubusercontent.com/Eat-garlic/picture/master/CWZJ/20240223201958.png)

