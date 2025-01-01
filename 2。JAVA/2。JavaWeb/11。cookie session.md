# Cookie  Session

### Cookie 是什么

coolie是可以存储数据的，一般是在客户端，我们可以看到存储在浏览器中，一般是用键值对的方式 来存储 ，k v 

### Session是什么 

session是在服务器端的，可以理解 为是一个对象，专门 有这么一个类的， 这里面可以存储 会话的临时信息，比如 哪个 连接什么的， 也可以存储 session           







## cookie和seesion是怎样保持会话的连续性

一般一个会话在发送请求给后端服务器，服务器会判断 这个当前会话是否携带一个Jseesionid的cookie，如果有，服务器，不创建新的sesiion，如果没有 会创建一个id 为 Jseeion的cookie ，返回 给 前台会话，下次如果这个会话请求过来，也会携带这个id为Jseesionid的cookie 



![image-20221216104926249](https://raw.githubusercontent.com/Eat-garlic/picture/master/images20221216104926.png)

![image-20221216104747055](https://raw.githubusercontent.com/Eat-garlic/picture/master/images20221216104747.png)