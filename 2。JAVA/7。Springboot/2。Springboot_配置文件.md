## application.xml的属性注入

我们在一个boot项目 中写一个类， 类里面有一些属性可以我们需要 动态的配置 ，那么就可以利用boot的配置文件来进行注入，在需要注入的类中我们写上@Value注解 ，里面加上（变量名）， 然后在配置 文件 中写上



层级 关系 要安排好：然后

​						哪个的变量名 =  什么 ，  



这种情况 下就完成 了注入了



![image-20230217112119907](https://raw.githubusercontent.com/Eat-garlic/picture/master/img/20230217112120.png)





##  yml

yml是boot更推荐的配置文件 

需要注意的是

1:  yml 是用空格和table键进行缩进的

2：冒号后面必须带个空格 （硬性规定）

3：配置文件中的字符串不需要加引号 







![image-20230217113518550](https://raw.githubusercontent.com/Eat-garlic/picture/master/img/20230217113518.png)











##  属性绑定 

###  一些增加开发效率的依赖

写代码时 当要注入配置文件 时，我们要自己写实体类的属性， 这样很麻烦，添加 个依赖就可以智能 的提示我们的属性了

 

写代码时， 代码中的po对象 需要 set 和get方法 时， 我们添加 这个依赖，那么程序在运行时会自动给我们 写上getset方法 （加个@Data)注解 

 ![image-20230217115252827](https://raw.githubusercontent.com/Eat-garlic/picture/master/img/20230217115253.png)





## 属性绑定 

类的属性 和 配置文件 对应 的绑定 





在@ConfigurationProperties 这个注解中的value写上这个类的名称，我们就可以在配置文件 中以这个名称找到对应 的配置类，然后进行属性注入

![image-20230217115437568](https://raw.githubusercontent.com/Eat-garlic/picture/master/img/20230217115437.png)











这节要重新看一遍视频来进行复习式笔记 

![image-20230217115459609](https://raw.githubusercontent.com/Eat-garlic/picture/master/img/20230217115459.png)



![image-20230217120153671](https://raw.githubusercontent.com/Eat-garlic/picture/master/img/20230217120153.png)

![image-20230217131320357](https://raw.githubusercontent.com/Eat-garlic/picture/master/img/20230217131320.png)



![](https://raw.githubusercontent.com/Eat-garlic/picture/master/img/20230217131527.png)















#### springboot中的yml文件 一配，就直接 配置 到对就的类的属性中去了，