#  

# Spring

我们从之前的简历项目中，sevlet层调用 service，service调用  dao， 但是这些一层层的对象调用 必须要在类中自己调用 自己创建好在类中的，要解耦

自己写个工厂类来解耦

# Spring的角色 ----解耦

## 初步解耦

写个工厂类在项目包中，然后调用 这个类的静态方法 ，

错误：（方法里面的参数 是String类型的， 需要 调用 方来传入，调用方就是 我们的业务 逻辑 ， 我们业务 逻辑 的对象 调用 工厂静态类的方法 时，传入这个方法 所需要 的字符 串，逻辑进入 工厂类的静态方法逻辑中，静态方法利用反射得到 字符串对象   返回 给业务 调用方，）

正确：将类中的属性需要另一个业务 对象eg:servlet中需要 service，原来需要自己在servlet 中new出service对象解耦成不需要在业务类中servet硬改代码就能达到我想切换不同的service实现 ，放在以前，你想换实现必须得硬改代码 ，这样代码的复用性就不高，需要 给这个代码 来进行解耦，这里引进一个工厂类，将new出需要对象 的逻辑全部写在工厂类中，工厂类提供一个静态的方法 ，返回业务 需要的对象

这样就初步做到业务类代码不更改的情况 下可切换其他的方案

![image-20220111160743686](https://raw.githubusercontent.com/Eat-garlic/picture/master/img/20240204164011.png)

![image-20220111160806661](https://raw.githubusercontent.com/Eat-garlic/picture/master/img/20240204164024.png)



## 再次进行解耦

业务 的类已经没有了耦合，但是工厂类还是需要自己进行手动的更改，那么 这个工厂类也是需要 解耦的，接下来进行工厂类的解耦，这里就需要利用配置文件来做到，将要new的类的全类名写在配置文件中，在程序运行中去读取它，再利用反射创建出配置文件 中的类，这样想要什么业务逻辑就可以直接在配置文件中更改字符串，就可以了，完全 实现了解耦



之后spirg就充当着这个角色 ，里面都是用反射将我们在配置文件 中字符串通过 反射来动态 的生成 bean,  bean也不需要我们来管理 了    spring就充当着我们自己写的工厂的这个角色，   不同的是Spring工厂的配置 文件 默认为applicationContext.xml  



通用 工厂

![img](https://raw.githubusercontent.com/Eat-garlic/picture/master/img/20240204164041.png)

![img](https://raw.githubusercontent.com/Eat-garlic/picture/master/img/20240204164050.png)

![img](https://raw.githubusercontent.com/Eat-garlic/picture/master/img/20240204164102.png)

![img](https://raw.githubusercontent.com/Eat-garlic/picture/master/img/20240204164118.png)





# 从工厂中拿bean及Ioc容器 的理解 

```java
ApplicationContext ct  = new ClassPathxmlApplicationContext("ApplicationContext.xml")
    ct.getBean（"id名"，类类型）  得到 对象 
```

## ApplicationContext

这个就是Spring的工厂，是一个接口，其他的类实现了这个接口，接口中有一系列抽象方法 ，其他的类实现                  

![image-20220111183638012](https://gitee.com/Jinekx_711/markdown-img/raw/master/img/202201111836119.png)

了这个接口，工厂类被spring组已经现成给我们写好了，我们用的时候直接 new这个工厂（接口）的实现 类就可以了，

new ClassPathxmlApplicationContext("ApplicationContext.xml")

这个类实现 了工厂，在实现工厂的时候，构造 方法 传进去了一个配置文件 ，这个就是spring的配置文件，意思就是你这个工厂在进行初始化时，利用反射要创建出哪些我在配置文件 中已经配置好的类，   工厂内部有个getBean方法，接收一个String 好让我日后 直接可以通过 这个方法 来找到我配置 文件 中的bean

### ApplicationContext接口的类体系和源码

https://blog.csdn.net/calm_encode/article/details/114017139



# Ioc容器的理解

Ioc  意思 为inversion of Controller    控制反转， 字面意思 ，之前在没有学spring之前 我们的对象，都 是由我们个人进行创建 ，权利在于我们自身，现在对象 的创建权利交由spring了， 在运行spring时在，使用这个类库的时候 ，spring会加载配置 文件 ，将配置文件中的bean的字符串读取到程序中，利用反射得到 配置文件中的类对象 ，再通过类对象 的newInstance方法 来创建出这个对象，

![image-20220111195727364](https://raw.githubusercontent.com/Eat-garlic/picture/master/img/20240204164135.png)

Ioc容器里面装着一个个的bean,这和我们之前自己写的工厂有点类似，工厂生产 bean， ctx这个运行时的环境装着这些bean

![image-20220111200737868](https://gitee.com/Jinekx_711/markdown-img/raw/master/img/202201112007959.png)





spring整个就是一个容器， spring运行时的环境 就是一个容器 这个运行时环境 会根据 不同的配置 文件 创建出不一样的容器，也就是不一样的环境 ，ioc容器就是整个spring    spring 本身 就是个大池子，里面装满了bean，





Ioc容器	  理解为spring整个程序  就是个窗口，运行的程序可以理解为容器 





## 容器中的id和name属性

在容器的配置文件中，每个bean有且只有一个id,如果配置文件中没有id 那么这个bean在容器中的id为全类名，  如果这个类有name属性，没有id属性，那么默认情况下是将name的名字就是id的名字，容器中不同的bean可以有相同 的名字，如果是相同的名字，spring容器默认设置为后者覆盖前者，否则容器会报错
