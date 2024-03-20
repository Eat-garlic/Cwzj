# 为什么要使用Mybatis 框架  

​        说起Mybatis框架， 我们要知道它是用来做什么的，显然它是用来访问数据库用的

​         我们在之前 的xmg resum项目中依次用纯jdbc的方式 来访问数据库，里面写的是java组自己提供的api，用来操作数据库，也用的不错， 但是每次连接 时都要创建连接，销毁连接，对我们内存的资源 是一个极大 的损耗，后续用了个技术 ，连接池，我们用druid连接池可以简化 我们对数据库连接的频繁操作， 

而且 在连接 的过程 中 查询 数据 库，我们需要自己写一些方法save()  update()来进行自己手工纯操作，这样对多个单表做一些同样 的操作，我们给它抽取到了Dbs，的工具类中去了，将重复的代码 抽到crud方法 中，将独有的代码 写成参数传进来，这样简化了我们对多张表的重复操作        纯用java组api我们需要 用到连接 池，这个连接池 

​          后来我们用了一个小框架  springjdbc这个框架 里面有个核心类JdbcTemple这个类可以无缝连接连接池， 将连接池传进去后得到一个tmp对象 Tpl， 我们可以直接 用这个tpl来进行一系列的crud，这里面的逻辑这个框架 全写好了，我们只需要用就可以了，里面对于 数据库 的连接和销毁也全都在连接池中， 这点还好，主要就是进行操作数据库时传参数比较麻烦，需要自己一个一个的问号 去和java  bean来为这匹配，这样开发的效率极其缓慢 在大型项目中，如果用这个框架 来开发，显然是不可取的 

​          Mybatis这个框架 就可以解决上面的很多 问题



# 课件

Java从0到架构师③课堂资料
链接：https://pan.baidu.com/s/1ickELf9Utm1fAwGuPAdWDw 
提取码：3333 



# 查询

## xml文件 

xml文件和 html文件很像，xml文件需要 一个文件 说明 

![image-20211223104520340](https://raw.githubusercontent.com/Eat-garlic/picture/master/img/20240204163130.png)



就像上面的一样的pom.xml我们可以通过 第一个来确认xml的版本信息，然后在拷贝一些东西来确认这个xml能够 写哪些内容 ，这也就是为什么 这个xml可以写一 些标签 的原因 ，之所以 有些标签 可以写，有些标签 不能写，就是因为有这个约束文件，好了，知道 这里后

Mybatis里面需要 写一个基本的Mybatis的基本配置 文件 ，用来配置mybatis这个库的一些基本使用信息， 一般我们称之为Mybatis-config.xml这个文件是在web项目 resources下面下， 这个xml也需要写一个版本和约束，可以从mybatis网上找到这两个文件 ，有了这两个 东西那么 整个配置文件的xml需要写什么标签就能确定，写其他 标签 就报错

## 设计思路，如果我是Mybatis,我要怎样设计 这个框架 



将相关的依赖导入进来   依赖    Mybatis   和   mysql![image-20211223115903425](https://raw.githubusercontent.com/Eat-garlic/picture/master/img/20240204163150.png)





## 使用步骤

你创建好核心配置 文件 后，在项目 中需要查询数据库的地方就需要使用这个mybatis组提供 的类了，我们可以通过项目来直接用组提供的类来操作数据库了，

 简单的操作步骤

```java
Reader reader  =  Resource.getResourceAsStrean("mybatis-congig.xml");//装载核心配置文件 

SqlSessionFactory factory = new SqlSeesionFactoryBuilder(reader);//需要一个工厂构建器，工厂构造器来构造工厂，工厂需要mybatis的核心配置文件内的信息，以方便知道数据源呀，转换格式等等

SqlSession session  factory.openSension();  //然后用一个工厂来openSenssion方法 来获得一个 （Session对象 OneLateI. error）Sqlsession对象

 seesion.   C  R  U  D   方法//用这个Seesion对象直接来操作数据库
```

![image-20230213072009326](https://raw.githubusercontent.com/Eat-garlic/picture/master/img/20230213072009.png)

得到 这个seesion对象后，我们便可以用这个对象中的很多 方法 ，这是Mybatis组内给我们写好的crud逻辑 ，我们直接 拿来就能用了，怎么用呢

session.update()，方法内接收一个String类型参数 ，回想以前，我们执行这个方法 的时候 是不是要传入 sql语句 和一些参数，这里面的参数其实 就是告诉程序去哪里加载sql， 告诉  映射文件 的位置 ， 这里可以通过 namespance， 加id 来找到我们需要 执行的那条 sql， 这样就加载 出来了我们需要 的查询出来 的对象 。





### 核心配置文件   Mybatis-config.xml内的标签

标签中配置有先后顺序的

- <configuration>中的<environment>标签：

  有个环境标签envirotes  里面可以配置 很多个环境 envirote, 每个这个标签 都会有个id，然后我们只需要在环境标签 下面写上默认属性的标签就好这个标签 下面可以配置数据 源对象  dataSource这个对象 是jdbc类中的，里面有很多 属性可以配置 

![image-20211223141629182](https://raw.githubusercontent.com/Eat-garlic/picture/master/img/20240204163212.png)



- <settings>中的<setting>标签：

  数据库里面的字段有些是两个 字母的，java中实体bean的属性一般是小驼峰的，这种转换成实体的javabean 

mybatis默认不会转为对应的字段，所以要在标签里面配置

![image-20211223141234365](https://raw.githubusercontent.com/Eat-garlic/picture/master/img/20240204163223.png)

  

- mapper标签：

  实体映射标签

 

### 设计逻辑

查询数据库需要有数据库对应的javabean，准备好bean，然后我们通过在resource下面创建一个mapper文件夹，里面创建一些实体映射的文件 ， 什么 映射呢，就是代码去哪里执行sql语句 ，且sql语句执行后返回的一些东西，我们要告诉 mybatis，这个文件夹里面的查询一些表的，或者 crud一些表的一个载体配置 文件     程序运行怎么装载这个配置 文件 呢， 如果按照  正常情况下写Java代码去装载这个mapper配置 文件 的话，

太麻烦 ，而且 这个实体文件还不只一个，会有很多 个，如果都 用java代码 去装载显然是不明智的， 这里Mybatis组的人员他们肯定知道 ，我们的程序 既然要去加载这个mybatis-config.xml的文件，那么程序 一定是要加载过来的，这时，直接将映射配置文件的路径写在My配置文件 中，程序便能知道 去哪里去加载 映射配置 文件 ，这样就省去了我们自己人为去加载映射配置文件  在 Mybatis-config.xml中配置

![image-20211223134822876](https://raw.githubusercontent.com/Eat-garlic/picture/master/img/20240204163235.png)



## 实体映射配置文件内的标签

  resource---》 mapper----> xx bean.xml 



- <namespance>标签：

  命名空间，用来确定的找到哪个 实体的

  

  CRUD标签内的属性resultype

  查询到的内容是返回的是哪种类型的

  CRUD标签内的属性resultMap

  单表也可以使用，我们使用sql在返回到一个对象时， 在

  ![image-20230213071158989](https://raw.githubusercontent.com/Eat-garlic/picture/master/img/20230213071159.png)



(这个resultMap的id),引用别处的result Map ，别处的resultMap



![image-20230213071408387](https://raw.githubusercontent.com/Eat-garlic/picture/master/img/20230213071408.png)



里面除了有两个属性，一个是Id,还有个是Type,  type就是返回 的是什么 类型的， 然后在这个resultMap标签内，我们可以对这个结果 来进行一一的映射，对应 ，用到Result标签，里面有两个属性propert和  column    前者代表javabean中的属性，后者代表数据库中的字段列 ，因为 是单表，如果没有复杂的两个单表的列，我们可以不写对应关系 mybatis会自动 给我们全都一 一对应 好，如果有两个单表的转换映射 ，必须要写好bean属性名和数据库id名才能映射 起来，否则，映射对不起来，查询到的对象就没这个属性的值 



这个查询出来 的和上面的作映射

![image-20230213075233895](https://raw.githubusercontent.com/Eat-garlic/picture/master/img/20230213075234.png)



 CRUD标签内的属性parameterType   是参数的的类型

![image-20230213071526430](https://raw.githubusercontent.com/Eat-garlic/picture/master/img/20230213071526.png)



 多表

![image-20230213071601728](https://raw.githubusercontent.com/Eat-garlic/picture/master/img/20230213071602.png)

  直接指定查询出来的列column直接对应 成员变量对象.属性上面去， 这样才能映射成功，否则映射不成功这点需要注意  或者

![image-20230213071643680](https://raw.githubusercontent.com/Eat-garlic/picture/master/img/20230213071643.png)

在sql语句中就直接写上查询的别名是对应 bean中bean的哪个id







![image-20230213071720738](https://raw.githubusercontent.com/Eat-garlic/picture/master/img/20230213071720.png)

![image-20230213071744623](https://raw.githubusercontent.com/Eat-garlic/picture/master/img/20230213071744.png)







#### resultType 和 resultMap标签内映射可以写的标签

- <id>标签

-  <result>标签 映射对应



### 传参

在使用的过程 中，有些sql语句是需要来传参的，，参数是由方法传来，直接将参数写在方法参数中，我们在sql语句中来接收这个参数， 用# 接收是预编译 的  ，  用$接收是直接 拼串的

![image-20211225101725827](https://raw.githubusercontent.com/Eat-garlic/picture/master/img/20240204163314.png)

![image-20211225101902494](https://raw.githubusercontent.com/Eat-garlic/picture/master/img/20240204163325.png)

![image-20211225101914923](https://raw.githubusercontent.com/Eat-garlic/picture/master/img/20240204163336.png)







## 几种不同形式的传参 占位方式

Mybatis是# ｛参数｝  ￥ ｛参数 ｝ 占位



jdbc连接数据库是用 变量  参数 名来占位       

![image-20211227114730676](https://raw.githubusercontent.com/Eat-garlic/picture/master/img/20240204163348.png)





Springjdbc  中的jdbctemp    是问号来占位



# 增删改

## 添加 

在db中添加 一行数据 进去想要可以是可以，但是一般是得不到这条数据的id 主键 的， 怎样才能获取到新添加 的数据 的id呢， 因为是多线程，所以不能再写一条sql来查询 这个id 可能 你在查的同时 又有插入 

 这时我们需要添加数据完成后就能打印出这条数据 的主键 id,利用这这个主键来做其他的业务 

两种写法：

第一种：

![image-20211227125400579](https://raw.githubusercontent.com/Eat-garlic/picture/master/img/20240204163359.png)

```sql
<insert  id = "insert"， parameterType= "bean">
     insert into skill (name, level)  VALUES (#{name}, #{level}) 
         <selectkey  resultType=int  keyProperty="id" Order="AFTER" >
               SELECT LAST_INSERT_ID()
         </selectkey>
</insert>
```



第二种：

![image-20211227131447903](https://raw.githubusercontent.com/Eat-garlic/picture/master/img/20240204163411.png)





## 更新 

基本差不多	

![image-20211227132217220](https://raw.githubusercontent.com/Eat-garlic/picture/master/img/20240204163424.png)

```sql
<update  id=update partemerType="全限定名">
      UPDATE skill  set name = #{name}, level = #{level} where id = #{id}
</update>
```







## 删除

![image-20211227132308480](https://raw.githubusercontent.com/Eat-garlic/picture/master/img/20240204163436.png)







# 动态sql

![img](https://raw.githubusercontent.com/Eat-garlic/picture/master/img/20240204163451.png)

 

不动态 要用条件  If else  来限制查询 

动态 就是也用 mapper映射文件中的动态标签条件来限制 ，我传什么 参数 而不需要我们用if else他就能查询 到想要参数符合 条件 的值



二者区别 

![img](https://raw.githubusercontent.com/Eat-garlic/picture/master/img/20240204163512.png)

![img](https://raw.githubusercontent.com/Eat-garlic/picture/master/img/20240204163529.png)









# 集成连接池



mybatis默认是有连接池的，不需要我们自己来配置 

![image-20211227155642567](https://raw.githubusercontent.com/Eat-garlic/picture/master/img/20240204163545.png)

![image-20211227155759846](https://raw.githubusercontent.com/Eat-garlic/picture/master/img/20240204163556.png)



![image-20211227155837647](https://raw.githubusercontent.com/Eat-garlic/picture/master/img/20240204163611.png)









![img](https://raw.githubusercontent.com/Eat-garlic/picture/master/img/20240204163636.png)







![img](https://raw.githubusercontent.com/Eat-garlic/picture/master/img/20240204163651.png)

从这个图就可以看出是会将标签内的属性对应 的值设置到数据源的属性上去







# MyBatis_多表查询_  延迟加载



## 多表查询 

 ### 判断表与表之间的关系 

站在对方 表的角度 下以人为单位 来看对面是  1 还是多， 分别 写在对面 ，最后即是正确的关系 	

![image-20220104003023762](https://raw.githubusercontent.com/Eat-garlic/picture/master/img/20240204163704.png)

例如一个人对应多张银行卡，那么银行卡就是多，  一张银行卡只有一个人能拥有，那么 人就是1  ，所以人对银行卡就是1对多，银行卡对人就是多对一



## 表与表之间很重要的点   (迪卡尔积要在脑中有，基本上就不会出太多错)

怎样看待表的问题  很重要     两张表不管哪个表的字体为外键引用另一个表的主键，都代表这两个表已经有关系了，可以正反来用，来理解



员工表中的外键company_id引用了company表中的主键    cr的cr.company_id是外键，引用cy的id

《我要把customer分别都哪家公司的信息查全》![image-20220104003518097](https://gitee.com/Jinekx_711/markdown-img/raw/master/img/202201040035185.png)

这个我们是站在cr表的角色下，我们要查customer表，自然 这两个表有联系，（cr这个表下面的一个外键 company_id要和cy表的id相等才能查到哪个员工分别在哪个 公司下面  cr.company_id 为外键，引用了cy.id）    

这两个表是主外键关系

《我要把company分别都哪些员工的信息查全》

```
select * from company cy join customer cr on company.id = cr.company.id
```

where后的条件你脑海中要有查询出来 的效果，然后在脑海 中筛选比如这个

select * from company cy join customer cr on company.id  写到这时，两张表的数据已经在你脑海中有了，脑海中就要有迪卡尔的印象，公司信息记录的前面， 员工信息在这条记录的后面，且是迪卡尔积的数据然后要选出我要的，我要公司下面都有哪些员工，自然在迪卡尔乘积中找 公司表的id      要等于   员工表中company_id字段  等于company.id的字段    才符合条件

自然就查出来了



同理![image-20220104003548297](https://gitee.com/Jinekx_711/markdown-img/raw/master/img/202201040035396.png)



站在人的角度上我要查人分别对应 的一张身份证，  《我要把人分别有哪张银行卡的信息查全》

```
select * from person p join id_card ic on where p.id = ic.person_id
```

我就要p .id= ic.person_id    



这个错误一定要记住(由于 设计表的时候人这张表下面没有外键引用 身份证表下面的主键所以这样看查不到)这样看，这两张表虽然没关系



站在身份证的角度上我要查身份证分别都是哪个人，  《我要把身份证对应的个人信息查全》， 

```
select * from id_card ic join person p on ic.person_id = p.id
```

看，这样查的逻辑要清楚些，

![image-20220104003632718](https://raw.githubusercontent.com/Eat-garlic/picture/master/img/20240204163718.png)







# 延迟加载

![image-20220104003855775](https://raw.githubusercontent.com/Eat-garlic/picture/master/img/20240204163730.png)

![image-20220104003902912](https://raw.githubusercontent.com/Eat-garlic/picture/master/img/20240204163741.png)





# 一 二级缓存

一级缓存 是sqlseesion级别的， 在同一个seesion里面只要不更新 comit,同样的查询 返回 的一定是同一个对象



二级缓存 是namespace级别 的，可以理解 为  k  为namespace  v为查询出来 的值 ，在同一个mapper文件 中是共享的 







# Mybatis整合 DAO

![image-20220104005204594](https://raw.githubusercontent.com/Eat-garlic/picture/master/img/20240204163756.png)

![image-20220104005209898](https://raw.githubusercontent.com/Eat-garlic/picture/master/img/20240204163806.png)

![image-20220104005217727](https://raw.githubusercontent.com/Eat-garlic/picture/master/img/20240204163817.png)











# springjdbc  和mybatis明显的区别

![img](https://raw.githubusercontent.com/Eat-garlic/picture/master/img/20240204163830.png)

![img](https://raw.githubusercontent.com/Eat-garlic/picture/master/img/20240204163844.png)

![img](https://raw.githubusercontent.com/Eat-garlic/picture/master/img/20240204163856.png)
