## @Configuration、@ bean 

@Configuration注解

 相当于窗口的入口 ， 相当于配置文件 中的application.xml 

配合 @Bean注解 可以更加便捷的使用容器技术

@Bean注解

@Bean注解放在方法 上，进行bean对象的创建  默认情况 下方法 方法名就是bean在容器中的id



![image-20230217140021983](https://raw.githubusercontent.com/Eat-garlic/picture/master/img/20230217140022.png)





## @Bean方法 的注入



1:如果A   bean的属性本身 就有Autowired   B  bean     (Autowired的前提 是 B  bean本身在容器中)

直接newA 的bean  那么这个B  bean就会被注入到A  bean的属性当中



![image-20230217140847424](https://raw.githubusercontent.com/Eat-garlic/picture/master/img/20230217140847.png)











####  方法 的参数会自行的注入



![image-20230217142602523](https://raw.githubusercontent.com/Eat-garlic/picture/master/img/20230217142602.png)









#### bean方法注入在工厂类中

![image-20230217142802367](https://raw.githubusercontent.com/Eat-garlic/picture/master/img/20230217142802.png)













####  其他类型

![image-20230217142837030](https://raw.githubusercontent.com/Eat-garlic/picture/master/img/20230217142837.png)





### 总结

![image-20230217142855386](https://raw.githubusercontent.com/Eat-garlic/picture/master/img/20230217142855.png)





![image-20230217142923232](https://raw.githubusercontent.com/Eat-garlic/picture/master/img/20230217142923.png)