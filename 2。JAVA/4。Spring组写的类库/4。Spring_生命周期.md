#  Spring中bean的作用域

Bean在Spring容器中，作用域分为singleton 和 prototype 两种                   

## 容器

就是一个工厂接口，或者类，有名字，有方法 

## singleton 

获取的同一个Id的bean每次都是一样的对象，是单例的，在同一个容器中。  并不是我们传统意义上说的单例，这里指的是同一个容器下面，不同容器还是可以生产出这个bean对象的，真正的单例是无论何时只有一个对象，所以说这是个引用 的单例

Spring容器中默认为Singleton,  且Bean这个作用域是跟着容器的销毁而销毁的



## Prototype

这个作用域  是不跟随容器的关闭而销毁的Bean，  bean的作用域设置为这个，bean的生命周期不随着容器，而是随着垃圾回收机制了，我们getBean("id")是可以一直找到这个对象的





# Spring中Bean的生命周期

一个Bean从出生到死亡 完整会经历这些方法 

1。构造方法 

2。Setter方法注入属性值

3。BeanNameAware接口中的SetBeanName方法   告诉Bean的Id名字

4。ApplicationAware接口中的Set（Name）ApplicationContext方法  告诉Bean容器的名字

5。初始化之前处理器的     BeanPostProcessor接口  中的  xxxx beforeInitalization 方法    before

6。 initpad s 接口中的初始化方法     initializingBean - afterPropertiesSet

7。配置文件中的init方法 

8。初始化之前处理器的    BeanPostProcessor 接口中的    xxxx afterInitalization  方法       after

9。业务方法

10。  接口的 销毁方法    DisposableBean -destory

11。配置文件中的销毁方法      destroy- method



![image-20220219163933324](https://raw.githubusercontent.com/Eat-garlic/picture/master/img/20240204165451.png)

![image-20230217212627256](https://raw.githubusercontent.com/Eat-garlic/picture/master/img/20230217212627.png)





![img](https://raw.githubusercontent.com/Eat-garlic/picture/master/img/20240204165519.png)

![img](https://raw.githubusercontent.com/Eat-garlic/picture/master/img/20240204165530.png)



