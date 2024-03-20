Mybatis plus   mapper层  service层  

iservice  <dictType>为什么 要加这个泛型

![image-20220820155227404](https://raw.githubusercontent.com/Eat-garlic/picture/master/images20220820155227.png)













![image-20230215091313477](https://raw.githubusercontent.com/Eat-garlic/picture/master/img/20230215091313.png)



官方 serviceimpl<dictTypeMapper, dictType> 实现是原理是什么 



![image-20230215091401065](https://raw.githubusercontent.com/Eat-garlic/picture/master/img/20230215091401.png)

我们继承官方 的类，将官方需要的泛型传进去，得到PlateTegionMapper ， PlateRegion  

![image-20220820155910429](https://raw.githubusercontent.com/Eat-garlic/picture/master/images20220820155910.png)

它给我们注入了

![image-20230215092501457](https://raw.githubusercontent.com/Eat-garlic/picture/master/img/20230215092501.png)



可以理解 为

@Autowired

PlateRegionMapper  baseMapper;

那我们就有PlateRegionMapper类型了

自然里面的

![image-20230215094633716](https://raw.githubusercontent.com/Eat-garlic/picture/master/img/20230215094633.png)



方法 我们可以拿来使用















![image-20221229164318069](https://raw.githubusercontent.com/Eat-garlic/picture/master/images20221229164318.png)

它的返回值就是你当初传进去的Page



















### MybatisPlus中Mapper查询映射问题

![image-20230223115717180](https://raw.githubusercontent.com/Eat-garlic/picture/master/img20230223115717.png)

 

这样写查出来 的可以 直接 转成Type的

为什么要写RestMap呢，防止查出来的对象成员 变量有引用类型的类



如果没有也可以直接这样写



![image-20230223115938709](https://raw.githubusercontent.com/Eat-garlic/picture/master/img20230223115938.png)



要是出现了数据库中的列名和 对象中的属性名对不上的情况 就需要自己写下对应 关系 了

![image-20230223120111099](https://raw.githubusercontent.com/Eat-garlic/picture/master/img20230223120111.png)











### 

传一个对象给mybatisPlus时

eg:从mapper层传一个









![image-20230223133302624](https://raw.githubusercontent.com/Eat-garlic/picture/master/img20230223133302.png)

传一个对象给mybatisplu方法 的话，可以根据参数名 获取对象的属性

#号和￥符号 的区别 ，Mj老师都记错 了，自己整理下

![image-20230223133746793](https://raw.githubusercontent.com/Eat-garlic/picture/master/img20230223133747.png)

 item.name

的本质是拿到Item这个对象调用 getName属性，得到这个对象的Name属性

准确的来讲

调用item对象name这个属性，也就是调用  get属性的方法 