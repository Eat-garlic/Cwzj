# Spring_aop 面向切面编程 

## 理解事务的前提是理解aop

![image-20230203104537373](https://raw.githubusercontent.com/Eat-garlic/picture/master/img/20230203104537.png)

怎么封装的  为什么使用起来方便





![image-20230203104859544](https://raw.githubusercontent.com/Eat-garlic/picture/master/img/20230203104859.png)





##  aop与动态代理之间的联系大白话

![](https://raw.githubusercontent.com/Eat-garlic/picture/master/img/20230203173310.png)

理解aop的前提是理解动态代理

要理解是怎么做到的，得很清楚的知道动态代理 

如果是我，我会怎么用动态代理来实现 在目标方法之前执行



动态代理你真的理解了嘛



![image-20230203171901066](https://raw.githubusercontent.com/Eat-garlic/picture/master/img/20230203171901.png)









![image-20230203171949504](https://raw.githubusercontent.com/Eat-garlic/picture/master/img/20230203171949.png)

也就是说这个引用 的类库 	底层的逻辑就是用动态代理实现 的

也就是讲aspectj类库中用了自己的方法引用了![image-20230203175212632](https://raw.githubusercontent.com/Eat-garlic/picture/master/img/20230203175212.png)这个方法 ，然后包装下给，整合起来给我们使用

如果我们自己想要在目标类中来切入代码，那么是需要自己写动态代理 这个程序的，虽然可以用，但是每次用起来都需要自己来写，这样真的很不方便 ，如果org.aspectj的工作人员就自己包装了动态代理 

将一个口留在外面 给我们自己配置 ，我们配置 的内容 ，它们通过 程序 来读取 ，读取之后，程序的底层最终是要执行类似下面逻辑的代码



![image-20230203174129554](https://raw.githubusercontent.com/Eat-garlic/picture/master/img/20230203174129.png)









## 我们做的只是需要如何使用这个口



![image-20230203175553180](https://raw.githubusercontent.com/Eat-garlic/picture/master/img/20230203175553.png)



#### 第一种使用方法（目标方法之前执行）

![image-20230203195440929](https://raw.githubusercontent.com/Eat-garlic/picture/master/img/20230203195441.png)





#### 第二种使用方法 （之前之后都可以执行）

![image-20230203195642057](https://raw.githubusercontent.com/Eat-garlic/picture/master/img/20230203195642.png)

methodInvocation.proceed方法就是执行目标 方法 ，其实 是被包装了，就像

![image-20230203195848818](https://raw.githubusercontent.com/Eat-garlic/picture/master/img/20230203195848.png)

这个逻辑一样











![image-20230203195952418](https://raw.githubusercontent.com/Eat-garlic/picture/master/img/20230203195952.png)







## aop的切入点表达式

![image-20230203200057797](https://raw.githubusercontent.com/Eat-garlic/picture/master/img/20230203200057.png)

![image-20230203200113680](https://raw.githubusercontent.com/Eat-garlic/picture/master/img/20230203200113.png)

![image-20230203201311163](https://raw.githubusercontent.com/Eat-garlic/picture/master/img/20230203201311.png)







![image-20230203201339150](C:\Users\Jinkex\AppData\Roaming\Typora\typora-user-images\image-20230203201339150.png)













## proceed方法 的理解 

 ![image-20230210192213126](https://raw.githubusercontent.com/Eat-garlic/picture/master/img/20230210192213.png)

调用 的proceed类型不一样，但是逻辑是一样的， 都是别人借用jdk的动态代理 来生成 aop ,  我们只要拿到别人给的口 自己来用就可以