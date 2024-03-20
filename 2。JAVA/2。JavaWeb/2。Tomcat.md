# tomcat的理解



## tomcat是什么

Idea一集成tomcat tomcat里面的类就有了，在集成的时候有个servlet-api的jar包，这个jar里面打包着jdk研发人员研发的javax.包中的servlet类及这个servlet的空口，所以idea集成 了tomcat后就能使用这个servlet了，

 servlet-apI 

我们写好一个程序，自己给我们的程序打成一个jar，我们可以自己命名，在这个程序中用到了自己写的一个类，然后导入这个类，这个导入的类和打包的jar的名字不相干

研发人员写好程序，给它们的这个程序打成一个jar， 他们 可以自己命名，程序中用到了他们自己写的一个类（javax.servlet），然后导入这个类，这个类和打成 的jar包名字可以不相干![image-20211205102428750](https://raw.githubusercontent.com/Eat-garlic/picture/master/img/20240204150342.png)

tomcat和servlt的关系 

![image-20211205102503684](https://raw.githubusercontent.com/Eat-garlic/picture/master/img/20240204150358.png)

这个目录下面有个servelet-api的jar包，jar里面有javax.servlet这个类





![image-20240204150419691](https://raw.githubusercontent.com/Eat-garlic/picture/master/img/20240204150419.png)









## 理解tomcat是什么的前提是知道什么 是servlet

servlet是javax包里面的类

​         java包是java  se 类标准的基库， 这是早期java开发的基本类库

​          随着之后的发展，在基本类库的层面上又加了一个拓展的包，这个包的名字就是javax.  而servlet就是在这个扩展包下面的，这是jdk的研发人员在面对web市场写的一个方便处理web方面的类，用这个类可以轻松的处理服务器与客户端之间的连接和交互 ，形成一些可见的功能， 这个类被放入到javax包中

市面上的很多服务器软件都不能支持这个servlet，这个类必须要一个引擎才能将其运行起来， 也就说就算你单独在项目中写这个类，没有引擎这个类是写不出来的，会报错  可以理解成这个类是内嵌在servlet-api这个包中的  ，servlet-api需要下载tomcat才能有

![image-20211204144959991](https://raw.githubusercontent.com/Eat-garlic/picture/master/img/20240204150435.png)



![image-20211205102316904](https://raw.githubusercontent.com/Eat-garlic/picture/master/img/20240204150450.png)

这个引擎的作用是给这个类来提供一些网络服务 ，提供 前台的一些编码格式 的东西，用来管理 这个servlet的生命周期 ，是servlet的外壳程序，并将servlet类的调用 全权都交给 这个引擎 来处理， tomcat就充当着这个引擎的作用



###  网文中提到的servlet容器是什么 

servlet容器是一个被jvm装载一堆servlet对象的器具（内存空间），并且具备管理这些对象的功能，

![image-20211204140219642](https://raw.githubusercontent.com/Eat-garlic/picture/master/img/20240204150505.png)











#  java语言的容器特性

java语言中有容器，比如tomcat，...一些的，这个容器是java，规定符合ｊａｖａ的ｊｃｐ组织规范其他公司自己开发的，为了是让java语言使用者可以更好的开发web应用，那么带servlet容器的这个版本的Java就是javaee ，它有一些se没有的api ，包，类，比如：servlet是javase 中没有的 ，如果 没有javaee这个版本，我们用se来开发一个可以在网站上访问的站点，开发起来是我们在连接http协议时就需要费很大的功夫，而且我们开发出来之后 别人在开发另外 一个站点时，也需要连接http协议，又需要写一些代码，这就造成了代码不能重复利用，需要重复的造轮子，为了解决这一问题，才有了jave ee   









后来，在javaee的发展中，我们servlet这些由ｏｒａｃｌｅ公司自己开发的容器也逐渐被市面上一些好的产品去替代，比如我spring strucs  Java              
官方制定的各种 Java EE 规范反而不z受欢迎，他们制定了 JSF 规范，但实际企业开发喜欢用 Struts 2、Spring MVC；他们制定了 EJB 规范，但实际企业开发往往还是喜欢用 Spring；他们制定了 JPA 规范，但实际企业开发往往还是喜欢直接用 Hibernate、MyBatis









# 总结tomcat

tomcat是什么

tomcat是jdk研发人员编写了一个可以运行servlet的一个引擎（容器）前面 的请求来了，分发给servlet去处理，包括可以管理 servlet的生命周期 

是一个运行在web服务器上的一组jar工具







# tomcat可以处理350个并发

我们自己平时 写的 Java程序 是需要内存的，这里可以理解， 假如 我们自己写的程序 可以承载350个人同时来访问 ，需要 多少的内存。  那一个tomcat在安装 时就提前 已经 向我们的计算机申请 了这么多的内存，让它在后续 的使用中，只能用申请 的内存大小， 这些内存大小刚好能够 承载350 个同时 的并发，如果再多，程序就要BOOM了， tomcat就要死机 了

![image-20211205102949195](https://raw.githubusercontent.com/Eat-garlic/picture/master/img/20240204150528.png)











![image-20230309220930036](https://raw.githubusercontent.com/Eat-garlic/picture/master/img20230309220930.png)



