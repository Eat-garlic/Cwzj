# 学完要搞明白这些



![image-20240223202926504](https://raw.githubusercontent.com/Eat-garlic/picture/master/CWZJ/20240223202926.png)











![image-20240224072526571](https://raw.githubusercontent.com/Eat-garlic/picture/master/CWZJ/20240224072526.png)



要考虑到这些问题 ，地铁上牛人又搞出来了一个组件











![image-20240224075402655](https://raw.githubusercontent.com/Eat-garlic/picture/master/CWZJ/20240224075402.png)















![image-20240224080050445](https://raw.githubusercontent.com/Eat-garlic/picture/master/CWZJ/20240224080050.png)









![image-20240224081257452](https://raw.githubusercontent.com/Eat-garlic/picture/master/CWZJ/20240224081257.png)







这里面又 有很多学问 

消息中间件 

![image-20240224081921720](https://raw.githubusercontent.com/Eat-garlic/picture/master/CWZJ/20240224081921.png)







隔离策略

![image-20240224083240665](https://raw.githubusercontent.com/Eat-garlic/picture/master/CWZJ/20240224083240.png)

![image-20240224083342251](https://raw.githubusercontent.com/Eat-garlic/picture/master/CWZJ/20240224083342.png)







![image-20240224084527677](https://raw.githubusercontent.com/Eat-garlic/picture/master/CWZJ/20240224084527.png)











![image-20240224091000791](https://raw.githubusercontent.com/Eat-garlic/picture/master/CWZJ/20240224091001.png)

![image-20240224091142102](https://raw.githubusercontent.com/Eat-garlic/picture/master/CWZJ/20240224091142.png)







![image-20240224091706055](https://raw.githubusercontent.com/Eat-garlic/picture/master/CWZJ/20240224091706.png)



* 时间窗口
* 请求数量 
*  错误率    就是你请求十次，有2次以上都出现 异常了，才会触发熔断



这三个

![image-20240224091922542](https://raw.githubusercontent.com/Eat-garlic/picture/master/CWZJ/20240224091922.png)







![image-20240224093629428](https://raw.githubusercontent.com/Eat-garlic/picture/master/CWZJ/20240224093629.png)







## 引出了消息队列和redis 这些技术 







调用的是这个方法 ，如果用系统的资源隔离有两种，第一种线程池（线程方式的资源隔离），第二种是信号量，也就是讲如果 没有熔断，会继续用线程池来执行被调用服务的方法 ，如果出现异常就返回异常就好了





![image-20240225084711961](https://raw.githubusercontent.com/Eat-garlic/picture/master/CWZJ/20240225084712.png)

![image-20240225083727582](https://raw.githubusercontent.com/Eat-garlic/picture/master/CWZJ/20240225083727.png)





## ![image-20240224201039776](https://raw.githubusercontent.com/Eat-garlic/picture/master/CWZJ/20240224201039.png)

这张图要看懂

如果 调用端调用 被调端， 服务端熔断中如果有缓存直接用缓存 中的处理方式 就可以 了， 如果没有缓存，并且 开了熔断，我们就要看服务端是否开启了熔断开关，直接走熔断就好了， 但是熔断如果 三个条件没有满足 ，

服务器默认会看看你这个方法 中可配置了线程池和信号量的参数，如果没有配置，直接走fallback，降级处理，如果有配置  

进行资源隔离，默认的资源隔离是线程，有默认的十个线程可以 给你使用，这十个线程的资源占尽后，你要是还往这上面发，就会走fallback，错误处理的方法 ，如果这十个线程中出现了异常或者超时也走fallback方法 ，



还有一种是信号灯，信号灯的逻辑和线程池是差不多的



如果都没问题，返回 正常结果 



、













## hystrix和feign的熔断和超时  

详情在zuul网关前面十几分钟 处

一定要记住hystrix的熔断超时时间 一定要大于ribbon，如果小于的话直接 走了hystrix那ribbon就没有任何 意义 了，当然 是先走ribbon，再走hystrix



![image-20240225110256135](https://raw.githubusercontent.com/Eat-garlic/picture/master/CWZJ/20240225110256.png)

![image-20240225104902305](https://raw.githubusercontent.com/Eat-garlic/picture/master/CWZJ/20240225104902.png)

![image-20240225105048787](https://raw.githubusercontent.com/Eat-garlic/picture/master/CWZJ/20240225105048.png)

![image-20240225105606931](https://raw.githubusercontent.com/Eat-garlic/picture/master/CWZJ/20240225105607.png)