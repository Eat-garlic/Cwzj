



















当项目 大了的时候 ，我们的配置 文件 都需要写在各个微服务 的yml中，如果 这个时候一个需求是想看一下某个服务



![](https://raw.githubusercontent.com/Eat-garlic/picture/master/CWZJ/20240227175709.png)







如果 你要更改一下商品在10秒钟的最大可访问数量 ，这时，要是更改项目 中硬编码，然后重启项目 ，需要等几个小时

为了解决 这个问题地铁大神又写出了一个Config的组件，它的作用是将整个项目 中的所有 微服务 的yml文件都集中写在这个Config的组件中，当然这个Config本身也是需要将自己 注册 到注册中心的，然后各个微服务在yml中配置上自己 的

1. 配置中心的地址 
2. 注册 中心的地址 

只需要配置 这两个 地址 ，其他 的全都交给配置 中心，也是通过 网络 上传输的













统一管理配置, 快速切换各个环境的配置

　在微服务体系中，服务的数量以及配置信息的日益增多，比如各种服务器参数配置、各种数据库访问参数配置、各种环境下配置信息的不同、配置信息修改之后实时生效等等，传统的配置文件方式或者将配置信息存放于数据库中的方式已无法满足开发人员对配置管理的要求，如：

安全性：配置跟随源代码保存在代码库中，容易造成配置泄漏
时效性：修改配置，需要重启服务才能生效
局限性：无法支持动态调整：例如日志开关、功能开关









01.使用Spring Initializr创建SpringBoot项目，选择Cloud Discover->Eureka Discover , Cloud Config -> Config Server
02.在启动类中贴上@EnableConfigServer注解
03.添加application.yml并设置相关的配置







## 理解 

各个微服务 在启动时要向注册中心传输自己 的地址 ，，注册中心在30秒内也要同步各个服务的地址 ，

在向注册中心传输自己 地址 后，整个的微服务如果配置 了配置 中心config这个组件 ，程序默认优先级不是读application.yml了，而是![image-20240227181306156](https://raw.githubusercontent.com/Eat-garlic/picture/master/CWZJ/20240227181306.png)bootsstrap.yml，它是去找这个配置文件 ，程序 通过 这个配置 文件 再加上pom中的Config就直接 找到了写在Config组件上的所有 相关配置，然后 运行