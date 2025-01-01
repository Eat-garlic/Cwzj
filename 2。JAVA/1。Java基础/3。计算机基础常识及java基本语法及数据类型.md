# 计算机的基本知识

计算机中都是用0，1 来存储数据 的也就是二进制 

##  进制

0000    0001    0010    0011     0100       0101      0110     0111      1000    

  0       1       2       3           4           5         6        7           8    

​        1001      1010      1011     1100      1101      1110        1111

​      9         A          B         C          D         E           F    

​       

000   001  010    011     100       101      110      111   

 0     1    2       3      4         5        6       7

 用01来表示计算机存储的数据，看起来时会很不方便，也不便于阅读，将二进制的前16个数（0-15）用十六进制 来表示 ，一一相对应

为什么要用4位来表示呢？

：16进制的最大的数对应的是二进制 中的4位，所以用4位表示 会更清晰 些

：  8进制的最大的数那就 的是二进制 中的三位，所以用三位表示会更清晰 



## **计算机的存储单位**

bit 是位  byte是字节      1byte = 8 bit     一个字节中有八个位，可以理解为八个小的空间

负数的符号位是1   ，正数的符号位数是0 

计算机存储浮点数是用

![image-20240202154959133](https://raw.githubusercontent.com/Eat-garlic/picture/master/img/20240202154959.png)

来存储的，前面的s 代表为正还是负





# java基本语法

## 基本常识

- java的代码是以分号为结尾的
- 程序的入口是从Main
- java中先有Class类，再有方法的
- Java中一个编译单元，只能有一个public 的类，这个类即是这个编译单元的入口，且这个编译单元的文件名必须和这个类名一样    如果没有Public修饰，那么这个编译单元在运行时，要选择其中一个没public作为编译单元的入口 

```java
 pack Sui.java
 public Class sui{
     sys..
 }
 public qiang{
     
 }
 public wang{
     
 }
```

## **java中的数据类型**

### 基本类型：

​       整数:

1. byte       1 个字节， 8bit  存储的范围是【-128，127】
2. short	  2个字节    16bit 存储的范围是[   ]
3. int 	   4               32
4. long        8

​       浮点数

1. float        4
2. dubbo     8

1. boolean   布尔类型  true  false
2. char        2





### 引用类型：

  用指针指向内存单元的都称为引用类型   引用类型的值 是对对象的引用

- 数组 
- 类
- ...

#### properties类型

这个类型是在![image-20231024101915708](https://raw.githubusercontent.com/Eat-garlic/picture/master/img/20231024101915.png)

包中，继承上面蓝色那些类，他是	![image-20231024101946134](https://raw.githubusercontent.com/Eat-garlic/picture/master/img/20231024101946.png)



读取文件时，是以k,v的形式存储键值对，因为它是继承hashtable



# 字符串所表示的含义

```java
String a  = ' '；
String b  =  Null
String c  =  "你好"
```





![image-20231024102118479](https://raw.githubusercontent.com/Eat-garlic/picture/master/img/20231024102118.png)



# 变量的初始化：

## 变量分类

- 局部变量： 可以理解为方法括号内的变量，一般在方法中定义的变量
- 成员变量    成员变量就是属性， 是在类中定义的‘

局部变量需要程序员手动的初始化，定义出来 了局部变量，如果你不赋值，直接使用编译器会报错

```
public void main (){
    int a//必须要赋值
    System.out.print (a);//会报错 
}
```



![image-20231024102135960](https://raw.githubusercontent.com/Eat-garlic/picture/master/img/20231024102136.png)







非局部变量：不赋值编译器也会默认的给一个默认值；

![image-20231024102152050](https://raw.githubusercontent.com/Eat-garlic/picture/master/img/20231024102152.png)





# **字符串拼接**

字符串拼接，用+号来拼接，这里只是用字符串用+号，也就是讲+号左，右两侧一定有一侧是字符串，所以才叫字符串的拼接，和其他的数据类型没什么关系

```
String name = "汪隋
int age  = 26
Doube  height  =  177

   System.out.print ("my name is " + name +", age is " + age+", height is "+ height);

```



![image-20231024102330225](https://raw.githubusercontent.com/Eat-garlic/picture/master/img/20231024102330.png)



# **位运算：**

&  : 按位与          都为1 时才为1，否则为0

 |  ：按位或         有一个为1 时就为1，否则为0

^  ：按位异或     两个不一样时为1 ，否则为0

用在boolean类型上





&&: 与

|| ：或 

^^：异或

具有短路功能 ，前面符合就不看后面的







# **类型转换**

拓宽类型转换：小类型的可以直接转为大类型的，隐式转换。例如 byte  和short 相加 ，编译器会自动转换为int 

窄化类型转换：long 类型的转换为int 类型的，要在long类型前面加上(int)强制转换





# 标识符 

标识符是用来当作Java变量，常量，函数，语句块的名字，我们统统称之为Java标识符。 标识符是用来给类、对象、方法、变量、接口和自定义数据类型命名的。 Java标识符由数字，字母和下划线（_），美元符号（$）或人民币符号（￥）组成。 在Java中是区分大小写的，而且还要求首位不能是数字。

只有是Java字母和java数字的字符才能当作标识符 



![image-20231024102411994](https://raw.githubusercontent.com/Eat-garlic/picture/master/img/20231024102412.png)	

## **命名建议**

变量名，方法名：            小驼峰

类名：                              大驼峰

常量：    MY_NAME_IS_SUI

