 

 [Git版本控制高级应用.xmind](Git版本控制高级应用.xmind) 





![image-20220421195331942](https://raw.githubusercontent.com/jinkex55/picture/master/images20220421195332.png)



# Git 分支

## 分支怎么理解 

在开发中，同一份代码可能会有不同的场景中去需要， 

到位的理解 ： 一套代码写好，我们怎样给他布置到不同的环境中去，难道要用一个主分支，主分支是一般是上线 的，测试的环境和主分支如果只用一个分支， 那显然是不选择，这时我切换一个分支出来，主分支可以在线上运行，开发好的在test分支上测试成功后再合并代码，



![image-20220421201806673](https://raw.githubusercontent.com/jinkex55/picture/master/images20220421201806.png)

理解的不到位：（同一个项目，模块有很多个小组负责，就可以切换不同的分支，写好后，合并代码，然后运行项目  理解的不到位）

我们在主分支写代码 ，然后切换到其他分支去写代码， 是在主分支上一个本地版本库的基础上进行变更的

可以合并



![image-20220421201933204](https://raw.githubusercontent.com/jinkex55/picture/master/images20220421201933.png)

指到哪个分支上面 你就操作哪个分支的代码







## base版本是怎么确定的

![image-20220421204247148](https://raw.githubusercontent.com/jinkex55/picture/master/images20220421204247.png)

Base版本 是怎么确定的，base版本是本地仓库 最近拿来共同拿来没修改过的代码 

合并时，代码行行之间有冲突就会解决冲突，没冲突就会合并， 在这里要判断代码之间的冲突如否，而不是文件 



## 只要合并 就必得寻找base版本

![image-20220421204356729](https://raw.githubusercontent.com/jinkex55/picture/master/images20220421204356.png)



### 要搞清楚 文件和 文件内容修改的区别





# 搞清楚 这个你就彻底理解分支了





![image-20220421204818502](https://raw.githubusercontent.com/jinkex55/picture/master/images20220421204818.png)

每次合并 都找基准版本，以基准版本为标本 ，添加内容，双方都不冲突就合并 

BASE版本的东西删除后，你再合并  版本中的东西就 东西就没了

如果在dev修改了 d.txt再合并 就有冲突 了





# 远程仓库 私服

![image-20220421204932977](https://raw.githubusercontent.com/jinkex55/picture/master/images20220421204933.png)

私服 的概念  自己的服务器，别人看不到

![image-20220421205000681](https://raw.githubusercontent.com/jinkex55/picture/master/images20220421205000.png)







# 公司 git的一般使用

![image-20220421205027872](https://raw.githubusercontent.com/jinkex55/picture/master/images20220421205028.png)

![image-20220421205041154](https://raw.githubusercontent.com/jinkex55/picture/master/images20220421205041.png)



关联远程仓库

![image-20220519155618957](https://raw.githubusercontent.com/Eat-garlic/picture/master/images20220519155619.png)



 git remote add origin https://github.com/Eat-garlic/JiaKao.git

 

git push -u origin master





![image-20220519163019926](https://raw.githubusercontent.com/Eat-garlic/picture/master/images20220519163020.png)







https://blog.csdn.net/buknow/article/details/80325986







![image-20230916164902989](C:\Users\AeatGarlic\AppData\Roaming\Typora\typora-user-images\image-20230916164902989.png)















# 代理问题

https://blog.csdn.net/hggjjkk/article/details/130528271



![image-20230922205814622](https://raw.githubusercontent.com/Eat-garlic/picture/master/CWZJ/20230922205814.png)





# push 的问题，21年密码登录被禁止了

![image-20230922221548785](https://raw.githubusercontent.com/Eat-garlic/picture/master/CWZJ/20230922221548.png)









![image-20230922221200757](https://raw.githubusercontent.com/Eat-garlic/picture/master/CWZJ/20230922221200.png)







一些相关



![image-20230922211123312](https://raw.githubusercontent.com/Eat-garlic/picture/master/CWZJ/20230922211123.png)