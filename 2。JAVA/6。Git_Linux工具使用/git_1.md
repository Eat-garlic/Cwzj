09

 [Git版本控制基础.xmind](Git版本控制基础.xmind) 



# Git的基本理解 



## git是什么，什么背景下出现的

在提交代码需要上线时，当发现这个提交的代码出现 bug不能正常的运行时，我们需要找到这个代码或者找到这个代码的上一份老代码，看看是哪里出现了问题，找到这份代码 很容易，但是如果 bug是出现在上份代码上，我们所面临的是要如何寻找到上一份代码 ，在一般情况下，如果没有作记录，上一个版本的代码基本上很难找到的。在这种情况下便产生了一个工具，管理代码的版本的工具，可以理解为一个可以生产代码仓库 的一个工具 

git是在linux系统的背景下产生的，因为 linux系统是一个庞大的开源社区，是由全世界的开发者来提供代码的，当时光是维护系统和保持linux系统正常的运行就需要庞大的工作量，且是没有定档记录的功能，linux内部人员花在维护最近更新的代码存档就需要很大的功夫， 在这时 linux内部人员就需要一个公司的托管这个存档代码，在当时是linux是没有开发这么一个软件来维护 linux的这些存档代码，就在别的公司买了这么一个软件，随着时间的发展 ， 这个公司和linux内部人员出现了利益的纠纷，然后linux人员不得不自己开发了一个代码托管的平台 ，这个平台就是git，git是一位大神通过一周时间开发出来的。



## 版本工具有很多种  git svn



# 使用

关联远程仓库

![image-20220519155618957](https://raw.githubusercontent.com/Eat-garlic/picture/master/CWZJ/20240315184913.png)

一般会报一个 不知当前用户是谁的错 文件使用者和所有 者不一致

这时输入 这个

git config --global --add safe.directory "*"





 git remote add origin https://github.com/Eat-garlic/JiaKao.git





新下载的git你提交 会让你说明你的身份

 

git config --global user.name "你的名字"

git config --global user.email "你的邮箱"



然后  git  commit  -m "你好"



git push -u origin master

















### git 和svn的区别 

git是分布式版本管理工具 只要你下载了这个工具，一般情况下需要登录你的帐号，你就可以像这个本地仓库中提交代码，只有下载了这个软件你才可以某一个项目 目录创建对应 的仓库，可以理解为git是创建仓库的工具 ，是版本管理的工具 。 git是分布式的，可以理解为每台电脑都是一个版本库， 你修改文件 ，他会保存在暂存区，  每做一次操作 都在暂存区有记录， 每台电脑都是自己的版本库， 没有中央服务器来管理版本， 每台电脑都可以在脱离断网的情况下也能工作 ，有属于自己的暂存区来管理版本， 写代码时可以回退到自己想要的版本，



但是为了方便 代码的交换 ，在远程 确实有一个中央仓库来管理这些代码， 方便同事之间代码的交换 

和svn的区别 git在没有这个中央仓库仍然可以在分布式下工作，分布式电脑本身 就有git来记录版本 而svn不行，svn版本都在中央服务器上，这就是区别所在 

也是为什么要创建 一个用户名和email的意义所有 ，记录是谁写的代码  

git是分布式的管理 工具 ，就算一台电脑出现 了问题不会影响其他电脑的代码的工作和提交，而svn一台主机出现 了问题其他的电脑就提交 不了代码 

只要你想：任何一台电脑都可以装这个软件 



而svn是集中式的版本管理工具 ，在某一个局域中，所有电脑写的代码 只能通过网络来提交给一个装有svn软件的电脑上来管理  ，所有的版本管理都在这个集中的服务 器上，这种是在网络和服务器比较好的情况 下才能用，如果网络不好，或者 svn的服务器电脑出现故障，就不能正常的运作

svn这种在现在的开发中基本上不常用 了





## git 和 github的区别 

Git 是一个“分布式版本管理工具”，这里需要理解分布式。 也就是每个用户会有一个本地仓库，同时还有一个远程仓库。 而 GitHub 就是用户远程仓库的托管网站 。 不同用户可以复制同一个仓库的代码到本地，然后开发某一部分功能，完成后提交请求到远程仓库。





## GIt的基本操作 

## 最基本的三个区域 

##### 工作区

（自己写代码的区域）



##### 暂存区

（git add filename的区域）    



git的暂存区用了快照的存储方式，然后将相同的二进制去重，这样暂存区的存储空间就会比工作区小很多

![image-20231001071457239](https://raw.githubusercontent.com/Eat-garlic/picture/master/CWZJ/20231001071457.png)



##### 本地仓库

（git commit区域)也 叫作本地版本库

本地仓库可以在任何位置，只要是计算机可以访问到的位置都可以是本地仓库，一般情况下我们下载了git软件时，在某个目录下输入git init 这个命令，我们就得到一个本地仓库，这个也叫作本地版本

![image-20230928102618540](https://raw.githubusercontent.com/Eat-garlic/picture/master/CWZJ/20230928102618.png)



### 本地仓库  就是 版本库 



写的一些文件 ，也就是写的一些代码的某个阶段commit 一下，然后git工具会通过这个commi操作，将这些已有的代码放到自己  tree下面的节点上去，然后通过这个commit时备注的信息找到 这些阶段写的代码，达到一个方便回撤的目的

之后 的整个状态就是版本库，也就是本地仓库

![image-20230923202844158](https://raw.githubusercontent.com/Eat-garlic/picture/master/CWZJ/20230923202844.png)

git add. 是将本地文件添加 到暂存区，   gitcommit后，这个代码暂存区的代码提交到版本库中了，暂存区的代码还是存在的，其实可以从.git文件下面的的Index文件夹中可以看到





一般git commit. 后添加代码到本地仓库中去了，暂存区有一份索引指向本地仓库，提交后 暂存区代码还是存在

这里强调的一点是add后 代码到暂存区，有个索引指出了您对文件系统的所有更改，   commit后才将本地仓库的代码生成 commit对象，生成版本库





当您在Git中执行`git add .`时，您是把所有修改（包括新文件、修改的文件和删除的文件）添加到暂存区。这个过程并不直接把代码添加到本地仓库，而是创建了一个索引，这个索引列出了您对文件系统的所有更改。

然后，当您执行`git commit -m "Your message"`时，Git会把这个暂存区的状态和一个特殊的commit对象关联起来。这个commit对象包含了您的所有更改，以及这个commit的父commit（也就是上一次的commit）。这个commit现在就保存在您的本地仓库中。

如果您想把这个commit添加到远程仓库，您可以使用`git push`命令。在这之前，您可能需要先执行`git fetch`来获取远程仓库的最新commit，然后可能需要用`git merge`或`git rebase`来将您的本地commit合并到远程仓库的最新commit。

在所有的这些步骤中，暂存区的状态都会被保留，直到您执行下一次的`git add .`或`git rm`命令。所以，即使您已经提交了更改，您仍然可以通过暂存区来查看和管理这些更改。





`git add .` 命令将当前目录下的所有修改添加到 Git 的暂存区，而不是本地仓库。它创建了一个包含所有更改的暂存区，但这些更改还没有被提交到实际的 Git 仓库。

要将这些更改提交到本地仓库，您需要使用 `git commit` 命令，例如 `git commit -m "Your commit message"`。这将创建一个新的提交对象，该对象将暂存区的更改与一个特定的提交关联起来，并将更改永久保存在您的本地仓库中。

在执行 `git add .` 之后，您的本地空间的代码已经被添加到暂存区，但还没有被提交到本地仓库。要将其提交到本地仓库，您需要执行 `git commit` 命令。





## 配置

当电脑 下载 了git后 

在代码的目录下,需要先设置自己的username 和E-mail 以便知晓这个代码是谁提交的

```java
git config --global user.name " Yourname"
git config --global user.email "YourEmail.com"
```



全局配置配置完成后，你提交代码到中央服务器上便有记录是谁提交的了



## Git的基本操作

在项目的相同文件下用git Bash here打开git的 非gui操作端，我们 只需要用

```Git init 
Git init 
```

便可以初始化一个仓库

写完代码后

用

```
git add filename                                                                                                                          
```

添加到暂存区这里代码已经到暂存区了



要生成 版本信息到本地版本库中去，需要用这个命令

```
git commit
```





基本操作就这样

git reflog

![image-20220418094527023](https://raw.githubusercontent.com/jinkex55/picture/master/imagesimage-20220418094527023.png)

可以看到日志



## git基本原理

## 原理

 git init 后会有创建一个仓库，这个仓库会在隐藏文件.git文件下面 这个.git就称做本地仓库，也叫本地版本库



这就是存放仓库的位置 

我们git add filename时，比如提交两个文件时，结构是这两个文件被存放到了暂存区（index）并为这两个文件生成两个blob类型的对象放在object文件jia中，Hash名字作为它们的文件 名， 它们的类型是 blob类型。如果提交了后， 就证明 了这个版本信息我们在电脑上有记录，这个版本在电脑上有了一份存档，在本地仓库中的object中，就算此时电脑死机了，也可以看到 这个版本记录了， 一整个.git下面的所有文件可以理解为本地版本库的 总和

commit本身也是个对象 ，这个对象也存放 在objecy中的（为什么叫也，是因为之前的对象都是放在这里面的比如add生成的blob类型的对象），它是commit类型，他的下面还关联着一个tree类型，这个 tree类型的文件信息里面存储着 git add filename的名字（当然里面有add时的），通过 commit类型里面的文件  （文件信息里面存储着![image-20230923082008494](https://raw.githubusercontent.com/Eat-garlic/picture/master/CWZJ/20230923082008.png)

![image-20220416111330426](https://raw.githubusercontent.com/jinkex55/picture/master/imagesimage-20220416111330426.png)

一个tree的节点，作者信息，提交的备注,也就是说Commit这个对象 是commit类型的，里面存储着tree这个节点commit时的作者信息和作者提交的备注）



### tree的作用是什么？

？ 为什么要有tree节点的

:作用是存储文件对象的名，（文件名）和权限   记住 文件存储对象名是commit的对象名



![image-20231001075909698](https://raw.githubusercontent.com/Eat-garlic/picture/master/CWZJ/20231001075909.png)

### 为什么存储文件名要和文件分开来存储

：第一点：避免Object对象重复，保证对象的唯一性  

​    第二点：节省空间，如果文件名不以tree对象形式进行 存储，而是以blob形式进行存储，那么 每次修改文件时都要再存储一次文件名，这样显然浪费了空间， 所以有节省空间的效果

## Master主分支

此时commit还有个master分支指向它，有个head指针指向master，这里我们理解为这个Master是我们提交代码的人，是主分支，通过后面的学习，还有副分支 主分支现在操作这个 仓库的只有我自己。

![image-20220416172540272](https://raw.githubusercontent.com/jinkex55/picture/master/imagesimage-20220416172540272.png)

## 暂存区

Index 区域，主要是指向本地仓库的文件可以通过这个index直接找到文件 进行操作



![image-20220416171544364](https://raw.githubusercontent.com/jinkex55/picture/master/imagesimage-20220416171544364.png)





![](https://raw.githubusercontent.com/jinkex55/picture/master/imagesimage-20220416112756952.png)



##　改了暂存区的两个文件中的其中一个到版本库的逻辑

我们修改了本地文件中两个文件中的基中一个，逻辑是怎样的呢

1。提交过后，修改的那个文件会被 新的tree节点重新指向，tree节点也会有个新的commit的对象 指向它

2。暂存区的代码和版本库的代码是一样的，生成 的commit对象会指向上一个commit对象 ，会像链表的形式存在,master也会重新指向这个commit， 你查看这个commit文件时可以清楚 的看到 父commit，![image-20220416164752644](https://raw.githubusercontent.com/jinkex55/picture/master/imagesimage-20220416164752644.png)这样就可以回到相应的版本库了

3。暂存区的Index会直接指向最新的这两个文件 



具体看下图

![image-20220416164856185](https://raw.githubusercontent.com/jinkex55/picture/master/imagesimage-20220416164856185.png)



![image-20220416164907957](https://raw.githubusercontent.com/jinkex55/picture/master/imagesimage-20220416164907957.png)

## 查看节点的命令

git cat-file -t  1c1493   (文件名称)

cat是查看的意思 ， -t 代表这个文件是什么类型的

-p可以查看到内容 eg:

git cat-file -p  1c1493   (文件名称)



# 额外理解补充 的点

git add. 是将本地文件添加 到暂存区，   gitcommit后，这个代码暂存区的代码提交到版本库中了，暂存区的代码还是存在的，其实可以从.git文件下面的的Index文件夹中可以看到





一般git add. 后添加代码到本地仓库中去了，暂存区有同样 的一份代码索引指向本地仓库，提交后 暂存区代码还是存在

这里强调的一点是add后 代码到索引区和本地仓库都有，   commit后才将本地仓库的代码生成 commit对象，生成版本库





# Git的命令

![image-20220416163706951](https://raw.githubusercontent.com/jinkex55/picture/master/imagesimage-20220416163706951.png)

## 查看版本库状态

![image-20220416172116395](https://raw.githubusercontent.com/jinkex55/picture/master/imagesimage-20220416172116395.png)





![image-20220416172629518](https://raw.githubusercontent.com/jinkex55/picture/master/imagesimage-20220416172629518.png)

什么可以提交的了，工作 空间都是干净的



![image-20220416172841565](https://raw.githubusercontent.com/jinkex55/picture/master/imagesimage-20220416172841565.png)

红色代表在工作区，没提交的



## 查看差异

![image-20220416173057947](https://raw.githubusercontent.com/jinkex55/picture/master/imagesimage-20220416173057947.png) 





## 版本回退

![image-20220416173206816](https://raw.githubusercontent.com/jinkex55/picture/master/imagesimage-20220416173206816.png)





原理

![image-20220416173256659](https://raw.githubusercontent.com/jinkex55/picture/master/imagesimage-20220416173256659.png)

将master指向上一个commit ，同时 将文件 指向暂存区





## 管理修改

![image-20220416173707640](https://raw.githubusercontent.com/jinkex55/picture/master/imagesimage-20220416173707640.png)

要理解工作区，暂存区和版本库，  

在某些情况下，工作区暂存区 版本库都会不一样![](https://raw.githubusercontent.com/jinkex55/picture/master/imagesimage-20220416173707640.png)

为什么会那样  推荐的第二种方式可以 将工作区的代码 提到暂存区，然后将暂存区的代码 一起提交 到版本库存，不会出现错误 



## 修改文件名

 ![image-20220416175734130](https://raw.githubusercontent.com/jinkex55/picture/master/imagesimage-20220416175734130.png)





## 忽略文件

![image-20220416175913783](https://raw.githubusercontent.com/jinkex55/picture/master/imagesimage-20220416175913783.png)

.gitignore文件下面的都可以忽略



![image-20220416180032244](https://raw.githubusercontent.com/jinkex55/picture/master/imagesimage-20220416180032244.png)

默认情况下 git add .  是将所有文件都添加到暂存区里面的

![image-20220416180124403](https://raw.githubusercontent.com/jinkex55/picture/master/imagesimage-20220416180124403.png)

例如这样就可以忽略其他你想要忽略 的文件 

## 临时保存

![image-20220416180333958](https://raw.githubusercontent.com/jinkex55/picture/master/imagesimage-20220416180333958.png)



![image-20220416180728747](https://raw.githubusercontent.com/jinkex55/picture/master/imagesimage-20220416180728747.png)

![image-20220416180652302](https://raw.githubusercontent.com/jinkex55/picture/master/imagesimage-20220416180652302.png)

![image-20220416181356625](https://raw.githubusercontent.com/jinkex55/picture/master/imagesimage-20220416181356625.png)

![image-20220416181742094](https://raw.githubusercontent.com/jinkex55/picture/master/imagesimage-20220416181742094.png)





## 查看暂存区文件

![image-20220418100421917](https://raw.githubusercontent.com/jinkex55/picture/master/images20220418100422.png)

git ls-files -s 

ls 列出所有文件 

![image-20220418100537244](https://raw.githubusercontent.com/jinkex55/picture/master/images20220418100537.png)









![image-20220506104656172](https://raw.githubusercontent.com/jinkex55/picture/master/images20220506104946.png)