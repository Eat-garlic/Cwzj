# 引入 Dao

一步一步的接近正式开发

 先开始 我们需要 写一些代码 来操作数据库

从前台保存数据到数据库中

![image-20220516091659970](https://raw.githubusercontent.com/jinkex55/picture/master/images20220516091700.png)



从数据库中显示东西到前台 

![image-20211210071355182](https://raw.githubusercontent.com/Eat-garlic/picture/master/img/20240204155401.png)

等等



这些都 是对于customer这个表的查询 与操作，这样写有个不好的地方 在于，servlet代码 和操作数据库 的代码 夹杂在一起，不分明，在这里要是能让servlet的代码 和 操作数据库 的代码 分开，这样会更有逻辑

在这里我们要优化下，将数据库中的代码 单独 的写到一个类中去，又因为这个servlet是对customer这个表的操作，所以我们在java中就引用 了一个Dao的概念，是专门 用来操作数据库表的

![image-20211210072144797](https://raw.githubusercontent.com/Eat-garlic/picture/master/img/20240204155417.png)

数据访问对象 ，专门 用来拿数据 的，操作数据 的    一般套路是你操作哪个 数据库就直接 xxxDao证明 操作这个数据库的







## 封装到Dao类中，将这个对象的类型作为Servlet类的成员变量，置使Servlet 对象 来调用

![image-20211210072439080](https://raw.githubusercontent.com/Eat-garlic/picture/master/img/20240204155429.png)

![image-20211210072452357](https://raw.githubusercontent.com/Eat-garlic/picture/master/img/20240204155442.png)













![image-20211210073333250](https://raw.githubusercontent.com/Eat-garlic/picture/master/img/20240204155454.png)

SaveServlet.java同理 

这样层次就分明了

![image-20211210080709226](https://raw.githubusercontent.com/Eat-garlic/picture/master/img/20240204155508.png)



# 抽方法    将很多 servlet共同的代码抽取到一个工具类的方法中去，变成 通用的

![image-20211210081045766](https://raw.githubusercontent.com/Eat-garlic/picture/master/img/20240204155626.png)



这些很多 代码都重复了，要优化， 一步步的抽取 将公用的代码全都抽取出来放到一个方法 中去，让这个方法 成为通用的方法 ，

![](https://raw.githubusercontent.com/Eat-garlic/picture/master/img/20240204155652.png)



![image-20211210082128969](https://raw.githubusercontent.com/Eat-garlic/picture/master/img/20240204155706.png)





# 德鲁伊连接池

我们的代码 每次连接一次数据库都 会调用 DriverManage.getConnection来拿连接 ，用完后再关闭，这样连接 关闭会浪费 大量的cpu资源，造成不必要的浪费 ，这里我们可以用alibaba的一个框架 来让我们有个连接 池，我们使用时，只需要 将这个框架的jar包引入 进来 ，然后







![image-20211210093619159](https://raw.githubusercontent.com/Eat-garlic/picture/master/img/20240204155728.png)



## 需要配置的参数，可以在官方 文档上去找还有哪些是可以 配置 的

![image-20211210093605137](https://raw.githubusercontent.com/Eat-garlic/picture/master/img/20240204155739.png)









![image-20211210095825617](https://raw.githubusercontent.com/Eat-garlic/picture/master/img/20240204155752.png)con不要放到try里面

![image-20211210100441058](https://raw.githubusercontent.com/Eat-garlic/picture/master/img/20240204155821.png)

DataSource对象你可以理解为连接池  





# SpringJdbc

利用SpringJdbc进一步来优化jdbc的代码 ，

 

springJdbc中有个核心类

SpringJdbcTemprte,构造方法 需要传入一个DataSource对象然后利用核心类的引用 tpl直接替换掉之前 自己抽取 的方法 ，可以无缝衔接这个代码 

![image-20211210101813025](https://raw.githubusercontent.com/Eat-garlic/picture/master/img/20240204155834.png)

![image-20211210103843776](https://raw.githubusercontent.com/Eat-garlic/picture/master/img/20240204155846.png)

