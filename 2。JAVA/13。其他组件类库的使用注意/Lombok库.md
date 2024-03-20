@Data 的 还需要no   all argarame 这个注解 嘛， data包含了这个注解 不

​	



这个问题是从贺圣军项目 中引审过来 的，本来， @data 是Lombok中类库中的一个注解，加了这个注解后，类中的一些方法都可以直接的省略掉， 包括什么 @get  ,set    equals,等方法 ，



 一些额外 的理解 ，

当一个类中有显性的有参构造 函数时，这个@data会生成 这个函数的get set 方法 ，这时它就不生成 无参构造 ， 如果 没有显性 的有参构造 ， 它 会生成无参构造 ，如果你想在有显性的有参构造时生成构造 ，那就要使用   @all argarame      @ no  argarame   这个注解 了   

具体的看下图

 ![image-20240201155322073](https://raw.githubusercontent.com/Eat-garlic/picture/master/img/20240201155323.png)