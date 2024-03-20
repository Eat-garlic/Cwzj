



# servlet

![ ](https://raw.githubusercontent.com/Eat-garlic/picture/master/img/20240204153345.png)



## 乱码解决

![image-20211206111558964](https://raw.githubusercontent.com/Eat-garlic/picture/master/img/20240204153401.png)

![image-20211206111700670](https://raw.githubusercontent.com/Eat-garlic/picture/master/img/20240204153807.png)

## 请求过程

![image-20211206111724439](https://raw.githubusercontent.com/Eat-garlic/picture/master/img/20240204153820.png)

#  调用 servlet的doGet()和doPost()方法 

servlet请求会调用 HttpServlet类的service();方法 ，利用service方法 看前台发送的是什么 请求，Service方法里面实现 了请求的调用 如果 是get请求就会调用 doget方法 ，如果 是post请求就会调用 post方法 



![image-20211205111109161](https://raw.githubusercontent.com/Eat-garlic/picture/master/img/20240204153849.png)







# 之前 是怎样开发的  改善之路   _jsp

只利用servlet的api我们利用Javax.servlet.http.HttpservletRequest,....Response,等类，我们是可以写一些东西到页面上，但是如果只有这个api我们东西是可以通过 

```java
PrintWriter out  =  response.getWrite();  //得到一个输出 流对象
    
    
```

然后利用这个对象的write方法去写一些东西到前台 可以写文字 ，写页面，如果 写页面就要将Contype设置 为html  然后前台的引擎 会根据 你设置 的类型来对应 的解析

![image-20211205104158638](https://raw.githubusercontent.com/Eat-garlic/picture/master/img/20240204153905.png)

这样就需要后台工作人员要懂html代码，没有前台人员什么 事了，后台 人员可以直接包了所有 事情 ， 但是这样非常 痛苦，尤其是这样一行一行的去输出 Html代码，显然效率低，又很恶心，

这样发展下去 java jdk研发人员看着这样下去 不行，就没人用Java了， 程序员在语言上的选择就会让流向其他语言，之后 jdk工作组就搞出了一个jsp这个玩意  









## 改善后就有了-->Jsp

![image-20211205112404602](https://raw.githubusercontent.com/Eat-garlic/picture/master/img/20240204153919.png)

## jsp的工作 逻辑 怎样理解 jsp就是servlet

在项目中写了jsp后，可以直接 用jsp的标签 就不需要我们自己write（）; 写代码 了我们可以通过 jsp的标签直接 写java代码 ，然后将我们Java代码在前台也展现出来 这个jsp可以直接 在前台 的浏览器 引擎上解析出来， 省得我们自己一行行的拼接html代码 ![image-20211205112913179](https://raw.githubusercontent.com/Eat-garlic/picture/master/img/20240204153933.png)







### 为什么 jsp可以直接被浏览器加载出来？

会想，我们写的Jsp标签 里面的html代码 为什么 会被浏览器给加载出来 ，

要找到原因：

因为jsp写完后，我们用idea运行程序 时，jsp比如说我写的jinkex.jsp,在类路径中会形成 一个jinkex_jsp的Java文件 ，而且在编译 的时候 会被 编译器编译成字节码文件，

（我们点进去 可以看到 jsp会继承一个个servlet，在某个代码 里会找到jsp这些代码 自己已经 调用 了write方法 ）

点进去Jinkex_jsp.java文件我们会发现这个文件继承一个叫httpJspBase的这么一个类，再项目 中敲两下shift 输入这个类找到这个类，发现这个类继承 了HttpServlet，从这之中，我们可以发现，其实 Jsp 最终继承的就是httpServlet类，从这一方面就可以说jsp就是servlet,  

当请求到达 Jinkex.jsp时，我们会调用 service方法 ，好，这时jinkex_jsp.java这个文件中没有，那么 会看看继承的父类中有没有，在httpjspBase中看到 了service方法 ， 打开这个方法 看到 它调用 了_jspService方法 ，那么 _jspService在 jinkex__jsp.java中找到_ _jspService方法 ，发现，jinkex.jsp中写的代码 全都 在这个_ _jspService方法中用write方法 写出去了，原来，这个jsp其实 就是被 Jdk组给包装起来了， 不用我们程序员自己写，jdk组给我们写好了



![image-20211206105752640](https://raw.githubusercontent.com/Eat-garlic/picture/master/img/20240204153948.png)

![image-20211206105813667](https://raw.githubusercontent.com/Eat-garlic/picture/master/img/20240204154126.png)

![image-20211206105955267](https://raw.githubusercontent.com/Eat-garlic/picture/master/img/20240204154138.png)

![image-20211206110112911](https://raw.githubusercontent.com/Eat-garlic/picture/master/img/20240204154156.png)

找到这个_jspService方法 可以发现————》

![image-20211206110356680](https://raw.githubusercontent.com/Eat-garlic/picture/master/img/20240204154218.png)

里面已经为我们将jsp里面的标签 用out.write对象全都写出去了



"jsp里面能用标签敲出java代码 "能敲出哪些Java代码 取决于jsp内置的Java对象，这里面就有jsp九大内置对象





# Jsp使用



![image-20211206112013906](https://raw.githubusercontent.com/Eat-garlic/picture/master/img/20240204154233.png)

![image-20211206112043318](https://raw.githubusercontent.com/Eat-garlic/picture/master/img/20240204154244.png)

![image-20211206112111941](https://raw.githubusercontent.com/Eat-garlic/picture/master/img/20240204154255.png)

![image-20211206112207760](https://raw.githubusercontent.com/Eat-garlic/picture/master/img/20240204154309.png)



![image-20211206112222544](https://raw.githubusercontent.com/Eat-garlic/picture/master/img/20240204154322.png)











# servlet之间的转发与重定向

## request 和 responsed

request response这个类也是这个 servlet.http.HttpServletRe....包中的，是请求和响应的类，抽象 而来的

![image-20211206112925593](https://raw.githubusercontent.com/Eat-garlic/picture/master/img/20240204154337.png)

前台请求的进入 servlet时，这个请求就是request这个参数，参数是什么 类型的呢，第一个参数 是RequestFacade类型的

![image-20211206123543825](https://raw.githubusercontent.com/Eat-garlic/picture/master/img/20240204154355.png)



![image-20211206142051491](https://raw.githubusercontent.com/Eat-garlic/picture/master/img/20240204154411.png)







![img](https://raw.githubusercontent.com/Eat-garlic/picture/master/img/20240204154430.png)



![img](https://raw.githubusercontent.com/Eat-garlic/picture/master/img/20240204154443.png)









![image-20211206112238052](https://raw.githubusercontent.com/Eat-garlic/picture/master/img/20240204154500.png)

![image-20211206112252288](https://raw.githubusercontent.com/Eat-garlic/picture/master/img/20240204154511.png)

![image-20211206120522298](https://raw.githubusercontent.com/Eat-garlic/picture/master/img/20240204154528.png)











重定向是通过 response对象 返回给客户端状态码和地址，告诉客户端要发送一个什么样的请求过来

![image-20211206112304884](https://raw.githubusercontent.com/Eat-garlic/picture/master/img/20240204154546.png)

![image-20211206112316003](https://raw.githubusercontent.com/Eat-garlic/picture/master/img/20240204154557.png) 

