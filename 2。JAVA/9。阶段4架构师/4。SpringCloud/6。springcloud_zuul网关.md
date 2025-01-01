## 前言

我们的单体项目有些重要的项目应用 是不能让外网直接访问的，这时候 就要自己 写servlet 也就是拦截器来进行一个判定，不能让一些请求直接 进来 ，只能让符合要求 的请求可以 进来 ，通过拦截器来进行筛选，这个时候我们进行的一个筛选保护我们的项目 。  但是 微服务我们必须如果要保护 应用，每个项目 都得进行一个拦截，这样很多的重复代码，这时在地铁上的大神就又写了一组类库，是专门来解决这个问题的，也就是下面要学习的







![image-20240226093319904](https://raw.githubusercontent.com/Eat-garlic/picture/master/CWZJ/20240226093320.png)







当服务多了的时候   可以用idea的 dashBoard

![image-20240226093803447](https://raw.githubusercontent.com/Eat-garlic/picture/master/CWZJ/20240226093803.png)

![image-20240226093932537](https://raw.githubusercontent.com/Eat-garlic/picture/master/CWZJ/20240226093932.png)

可以 批量启动

![image-20240226094127608](https://raw.githubusercontent.com/Eat-garlic/picture/master/CWZJ/20240226094127.png)





# 原理，理解这个就行了

![image-20240226094453736](https://raw.githubusercontent.com/Eat-garlic/picture/master/CWZJ/20240226094453.png)

其实也这个地铁上的大神用了拦截器作了一个  逻辑处理zuulservlet ，可以 让某些请求直接 转发到对应 的url上面去，其实也不难理解的



上面图片 只能用于某个端口的app，如果服务端这个有很多服务 ，服务的集群，这时你不能说只访问 某个服务，这显然是不现实 的，这时候就可以在zuul网关中添加 注册 中心的服务名称 ，这时，调用 端会自动 的帮我们进行一个负载均hen

![image-20240226100617898](https://raw.githubusercontent.com/Eat-garlic/picture/master/CWZJ/20240226100617.png)





有个默认规则

![image-20240226101224895](https://raw.githubusercontent.com/Eat-garlic/picture/master/CWZJ/20240226101224.png)

![image-20240226101339817](https://raw.githubusercontent.com/Eat-garlic/picture/master/CWZJ/20240226101339.png)







里面做的一些流程

![image-20240226102043745](https://raw.githubusercontent.com/Eat-garlic/picture/master/CWZJ/20240226102043.png)





## zuuoservlet做了哪些事情  

在zuul网关这节的1分23秒处，源 码

![image-20240226112712174](https://raw.githubusercontent.com/Eat-garlic/picture/master/CWZJ/20240226112712.png)

![image-20240226113050849](https://raw.githubusercontent.com/Eat-garlic/picture/master/CWZJ/20240226113050.png)





![image-20240226120054000](https://raw.githubusercontent.com/Eat-garlic/picture/master/CWZJ/20240226120054.png)

会调到ribbonRoutingFilter这个处理器

![image-20240226120326443](https://raw.githubusercontent.com/Eat-garlic/picture/master/CWZJ/20240226120326.png)







## 为什么zuulservlet可以有作用

![image-20240226120609247](https://raw.githubusercontent.com/Eat-garlic/picture/master/CWZJ/20240226120609.png)



看到没有xx什么的Configuration 自动 装配  和小码哥springboot讲的自动 装配那个 一起来学习

![image-20240226120544511](https://raw.githubusercontent.com/Eat-garlic/picture/master/CWZJ/20240226120544.png)

程序会为我们创建 这个对象 ，当没有这个对象的时候 ，交给容器管理 了

![image-20240226120844269](https://raw.githubusercontent.com/Eat-garlic/picture/master/CWZJ/20240226120844.png)



然后 进行一个请求拦截  

![image-20240226121020381](https://raw.githubusercontent.com/Eat-garlic/picture/master/CWZJ/20240226121020.png)





![image-20240226153040489](https://raw.githubusercontent.com/Eat-garlic/picture/master/CWZJ/20240226153040.png)





![image-20240226153122672](https://raw.githubusercontent.com/Eat-garlic/picture/master/CWZJ/20240226153122.png)









## 用网关进行一个鉴权





![image-20240226170257568](https://raw.githubusercontent.com/Eat-garlic/picture/master/CWZJ/20240226170257.png)







自己 定义一个类，继承地铁高人写的组件 zuul中的一个zuulFilter然后重写  其中 的方法 

![image-20240226171316981](https://raw.githubusercontent.com/Eat-garlic/picture/master/CWZJ/20240226171317.png)







具体的逻辑如下图

![image-20240226173708745](https://raw.githubusercontent.com/Eat-garlic/picture/master/CWZJ/20240226173709.png)





![image-20240226181815657](https://raw.githubusercontent.com/Eat-garlic/picture/master/CWZJ/20240226181815.png)





# 为什么写了@EnableZuulProxy就能找到相对应的类呢，这是什么 逻辑 呢

![image-20240226183206482](https://raw.githubusercontent.com/Eat-garlic/picture/master/CWZJ/20240226183206.png)







![image-20240226183448215](https://raw.githubusercontent.com/Eat-garlic/picture/master/CWZJ/20240226183448.png)





如果用后面的，这三个过滤器就没了，下面的程序就直接走不了了

![image-20240226184416161](https://raw.githubusercontent.com/Eat-garlic/picture/master/CWZJ/20240226184416.png)





![image-20240226184600375](https://raw.githubusercontent.com/Eat-garlic/picture/master/CWZJ/20240226184600.png)







## 自动装配的原理







![image-20240226190558427](https://raw.githubusercontent.com/Eat-garlic/picture/master/CWZJ/20240226190558.png)







![image-20240226190847234](https://raw.githubusercontent.com/Eat-garlic/picture/master/CWZJ/20240226190847.png)



![image-20240226190829148](https://raw.githubusercontent.com/Eat-garlic/picture/master/CWZJ/20240226190829.png)





![image-20240226190929079](https://raw.githubusercontent.com/Eat-garlic/picture/master/CWZJ/20240226190929.png)



 

![image-20240226191134741](https://raw.githubusercontent.com/Eat-garlic/picture/master/CWZJ/20240226191134.png)









![image-20240226191945651](https://raw.githubusercontent.com/Eat-garlic/picture/master/CWZJ/20240226191945.png)





三个的过滤器的意义 

1. ribbonFilter 这个是调用 的
2. 注册中心的服务过滤器，这个是用来调用 服务名称 的过滤 
3. 还有个url 是表示 这个项目 中，硬编码 就靠这个来调用 









![image-20240227174640973](https://raw.githubusercontent.com/Eat-garlic/picture/master/CWZJ/20240227174641.png)