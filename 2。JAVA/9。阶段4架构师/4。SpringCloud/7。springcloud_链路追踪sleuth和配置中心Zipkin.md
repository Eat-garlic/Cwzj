#  链路追踪

当用户发送很多请求时，，微服务也接收到了，如果服务通过了网关调用 了，比如订单服务 调用 了商品服务，

此时如果想要出现了一些错误，想找到这些调用 的日志 怎么办呢，我们可以通过 lombok的logforj来提取日志，来看问题是出现 在哪里，少量的请求我们是可以做到的，但是如果成千上万的请求过来 呢，都用logforj来提取，很麻烦并且哪个请求对应 的是哪个 请求，forj如果要自己用手动写的话很难一 一对应 ，这个时候如果大量的请求或者大量的请求到达了服务中的某些方法 ，，，自己 写日志很容易混乱，这个时候我们就引入 了一个日志，也是地铁的牛人来解决 这个问题的，写了一些关于解决 日志 的组件出来 ，让我们很方便的就可以知道 自己 系统上的问题出在哪，因为 这个组件就是为了解决日志 而写出来的



![image-20240227163923556](https://raw.githubusercontent.com/Eat-garlic/picture/master/CWZJ/20240227163923.png)





这个组件叫做sleuth



加入这个组件 后，我们通过 这个组件打印出来的格式 

Trace的 Id 是相同 的，不管在哪个服务 中，都是相同 的



日志格式:
[order-server,c323c72e7009c077,fba72d9c65745e60,false] 

1、第一个值，spring.application.name的值
			
2、第二个值，c323c72e7009c077 ，sleuth生成的一个ID，叫Trace ID，用来标识一条请求链路，一条请求链路中包含一个Trace ID，多个Span ID
			
3、第三个值，fba72d9c65745e60、spanID 基本的工作单元，获取元数据，如发送一个http





![image-20240227083628600](https://raw.githubusercontent.com/Eat-garlic/picture/master/CWZJ/20240227083628.png)



# ZipKin



![image-20240227164934605](https://raw.githubusercontent.com/Eat-garlic/picture/master/CWZJ/20240227164934.png)

将这个日志通过 一个服务器es ,存取 到一个JAR包中，这个JAR包的程序可以 理解 为是一个集合，需要下载 ，它帮助 我们进行咔嚓分布式服务之间 的调用 ，分析 这些服务 的日志 呀，调用 时间 呀，可以 理解 为是一个帮助 我们处理分布式问题的一个容器，也是需要在pom文件中导入，或者 在电脑 上进行一个下载   下载 的是可视化图形 界面 ，然后 我们可以 通过 这个界面 来判断一些直观 的分布式系统 的问题


