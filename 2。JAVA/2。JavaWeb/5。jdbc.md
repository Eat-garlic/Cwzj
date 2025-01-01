# 解决用代码操作数据库的问题---->jdbc的由来 

学完数据库，我们可以操作数据库，用可视化软件 或者 命令台，

但是无法直接用java代码来操作数据库，这个时候 我们就想怎样可以直接用Java代码 可以操作数据库，这样我们便可以在代码内连接数据库，这样就能方便很多 

如果想要实现Java代码内实现可以操作数据库，这是jdk组的人研究的问题

 这时候 Jdk组就设计 了一组组接口，将这个接口放到 java.sql包中，作为jdk的一部分， 下载jdk时就自带了这个包， 这个包里面设计了很多 接口，这个接口是需要 各大数据库厂商来实现的接口，只有实现 了这个接口，才能在java代码中直接用代码来操作这个数据库

同时每个不同 的数据库厂商都需要实现同java.sql下面的api才能和java代码联系，这样开发人员只需要用java.sql包中的同一套api就可以操作不同的数据库，因为不同数据库都实现 了api，开发人员一个api调用直接调到数据库的内部获取到了连接，不需要知道每个数据库内部具体怎样连接的，内部的连接java程序员不用关心

![image-20240310154336956](https://raw.githubusercontent.com/Eat-garlic/picture/master/CWZJ/20240310154337.png)

我们将java.sql包中的一组组api统称为jdbc，这样我们，用这组组api实现 对数据库的连接，就称为用jdbc来实现操作数据库

![image-20211208114657971](https://raw.githubusercontent.com/Eat-garlic/picture/master/img/20240204155133.png)



## jdbc的使用步骤

```java
Class.forname（com.mysql.jdbc.driver..)
   Connection con = DriverManage.getConnection(数据库配置)
   Statement st  =   con.CreatStatement(sql语句)
      st.execute                            // 错误 ，之前写的exupat.update (st)
```

圈住的东西全都是jdbc家 的

![image-20211208213310537](https://gitee.com/Jinekx_711/markdown-img/raw/master/img/202112082133633.png)

![image-20211208213159837](https://raw.githubusercontent.com/Eat-garlic/picture/master/img/20240204155150.png)







![image-20211208115029500](https://raw.githubusercontent.com/Eat-garlic/picture/master/img/20240204155159.png)







#   sql注入解析



statement这个类会出现 sql注入问题什么 意思 呢

## Statement这个类

这个类是java.sql包里面的一个类，主要 就是用来执行sql语句 的，  这个对象 是通过 连接对象调用 creStatement得来 的，可以通过 这个类来实现 对sql的执行，statement（对象）.execute（String sql）；这样就能执行sql语句 

用这个类来进行sql操作，如果方法中将sql的用户名和密码抽取在了String的参数中，这时用这个用户名和密码查询 数据库，我们可以传参是传用户名和密码 

![image-20211209162116493](https://raw.githubusercontent.com/Eat-garlic/picture/master/img/20240204155211.png)

![image-20211209162704267](https://raw.githubusercontent.com/Eat-garlic/picture/master/img/20240204155223.png)

用这个类的execute()方法 来执行sql语句 ，这个sql语句 是直接 需要 执行时才编译，解析，优化，执行的，因为 execute（String Sql）statement这个对象 调用 execuet时，sql语句 这时才传进去，所以 在这时才对sql语句 来一系列的操作，每调用 方法 执行一次都 会来一次一系列操作，速度比较慢

这个类在执行sql操作时，（如果 sql语句中有参数 需要前台 传进来的情况 下，这时）这个类会直接拼接字符串，![image-20211209163816105](https://raw.githubusercontent.com/Eat-garlic/picture/master/img/20240204155233.png)

就是因为这样的一个机制导致这个类别人能伟一个字符串让sqL 恒等， where 1=1               select* from 什么 表

这样就直接查询了数据库中所有 的东西这样是绝对不可能 的，我们要避免  ，所以 在开发的过程 要重视 这个问题，尽量不要出现sql注入的情况，避免使用这个类



## PreStatement这个类

preStatement这个类是将sql预编译的， 这个类是通过 Connection类中的con.preStatemnet（String sql ）方法得到 的不同的是在得到这个sql执行类时，就要将sql传进去 ，这时，得到 这个类时，sql 一系列的操作已经弄好 了，只需要 等PreStatemnet这个类调用 执行方法 就可以 了速度比较快



这个类在执行sql操作时，（如果 sql语句中有参数 需要前台 传进来的情况 下，这时）这个类就是这个类，这是类行为，类见到sql语句 时，它不会进行拼接，而是将客户输入 的  where1=1这些字符串真正的去数据库里面查，如果真的有这样的账号和密码才给你结果 ，如果 没有这有，就向前台显示账号和密码错误 ，这就是为什么 preStatemnet这个类能做到防止 sql注入的原因、



这个类在运行时，需要编译器 先扫描这个类，因为sql是先传进来 ，编译器会默认的来提前 编译下这个sql，如果sql，这时sql中的参数是用变量占位的，当我预编译好后就等着编译器来编译 了，这时，这条sql语句就不能动了，已经编译好了，你想要里面的参数变为你想要的只能用api进行传参 



而statement则不同

![image-20211227113952123](https://raw.githubusercontent.com/Eat-garlic/picture/master/img/20240204155243.png)

他不是预编译的，他是现编译的，所以是直接 可以将sql和将文的参数来进行拼接，执行到sql后，执行到参数，看有没有参数传进来，如果传进来 就直接 替换掉，而预编译的则不行，替换不了，因为已经 编译好了
