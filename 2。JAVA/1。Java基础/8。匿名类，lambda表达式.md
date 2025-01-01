​	

# 匿名类

一个类实现了一个接口或抽象类，必须要实现接口和抽象类中的所有抽象方法 ，我们写一个类实现了一个接口或抽象类，可以说是这个类是属于这个接口或抽象类类型的，如果我们在很多地方经常用到这个类的实例，那没问题， 我们就非常有单独写一个.java这个类的必要，但是还有种情况是如果这个类只在项目中使用几次，用的不多，这种情况 下我们可以将这个类设置 为匿名类



当一个类在项目中只需要使用一次时，外界不会对其反复的使用时，便可以使用匿名类，不知道它是属于哪种类型，但是也可以在这个类中定义内部类中的资源

- 这样可以省掉一些类结构 ，便项目的类结构变得更加的精简
- 匿名类的书写方式，new 接口名称（）{    }；代表这个类实现了这个接口,或者抽象类的基础上的类，也只有在接口和抽象类中体现，

![image-20220527203510528](https://raw.githubusercontent.com/Eat-garlic/picture/master/images20220527203510.png)



![image-20220527204405306](https://raw.githubusercontent.com/Eat-garlic/picture/master/images20220527204405.png)

# 排序

排序Jdk提供了一个接口

![image-20220530082826099](https://raw.githubusercontent.com/Eat-garlic/picture/master/images20220530082826.png)

两个数来调用 这个方法，默认排法是将小的排在左边，大的排在右边 这是 自带的 不能变更 

Java的Arrays.sort()方法的逻辑   简单的理解 



例如 33 22 来调用 这个方法 ， 用33-22 结果是大于0，那么编译器 会认为  33这个位置 >32这个位置  又因为大的在右边，所以 33 在22的右边 

如果11 98来调用 这个方法 ， 用11-98  结果小于0 ，  那么 编译器会认为  11这个位置 <98位置 又因为大的在右边  ，所以 98 在11 的右边



根据以上逻辑，如果想要有不同的排序结果 只需要 让   同样 是33 22 两个 数来比，我让编译器认为22比较大 33比较小不就可以 了怎样让编译器 这样认为 呢 本来是33  22 比   33 大   是因为减出来的结果大于 0    所以 认为 33 大，那么我将这个返回值反过来 ，同样 还是33 22 来比， 返回值 的结果是 33  22 <0  ,那么 编译器   33 就小于22 了就会把它放在左边，便完成 了降序的效果



![](https://raw.githubusercontent.com/Eat-garlic/picture/master/images20220530083545.png)

## 判断排序的逻辑

### 怎样判断大和小？01 - 02     **返回值 小于0**    右边就大本来既定事实 01 - 02 <0   02大，现我让他返回值 硬变成相反的（02-01）也就是大于0 了， 那左边就比较大 那左边就要往右排，可事实上左边还是比右边 小，这样就降序了



## comparable接口中的compareTo方法的实现

![image-20220530084022430](https://raw.githubusercontent.com/Eat-garlic/picture/master/images20220530084022.png)



![image-20220530084701352](https://raw.githubusercontent.com/Eat-garlic/picture/master/images20220530084701.png)



![image-20220530084151433](https://raw.githubusercontent.com/Eat-garlic/picture/master/images20220530084151.png)



# **Lambda表达式**

![image-20221216173543837](https://raw.githubusercontent.com/Eat-garlic/picture/master/images20221216173543.png)

![image-20221216174355771](https://raw.githubusercontent.com/Eat-garlic/picture/master/images20221216174355.png)



当一个接口中只有一个抽象 方法 时，便可以使用lambda表达式，我们可以在这个接口上加上注解@FunctionalInterface来表示这个是函数式接口，加了这个注解就告诉Jvm这个接口在加载时如果出现了另外 一个抽象 方法就会加载出错，  这个语法也是Java8才有的语法

![image-20220530084629911](https://raw.githubusercontent.com/Eat-garlic/picture/master/images20220530084630.png)



![image-20220530084811495](https://raw.githubusercontent.com/Eat-garlic/picture/master/images20220530084811.png)

# 匿名类和lambda 的 区别

- Lambda没有引入新的作用域不能定义表达式中局部变量中已经存在的变量，定义的话会出现冲突
-  在访问时，如果 访问this对象里面的成员变量时，访问的是这个类中的成员变量，如果有的话就能访问到
- 匿名类中如果 访问的this成员变量，如果类中本身没有这个成员变量会报错，这就是最大的区别
-  Lambda  this表示的  是这个实例方法中的实例有没有这个成员变量， 而匿名类表示的是这个类本身有没有this这个成员变量，访问上有差异

![image-20220530085000105](https://raw.githubusercontent.com/Eat-garlic/picture/master/images20220530085000.png)





# **方法引用**

Lambda表达式是对函数式接口的优化，那么方法引用便是对Lambda的优化

当lambda表达式中调用的是不同方法时（静态方法，构造方法，实例方法....）我们会对其书写进行不同程序的优化![image-20220530085131818](https://raw.githubusercontent.com/Eat-garlic/picture/master/images20220530085131.png)

![image-20220604102057849](https://raw.githubusercontent.com/Eat-garlic/picture/master/images20220604102057.png)

![image-20211119114552369](https://raw.githubusercontent.com/Eat-garlic/picture/master/images20220604102343.png)

![image-20220604103049353](https://raw.githubusercontent.com/Eat-garlic/picture/master/images20220604103049.png)

![image-20220604103146947](https://raw.githubusercontent.com/Eat-garlic/picture/master/images20220604103147.png)

![image-20220604103218401](https://raw.githubusercontent.com/Eat-garlic/picture/master/images20220604103218.png)