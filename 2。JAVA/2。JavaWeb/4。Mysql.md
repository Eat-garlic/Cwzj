# 创表语句和sql语句 



只有多练习，才能记得住，这时略过





# 主键外键

## 主键

一个表保证一行数据的唯一性会引入 一列为Id的列名，这个列名通常是自增的，称之为主键 可以保证每一行数据的不重复性，也会有联合主键 ，就是两列共同作为一个主键，两个列不一样即可，主键一般和业务无关

![image-20211206145827938](https://raw.githubusercontent.com/Eat-garlic/picture/master/img/20240204154635.png)



##  外键

当我们的表中出现了很多重复的数据时，比如下面customer表记录着的很多客户都是来自于同一家公司 ，那么这个公司可能会有很多相同的信息，这样对于数据的操作，很不方便，如果公司信息修改了，那么要修改表中的所有信息，这种情况 下便引入 了外键





### 理解 哪个为外键，  是小表被寄主表的 额外字段

![image-20211206150337398](https://raw.githubusercontent.com/Eat-garlic/picture/master/img/20240204154651.png)

### 这个用sql语句创建出来 

![img](https://raw.githubusercontent.com/Eat-garlic/picture/master/img/20240204154702.png)

```sql
CREATE TABLE company (
id INT AUTO_INCREMENT PRIMARY KEY, 
name VARCHAR(20)NOT null UNIQUE, 
adress VARCHAR(20)
); 

CREATE TABLE customer (
id INT AUTO_INCREMENT PRIMARY KEY,
name VARCHAR(20) NOT NULL,
age INT,
company_id INT
FOREIGN KEY (company_id) REFERENCES company(id)
);

INSERT INTO company (name, adress) VALUES ('阿里巴巴‘, ’杭州‘);
INSERT INTO company (name, adress) VALUES ('腾讯‘, ’深圳‘);


INSERT into customer (name, age , company_id) VALUES ('张三’, 18, 1);
INSERT into customer (name, age , company_id) VALUES ('李四’, 20, 2);
INSERT into customer (name, age , company_id) VALUES ('王五’, 25, 1);
```





​	

# 多表查询   join_on     leftjoin  right join的区别 

## 需求：查询每个客户在哪家公司

![img](https://raw.githubusercontent.com/Eat-garlic/picture/master/img/20240204154716.png)

### 实现一

```sql
SELECT
  cr.NAME cr_name,
  cy.name cy_name
FROM
  customer cr,
  company cy
WHERE
cr.company_id = cy.id

```

from后面表的连接很重要，如果用，连接便会产生迪卡尔集，会将第一张表的每一行数据 都 和每二张表的每行数据进行连接查询一次 然后利用whert条件来筛选符合要求 的，上面两张表因为cr的company_id是外键  引用cy的主键 id字段，所以符合两个字段相等的一定是我们需要 的数据



### 实现二

这个需求可以换一种实现 ，用逗号连接两个表会产生 迪卡尔乘积，我们可以用join连接两个表，

```sql
SELECT
  cr.NAME cr_name,
  cy.name cy_name
FROM
  customer cr join
  company cy
on
cr.company_id = cy.id
```

上面 的是符合On 的就是内连接

符合on的是两表相交的部分，不符合on的看是Leftjoin 还是rightjoin  

leftjoin简言之就是就是以第一张表为主，不符合on条件的也查询出来， 按上两张表为例，就是能查询出不符合条件的比如：customer客户就算 没有公司 也能查询出来公司，查询出来的结果就是cmpany有些字段显示Null

rightjoin简言之就是以第二张表为主，不符合On的条件也能查询出来 ，按上两个表为例 ，就是能查询出不符合条件 的比如：company公司就算没有客户也能查询出来客户，查询出来的结果就是customer有些字段显示Null



### 为什么where后面的条件相等了就可以

![image-20211229071435967](https://raw.githubusercontent.com/Eat-garlic/picture/master/img/20240204154730.png)



















# on 和where的区别

On只能用来表与表之间的连接条件   ， 一般用于join后面，当然也可用于“，” 后面

where不仅可以用来表示连接条件 还可以在查询后的结果上再做一次筛选 



![image-20230215080636731](https://raw.githubusercontent.com/Eat-garlic/picture/master/img/20240204154746.png)



# IN

=只是一个值，查询 出来 

In可以 有多个

![img](https://raw.githubusercontent.com/Eat-garlic/picture/master/img/20240204154802.png)

![img](https://raw.githubusercontent.com/Eat-garlic/picture/master/img/20240204154824.png)





# 子查询

![img](https://raw.githubusercontent.com/Eat-garlic/picture/master/img/20240204154840.png)

# 疑问 

##　为什么mysql   列表 加Unique 就叫唯一索引   这个行为为什么叫索引    mysql高级部分会有讲



![image-20211206150003955](https://raw.githubusercontent.com/Eat-garlic/picture/master/img/20240204154852.png)

![image-20211206150018367](https://raw.githubusercontent.com/Eat-garlic/picture/master/img/20240204154905.png)





# 怎样看待表的问题  很重要     两张表不管哪个表的字体为外键引用另一个表的主键，都代表这两个表已经有关系了，可以正反来用，来理解

员工表中的外键company_id引用了company表中的主键    cr的cr.company_id是外键，引用cy的id





《我要把customer分别都哪家公司的信息查全》

![image-20211229085734641](https://raw.githubusercontent.com/Eat-garlic/picture/master/img/20240204154919.png)

这个我们是站在cr表的角色下，我们要查customer表，自然 这两个表有联系，（cr这个表下面的一个外键 company_id要和cy表的id相等才能查到哪个员工分别在哪个 公司下面  cr.company_id 为外键，引用了cy.id）    

这两个表是主外键关系





《我要把company分别都哪些员工的信息查全》

```sql
select * from company cy join customer cr on company.id = cr.company.id
```

where后的条件你脑海中要有查询出来 的效果，然后在脑海 中筛选比如这个

select * from company cy join customer cr on company.id  写到这时，两张表的数据已经在你脑海中有了，脑海中就要有迪卡尔的印象，公司信息记录的前面， 员工信息在这条记录的后面，且是迪卡尔积的数据然后要选出我要的，我要公司下面都有哪些员工，自然在迪卡尔乘积中找 公司表的id      要等于   员工表中company_id字段  等于company.id的字段    才符合条件

自然就查出来了









同理

![image-20211229060741237](https://raw.githubusercontent.com/Eat-garlic/picture/master/img/20240204154931.png)



站在人的角度上我要查人分别对应 的一张身份证，  《我要把人分别有哪张银行卡的信息查全》， 

```sql
select * from person p join id_card ic on where p.id = ic.person_id
```

我就要p .id= ic.person_id    

 #### 这个错误一定要记住(由于 设计表的时候人这张表下面没有外键引用 身份证表下面的主键所以这样看查不到)这样看，这两张表虽然没关系





站在身份证的角度上我要查身份证分别都是哪个人，  《我要把身份证对应的个人信息查全》， 

```sql
select * from id_card ic join person p on ic.person_id = p.id

```

看，这样查的逻辑要清楚些，



![image-20211229062305317](https://raw.githubusercontent.com/Eat-garlic/picture/master/img/20240204154945.png)

![image-20211229062249558](https://raw.githubusercontent.com/Eat-garlic/picture/master/img/20240204155006.png)

















# 查询出来的数据 增加自己想要的字段，改名或者合并字段操作

## 需要在表中添加 一列自己需要的字段，可以在select 里面加个字段，后面写上别名 ，查询出来自然会跟着出来



![img](https://raw.githubusercontent.com/Eat-garlic/picture/master/img/20240204155023.png)





![](https://raw.githubusercontent.com/Eat-garlic/picture/master/img/20240204155037.png)













#   MySql数据库的存储类型选择



![image-20221227093358249](https://raw.githubusercontent.com/Eat-garlic/picture/master/img/20240204155052.png)



两个字节的大小

16位

16个小格子

unsignm 就是无符号  32767*2   的大小 

![image-20230212090256267](https://raw.githubusercontent.com/Eat-garlic/picture/master/img/20230212090256.png)





![image-20221227093419107](https://raw.githubusercontent.com/Eat-garlic/picture/master/images20221227093419.png)



![image-20221229152135599](https://raw.githubusercontent.com/Eat-garlic/picture/master/images20221229152135.png)

比如身份证 使用char(18)后面加字符， 这样可以省空间









int(1)、tinyint(4) 哪个大？              int 大。
注意数字类型后面括号中的数字，不表示长度，表示的是显示宽度，这点与 varchar、char 后面的数字含义是不同的。
也就是说不管 int 后面的数字是多少，它存储的范围始终是 -2^31 到 2^31 - 1。



综上整型的数据类型括号内的数字不管是多少，所占的存储空间都是一样
tinyint一个字节   smallint  两个字节   MEDIUMINT三个字节  

varchar  char  中的括号 char(1)表示一个字符，如 'a'  '男' 表示字符个数

varchar(50)  可以储存50个字符







tinyint 后面加个4是什么 意思 

表示的是显示宽度







varchar  和char有什么区别

![image-20230212091738015](https://raw.githubusercontent.com/Eat-garlic/picture/master/img/20230212091738.png)











## 设计表





![image-20230212091948169](https://raw.githubusercontent.com/Eat-garlic/picture/master/img/20230212091948.png)

![image-20230212092204993](https://raw.githubusercontent.com/Eat-garlic/picture/master/img/20230212092205.png)









# 事务 

