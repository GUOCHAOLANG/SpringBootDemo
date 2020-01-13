# SpringBootDemo

git，spring boot 学习

================================
domebaseweb
引入依赖Web

================================
eureka-server
引入依赖Web
引入依赖Eureka Server

添加配置
#服务端口
server.port=10002

eureka.instance.hostname=localhost
#是否向服务注册中心注册自己
eureka.client.register-with-eureka=false
#它是用来管理服务的，所有不需要检索服务
eureka.client.fetch-registry=false
#注册中心
eureka.client.serviceUrl.defaultZone=http://${eureka.instance.hostname}:${server.port}/eureka/
#是否优先从文件系统加载template，以支持热加载，默认为true 这个会影响 访问注册中心
spring.freemarker.prefer-file-system-access=false
#自我保护模式
eureka.server.enable-self-preservation=true
#清理间隔（单位毫秒，默认是60*1000） 用于配置Eureka Server清理无效节点的时间间隔
eureka.server.eviction-interval-timer-in-ms=10000

启动类添加注解
@EnableEurekaServer



启动后访问注册中心（此页面时一个系统提供的页面，注意证据加配置***。prefer-file-system-access=false）
localhost:10002

================================
eureka-client
引入依赖Web
引入依赖Eureka Discovery Client

添加配置
#服务端口
server.port=10001
#服务名称
spring.application.name=eureka-client
#注册中心
eureka.client.serviceUrl.defaultZone=http://localhost:10002/eureka/

启动类添加注解
@EnableDiscoveryClient

================================

eureka-