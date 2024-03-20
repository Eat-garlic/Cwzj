

# Spring复杂对象的注入

在学习jdbc时，jdbc类库中的Connection这种对象Spring是怎样注入到Ioc容器中的呢，

有几种方法 

## 实例工厂注入

写一个类 类中提供 一个实例方法 GetCon（）返回值是Connection，在方法内将得到Connection的逻辑写在方法 中并且返回出去

在配置 文件 中配置 这个类

![image-20220113162436328](https://raw.githubusercontent.com/Eat-garlic/picture/master/img/20240204164809.png)



## 静态工厂注入

写一个类 类中提供 一个静态方法 GetCon2（）返回值是Connection，在方法内将得到Connection的逻辑写在方法 中并且返回出去

在配置 文件 中配置 这个类

![](https://raw.githubusercontent.com/Eat-garlic/picture/master/img/20240204164826.png)



## 实现接口(FactoryBean)进行注入

写一个类实现 FactoryBean接口

### FactoryBean接口

 这个接口是个泛型接口，接口中有两个抽象方法 getObject （）；  返回 值 是obj，  getObjType();返回的是Class的类对象  泛型的t 类型

![image-20220113162457036](https://raw.githubusercontent.com/Eat-garlic/picture/master/img/20240204164840.png)







# Ioc容器中的Bean的创建时机

![image-20220113162654483](https://raw.githubusercontent.com/Eat-garlic/picture/master/img/20240204164852.png)



配置文件 中的bean默认创建时机是创建了这个工厂时也就是加载了项目 中的配置 文件 创建工厂时就创建了springbean 而且 默认情况下bean为singletom 的 scope属性默认就是 这个类型 的，所以 

 

![image-20220113162934889](https://raw.githubusercontent.com/Eat-garlic/picture/master/img/20240204164901.png)

可以 设置 属性来让其进行延迟加载 





##　Ｉｏｃ单例和传统单例的区别



容器中的单例和我们平时 说的单例设计模式是有区别 的，模式中的单例在整个程序中无论如何都只有一个实例，而Ioc容器中的单例 是指同一个id名，无论创建多少次都是同一个对象，但是不同的ｉｄ可以创建出同一个对象但是不是同一个的对象，所以这种情况　严格　意义上来讲不是单例设计模式中的单例

![image-20220113163014107](https://raw.githubusercontent.com/Eat-garlic/picture/master/img/20240204164911.png)

![image-20220113163445786](https://raw.githubusercontent.com/Eat-garlic/picture/master/img/20240204164921.png)





# 自定义转换器Converter

![image-20220113163638396](https://raw.githubusercontent.com/Eat-garlic/picture/master/img/20240204164933.png)

我们在配置文件中写bean时， 当bean中的属性为日期格式时，不需要我们自己做什么操作，就可以 将字符串yyyy/mm/dd类型转换为日期类型，这是因为spring内部给我们实现 了这个格式的转换器

![image-20220113164218241](https://raw.githubusercontent.com/Eat-garlic/picture/master/img/20240204164946.png)

这只是其中的一个实现类， 还有类似的实现类    有些格式 的转换，spring内部的实现 类就给我们实现过了，所以可以直接用，但是在我们天朝，yyyy/mm/dd这种格式用的不多，我们很喜欢用yyyy-mm-dd 格式 的字符串，这种字符串转换为data类型，它的内部是没有给我们实现的 ，需要我们自己来实现



## Converter接口

![image-20220113165043257](https://raw.githubusercontent.com/Eat-garlic/picture/master/img/20240204165026.png)

接口在这个包中 ，



![image-20220113164806538](https://raw.githubusercontent.com/Eat-garlic/picture/master/img/20240204165040.png)

我们只需要实现这个接口，将转换器的逻辑写在方法 内即可，然后返回出去



```java
Public Class DateConver implmetn Coverter<String,Date>{
    private String format;
    Public void setformat(String format){
     this.format = format ; 
    }
    
    public Date Convert(String 0){
        
        try{
            return new SimpleDateFormat(format).parse(o);
           }catch(parseException e){
            e.printStackTrace();
            return null;
        }
        
    }
          
}
```

如上，我们自己实现 自己想要格式 的转换即可   这只是有了这个转换器，



接下来我们需要 在配置 文件 中配置一个转换服务的bean

  id 为convertersionService    Bean的名字是类名是ConverServiceFactoryBean 是spring 中的一个类，

![image-20220114153429488](https://raw.githubusercontent.com/Eat-garlic/picture/master/img/20240204165058.png)

配置 在配置文件 中 容器返回的是ConversionService对象spring拿着这个对象去调用 配置 文件 中类的一个属性 converters, 这一个set 从名字就可以看出 里面装着很多 的converter ，我们只需要将自己之前 写的转换器类名配置在这个set中，然后spring容器就能拿着返回的ConverterService（类实现FactoryBean接口返回的对象） 

用getBean(id )拿到

![image-20220218184158639](https://raw.githubusercontent.com/Eat-garlic/picture/master/img/20240204165109.png)



![image-20220218184130249](https://raw.githubusercontent.com/Eat-garlic/picture/master/img/20240204165123.png)对象 来调用 自身 被实现 类实现的抽象方法 Converter();它会调到我们的 转换器中



![image-20220114153612374](https://raw.githubusercontent.com/Eat-garlic/picture/master/img/20240204165138.png)







# Spring整合Mybatis

![image-20220114155624710](https://raw.githubusercontent.com/Eat-garlic/picture/master/img/20240204165154.png)

为了两个类库整合在一起简单方便快捷的能使用，需要两个框架中的各自的依赖，让基可以在一起能正常的使用





![image-20220114155720814](https://raw.githubusercontent.com/Eat-garlic/picture/master/img/20240204165206.png)



![image-20220114160038259](https://raw.githubusercontent.com/Eat-garlic/picture/master/img/20240204165220.png)

最后一步，配置 了这个类，这个类的作用是用来扫描dao的  类里面的属性有  sqlSeesionFactoryBeanName 告诉要扫描哪个工厂数据源 扫描哪个包名将dao 生成代理对象，直接可以getBean ,就能用这个dao来进行crud了，  它里面的原理也是自动调用 seesion.update........   crud的方法 来进行对数据库的操作







# DataSource

datasource接口是sun公司在连接数据库方面2.0版本新出来的一个接口，在之前的1.0中，只有驱动管理器，DriverManager，用这个加载第三方数据库的驱动达到一个连接的效果，这样的弊端是数据库的连接需要在应用 程序中new，对性能的影响 很大， 每次new连接然后还要关闭。出于这方面的考虑，sun公司自己给了我们一组接口，这个接口就是DataSource系列的，接口中有抽象 方法 ，我们的程序只要实现 这些抽象方法 系列接口有三个都继承一个公共的接口，

![image-20220218112508191](https://raw.githubusercontent.com/Eat-garlic/picture/master/img/20240204165236.png)



![image-20220218112431768](https://raw.githubusercontent.com/Eat-garlic/picture/master/img/20240204165246.png)





![image-20220218112641443](https://raw.githubusercontent.com/Eat-garlic/picture/master/img/20240204165256.png)

基础连接只需要类（我们自己写的类或者第三方的类）实现 DataSource接口，实现其中抽象方法，方法中的实现 类写上自己数据库的参数，得到连接，跨过DriverManaget组件，无需自己关闭资源，Sun公司DateSource底层已经写好，



连接池连接

![img](https://raw.githubusercontent.com/Eat-garlic/picture/master/img/20240204165307.png)

也是实现sun公司2.0的DataSource系列接口，将连接交给连接池，底层不用每次进行维护资源的操作，只需要在获取连接 时进行连接初始化的操作，和规定时间不用进行连接的销毁即可，连接池也是第三方公司做的类库而已
