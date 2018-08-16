# taotao-shopstore
## 2018-7-27
maven配置：`clean install`、`clean tomcat7:run`

项目结构：parent、manager-web、commons、manager目录平级，pom.xml继承parent。

soa，服务层，表现层

## 2018-7-31
dubbo架构下，实体类需要实现序列化接口

注册中心（Linux命令）：zkServer.sh start

监听中心(Tomcat服务器)：dubbo-admin

动态，静态资源：

```
<!--动静态资源-->
    <mvc:default-servlet-handler/>
    <mvc:annotation-driven></mvc:annotation-driven>
```



解决mapper.xml文件不发布到classes下：

```
<!--手动指定目标目录的文件，加载到类目录-->
<resources>
     <resource>
         <directory>src/main/java</directory>
            <includes>
               <include>**/*.xml</include>
            </includes>
       </resource>
</resources>
```
## 2018-8-4
完成了商品添加模块，使用fastDFS作为图片上传服务器。

虚拟机网段统一设置为`192.168.25.xxx`

使用工具类:`JsonUtils、IDUtils`

## 2018-8-16
更新了后台的内容管理页面
