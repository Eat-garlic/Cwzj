## mysql高手是怎样炼成的



### GPL

gpl协议 ，  是一个大家必须要遵守的一个协议，你在开源的基础上开发 出来的系统，必须开源 





### 如果问是oracle数据库怎么办，Mysql和这个有写的sql有什么区别 

关系型数据库的sql格式的书写都一样，区别是函数的不同

有什么区别 ，什么是函数 ，   两个 数据库的函数不同

![image-20240310174549313](https://raw.githubusercontent.com/Eat-garlic/picture/master/CWZJ/20240310174549.png)



### 分库分表

Mysql单表的访问操作量是500万条，如果超过了或者服务器承载不了，就需要水平分表，相同的表，分表也是在另一个服务器上，这个操作叫作水平分表  比如搞两个服务器，一台服务器我的表我放一半数据，另一台服务器的表放一半数据，这样就解决 了这个问题



单个数据库的访问是5000万条，如果这个库的系统资源不够，我在另台服务器上弄个相同的库，垂直拆分，分布式数据库，垂直的拆分开来，相同 的数据库放在两台不同的机器 上，库中表的一半放在一台机器上，另一半放在另一台机器上







### 公司的dba及整个小型的一个结构

怎样才能成为dba

中小每个公司一般只有一到二个dba，你如果 想成为dba ， 只有在java岗位上完成 的很好，然后 在和项目 经理沟通 ，自己要亲历亲为的去跟着公司的dba去学，只有这样才可能 成为dba，市面上没有课程 ，这个工作 需要 亲历亲为的经验的



#### mysql高手是怎样炼成的

![image-20240310172111400](https://raw.githubusercontent.com/Eat-garlic/picture/master/CWZJ/20240310172111.png)









这张图片是什么意思usr/bin里面的命令

![](https://raw.githubusercontent.com/Eat-garlic/picture/master/CWZJ/20240311021827.png)







## group by  的用法 



![image-20240311194745481](https://raw.githubusercontent.com/Eat-garlic/picture/master/CWZJ/image-20240311194745481.png)





要求：查出各班级的最大年龄

一般都会是这样写的

```sql
select id , name , class, age(max) from test.student order by class
```

这个意思 是以classs的列名为一个组，将class一个为组  查各班级，就是以班级为一个组



这样写在sql 99的标准 是可以 写的 ，但是查出来的结果是不对的，99的标准 是分组以外的列，它是随机找一个值去匹配的，比如     按99年的标准，可以 写，也可以 执行，结果错误



sql如果用99年标准的sql写法

![image-20240311200222333](https://raw.githubusercontent.com/Eat-garlic/picture/master/CWZJ/image-20240311200222333.png)

  如果 这时将sql_mode改成92年 的标准，像上面那样写是不通过的，会报错          按92的标准 是可以写，执行不出来，92的标准 是select 后 面的字段只能是函数 和group by分组的字段 ， 不然 会出现 随机 找个值的情况 ，这样的话我们出来 的结果 也是错误 的![image-20240311203015127](https://raw.githubusercontent.com/Eat-garlic/picture/master/CWZJ/image-20240311203015127.png)



怎么解决 个问题呢![image-20240311201812460](https://raw.githubusercontent.com/Eat-garlic/picture/master/CWZJ/image-20240311201812460.png)



最常用的两种方法

![image-20240311202553770](https://raw.githubusercontent.com/Eat-garlic/picture/master/CWZJ/image-20240311202553770.png)









## linux系统上安装 mysql

### 启动mysql





# sql预热

#####  自己 写出那些 sql 



把课件都下载上 linux也安装 上

来开干 





# 







