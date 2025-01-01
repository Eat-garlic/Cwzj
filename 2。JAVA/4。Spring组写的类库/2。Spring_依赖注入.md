# 构造方法注入

## 参数注入，绑定顺序

Spring在加载配置文件时，创建配置文件中的bean，可以通过构造方法中的参数直接初始化一个带有值 的bean，

```java
<bean id="person" class="com.mj.domain.Person">
    <constructor-arg value = "18" index="1"/>
    <constructor-arg value = "汪隋" index="0"/>
</bean>
```

构造参数注入的情况下，可以通过 下标来确定参数位置的，默认person类中的构造方法 第一个参数的下标为0,第二个参数的下标为1 ，这样<constructor-arg>标签，顺序可以随意 的调换，只要下标和类型对应的就能注入成功 





在mybatis中， 在进行传参时，![image-20220110130318040](https://raw.githubusercontent.com/Eat-garlic/picture/master/img/20240204164329.png)

需要用@parame注解来指定传入的参数名称，因为编译器 在编译DAO中抽象方法 代码 时，会将参数名默认认为argo,arg1  param1, param 2  来传参，所以为了精确的找到sql语句中占位的参数 并将其传进去，需要用注解告诉 编译器 ，这个参数 是什么 名字，在sql语句 中去找参数就以这个参数 名去找



[ 括号中的有待指证（多个参数通过mapper中的映射文件查询出来，绑定是需要指定参数名的，如果不指定参数名，编译器默认情况 下是会去除参数名的，没有办法 将查询出来 的参数绑定 到domain中的领域模型上）]

![image-20220107124200547](https://raw.githubusercontent.com/Eat-garlic/picture/master/img/20240204164339.png)









而在spring中， 参数注入也有类似的场景 ， 

利用构造 方法 创建 bean注入参数时，  后面就不知道 怎么表述 了

在构造方法 上面加个注解 ![image-20220111134035466](https://raw.githubusercontent.com/Eat-garlic/picture/master/img/20240204164406.png)

配置文件 中的标签可以指定name=什么 

![image-20220111134219502](https://raw.githubusercontent.com/Eat-garlic/picture/master/img/20240204164443.png)





# 依赖注入   注入也是通过反射的，总之，理解 反射了，就知道 spring里面做了什么事

  ![image-20220111194027938](https://raw.githubusercontent.com/Eat-garlic/picture/master/img/20240204164504.png)

![image-20220111194058291](https://raw.githubusercontent.com/Eat-garlic/picture/master/img/20240204164535.png)

![image-20220111194113336](https://raw.githubusercontent.com/Eat-garlic/picture/master/img/20240204164552.png)

![image-20220111194132704](https://raw.githubusercontent.com/Eat-garlic/picture/master/img/20240204164611.png)

![image-20220111194141814](https://raw.githubusercontent.com/Eat-garlic/picture/master/img/20240204164639.png)

![image-20220111194153088](https://raw.githubusercontent.com/Eat-garlic/picture/master/img/20240204164651.png)

![image-20220111194207233](https://raw.githubusercontent.com/Eat-garlic/picture/master/img/20240204164703.png)

![image-20220111194220271](https://raw.githubusercontent.com/Eat-garlic/picture/master/img/20240204164715.png)

![image-20220111194230650](https://raw.githubusercontent.com/Eat-garlic/picture/master/img/20240204164726.png)

![image-20220111194241388](https://raw.githubusercontent.com/Eat-garlic/picture/master/img/20240204164736.png)

