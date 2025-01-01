![image-20220423115943702](https://raw.githubusercontent.com/jinkex55/picture/master/images20220423115943.png)

# Linux系统简介

linux  是相对于win的另一个操作系统 ，些系统相对于win操作系统 更稳定，安全性强，不容易被病毒攻击， 适合作服务器  

大神开发此系统时，只写了一个固定的内核， 系统分为  内核版和发行版，![image-20220423125122356](https://raw.githubusercontent.com/jinkex55/picture/master/images20220423125122.png)发行版有很多不同的版本在市面上销售，内核版本也不停的在更新，市面上的发行版本有

![image-20220423124215787](https://raw.githubusercontent.com/jinkex55/picture/master/images20220423124215.png)

这些版本

![image-20220423125430564](https://raw.githubusercontent.com/jinkex55/picture/master/images20220423125430.png)

红帽和centOs基本区别 不大 ，红帽是提供服务的，centOs不提供官方服务，



## 操作

 [Linux.xmind](Linux.xmind) 

![image-20220427180414718](https://raw.githubusercontent.com/jinkex55/picture/master/images20220427180414.png)

# 

代表是超级管理员

$ 代表的是一般管理员

~代表的是当前位置

root代表的是谁

moo1代表的是在使用什么电脑

@是分隔符



### ssh协议

 ssh是一个加密的网络传输协议，用于传输一些操作指令很方便，可以通过

什么是网络传输协议，  网络传输协议 或简称为 传送协议 （ Communications Protocol ），是指计算机通信或网络设备的共同语言。 现在最普及的计算机通信为网络通信，所以“传送协议”一般都指计算机通信的传送协议， [1] 如：TCP/IP、NetBEUI、DHCP、FTP等。

![image-20220427175638758](https://raw.githubusercontent.com/jinkex55/picture/master/images20220427175638.png)



![image-20220427180052697](https://raw.githubusercontent.com/jinkex55/picture/master/images20220427180052.png)

客户端通过 ssh协议连接远程服务器 





xshell又是什么 

xshell是一个客户端，用来连接远程服务器的，就是一个可以操作远程电脑给远程电脑通过 ssh协议发送指令的一个工具



## Dns 和ip 有什么 区别 





![image-20220427175908255](https://raw.githubusercontent.com/jinkex55/picture/master/images20220427175908.png)

![image-20220427175917960](https://raw.githubusercontent.com/jinkex55/picture/master/images20220427175918.png)

我们也知道每一台机都有一个唯一ip地址，

特别难记，所以出现了今天的DNS(域名)

当我们的计算机想要和一个远程机器连接时，我们可以申请连接该机器ip地址下的DNS，例如：www.baidu.com。

连接的时候，DNS会提供一个ip地址，供服务器去找寻

所以，当我们在网址中输入：www.baidu.com，会获取到百度ip，并跳转页面 

1.比如说：我们现在在"陕西省西安市大雁塔喷泉旁"，那么这个"陕西省西安市大雁塔喷泉旁"就是一个域名，而具体的这个唯一的地方（陕西省西安市大雁塔喷泉旁）就是一个IP地址，它是网络层地址，用来识别TCP/IP网络中互联的主机和路由器。（推荐一本书《图解TCP/IP》） 

2.域名是相对于网站来说的，ip地址是相对于网络来说的，准确的说是通过dns服务器来完成的，你提交域名，他给你返回一个ip地址，也称之为域名解析），接着做出一个相应，将信息返回。

也就是：输入域名----域名解析服务器（dns）解析成ip地址---访问IP地址---完成访问的内容---返回信息

有个dns服务器













## Rsa 非对称加密

![](https://raw.githubusercontent.com/jinkex55/picture/master/images20220427181418.png)





SSH（22端口）是Secure Shell Protocol的简写，由IETF网络工作小组（Network Working Group）制定；在进行数据传输之前，SSH先对联机数据包通过加密技术进行加密处理，加密后在进行数据传输。确保了传递的数据安全。

SSH是专为远程登录会话和其他网络服务提供的安全性协议。利用SSH协议可以有效的防止远程管理过程中的信息泄露问题，在当前的生产环境运维工作中，绝大多数企业普通采用SSH协议服务来代替传统的不安全的远程联机服务软件，如telnet（23端口，非加密的）等。

SSH远程登录原理

使用ssh主要有两种登录方式：

1、密码口令登录

像上面的方式就是基于密码口令验证去做登录的，通过密码进行登录，主要流程为：

1、客户端连接上服务器之后，服务器把自己的公钥传给客户端

2、客户端输入服务器密码通过公钥加密之后传给服务器

3、服务器根据自己的私钥解密登录密码，如果正确那么就让客户端登录

‘







怎样理解 rsa的公钥和私钥：

公钥（Public Key）与私钥（Private Key）是通过一种算法得到的一个密钥对（即一个公钥和一个私钥），公钥是密钥对中公开的部分，私钥则是非公开的部分。. 公钥通常用于加密会话密钥、验证数字签名，或加密可以用相应的私钥解密的数据。. 通过这种算法得到的密钥对能保证在世界范围内是唯一的。. 使用这个密钥对的时候，如果用其中一个密钥加密一段数据，则必须用另一个密钥才能解密。. 比如用公钥加密的数据就必须用私钥才能解密，如果用私钥进行加密也必须用公钥才能解密，否则将无法成功解密。. 说明：. 由于私钥的非公开属性，建议在SSL证书申请过程中，由客户自己生成私钥，并妥善保管。.





## 用户组

![image-20220428114210950](https://raw.githubusercontent.com/jinkex55/picture/master/images20220428114211.png)





![image-20220428114954069](https://raw.githubusercontent.com/jinkex55/picture/master/images20220428114954.png)









### sh 结尾的一般都是脚本可执行文件





![image-20220428151510145](https://raw.githubusercontent.com/jinkex55/picture/master/images20220428151510.png)

hello.sh显然不 在环境变量下面，所以你要告诉它具体的路径





































# Linux 软件安装（重点）













# 遇到的一些问题



##### 获取不到ip

ip addr  获取不到是因为这个服务没开

![image-20240312144558672](https://raw.githubusercontent.com/Eat-garlic/picture/master/CWZJ/image-20240312144558672.png)

 解决 办法 

https://www.jianshu.com/p/933e2760374b





# 指令

#### rpm

![image-20240312151307770](https://raw.githubusercontent.com/Eat-garlic/picture/master/CWZJ/image-20240312151307770.png)

#### grep

![image-20240312151358654](https://raw.githubusercontent.com/Eat-garlic/picture/master/CWZJ/image-20240312151358654.png)



#### l 表示 ，权xian

![image-20240312152843902](https://raw.githubusercontent.com/Eat-garlic/picture/master/CWZJ/image-20240312152843902.png)

前三个表示当前用户 权艮， 中间的表示当前组，后面三个表示 其他用户



#### 安装net -tools组件

![image-20240312155855793](https://raw.githubusercontent.com/Eat-garlic/picture/master/CWZJ/image-20240312155855793.png)



yum install net-tools centos 7

![image-20240312160058958](https://raw.githubusercontent.com/Eat-garlic/picture/master/CWZJ/image-20240312160058958.png)

#### 移动文件

![image-20240312162214487](https://raw.githubusercontent.com/Eat-garlic/picture/master/CWZJ/image-20240312162214487.png)

