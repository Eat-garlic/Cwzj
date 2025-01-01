# Ribbon

硬编码





## ribbon的 基本逻辑 

从客户端和服务 端的层面上 理解 

订单服务  调用  商品服务  



## 还是没解决 硬编码 的问题

## fuzaijunhen  的策略，写个教材

有几种









# Feign









![image-20240223075700482](https://raw.githubusercontent.com/Eat-garlic/picture/master/CWZJ/20240223075700.png)

![image-20240223094459545](https://raw.githubusercontent.com/Eat-garlic/picture/master/CWZJ/20240223094459.png)









## 服务提供

![image-20240223103103801](https://raw.githubusercontent.com/Eat-garlic/picture/master/CWZJ/20240223103103.png)







## 服务调用 

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







### 为什么 说是用的ribbon

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