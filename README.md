# SpringCloud

**回顾之前的知识**

* JavaSE
* 数据库
* 前端
* Servlet
* Http
* MyBatis
* Spring
* SpringMVC
* SpringBoot
* Dubbo、Zookeeper、分布式基础
* Maven、Git
* AJAX、JSON

**自己会的东西**

* 数据库
* MyBatis
* Spring
* SpringMVC
* SpringBoot
* Dubbo、Zookeeper、分布式基础
* Maven、Git
* AJAX、JSON

**该阶段怎么学习**

1. 微服务架构

   **模块化**

2. 微服务架构4个核心问题

   1. 服务很多，客户怎么访问？
   2. 这么多服务之间怎么通信？
   3. 这么多服务如何治理？
   4. 服务挂了怎么办？

   解决方案：

   ​	SpringCloud：生态！

   1. **Spring Cloud NetFlix**

      一站式解决方案

      API网关：Zuul组件

      Feign——HttpClient——HTTP通信方式（同步，阻塞）

      服务注册与发现：Eureka

      熔断机制：Hystrix

   2. **Apache Dubbo Zookeeper**

      API：没有，第三方组件或自己实现

      Dubbo：通信

      Zookeeper：服务注册与发现

      熔断机制：没有，借助Hystrix

      

      Dubbo这个方案并不完善

   3. **Spring Cloud Alibaba**

      一站式解决方案！更简单



新概念：服务网格——Server Mesh



总之都是为了解决微服务架构的4个核心问题

1. API：客户端访问
2. HTTP，RPC：服务之间的通信
3. 注册与发现
4. 熔断机制





# 微服务概述

### 什么是为服务

微服务（Microservice Architecture）是近几年流行的一种架构思想，关于他的概念很难用一句话来解释

究竟什么是微服务？我可以引用ThoughtWorks公司的首席科学家Martin Fowler在2014年提出的一段话：

原文：https://martinfowler.com/articles/microservices.html

汉译：https://www.cnblogs.com/liuning8023/p/4493156.html



* 通常而言，微服务架构是一种架构模式，或者说是一种架构风格，**它提倡将单一的应用程序划分为一组小的服务**，每个服务运行在其独立的自己的进程中，服务之间互相协调、互相配置，为用户提供最终价值，服务之间采用轻量级的通信机制互相沟通，每个服务都围绕着具体的业务进行构建，并且能够独立的部署到生产环境中，另外，应尽量避免统一的、集中式的服务管理机制，对具体的一个服务而言，应根据业务的上下文，选择合适的语言、工具对其进行构建，可以有一个非常轻量级的集中式管理来协调这些服务，可以使用不同的语言进行编写服务，也可以使用不同的数据存储；



**通过技术维度理解：**

* 微服务化的核心就是将传统的一站式应用，根据业务拆分成一个一个的服务，彻底解去耦合，每一个微服务提供单个业务功能的服务，一个服务做一件事情，从技术角度看就是一种小而独立的处理过程，类似进程的概念，能够自行单独启动或销毁，拥有自己独立的数据库。



### 微服务与微服务架构

**微服务**

强调的是服务的大小，他关注的是某一个点，是具体解决某一个问题/提供落地对应服务的一个服务应用，狭义的看，可以看作是IDEA中的一个个微服务工程，或者Moudel

```
IDEA 工具里面使用Maven开发的一个个独立的小Moudle，它具体是使用SpringBoot开发的一个小模块，专业的事情交给专业的模块来做，一个模块就做一件事情
强调的是一个个的个体，每个个体完成一个具体的任务或者功能！
```



**微服务架构**

一种新的架构形式，Martin Fowler，2014年提出



微服务架构是一种架构模式，它提倡将单一应用程序划分成一组小的服务，服务之间互相协调，互相配合，为用户提供最终价值。服务之间采用轻量级的通信机制互相沟通，每个服务都围绕着具体的业务进行构建，并且能够独立的部署到生产环境中，另外，应尽量避免统一的、集中式的服务管理机制，对具体的一个服务而言，应根据业务的上下文，选择合适的语言、工具对其进行构建



### 微服务的优缺点

**优点**

* 单一职责原则

* 每个服务足够内聚，足够小，代码容易理解，这样能聚焦一个指定的业务功能或业务需求
* 开发简单，开发效率提高，一个服务可能就是专一的只干一件事
* 微服务能够被小团队单独开发，这个小团队事2~5人的开发人员组成
* 微服务事松耦合的，是有功能意义的服务，无论是在开发阶段或部署阶段都是独立的
* 微服务能使用不同的语言开发
* 易于和第三方集成，微服务允许容易且灵活的方式集成自动部署；通过持续集成工具，如jenkins、Hudson、bamboo
* 微服务易于被一个开发人员理解、修改和维护，这样的小团队能够更关注自己的工作成果。无需通过合作才能体现价值
* 微服务允许你利用融合最新技术
* **微服务只是业务逻辑的代码，不会和HTML、CSS或其他界面混合**
* **每个微服务都有自己的存储能力，可以有自己的数据库，也可以有统一的数据库**



**缺点：**

* 开发人员要处理分布式系统的复杂性
* 多服务运维难度，随着服务的增加，运维的压力也在增大
* 系统部署依赖
* 服务间通信成本
* 数据一致性
* 系统集成测试
* 性能监控...



### 微服务技术栈有哪些：

| 微服务条目                               | 落地技术                                                     |
| ---------------------------------------- | ------------------------------------------------------------ |
| 服务开发                                 | SpringBoot,Spring,SpringMVC                                  |
| 服务配置与管理                           | NetFlix公司的Archaius、阿里的Diamond等                       |
| 服务注册与发现                           | Eureka、Consul、Zookeeper等                                  |
| 服务调用                                 | Rest、RPC、gRPC                                              |
| 服务熔断器                               | Hystrix、Envoy等                                             |
| 负载均衡                                 | Ribbon、Nginx等                                              |
| 服务接口调用（客户端调用服务的简化工具） | Feign等                                                      |
| 消息队列                                 | Kafka、RabbitMQ、ActiveMQ                                    |
| 服务配置中心管理                         | SpringCloudConfig、Chef等                                    |
| 服务路由（API网关）                      | Zuul等                                                       |
| 服务监控                                 | Zabbix、Nagios、Metrics、Specatator等                        |
| 全链路追踪                               | Zipkin、Brave、Dapper等                                      |
| 服务部署                                 | Docker、OpenStack、Kubernetes等                              |
| 数据流操作开发包                         | SpringCloud Stream（封装与Redis、Rabbit、Kafka等发送接收消息） |
| 事件消息总线                             | SpringCloud Bus                                              |



### 为什么选择SpringCloud作为微服务架构

1. 选型依据

   * 整体解决方案和框架成熟度
   * 社区热度
   * 可维护性
   * 学习曲线

2. 当前各大IT公司用的微服务架构有哪些？

   * 阿里：Dubbo + HFS
   * 京东：JSF
   * 新浪：Motan
   * 当当网：DubboX

3. 各微服务框架对比

   | 功能点/服务架构 | NetFlix/SpringCloud                                          | Motan                                                        | gRPC                      | Thrift   | Dubbo/DubboX                    |
   | --------------- | ------------------------------------------------------------ | ------------------------------------------------------------ | ------------------------- | -------- | ------------------------------- |
   | 功能定位        | 完整的微服务框架                                             | RPC框架，但整合了ZK或Consul，实现集群环境的基本服务注册/发现 | RPC框架                   | RPC框架  | 服务框架                        |
   | 支持Rest        | 是，Ribbon支持多种可插拔的序列化选择                         | 否                                                           | 否                        | 否       | 否                              |
   | 支持RPC         | 否                                                           | 是（Hession2）                                               | 是                        | 是       | 是                              |
   | 支持多语言      | 是（Rest形式）                                               | 否                                                           | 是                        | 是       | 否                              |
   | 负载均衡        | 是（服务端Zuul+客户端Ribbon），zuul-服务，动态路由，，云端负载均衡，Eureka（针对中间层服务器） | 是（客户端）                                                 | 否                        | 否       | 是（客户端）                    |
   | 配置服务        | NetFlix Archaius，SpringCloud Config Server集中配置          | 是（Zookeeper提供）                                          | 否                        | 否       | 否                              |
   | 服务调用链监控  | 是（zuul），zuul提供边缘服务，API网关                        | 否                                                           | 否                        | 否       | 否                              |
   | 高可用/容错     | 是（服务端Hystrix+客户端Ribbon）                             | 是（客户端）                                                 | 否                        | 否       | 是（客户端）                    |
   | 典型应用案例    | NetFlix                                                      | Sina                                                         | Google                    | Facebook |                                 |
   | 社区活跃程度    | 高                                                           | 一般                                                         | 高                        | 一般     | 2017年后开始维护，之前中断了5年 |
   | 学习难度        | 中                                                           | 低                                                           | 高                        | 高       | 低                              |
   | 文档丰富程度    | 高                                                           | 一般                                                         | 一般                      | 一般     | 低                              |
   | 其他            | SpringCloud Bus为我们的应用程序带来了更多管理端点            | 支持降级                                                     | NetFlix内部在开发集成gRPC | IDL定义  | 实践的公司比较多                |





# SpringCloud入门概述

<b style="color:red">Spring Cloud 2020.0.0版本彻底删除掉了Netflix除Eureka外的所有组件</b>

### Netflix组件替代方案

| Netflix                     | 推荐替代品                               | 说明                                   |
| --------------------------- | ---------------------------------------- | -------------------------------------- |
| Hystrix                     | Resilience4j                             | Hystrix自己也推荐你使用它代替自己      |
| Hystrix Dashboard / Turbine | Micrometer + Monitoring System           | 说白了，监控这件事交给更专业的组件去做 |
| Ribbon                      | Spring Cloud Loadbalancer                | 忍不住了，Spring终究亲自出手           |
| Zuul                        | Spring Cloud Gateway                     | 忍不住了，Spring终究亲自出手           |
| Archaius                    | Spring Boot外部化配置 + Spring Cloud配置 | 比Netflix实现的更好、更强大            |


​		

### 什么是SpringCloud？

Spring官网：https://spring.io/

![](images/1.png)

SpringCloud,基于SpringBoot提供了一套微服务解决方案，包括服务注册与发现，配置中心，全链路监控，服务网关，负载均衡，熔断器等组件，除了基于NetFlix的开源组件做高度抽象封装之外，还有一些选型中立的开源组件。

SpringCloud利用SpringBoot的开发便利性，巧妙地简化了分布式系统基础设施的开发，SpringCloud为开发人员提供了快速构建分布式系统的一些工具，**包括配置管理，服务发现，断路器，路由，微代理，事件总线，全局锁，决策竞选，分布式会话等等**，他们都可以用SpringBoot的开发风格做到一键启动和部署。

SpringBoot并没有重复造轮子，它只是将目前各家公司开发的比较成熟，经得起实际考研的服务框架组合起来，通过SpringBoot风格进行再封装，屏蔽掉了复杂的配置和实现原理，**最终给开发者留出了一套简单易懂，易部署和易维护的分布式系统开发工具包**

SpringCloud是分布式微服务架构下的一站式解决方案，是各个微服务架构落地技术的集合体，俗称微服务全家桶。



### SpringCloud和SpringBoot关系

* SpringBoot专注于快速方便的开发单个个体微服务
* SpringCloud是关注全局的微服务协调整理治理框架，它将SpringBoot开发的一个个单体微服务整合并管理起来，为各个微服务之间提供：配置管理、服务发现、断路器、路由、微代理、事件总线、全局锁、决策竞选、分布式会话等等集成服务
* SpringBoot可以离开SpringCloud独立使用，开发项目，但是SpringCloud离不开SpringBoot，属于依赖关系
* **SpringBoot专注于快速、方便的开发单个个体微服务，SpringCloud关注全局的服务治理框架**



### Dubbo和SpringCloud技术选型

1. **分布式 + 服务治理Dubbo**

   目前成熟的互联网架构：应用服务化拆分 + 消息中间件

   ![](images/2.png)

2. Dubbo和SpringCloud对比

   可以看一下社区活跃度

   https://github.com/dubbo

   https://github.com/spring-cloud

   结果：

   |              | Dubbo         | Spring                        |
   | ------------ | ------------- | ----------------------------- |
   | 服务注册中心 | Zookeeper     | SpringCloud    NetFlix Eureka |
   | 服务调用方式 | RPC           | REST API                      |
   | 服务监控     | Dubbo-monitor | Spring Boot Admin             |
   | 断路器       | 不完善        | SpringCloud NetFlix Hystrix   |
   | 服务网关     | 无            | SpringCloud NetFlix Zuul      |
   | 分布式配置   | 无            | SpringCloud Config            |
   | 服务跟踪     | 无            | SpringCloud Sleuth            |
   | 消息总线     | 无            | SpringCloud Bus               |
   | 数据流       | 无            | SpringCloud Stream            |
   | 批量任务     | 无            | SpringCloud Task              |

   **最大区别：SpringCloud抛弃了Dubbo的RPC通信，采用的是基于HTTP的REST方式。**

   严格来说，这两种方式各有优势。虽然从一定程度上来说，后者牺牲了服务调用的性能，但也避免了上面提到的原生RPC带来的问题。而且REST相比RPC更为灵活，服务提供方和调用方只依赖一纸契约，不存在代码级别的强依赖，这在强调快速演化的微服务环境下，显得更加合适。

   **品牌机与组装机的区别**

   很明显，Spring Cloud的功能比DUBBO更加强大，涵盖面更广，而且作为Spring的拳头项目，它也能够与SpringFramework、Spring Boot、Spring Data、Spring Batch等其他Spring项目完美融合，这些对于微服务而言是至关重要的。使用Dubbo构建的微服务架构就像组装电脑，各环节我们的选择自由度很高，但是最终结果很有可能因为一条内存质量不行就点不亮了，总是让人不怎么放心，但是如果你是一名高手，那这些都不是问题;而SpringCloud就像品牌机，在Spring Source的整合下，做了大量的兼容性测试，保证了机器拥有更高的稳定性，但是如果要在使用非原装组件外的东西，就需要对其基础有足够的了解。

   **社区支持与更新力度**

   最为重要的是，DUBBO停止了5年左右的更新，虽然2017.7重启了。对于技术发展的新需求，需要由开发者自行拓展升级（比如当当网弄出了DubboX)，这对于很多想要采用微服务架构的中小软件组织，显然是不太合适的,中小公司没有这么强大的技术能力去修改Dubbo源码+周边的一整套解决方案，并不是每一个公司都有阿里的大牛+真实的线上生产环境测试过。

   **总结：**

   曾风靡国内的开源RPC服务框架Dubbo在重启维护后，令许多用户为之雀跃，但同时，也迎来了一些质疑的声音。互联网技术发展迅速，Dubbo是否还能跟上时代? Dubbo与Spring Cloud相比又有何优势和差异?是否会有相关举措保证 Dubbo的后续更新频率?

   人物：Dubbo重启维护开发的刘军，主要负责人之一

   刘军，阿里巴巴中间件高级研发工程师，主导了 Dubbo重启维护以后的几个发版计划，专注于高性能RPC框架和微服务相关领域。曾负责网易考拉RPC框架的研发及指导在内部使用，参与了服务治理平台、分布式跟踪系统、分布式一致性框架等从无到有的设计与开发过程。

   **解决的问题域不一样: Dubbo的定位是一款RPC框架，Spring Cloud的目标是微服务架构下的一站式解决方案**



### SpringCloud能干嘛

* Distributed/versioned configuration(分布式/版本控制配置)
* Service registration and discovery(服务注册与发现)
* Routing(路由)
* Service-to-service calls(服务到服务的调用)
* Load balancing(负载均衡配置)
* Circuit Breakers(断路器)
* Distributed messaging(分布式消息管理)



### SpringCloud在哪下

官网：https://projects.spring.io/spring-cloud/

![](images/3.png)

```
spring cloud是一个由众多独立子项目组成的大型综合项目，每个子项目有不同的发行节奏，都维护着自己的发布版本号。spring cloud通过一个资源清单BOM(Bi11 of Materials)来管理每个版本的子项目清单。为避免与子项目的发布号混淆，所以没有采用版本号的方式，而是通过命名的方式。

这些版本名称的命名方式采用了伦敦地铁站的名称，同时根据字母表的顺序来对应版本时间顺序，比如:最早的Release版本: Ange1，第二个Release版本: Brixton，然后是camden、Dalston、Edgware，目前最新的是Finchley版本。
```



参考书：

* https://springcloud.cc/spring-cloud-netflix.html
* 中文API文档：https://springcloud.cc/spring-cloud-dalston.html
* SpringCloud中国社区：http://springcloud.cn/
* SpringCloud中文网：https://springcloud.cc



# SpringCloud——REST

### 总体介绍

* 我们会使用一个Dept部门模块做一个微服务通用案例Consumer消费者（Client）通过REST调用Provider提供者（Server）提供的服务

* Maven的分包分模块架构复习

  ```
  一个简单的Maven模块结构是这样的：
  -- app-parent：一个父项目(app-parent)聚合了很多子项目(app-util，app-dao，app_web...)
  |-- pom.xml
    |
    |-- app-core
    ||---- pom.xml
    |
    |-- app-web
    ||---- pom.xml
    ......
  ```
  
  一个父工程带着多个子Module子模块
  
  MicroserviceCloud父工程（Project）下初次带着3个子模块（Module）
  
  * microservicecloud-api【封装的整体entity/接口/公共配置等】
  * microservicecloud-provider-dept-8001【服务提供者】
  * microservicecloud-consumer-dept-80【服务消费者】
  
* 开干！



### SpringCloud版本选择

**大版本说明**

| Spring Boot | Spring Cloud            | 关系                                           |
| ----------- | ----------------------- | ---------------------------------------------- |
| 1.2.x       | Angel版本(天使)         | 兼容Spring Boot 1.2.x                          |
| 1.3.x       | Brixton版本(布里克斯顿) | 兼容Spring Boot 1.3.x，也兼容Spring Boot 1.4.x |
| 1.4.x       | Camden版本(卡姆登)      | 兼容Spring Boot 1.4.x，也兼容Spring Boot 1.5.x |
| 1.5.x       | Dalston版本(多尔斯顿)   | 兼容Spring Boot 1.5.x，不兼容Spring Boot 2.0.x |
| 1.5.x       | Edgware(埃奇韦尔)       | 兼容Spring Boot 1.5.x，不兼容Spring Boot 2.0.x |
| 2.0.x       | Finchley版本(芬奇利)    | 兼容Spring Boot 2.0.x，不兼容Spring Boot 1.5.x |
| 2.1.x       | Greenwich(格林威治)     |                                                |

**实际开发版本关系**

![](images/4.png)

使用最后的这两个



### 创建父工程

* 新建父工程项目springcloud，切记Packageing是pom模式
* 主要是定义POM文件，将后续各个子模块公用的jar包等统一提取出来，类似一个抽象父类

**pom.xml**

```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
     <modelVersion>4.0.0</modelVersion>

     <groupId>com.guighost</groupId>
     <artifactId>springcloud</artifactId>
     <version>1.0-SNAPSHOT</version>
     <modules>
          <module>springcloud-api</module>
          <module>springcloud-provider-dept-8001</module>
          <module>springcloud-consumer-dept-80</module>
     </modules>

     <!-- 打包方式  pom-->
     <packaging>pom</packaging>

     <properties>
          <!-- 设置UTF-8编码 -->
          <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
          <!-- 指定JDK的版本 -->
          <maven.compiler.source>14</maven.compiler.source>
          <maven.compiler.target>14</maven.compiler.target>
          <!-- 指定依赖的版本 -->
          <junit.version>4.13.2</junit.version>
          <lombok.version>1.18.18</lombok.version>
          <log4j.version>1.2.17</log4j.version>
     </properties>

     <dependencyManagement>
          <dependencies>
               <!--SpringCloud的依赖-->
               <!-- https://mvnrepository.com/artifact/org.springframework.cloud/spring-cloud-dependencies -->
               <dependency>
                    <groupId>org.springframework.cloud</groupId>
                    <artifactId>spring-cloud-dependencies</artifactId>
                    <version>2020.0.2</version>
                    <type>pom</type>
                    <scope>import</scope>
               </dependency>
               <!--SpringBoot-->
               <dependency>
                    <groupId>org.springframework.boot</groupId>
                    <artifactId>spring-boot-dependencies</artifactId>
                    <version>2.4.4</version>
                    <type>pom</type>
                    <scope>import</scope>
               </dependency>
               <!--数据库-->
               <dependency>
                    <groupId>mysql</groupId>
                    <artifactId>mysql-connector-java</artifactId>
                    <version>8.0.23</version>
               </dependency>
               <!--数据源：Druid-->
               <dependency>
                    <groupId>com.alibaba</groupId>
                    <artifactId>druid</artifactId>
                    <version>1.2.5</version>
               </dependency>
               <!-- SpringBoot 启动器-->
               <dependency>
                    <groupId>org.mybatis.spring.boot</groupId>
                    <artifactId>mybatis-spring-boot-starter</artifactId>
                    <version>2.1.4</version>
               </dependency>

               <!-- 日志和测试-->
               <dependency>
                    <groupId>ch.qos.logback</groupId>
                    <artifactId>logback-core</artifactId>
                    <version>1.2.3</version>
               </dependency>
               <!-- junit -->
               <dependency>
                    <groupId>junit</groupId>
                    <artifactId>junit</artifactId>
                    <version>${junit.version}</version>
               </dependency>
               <!-- Lombok -->
               <dependency>
                    <groupId>org.projectlombok</groupId>
                    <artifactId>lombok</artifactId>
                    <version>${lombok.version}</version>
               </dependency>
               <!-- Log4j -->
               <dependency>
                    <groupId>log4j</groupId>
                    <artifactId>log4j</artifactId>
                    <version>${log4j.version}</version>
               </dependency>
          </dependencies>
     </dependencyManagement>
</project>
```



### 创建API

1. 在父工程中new Module：名为springcloud-api

2. pom.xml

   ```xml
   <?xml version="1.0" encoding="UTF-8"?>
   <project xmlns="http://maven.apache.org/POM/4.0.0"
            xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
            xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
        <parent>
             <artifactId>springcloud</artifactId>
             <groupId>com.guighost</groupId>
             <version>1.0-SNAPSHOT</version>
        </parent>
        <modelVersion>4.0.0</modelVersion>
   
        <artifactId>springcloud-api</artifactId>
   
        <!-- 当前的Module自己需要的依赖，若父依赖中已经配置了版本，这里就不用写了-->
        <dependencies>
             <dependency>
                  <groupId>org.projectlombok</groupId>
                  <artifactId>lombok</artifactId>
             </dependency>
        </dependencies>
   </project>
   ```

3. 新建一个实体类

   <img src="images/5.png" style="zoom:50%;" />

   ```java
   package com.guighost.springcloud.entity;
   
   import lombok.Data;
   import lombok.NoArgsConstructor;
   import lombok.experimental.Accessors;
   
   import java.io.Serializable;
   
   /**
    * @author GuiGhost
    * @date 2021/04/06
    * @className Dept()
    * 描述：部门表实体类
    * orm：类表关系映射
    */
   @Data
   @NoArgsConstructor
   @Accessors(chain = true)    //链式写法
   public class Dept implements Serializable { //注意：在微服务阶段，实体类都要序列化
        private Long deptno;//主键
        private String dname;//部门名称
   
        //这个数据是存在哪个数据库的字段~ 微服务：一个服务对应一个数据库，同一个信息可能存在不同的数据库
        private String db_source;
   
        public Dept(String dname){
             this.dname = dname;
        }
   
        /**
        * 链式写法：
        * Dept dept = new Dept();
        *
        * dept.setDname("ddd").setDpetno(11).setDb_source("cloud-db1");
        *
        */
   }
   ```



### 服务提供者

1. 在父工程中new Module：名为：springcloud-provider-dept-8001

2. pom.xml

   **注意：我们需要实体类，所以在pom.xml文件中配置我们的springcloud-api**

   ```xml
   <?xml version="1.0" encoding="UTF-8"?>
   <project xmlns="http://maven.apache.org/POM/4.0.0"
            xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
            xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
       <parent>
           <artifactId>springcloud</artifactId>
           <groupId>com.guighost</groupId>
           <version>1.0-SNAPSHOT</version>
       </parent>
       <modelVersion>4.0.0</modelVersion>
   
       <artifactId>springcloud-provider-dept-8001</artifactId>
   
       <dependencies>
           <!-- 我们需要拿到我们的实体类，所以需要配置api Module -->
           <dependency>
               <groupId>com.guighost</groupId>
               <artifactId>springcloud-api</artifactId>
               <version>1.0-SNAPSHOT</version>
           </dependency>
   
           <!-- junit -->
           <dependency>
               <groupId>junit</groupId>
               <artifactId>junit</artifactId>
           </dependency>
   
           <!-- MySQL -->
           <dependency>
               <groupId>mysql</groupId>
               <artifactId>mysql-connector-java</artifactId>
           </dependency>
   
           <!-- 数据源：Druid -->
           <dependency>
               <groupId>com.alibaba</groupId>
               <artifactId>druid</artifactId>
           </dependency>
           <dependency>
               <groupId>ch.qos.logback</groupId>
               <artifactId>logback-core</artifactId>
           </dependency>
           <!-- springboot整合mybatis-->
           <dependency>
               <groupId>org.mybatis.spring.boot</groupId>
               <artifactId>mybatis-spring-boot-starter</artifactId>
           </dependency>
   
           <!-- test -->
           <dependency>
               <groupId>org.springframework.boot</groupId>
               <artifactId>spring-boot-test</artifactId>
           </dependency>
           <!-- WEB -->
           <dependency>
               <groupId>org.springframework.boot</groupId>
               <artifactId>spring-boot-starter-web</artifactId>
           </dependency>
           <!-- jetty 应用服务器：与Tomcat一样-->
           <dependency>
               <groupId>org.springframework.boot</groupId>
               <artifactId>spring-boot-starter-jetty</artifactId>
           </dependency>
           <!-- 热部署工具 -->
           <dependency>
               <groupId>org.springframework.boot</groupId>
               <artifactId>spring-boot-devtools</artifactId>
           </dependency>
       </dependencies>
   </project>
   ```

3. application.yaml

   注意：配置数据库连接、Druid数据源以及MyBatis的配置

   ```yaml
   # 配置端口号
   server:
     port: 8001
   
   # mybatis配置
   mybatis:
     # 配置实体类的别名
     type-aliases-package: com.guighost.springcloud.entity
     # 配置mapper文件路径
     mapper-locations: classpath:mybatis/mapper/*.xml
     # 配置mybatis的核心xml文件的路径（该核心配置文件可以省略，因为在application.yaml中都可以配置）
     config-location: classpath:mybatis/mybatis-config.xml
   
   # spring的配置
   spring:
     # 服务提供者的名字
     application:
       name: springcloud-provider-dept
     # 配置数据库连接和数据源
     datasource:
       type: com.alibaba.druid.pool.DruidDataSource
       driver-class-name: com.mysql.cj.jdbc.Driver
       url: jdbc:mysql://localhost:3306/cloud-db01?serverTimezone=UTC&useUnicode=true&characterEncoding=utf-8
       username: root
       password: ghost
   ```

4. mybatis-config.xml：MyBatis的核心配置文件【可省略】

   ```xml
   <?xml version="1.0" encoding="UTF-8" ?>
   <!DOCTYPE configuration
           PUBLIC "-//mybatis.org//DTD Config 3.0//EN"
           "http://mybatis.org/dtd/mybatis-3-config.dtd">
   <!--该配置文件可以省略：在application.yaml配置文件中都可以配置-->
   <configuration>
        <settings>
             <!-- 开启二级缓存 -->
             <setting name="cacheEnabled" value="true"/>
        </settings>
   </configuration>
   ```

5. 编写dao/mapper

   **接口**

   ```java
   package com.guighost.springcloud.dao;
   
   import com.guighost.springcloud.entity.Dept;
   import org.apache.ibatis.annotations.Mapper;
   import org.apache.ibatis.annotations.Param;
   import org.springframework.stereotype.Repository;
   
   import java.util.List;
   
   /**
    * @author GuiGhost
    * @date 2021/04/07
    * @interfaceName DeptDao()
    * 描述：数据访问层接口
    */
   @Mapper    //该注解是为了这个接口在编译时会生成相应的实现类
   @Repository    //该注解是为了将该类注入到Spring容器
   public interface DeptDao {
       public boolean addDept(Dept dept);
   
       public Dept getById(@Param("deptno") Long id);
   
       public List<Dept> getAll();
   }
   ```

   **xml文件**

   ```xml
   <?xml version="1.0" encoding="UTF-8" ?>
   <!DOCTYPE mapper
           PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
           "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
   <mapper namespace="com.guighost.springcloud.dao.DeptDao">
       <insert id="addDept" parameterType="Dept">
           insert into `cloud-db01`.dept (dname,db_source)
           values (#{dname},DATABASE())
       </insert>
   
       <select id="getById" parameterType="Long" resultType="Dept">
           select *
           from `cloud-db01`.dept
           where deptno = #{deptno}
       </select>
   
       <select id="getAll" resultType="Dept">
           select * from `cloud-db01`.dept
       </select>
   </mapper>
   ```

6. 编写service服务层接口以及实现类

   **service接口**

   ```java
   package com.guighost.springcloud.service;
   
   import com.guighost.springcloud.entity.Dept;
   import java.util.List;
   
   /**
    * @author GuiGhost
    * @date 2021/04/07
    * @interfaceName DeptService()
    * 描述：部门表业务接口
    */
   public interface DeptService {
       public boolean addDept(Dept dept);
   
       public Dept getById(Long id);
   
       public List<Dept> getAll();
   }
   ```

   **service接口实现类**

   ```java
   package com.guighost.springcloud.service.impl;
   
   import com.guighost.springcloud.dao.DeptDao;
   import com.guighost.springcloud.entity.Dept;
   import com.guighost.springcloud.service.DeptService;
   import org.springframework.beans.factory.annotation.Autowired;
   import org.springframework.stereotype.Service;
   
   import java.util.List;
   
   /**
    * @author GuiGhost
    * @date 2021/04/07
    * @className DeptServiceImpl()
    * 描述：部门表业务接口实现类
    */
   @Service   //将该类注入到Spring容器
   public class DeptServiceImpl implements DeptService {
   
       @Autowired
       private DeptDao deptDao;
   
       @Override
       public boolean addDept(Dept dept) {
           return deptDao.addDept(dept);
       }
   
       @Override
       public Dept getById(Long id) {
           return deptDao.getById(id);
       }
   
       @Override
       public List<Dept> getAll() {
           return deptDao.getAll();
       }
   }
   ```

7. 编写Controller接口

   ```java
   package com.guighost.springcloud.controller;
   
   import com.guighost.springcloud.entity.Dept;
   import com.guighost.springcloud.service.DeptService;
   import org.springframework.beans.factory.annotation.Autowired;
   import org.springframework.web.bind.annotation.GetMapping;
   import org.springframework.web.bind.annotation.PathVariable;
   import org.springframework.web.bind.annotation.PostMapping;
   import org.springframework.web.bind.annotation.RestController;
   
   import java.util.List;
   
   /**
    * @author GuiGhost
    * @date 2021/04/07
    * @className DeptController()
    * 描述：提供RestFul服务
    */
   @RestController
   public class DeptController {
   
       @Autowired
       private DeptService deptService;
   
       @PostMapping("/dept/add")
       public boolean addDept(Dept dept){
           return deptService.addDept(dept);
       }
   
       @GetMapping("/dept/get/{deptno}")
       public Dept get(@PathVariable("deptno") Long id){
           return deptService.getById(id);
       }
   
       @GetMapping("/dept/list")
       public List<Dept> getAll(){
           return deptService.getAll();
       }
   }
   ```

8. 编写服务的启动器

   ```java
   package com.guighost.springcloud;
   
   import org.springframework.boot.SpringApplication;
   import org.springframework.boot.autoconfigure.SpringBootApplication;
   
   /**
    * @author GuiGhost
    * @date 2021/04/07
    * @className DeptProvider_8001()
    * 描述：主启动类
    */
   @SpringBootApplication
   public class DeptProvider_8001 {
       public static void main(String[] args) {
           SpringApplication.run(DeptProvider_8001.class,args);
       }
   }
   ```

9. 测试

   ![](images/6.png)

   **测试OK**

10. 提供者服务的项目结构

    ![](images/7.png)



### 服务消费者

1. 在父工程new Module：名为：springcloud-consumer-dept-80

2. pom.xml

   ```xml
   <?xml version="1.0" encoding="UTF-8"?>
   <project xmlns="http://maven.apache.org/POM/4.0.0"
            xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
            xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
       <parent>
           <artifactId>springcloud</artifactId>
           <groupId>com.guighost</groupId>
           <version>1.0-SNAPSHOT</version>
       </parent>
       <modelVersion>4.0.0</modelVersion>
   
       <artifactId>springcloud-consumer-dept-80</artifactId>
   
       <!-- 实体类 + WEB + 热部署工具-->
       <dependencies>
           <dependency>
               <groupId>com.guighost</groupId>
               <artifactId>springcloud-api</artifactId>
               <version>1.0-SNAPSHOT</version>
           </dependency>
           <dependency>
               <groupId>org.springframework.boot</groupId>
               <artifactId>spring-boot-starter-web</artifactId>
           </dependency>
           <dependency>
               <groupId>org.springframework.boot</groupId>
               <artifactId>spring-boot-devtools</artifactId>
           </dependency>
       </dependencies>
   </project>
   ```

3. application.yaml

   ```yaml
   server:
     port: 80
   ```

4. 编写配置类：ConfigBean（配置RestTemplate：消费者访问提供者需要）

   ```java
   package com.guighost.springcloud.config;
   
   import org.springframework.context.annotation.Bean;
   import org.springframework.context.annotation.Configuration;
   import org.springframework.web.client.RestTemplate;
   
   /**
    * @author GuiGhost
    * @date 2021/04/07
    * @className ConfigBean()
    * 描述：@Configuration    ——  相当于spring中的applicationContext.xml
    */
   @Configuration
   public class ConfigBean {
   
       @Bean
       public RestTemplate restTemplate(){
           return new RestTemplate();
       }
   }
   ```

5. 编写Controller接口：DeptConsumerController

   ```java
   package com.guighost.springcloud.controller;
   
   import com.guighost.springcloud.entity.Dept;
   import org.springframework.beans.factory.annotation.Autowired;
   import org.springframework.web.bind.annotation.PathVariable;
   import org.springframework.web.bind.annotation.RequestMapping;
   import org.springframework.web.bind.annotation.RestController;
   import org.springframework.web.client.RestTemplate;
   
   import java.util.List;
   
   /**
    * @author GuiGhost
    * @date 2021/04/07
    * @className DeptConsumerController()
    * 描述：
    */
   @RestController
   public class DeptConsumerController {
       // 消费者不应该有service层
       /**
        * RestTemplate：里面有很多的方法供我们直接调用
        * 作用：提供多种边界访问远程http服务的方法，简单的RestFul服务模板
        * 若要使用RestTemplate，将其注册到Spring中即可
        * 核心参数：(String url,实体：Map,Class<T> responseType)
        *          请求地址        实体          返回值
        */
       @Autowired
       private RestTemplate restTemplate;
   
       //提供者提供的接口地址
       private static final String REST_URL_PREFIX = "http://localhost:8001";
   
       @RequestMapping("/consumer/dept/get/{deptno}")
       public Dept get(@PathVariable("deptno") Long id){
           return restTemplate.getForObject(REST_URL_PREFIX + "/dept/get/" + id,Dept.class);
       }
   
       @RequestMapping("/consumer/dept/add")
       public boolean add(Dept dept){
           return restTemplate.postForObject(REST_URL_PREFIX + "/dept/add",dept,Boolean.class);
       }
   
       @RequestMapping("/consumer/dept/list")
       public List<Dept> getAll(){
           return restTemplate.getForObject(REST_URL_PREFIX + "/dept/list",List.class);
       }
   
   }
   ```

6. 编写服务启动器

   ```java
   package com.guighost.springcloud;
   
   import org.springframework.boot.SpringApplication;
   import org.springframework.boot.autoconfigure.SpringBootApplication;
   
   /**
    * @author GuiGhost
    * @date 2021/04/07
    * @className DeptConsumer_80()
    * 描述：主启动类
    */
   @SpringBootApplication
   public class DeptConsumer_80 {
       public static void main(String[] args) {
           SpringApplication.run(DeptConsumer_80.class,args);
       }
   }
   ```

7. 测试

   ![](images/8.png)

   测试OK

8. 消费者服务项目结构

   ![](images/9.png)




# Eureka服务注册与发现

### 什么是Eureka

* Eureka [juˈriːkə]
* NetFlix在设计Eureka时，遵循的就是AP原则
* Eureka是Netflix的一个子模块，也是核心模块之一。Eureka是一个基于REST的服务，用于定位服务，以实现云端中间层服务发现和故障转移，服务注册与发现对于微服务来说是非常重要的，有了服务发现与注册，只需要使用服务的标识符，就可以访问到服务，而不需要修改服务调用的配置文件了，功能类似于Dubbo的注册中心，比如Zookeeper;



### 原理讲解

* Eureka的基本架构

  * SpringCloud封装了NetFlix公司开发的Eureka模块来实现服务注册和发现(对比Zookeeper)

  * Eureka采用了C-S的架构设计，EurekaServer作为服务注册功能的服务器，他是服务注册中心

  * 而系统中的其他微服务。使用Eureka的客户端连接到EurekaServer并维持心跳连接。这样系统的维护人员就可以通过EurekaServer来监控系统中各个微服务是否正常运行，SpringCloud的一些其他模块（比如Zuul)就可以通过EurekaServer来发现系统中的其他微服务，并执行相关的逻辑

  * 和Dubbo架构对比

    ![](images/10.png)

    ![](images/11.png)

  * Eureka包含两个组件: **Eureka Server**和**Eureka Client**

  * Eureka Server提供服务注册服务，各个节点启动后，会在EurekaServer中进行注册，这样Eureka Server中的服务注册表中将会存储所有可用服务节点的信息，服务节点的信息可以在界面中直观的看到

  * Eureka Client是一个Java客户端，用于简化EurekaServer的交互，客户端同时也具备一个内置的，使用轮询负载算法的负载均衡器。在应用启动后，将会向EurekaServer发送心跳（默认周期为30秒)。如果Eureka Server在多个心跳周期内没有接收到某个节点的心跳，EurekaServer将会从服务注册表中把这个服务节点移除掉(默认周期为90秒)

* 三大角色

  * Eureka Server:提供服务的注册于发现。
  * Service Provider:将自身服务注册到Eureka中，从而使消费方能够找到。
  * Service Consumer:服务消费方从Eureka中获取注册服务列表，从而找到消费服务。



### 编写Eureka服务

1. 在父工程中new Module：名为：springcloud-eureka-7001

2. pom.xml

   ```xml
   <?xml version="1.0" encoding="UTF-8"?>
   <project xmlns="http://maven.apache.org/POM/4.0.0"
            xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
            xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
       <parent>
           <artifactId>springcloud</artifactId>
           <groupId>com.guighost</groupId>
           <version>1.0-SNAPSHOT</version>
       </parent>
       <modelVersion>4.0.0</modelVersion>
   
       <artifactId>springcloud-eureka-7001</artifactId>
   
       <!-- 导包 -->
       <dependencies>
           <!-- Eureka -->
           <!-- https://mvnrepository.com/artifact/org.springframework.cloud/spring-cloud-starter-eureka-server -->
           <dependency>
               <groupId>org.springframework.cloud</groupId>
               <artifactId>spring-cloud-starter-eureka-server</artifactId>
               <version>1.4.7.RELEASE</version>
           </dependency>
           <!-- 热部署工具 -->
           <dependency>
               <groupId>org.springframework.boot</groupId>
               <artifactId>spring-boot-devtools</artifactId>
           </dependency>
       </dependencies>
   </project>
   ```

3. application.yaml

   ```yaml
   server:
     port: 7001
   
   # Eureka配置
   eureka:
     instance:
       hostname: localhost  # Eureka服务端的实例名称
     client:
       register-with-eureka: false   # 表示是否向Eureka注册中心注册自己
       fetch-registry: false   # fetch-registry为false时，则表示自己为注册中心
       service-url:  # 监控页面（与Eureka交互的路径）
         defaultZone: http://${eureka.instance.hostname}:${server.port}/eureka/  # 别人访问Eureka服务的路径
   ```

4. 编写主启动类并开启Eureka服务

   **注意：开启某个功能一般都是：@EnableXxxx；如开启Eureka服务：使用@EnableEurekaServer注解**

   ```java
   package com.guighost.springcloud;
   
   import org.springframework.boot.SpringApplication;
   import org.springframework.boot.autoconfigure.SpringBootApplication;
   import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
   
   /**
    * @author GuiGhost
    * @date 2021/04/07
    * @className EurekaServer_7001()
    * 描述：主启动类
    */
   // 启动之后，访问http://localhost:7001/
   @SpringBootApplication
   @EnableEurekaServer     //@EnableEurekaServer   服务端的启动类，可以接受别人注册进来
   public class EurekaServer_7001 {
       public static void main(String[] args) {
           SpringApplication.run(EurekaServer_7001.class,args);
       }
   }
   ```

5. 测试：访问Eureka：http://localhost:7001/

   ![](images/12.png)

6. 项目结构图

   ![](images/13.png)



### 将提供者注册到Eureka

1. 打开服务提供者的项目：springcloud-provider-dept-8001(在原来的代码的基础上)

2. pom.xml：导入Eureka的依赖

   ```xml
   <!-- Eureka -->
   <!-- https://mvnrepository.com/artifact/org.springframework.cloud/spring-cloud-starter-eureka -->
   <dependency>
        <groupId>org.springframework.cloud</groupId>
        <artifactId>spring-cloud-starter-eureka</artifactId>
        <version>1.4.7.RELEASE</version>
   </dependency>
   ```

3. application.yaml：配置的是将该项目中的服务通过http://localhost:7001/eureka/注册到Eureka中，还有修改Eureka中默认的Status

   ```yaml
   # Eureka配置：服务注册到哪里
   eureka:
     client:
       service-url:
         defaultZone: http://localhost:7001/eureka/
     # 修改eureka上的默认描述信息（Eureka中默认的Status）
     instance:
       instance-id: springcloud-provider-dept:8001
   ```

4. 在服务提供者项目中开启Eureka

   通过@EnableEurekaClient注解开启；作用：在服务启动后，自动注册到Eureka中

   ```java
   package com.guighost.springcloud;
   
   import org.springframework.boot.SpringApplication;
   import org.springframework.boot.autoconfigure.SpringBootApplication;
   import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
   
   /**
    * @author GuiGhost
    * @date 2021/04/07
    * @className DeptProvider_8001()
    * 描述：主启动类
    */
   @SpringBootApplication
   @EnableEurekaClient     //该注解作用是：在服务启动后，自动注册到Eureka中
   public class DeptProvider_8001 {
       public static void main(String[] args) {
           SpringApplication.run(DeptProvider_8001.class,args);
       }
   }
   ```

5. 测试：http://localhost:7001/

   ![](images/14.png)

6. 由上图可以看出，我们修改的Eureka的默认Status是可以访问的，并且访问的链接为：ghost:8001/actuator/info（ghost相当于localhost）

   默认访问的结果为：404页面

   ![](images/15.png)

7. 如果我们解决上面这个404问题：则需要完善我们的Eureka的监控信息

   1. 导入pom依赖

      ```xml
      <!-- actuator：完善监控信息 -->
      <dependency>
           <groupId>org.springframework.boot</groupId>
           <artifactId>spring-boot-starter-actuator</artifactId>
      </dependency>
      ```

   2. 在application.yaml中配置此页面的信息：这些信息是以JSON的格式传输到页面

      ```yaml
      # 配置监控服务的信息
      info:
        app.name: Ghost-springcloud
        message: "已经完善的监控信息"
      ```

   3. 测试

      ![](images/16.png)
      
   4. 扩展
   
      显示服务的IP地址
   
      application.yaml配置
   
      ```yaml
      # Eureka配置：服务注册到哪里
      eureka:
        client:
          service-url:
            defaultZone: http://eureka7001:7001/eureka/,http://eureka7002:7002/eureka/,http://eureka7003:7003/eureka/
        # 修改eureka上的默认描述信息
        instance:
          instance-id: springcloud-provider-dept8001
          prefer-ip-address: true   # true可以显示服务的IP地址
      ```
   
      结果
   
      ![](images/24.png)



### Eureka的自我保护机制

![](images/17.png)

**自我保护机制：好死不如赖活着：**

一句话总结:某时刻某一个微服务不可以用了，eureka不会立刻清理，依旧会对该微服务的信息进行保存!

* 默认情况下，如果EurekaServer在一定时间内没有接收到某个微服务实例的心跳，EurekaServer将会注销该实例(默认90秒)。但是当网络分区故障发生时，微服务与Eureka之间无法正常通行，以上行为可能变得非常危险了--因为微服务本身其实是健康的，**此时本不应该注销这个服务**。Eureka通过**自我保护机制**来解决这个问题--当EurekaServer节点在短时间内丢失过多客户端时(可能发生了网络分区故障)，那么这个节点就会进入自我保护模式。一旦进入该模式，.EurekaServer就会保护服务注册表中的信息，不再删除服务注册表中的数据（也就是不会注销任何微服务)。当网络故障恢复后，该EurekaServer节点会自动退出自我保护模式
* 在自我保护模式中，EurekaServer会保护服务注册表中的信息，不再注销任何服务实例。当它收到的心跳数重新恢复到阈值以上时，该EurekaServer节点就会自动退出自我保护模式。它的设计哲学就是宁可保留错误的服务注册信息，也不盲目注销任何可能健康的服务实例。一句话:好死不如赖活着
* 综上，自我保护模式是一种应对网络异常的安全保护措施。它的架构哲学是宁可同时保留所有微服务（健康的微服务和不健康的微服务都会保留)，也不盲目注销任何健康的微服务。使用自我保护模式，可以让Eureka集群更加的健壮和稳定
* 在SpringCloud中，可以使用eureka.server.enab1e-se1f-preservation = false禁用自我保护模式【不推荐关闭自我保护机制】



### 8001（提供者）服务发现Discovery

* 对于注册进Eureka里面的微服务，可以通过服务发现来获得该服务的信息【对外暴露服务】

* 修改提供者8001工程中的DeptController

  注入：org.springframework.cloud.client.discovery包下的DiscoveryClient

  ```java
  package com.guighost.springcloud.controller;
  
  import com.guighost.springcloud.entity.Dept;
  import com.guighost.springcloud.service.DeptService;
  import org.springframework.beans.factory.annotation.Autowired;
  import org.springframework.cloud.client.ServiceInstance;
  import org.springframework.cloud.client.discovery.DiscoveryClient;
  import org.springframework.web.bind.annotation.*;
  
  import java.util.List;
  
  /**
   * @author GuiGhost
   * @date 2021/04/07
   * @className DeptController()
   * 描述：提供RestFul服务
   */
  @RestController
  public class DeptController {
  
      @Autowired
      private DeptService deptService;
  
      //获取一些配置的信息，得到具体的微服务
      @Autowired
      private DiscoveryClient client;
  
      @PostMapping("/dept/add")
      public boolean addDept(Dept dept){
          return deptService.addDept(dept);
      }
  
      @GetMapping("/dept/get/{deptno}")
      public Dept get(@PathVariable("deptno") Long id){
          return deptService.getById(id);
      }
  
      @GetMapping("/dept/list")
      public List<Dept> getAll(){
          return deptService.getAll();
      }
  
  
      //获取注册进来的微服务的一些信息
      @GetMapping("/dept/discovery")
      public Object discovery(){
          //获取微服务列表的清单
          List<String> services = client.getServices();
          System.out.println("discovery=>services:" + services);
  
          //得到一个具体的微服务信息，通过具体的微服务id（applicationName）
          List<ServiceInstance> instances = client.getInstances("SPRINGCLOUD-PROVIDER-DEPT");
  
          for (ServiceInstance instance : instances) {
              System.out.println(
                      instance.getHost() + "\t" +
                      instance.getPort() + "\t" +
                      instance.getUri() + "\t" +
                      instance.getServiceId()
              );
          }
  
          return this.client;
      }
  }
  ```

  ![](images/18.png)



### Eureka集群

将多个Eureka服务关联起来，当其中一个服务崩了时，其他的服务还可以继续使用：形成：**你中有我，我中有你**

1. 扩建两个Eureka服务：springcloud-eureka-7002、springcloud-eureka-7003

2. application.yaml文件的配置

   **springcloud-eureka-7002的application.yaml：**

   ```yaml
   server:
     port: 7002
   
   # Eureka配置
   eureka:
     instance:
       hostname: eureka7002  # Eureka服务端的实例名称
     client:
       register-with-eureka: false   # 表示是否向Eureka注册中心注册自己
       fetch-registry: false   # fetch-registry为false时，则表示自己为注册中心
       service-url:  # 监控页面（与Eureka交互的路径）
         # 集群其他的Eureka服务
         defaultZone: http://eureka7001:7001/eureka/,http://eureka7003:7003/eureka/  # 别人访问Eureka服务的路径
   ```

   **springcloud-eureka-7003的application.yaml：**

   ```yaml
   server:
     port: 7003
   
   # Eureka配置
   eureka:
     instance:
       hostname: eureka7003  # Eureka服务端的实例名称
     client:
       register-with-eureka: false   # 表示是否向Eureka注册中心注册自己
       fetch-registry: false   # fetch-registry为false时，则表示自己为注册中心
       service-url:  # 监控页面（与Eureka交互的路径）
         defaultZone: http://eureka7001:7001/eureka/,http://eureka7002:7002/eureka/  # 别人访问Eureka服务的路径
   ```

3. 分别编写扩展Eureka服务的启动器类

   **7002：**

   ```java
   package com.guighost.springcloud;
   
   import org.springframework.boot.SpringApplication;
   import org.springframework.boot.autoconfigure.SpringBootApplication;
   import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
   
   /**
    * @author GuiGhost
    * @date 2021/04/07
    * @className EurekaServer_7001()
    * 描述：主启动类
    */
   // 启动之后，访问http://localhost:7001/
   @SpringBootApplication
   @EnableEurekaServer     //@EnableEurekaServer   服务端的启动类，可以接受别人注册进来
   public class EurekaServer_7002 {
       public static void main(String[] args) {
           SpringApplication.run(EurekaServer_7002.class,args);
       }
   }
   ```

   **7003：**

   ```java
   package com.guighost.springcloud;
   
   import org.springframework.boot.SpringApplication;
   import org.springframework.boot.autoconfigure.SpringBootApplication;
   import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
   
   /**
    * @author GuiGhost
    * @date 2021/04/07
    * @className EurekaServer_7001()
    * 描述：主启动类
    */
   // 启动之后，访问http://localhost:7001/
   @SpringBootApplication
   @EnableEurekaServer     //@EnableEurekaServer   服务端的启动类，可以接受别人注册进来
   public class EurekaServer_7003 {
       public static void main(String[] args) {
           SpringApplication.run(EurekaServer_7003.class,args);
       }
   }
   ```

4. 更改服务提供者的配置文件中的服务注册地址

   同时提交到三个Eureka服务中

   ```yaml
   # Eureka配置：服务注册到哪里
   eureka:
     client:
       service-url:
         defaultZone: http://eureka7001:7001/eureka/,http://eureka7002:7002/eureka/,http://eureka7003:7003/eureka/
     # 修改eureka上的默认描述信息
     instance:
       instance-id: springcloud-provider-dept8001
   ```

5. 测试

   ![](images/19.png)

   ![](images/20.png)

   ![](images/21.png)



### 对比Zookeeper	<b style="color:red">重点：面试</b>

**回顾CAP原则**

* RDBMS（MySQL、Oracle、SqlServer）====> ACID
* NoSQL（Redis、MongoDB）====>	CAP

**ACID是什么？**

* A（Atomicity）原子性
* C（Consistency）一致性
* I（Isolation）隔离性
* D（Durability）持久性

**CAP是什么？**

* C（Consistency）强一致性
* A（Availability）可用性
* P（Partition tolerance）分区容错性

CAP的三进二：CA、AP、CP

<b style="color:red">CAP理论的核心</b>

* 一个分布式系统不可能同时很好的满足一致性、可用性、分区容错性这三个需求
* 根据CAP原理，将NoSQL数据库分成了满足CA原则、满足CP原则和满足AP原则三大类：
  * CA：单点集群，满足一致性、可用性系统，通常可扩展性较差
  * CP：满足一致性、分区容错性的系统，通常性能不是特别高
  * AP：满足可用性、分区容错性的系统，通常可能对一致性要求低一些



#### 作为服务注册中心，Eureka比Zookeeper好在哪里？

著名的CAP理论指出，一个分布式系统不可能同时满足C(一致性)、A(可用性)、P(容错性)

由于分区容错性P在分布式系统中是必须要保证的，因此我们只能在A和C之间进行权衡

* Zookeeper保证的时CP
* Eureka保证的是AP



**Zookeeper保证的是CP**

​	当向注册中心查询服务列表时，我们可以容忍注册中心返回的是几分钟以前的注册信息，但不能接受服务直接down掉不可用。也就是说，服务注册功能对可用性的要求要高于一致性。但是水k会出现这样一种情况，当master节点因为网络故障与其他节点失去联系时，剩余节点会重新进行leader选举。问题在于，选举leader的时间太长，30~120s，且选举期间整个zk集群都是不可用的，这就导致在选举期间注册服务瘫痪。在云部署的环境下，因为网络问题使得z水k集群失去master节点是较大概率会发生的事件，虽然服务最终能够恢复，但是漫长的选举时间导致的注册长期不可用是不能容忍的。

**Eureka保证的是AP**

​	Eureka看明白了这一点，因此在设计时就优先保证可用性。**Eureka各个节点都是平等的**，几个节点挂掉不会影响正常节点的工作，剩余的节点依然可以提供注册和查询服务。而Eureka的客户端在向某个Eureka注册时，如果发现连接失败，则会自动切换至其他节点，只要有一台Eureka还在，就能保住注册服务的可用性，只不过查到的信息可能不是最新的，除此之外，Eureka还有一种自我保护机制，如果在15分钟内超过85%的节点都没有正常的心跳，那么Eureka就认为客户端与注册中心出现了网络故障，此时会出现以下几种情况：

1. Eureka不再从注册列表中移除因为长时间没收到心跳而应该过期的服务
2. Eureka仍然能够接受新服务的注册和查询请求，但是不会被同步到其他节点上(即保证当前节点依然可用)
3. 当网络稳定时，当前实例新的注册信息会被同步到其他节点中



<b style="color:red">因此，Eureka可以很好的应对因网络故障导致部分节点失去联系的情况，而不会像Zookeeper那样使整个注册服务瘫痪</b>



# 负载均衡

* Ribbon
* SpringCloud LoadBalance：基于springcloud3.0.1版本Loadbalancer（替代Ribbon的负载均衡工具）



### Robbon

ribbon [ˈrɪbən]

![](images/23.png)

### Ribbon是什么？

* Spring Cloud Ribbon是基于Netflix Ribbon实现的一套<b style="color:red">客户端负载均衡的工具</b>
* 简单的说，Ribbon是Netflix发布的开源项目，主要功能是提供客户端的软件负载均衡算法，将NetFlix的中间层服务连接在一起。Ribbon的客户端组件提供一系列完整的配置项如:连接超时、重试等等。简单的说，就是在配置文件中列出LoadBalancer(简称LB:负载均衡）后面所有的机器，Ribbon会自动的帮助你基于某种规则(如简单轮询，随机连接等等）去连接这些机器。我们也很容易使用Ribbon实现自定义的负载均衡算法



### Ribbon能干嘛？

* LB：即负载均衡（Load Balance），在微服务或分布式集群中经常用的一种应用
* 负载均衡简单的说就是将用户的请求平摊的分配到多个服务上，从而达到系统的HA（高可用）
* 常见的负载均衡软件Nginx、Lvs等等
* Dubbo、SpringCloud中均给我们提供了负载均衡，**SpringCloud的负载均衡算法可以自定义**
* 负载均衡简单分类：
  * 集中式LB
    * 即在服务的消费方和提供方之间使用独立的LB设施，如Nginx，由该设施负责把访问请求通过某种策略转发至服务的提供方!
  * 进程式LB
    * 将LB逻辑集成到消费方，消费方从服务注册中心获知有哪些地址可用，然后自己再从这些地址中选出一个合适的服务器。
    * <b style="color:red">Ribbon就属于进程式LB</b>，它只是一个类库，集成于消费方进程，消费方通过它来获取到服务提供方的地址!



### Ribbon的使用

1. 导入相应的jar包
2. 在配置类中的获得RestTemplate的方法上加上@LoadBalance注解

<b style="color:red">注意：Spring Cloud 2020.0.2版本使用Spring Cloud LoadBalance代替了Ribbon，需要使用Ribbon得降低Spring Cloud的版本</b>



### Ribbon自定义负载均衡策略

在Ribbon中，负载均衡策略通过一个IRule接口来实现的，他有很多的实现类，这些类就是负载均衡的策略，如：

* RoundRobinRule：轮询（默认）
* RandomRule：随机

* AvailabilityFilteringRule：会先过滤掉跳闸（崩溃）的服务，然后对剩下的进行轮询
* RetryRule：会先按照轮询的策略获取服务，如果服务获取失败，则会在指定的时间内进行重试

1. 写一个自己的均衡策略

   <b style="color:red">注意：自己写的均衡策略不能跟主启动类在同级目录，所以我们可以往外跳一级</b>

   在com.guighost下新建一个包myrule，在该包下创建自己的均衡策略

   新建一个自己的均衡策略类（继承AbstractLoadBalancerRule）

   ```java
   
   package com.kuang.myrule;
   
   import com.netflix.client.config.IClientConfig;
   import com.netflix.loadbalancer.AbstractLoadBalancerRule;
   import com.netflix.loadbalancer.ILoadBalancer;
   import com.netflix.loadbalancer.Server;
   
   import java.util.List;
   import java.util.concurrent.ThreadLocalRandom;
   
   
   public class KuangRandomRule extends AbstractLoadBalancerRule {
   
       //每个服务，访问5次~，换下一个服务（3个）
   
       // total=0, 默认=0，如果=5，我们指向下一个服务节点
       // index=0，默认0，如果total=5，index+1，
   
       private int total = 0; //被调用的次数
       private int currentIndex = 0; //当前是谁在提供服务~
   
   
       //@edu.umd.cs.findbugs.annotations.SuppressWarnings(value = "RCN_REDUNDANT_NULLCHECK_OF_NULL_VALUE")
       public Server choose(ILoadBalancer lb, Object key) {
           if (lb == null) {
               return null;
           }
           Server server = null;
   
           while (server == null) {
   
               if (Thread.interrupted()) {
                   return null;
               }
   
               List<Server> upList = lb.getReachableServers(); //获得活着的服务
               List<Server> allList = lb.getAllServers(); //获得全部的服务
   
               int serverCount = allList.size();
               if (serverCount == 0) {
                   return null;
               }
   
   //            int index = chooseRandomInt(serverCount); //生成区间随机数
   //            server = upList.get(index); //从活着的服务中，随机获取一个~
   
   
               //-=========================================================
   
               if (total<5){
                   server = upList.get(currentIndex);
                   total++;
               }else {
                   total = 0;
                   currentIndex++;
                   if (currentIndex>upList.size()){
                       currentIndex = 0;
                   }
                   server = upList.get(currentIndex); //从活着的服务中，获取指定的服务来进行操作
               }
   
   
   
               //-=========================================================
   
               if (server == null) {
                   Thread.yield();
                   continue;
               }
   
               if (server.isAlive()) {
                   return (server);
               }
   
               server = null;
               Thread.yield();
           }
   
           return server;
   
       }
   
       protected int chooseRandomInt(int serverCount) {
           return ThreadLocalRandom.current().nextInt(serverCount);
       }
   
   	@Override
   	public Server choose(Object key) {
   		return choose(getLoadBalancer(), key);
   	}
   
   	@Override
   	public void initWithNiwsConfig(IClientConfig clientConfig) {
   		// TODO Auto-generated method stub
   		
   	}
   }
   ```

   在myrule包下，写一个配置类（配置自定义的均衡策略）

   ```java
   package com.kuang.myrule;
   
   import com.netflix.loadbalancer.IRule;
   import com.netflix.loadbalancer.RoundRobinRule;
   import org.springframework.context.annotation.Bean;
   import org.springframework.context.annotation.Configuration;
   
   @Configuration
   public class KuangRule {
   
       @Bean
       public IRule myRule(){
           return new RoundRobinRule(); //默认是轮询，现在我们定义为~ KuangRandomRule
       }
   
   }
   ```

2. 在主启动类上通过@RibbonClient注解配置我们自己的均衡策略

   ```java
   @SpringBootApplication
   @EnableEurekaClient
   //在微服务启动时加载我们自定义的Ribbon组件
   @RibbonClient(name = "SPRINGCLOUD-PROVIDER-DEPT",configuration = "KuangRule.class")
   public class DeptConsumer_80 {
        public static void main(String[] args) {
             SpringApplication.run(DeptConsumer_80.class,args);
        }
   }
   ```

   

### Spring Cloud LoadBalancer负载均衡

**Spring Cloud LoadBalancer负载均衡是从springcloud3.0.1版本开始替代Ribbon的负载均衡工具**

我是在学习使用比较新版的springcloud3.0.1GA的时候，遇到一个问题，springcloud加入了一个新模块-Loadbalancer来替代ribbon，有两种负载均衡模式（轮询和随机），默认是用随机轮询，假如想使用随机或者自定义负载均衡策略，就不能按照以前使用ribbon的模式（注入IRule类，必须引入ribbon依赖），那么如果我使用Loadbalancer的随机负载均衡，要怎么设置呢？我们可以参照官网来了解

官网地址：https://docs.spring.io/spring-cloud-commons/docs/3.0.2/reference/html/#spring-cloud-loadbalancer

为了方便使用Spring Cloud LoadBalancer，我们提供了  `ReactorLoadBalancerExchangeFilterFunction` 可以与  `WebClient` 和  `BlockingLoadBalancerClient` 与  `RestTemplate`。  您可以在以下各节中查看更多信息和用法示例： 



### 使用Spring Cloud LoadBalance + RestTemplate

Spring Cloud LoadBalance默认的负载均衡策略是轮询

1. 在服务消费者80项目导入依赖

   ```xml
   <!-- https://mvnrepository.com/artifact/org.springframework.cloud/spring-cloud-starter-netflix-eureka-client -->
   <dependency>
        <groupId>org.springframework.cloud</groupId>
        <artifactId>spring-cloud-starter-netflix-eureka-client</artifactId>
        <version>3.0.2</version>
   </dependency>
   ```

2. 编写配置类：在配置类中获取RestTemplate的Bean上加上<b style="color:red">@LoadBalance</b>注解

   ```java
   package com.guighost.springcloud.config;
   
   import org.springframework.cloud.client.loadbalancer.LoadBalanced;
   import org.springframework.context.annotation.Bean;
   import org.springframework.context.annotation.Configuration;
   import org.springframework.web.client.RestTemplate;
   
   /**
    * @author GuiGhost
    * @date 2021/04/07
    * @className ConfigBean()
    * 描述：@Configuration    ——  相当于spring中的applicationContext.xml
    */
   @Configuration
   public class ConfigBean {
   
       /**
        * 配置负载均衡
        * @LoadBalance 注解
        * 这里是通过RestTemplate来获取提供者提供的服务的
        * 所以在RestTemplate上面加上@LoadBalance即可
        */
       @Bean
       @LoadBalanced//Ribbon
       public RestTemplate restTemplate(){
           return new RestTemplate();
       }
   }
   ```

3. 依次开启eureka7001、eureka7002、provider8001、provider8002、provider8002、consumer80服务

   测试

   ![](images/22.png)



### Loadbalancer切换默认负载均衡策略

由默认的轮询切换到随机

1. 在配置类中配置负载均衡的策略

   ```java
   //负载均衡算法之间切换
   @Bean
   public ReactorLoadBalancer<ServiceInstance> randomLoadBalancer(Environment environment,
                                                                  LoadBalancerClientFactory loadBalancerClientFactory) {
        String name = environment.getProperty(LoadBalancerClientFactory.PROPERTY_NAME);
        return new RandomLoadBalancer(loadBalancerClientFactory
                                      .getLazyProvider(name, ServiceInstanceListSupplier.class),
                                      name);
   }
   ```

2. 在主启动类上使用`@LoadBalancerClients(defaultConfiguration = {ConfigBean.class})`注解指定配置了负载均衡策略的配置类

   ```java
   package com.guighost.springcloud;
   
   
   import com.guighost.springcloud.config.ConfigBean;
   import org.springframework.boot.SpringApplication;
   import org.springframework.boot.autoconfigure.SpringBootApplication;
   import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClients;
   import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
   
   /**
    * @author GuiGhost
    * @date 2021/04/07
    * @className DeptConsumer_80()
    * 描述：主启动类
    * Ribbon 和 Eureka 整合以后，客户端可以直接调用，不用去管IP地址和端口号
    */
   @SpringBootApplication
   @EnableEurekaClient
   //指定负载均衡策略的配置类
   @LoadBalancerClients(defaultConfiguration = {ConfigBean.class})
   public class DeptConsumer_80 {
       public static void main(String[] args) {
           SpringApplication.run(DeptConsumer_80.class,args);
       }
   }
   ```





# Feign负载均衡

### Feign简介

feign是声明式的web service客户端，它让微服务之间的调用变得更简单了，类似controller调用service。SpringCloud集成了Ribbon和Eureka，可在使用Feign时提供负载均衡的http客户端

只需要创建一个接口，然后添加注解即可!

feign，主要是社区，大家都习惯面向接口编程。这个是很多开发人员的规范。调用微服务访问两种方法

1. 微服务名字【ribbon】
2. 接口和注解【feign 】



**Feign能干什么**？

* Feign只是使编写Java Http客户端变得更加容易
* 前面在使用Ribbon + RestTemplate时，利用RestTemplate对Http请求的封装处理，形成了一套模板化的调用方法。但是在实际开发中，由于对服务依赖的调用可能不止一处，往往一个接口会被多处调用，所以通常都会针对每个微服务自行封装一些客户端类来包装这些依赖服务的调用。所以，Feign在此基础上做了进一步封装，由他来帮助我们定义和实现依赖服务接口的定义，<b style="color:red">在Feign的实现下，我们只需要创建一个接口并使用注解的方式来配置它(类似于以前Dao接口上标注Mapper注解，现在是一个微服务接口上面标注一个Feign注解即可。）</b>即可完成对服务提供方的接口绑定，简化了使用Spring Cloud Ribbon时，自动封装服务调用客户端的开发量



**Feign集成了Ribbon**

利用Ribbon维护了MicroServiceCloud-Dept的服务列表信息，并且通过轮询实现了客户端的负载均衡，而与Ribbon不同的是，通过Feign只需要定义服务绑定接口且以声明式的方法，优雅而且简单的实现了服务调用。



### Feign的使用

1. 在父工程中new Module：springcloud-consumer-dept-feign

2. pom.xml

   ```xml
   <!--实体类+web-->
   <dependencies>
   
        <!--feign-->
        <dependency>
             <groupId>org.springframework.cloud</groupId>
             <artifactId>spring-cloud-starter-feign</artifactId>
             <version>1.4.6.RELEASE</version>
        </dependency>
   
        <!--Ribbon-->
        <dependency>
             <groupId>org.springframework.cloud</groupId>
             <artifactId>spring-cloud-starter-ribbon</artifactId>
             <version>1.4.6.RELEASE</version>
        </dependency>
        <!--erueka-->
        <dependency>
             <groupId>org.springframework.cloud</groupId>
             <artifactId>spring-cloud-starter-eureka</artifactId>
             <version>1.4.6.RELEASE</version>
        </dependency>
   
        <dependency>
             <groupId>com.kuang</groupId>
             <artifactId>springcloud-api</artifactId>
             <version>1.0-SNAPSHOT</version>
        </dependency>
        <dependency>
             <groupId>org.springframework.boot</groupId>
             <artifactId>spring-boot-starter-web</artifactId>
        </dependency>
        <dependency>
             <groupId>org.springframework.boot</groupId>
             <artifactId>spring-boot-devtools</artifactId>
        </dependency>
   </dependencies>
   ```

3. 在springcloud-api导入feign依赖

   ```xml
   <!--feign-->
   <dependency>
        <groupId>org.springframework.cloud</groupId>
        <artifactId>spring-cloud-starter-feign</artifactId>
        <version>1.4.6.RELEASE</version>
   </dependency>
   ```

4. 在springcloud-api子工程中创建一个接口，并加上Feign的注解

   ```java
   package com.kuang.springcloud.service;
   
   import com.kuang.springcloud.pojo.Dept;
   import org.springframework.cloud.openfeign.FeignClient;
   import org.springframework.stereotype.Component;
   import org.springframework.web.bind.annotation.GetMapping;
   import org.springframework.web.bind.annotation.PathVariable;
   import org.springframework.web.bind.annotation.PostMapping;
   
   import java.util.List;
   
   @Component
   @FeignClient(value = "SPRINGCLOUD-PROVIDER-DEPT",fallbackFactory = DeptClientServiceFallbackFactory.class)
   public interface DeptClientService {
   
       @GetMapping("/dept/get/{id}")
       public Dept queryById(@PathVariable("id") Long id);
   
       @GetMapping("/dept/list")
       public List<Dept> queryAll();
   
       @PostMapping("/dept/add")
       public boolean addDept(Dept dept);
   
   }
   ```

5. 编写配置类

   ```java
   package com.kuang.springcloud.config;
   
   import org.springframework.cloud.client.loadbalancer.LoadBalanced;
   import org.springframework.context.annotation.Bean;
   import org.springframework.context.annotation.Configuration;
   import org.springframework.web.client.RestTemplate;
   
   @Configuration
   public class ConfigBean { //@Configuration -- spring  applicationContext.xml
   
       //配置负载均衡实现RestTemplate
       // IRule
       // RoundRobinRule 轮询
       // RandomRule 随机
       // AvailabilityFilteringRule ： 会先过滤掉，跳闸，访问故障的服务~，对剩下的进行轮询~
       // RetryRule ： 会先按照轮询获取服务~，如果服务获取失败，则会在指定的时间内进行，重试
       @Bean
       @LoadBalanced //Ribbon
       public RestTemplate getRestTemplate(){
           return new RestTemplate();
       }
   
   }
   ```

6. 编写Controller

   ```java
   package com.kuang.springcloud.controller;
   
   import com.kuang.springcloud.pojo.Dept;
   import com.kuang.springcloud.service.DeptClientService;
   import org.springframework.beans.factory.annotation.Autowired;
   import org.springframework.web.bind.annotation.PathVariable;
   import org.springframework.web.bind.annotation.RequestMapping;
   import org.springframework.web.bind.annotation.RestController;
   
   import java.util.List;
   
   @RestController
   public class DeptConsumerController {
   
       @Autowired
       private DeptClientService service = null;
   
       @RequestMapping("/consumer/dept/add")
       public boolean add(Dept dept){
          return this.service.addDept(dept);
       }
   
       @RequestMapping("/consumer/dept/get/{id}")
       public Dept get(@PathVariable("id") Long id){
          return this.service.queryById(id);
       }
   
   
       @RequestMapping("/consumer/dept/list")
       public List<Dept> list(){
           return this.service.queryAll();
       }
   
   }
   ```

7. 在主启动类上开启Feign

   ```java
   package com.kuang.springcloud;
   
   import org.springframework.boot.SpringApplication;
   import org.springframework.boot.autoconfigure.SpringBootApplication;
   import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
   import org.springframework.cloud.netflix.ribbon.RibbonClient;
   import org.springframework.cloud.openfeign.EnableFeignClients;
   import org.springframework.context.annotation.ComponentScan;
   
   //Ribbon 和 Eureka 整合以后，客户端可以直接调用，不用关心IP地址和端口号~
   @SpringBootApplication
   @EnableEurekaClient
   @EnableFeignClients(basePackages = {"com.kuang.springcloud"})
   @ComponentScan("com.kuang.springcloud")
   public class FeignDeptConsumer_80 {
       public static void main(String[] args) {
           SpringApplication.run(FeignDeptConsumer_80.class,args);
       }
   }
   ```

8. 测试





# Hystrix熔断器

**分布式系统面临的问题**

复杂分布式体系结构中的应用程序有数十个依赖关系，每个依赖关系在某些时候将不可避免的失败!

**服务雪崩**

​	多个微服务之间调用的时候，假设微服务A调用微服务B和微服务C，微服务B和微服务C又调用其他的微服务，这就是所谓的“扇出"、如果扇出的链路上某个微服务的调用响应时间过长或者不可用，对微服务A的调用就会占用越来越多的系统资源，进而引起系统崩溃，所谓的“雪崩效应"。

​	对于高流量的应用来说，单一的后端依赖可能会导致所有服务器上的所有资源都在几秒中内饱和。比失败更糟糕的是，这些应用程序还可能导致服务之间的延迟增加，备份队列，线程和其他系统资源紧张，导致整个系统发生更多的级联故障，这些都表示需要对故障和延迟进行隔离和管理，以便单个依赖关系的失败，不能取消整个应用程序或系统。

​	我需要	弃车保帅

**什么使Hystrix**

Hystrix是一个用于处理分布式系统的延迟和容错的开源库，在分布式系统里，许多依赖不可避免的会调用失败，比如超时，异常等，Hystrix能够保证在一个依赖出问题的情况下，不会导致整体服务失败，避免级联故障，以提高分布式系统的弹性。

“断路器”本身是一种开关装置，当某个服务单元发生故障之后，通过断路器的故障监控（类似熔断保险丝)，向调用方返回一个服务预期的，可处理的备选响应(FallBack)，而不是长时间的等待或者抛出调用方法无法处理的异常，这样就可以保证了服务调用方的线程不会被长时间，不必要的占用，从而避免了故障在分布式系统中的蔓延，乃至雪崩



**能干嘛**

* 服务降级
* 服务熔断
* 服务限流
* 接近实时的监控



官网资料

https://github.com/Netflix/Hystrix/wiki



### 服务熔断

是什么

熔断机制是对应雪崩效应的一种微服务链路保护机制

当扇出链路的某个微服务不可用或者响应时间太长时，会进行服务的降级，<b style="color:red">进而熔断该节点微服务的调用，快速返回错误的响应信息。</b>当检测到该节点微服务调用响应正常后恢复调用链路。在Spring Cloud框架里熔断机制通过Hystrix实现。Hystrix会监控微服务间调用的状况，当失败的调用到达一定阈值，缺省时5秒内20次调用失败就会启动熔断机制。熔断机制的注解时@HystrixCommand



### 使用Hystrix

1. 在服务提供者的项目中导入依赖

   ```xml
   <!-- Hystrix -->
   <!-- https://mvnrepository.com/artifact/org.springframework.cloud/spring-cloud-starter-netflix-hystrix -->
   <dependency>
        <groupId>org.springframework.cloud</groupId>
        <artifactId>spring-cloud-starter-netflix-hystrix</artifactId>
        <version>2.2.7.RELEASE</version>
   </dependency>
   ```

2. 在需要熔断的方法上面指定熔断的方案

   通过@HystrixCommand注解指定

   @HystrixCommand(fallbackMethod = "hystrixGet")

   fallbackMethod：指定当前方法失效后的解决方案

   ```java
   @GetMapping("/dept/get/{deptno}")
   @HystrixCommand(fallbackMethod = "hystrixGet")
   public Dept get(@PathVariable("deptno") Long id){
        Dept dept = deptService.getById(id);
        if (dept == null){
             throw new RuntimeException("id" + id + "该用户不存在，或者信息无法找到");
        }
        return dept;
   }
   
   //备选方案
   public Dept hystrixGet(@PathVariable("deptno") Long id){
        return new Dept()
             .setDeptno(id)
             .setDname("id" + id + "没有对应的信息，为NULL——@Hystrix")
             .setDb_source("not this database in MySQL");
   }
   ```

3. 在主启动类上开启断路器（Hystrix）

   通过注解@EnableHystrix开启：

   ```java
   package com.guighost.springcloud;
   
   import org.springframework.boot.SpringApplication;
   import org.springframework.boot.autoconfigure.SpringBootApplication;
   import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
   import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
   import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
   import org.springframework.cloud.netflix.hystrix.EnableHystrix;
   
   /**
    * @author GuiGhost
    * @date 2021/04/07
    * @className DeptProvider_8001()
    * 描述：主启动类
    */
   @SpringBootApplication
   @EnableEurekaClient     //该注解作用是：在服务启动后，自动注册到Eureka中
   @EnableDiscoveryClient  //服务发现
   @EnableHystrix//添加对熔断的支持
   public class DeptProvider_hystrix_8001 {
       public static void main(String[] args) {
           SpringApplication.run(DeptProvider_hystrix_8001.class,args);
       }
   }
   ```

   源码：

   ```java
   //
   // Source code recreated from a .class file by IntelliJ IDEA
   // (powered by Fernflower decompiler)
   //
   
   package org.springframework.cloud.netflix.hystrix;
   
   import java.lang.annotation.Documented;
   import java.lang.annotation.ElementType;
   import java.lang.annotation.Inherited;
   import java.lang.annotation.Retention;
   import java.lang.annotation.RetentionPolicy;
   import java.lang.annotation.Target;
   import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
   
   @Target({ElementType.TYPE})
   @Retention(RetentionPolicy.RUNTIME)
   @Documented
   @Inherited
   @EnableCircuitBreaker
   public @interface EnableHystrix {
   }
   ```

   查看源码发现**@EnableHystrix它继承了@EnableCircuitBreaker，并对它进行了在封装**

   **结论：**

   **这两个注解都是激活hystrix的功能，我们根据上面代码得出来结论，只需要在服务启动类加入@EnableHystrix注解即可，无须增加@EnableCircuitBreaker注解，本身@EnableHystrix注解已经涵盖了EnableCircuitBreaker的功能**





### 服务降级

1. 在springcloud-api项目写一个FallbackFactory的实现类，用来返回客户端给出的信息（对应：DeptClientService接口）

   ```java
   package com.guighost.springcloud.service;
   
   import com.guighost.springcloud.entity.Dept;
   import org.springframework.cloud.openfeign.FallbackFactory;
   import org.springframework.stereotype.Component;
   
   import java.util.List;
   
   /**
    * @author GuiGhost
    * @date 2021/04/11
    * @className DeptConsumerControllerFallbackFactory()
    * 描述：服务降级
    */
   @Component
   public class DeptClientServiceFallbackFactory implements FallbackFactory {
       @Override
       public DeptClientService create(Throwable cause) {
           return new DeptClientService(){
               @Override
               public Dept queryById(Long id) {
                   return new Dept()
                           .setDeptno(id)
                           .setDname("id=>" + id + "没有对应的信息，客户端提供降级信息，该服务已关闭")
                           .setDb_source("无数据");
               }
   
               @Override
               public List<Dept> queryAll() {
                   return null;
               }
   
               @Override
               public boolean addDept(Dept dept) {
                   return false;
               }
   
           };
       }
   }
   ```

2. 在springcloud-api项目对应的DeptClientService接口上配置

   ```java
   package com.guighost.springcloud.service;
   
   import com.guighost.springcloud.entity.Dept;
   import org.springframework.cloud.openfeign.FeignClient;
   import org.springframework.stereotype.Component;
   import org.springframework.web.bind.annotation.GetMapping;
   import org.springframework.web.bind.annotation.PathVariable;
   import org.springframework.web.bind.annotation.PostMapping;
   
   import java.util.List;
   
   /**
    * @author GuiGhost
    * @date 2021/04/10
    * @interfaceName DeptClientService()
    * 描述：
    */
   @Component
   @FeignClient(value = "SPRINGCLOUD-PROVIDER-DEPT",fallbackFactory = DeptClientServiceFallbackFactory.class)
   public interface DeptClientService {
   
       @GetMapping("/dept/get/{id}")
       public Dept queryById(@PathVariable("id") Long id);
   
       @GetMapping("/dept/list")
       public List<Dept> queryAll();
   
       @PostMapping("/dept/add")
       public boolean addDept(Dept dept);
   
   }
   ```

3. 配置客户端springcloud-consumer-dept-feign-80项目的yaml文件

   ```yaml
   server:
     port: 80
   
   
   # 开启服务降级feign.circuitbreaker
   feign:
     circuitbreaker:
       enabled: true
   
   
   
   
   # Eureka配置
   eureka:
     client:
       register-with-eureka: false   # 不向Eureka注册自己（因为不是提供者）
       service-url:
         defaultZone: http://eureka7001:7001/eureka/,http://eureka7002:7002/eureka/,http://eureka7003:7003/eureka/
   ```





### 总结

#### 服务熔断：服务端

某个服务超时或者异常时，引起熔断~	保险丝

#### 服务降级：客户端

从整体网站请求负载考虑，当某个服务熔断或者关闭之后，服务将不在被调用，此时客户端，我们可以准备一个FallbackFactory，返回一个默认的值（缺省值），整体的服务水平下降了



### Dashboard流监控

#### 配置监控页

1. 在父工程中new Module：springcloud-consumer-hystrix-dashboard

2. 导入依赖

   ```xml
   <!-- 实体类 + WEB + 热部署工具-->
   <dependencies>
        <!-- Hystrix依赖 -->
        <dependency>
             <groupId>org.springframework.cloud</groupId>
             <artifactId>spring-cloud-starter-netflix-hystrix</artifactId>
             <version>2.2.7.RELEASE</version>
        </dependency>
        <!-- hystrix-dashboard -->
        <!-- https://mvnrepository.com/artifact/org.springframework.cloud/spring-cloud-starter-netflix-hystrix-dashboard -->
        <dependency>
             <groupId>org.springframework.cloud</groupId>
             <artifactId>spring-cloud-starter-netflix-hystrix-dashboard</artifactId>
             <version>2.2.7.RELEASE</version>
        </dependency>
        <!-- https://mvnrepository.com/artifact/org.springframework.cloud/spring-cloud-starter-netflix-eureka-client -->
        <dependency>
             <groupId>org.springframework.cloud</groupId>
             <artifactId>spring-cloud-starter-netflix-eureka-client</artifactId>
        </dependency>
   
        <dependency>
             <groupId>com.guighost</groupId>
             <artifactId>springcloud-api</artifactId>
             <version>1.0-SNAPSHOT</version>
        </dependency>
        <dependency>
             <groupId>org.springframework.boot</groupId>
             <artifactId>spring-boot-starter-web</artifactId>
        </dependency>
        <dependency>
             <groupId>org.springframework.boot</groupId>
             <artifactId>spring-boot-devtools</artifactId>
        </dependency>
   </dependencies>
   ```

3. 配置yaml文件

   ```yaml
   server:
     port: 9001
   ```

4. 编写主启动类

   ```java
   package com.guighost.springcloud;
   
   import org.springframework.boot.SpringApplication;
   import org.springframework.boot.autoconfigure.SpringBootApplication;
   import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
   
   /**
    * @author GuiGhost
    * @date 2021/04/11
    * @className HystrixDashboard_9001()
    * 描述：
    */
   @SpringBootApplication
   @EnableHystrixDashboard     //开启监控页面
   public class HystrixDashboard_9001 {
       public static void main(String[] args) {
           SpringApplication.run(HystrixDashboard_9001.class,args);
       }
   }
   ```

5. 测试

   ![](images/25.png)



#### 监控服务

1. 在springcloud-provider-dept-hystrix-8001项目中导入依赖

   ```xml
   <!-- Hystrix -->
   <!-- https://mvnrepository.com/artifact/org.springframework.cloud/spring-cloud-starter-netflix-hystrix -->
   <dependency>
        <groupId>org.springframework.cloud</groupId>
        <artifactId>spring-cloud-starter-netflix-hystrix</artifactId>
        <version>2.2.7.RELEASE</version>
   </dependency>
   
   <!-- actuator：完善监控信息 -->
   <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-actuator</artifactId>
   </dependency>
   ```

2. 在主启动类中增加一个Servlet

   ```java
   package com.guighost.springcloud;
   
   import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
   import org.springframework.boot.SpringApplication;
   import org.springframework.boot.autoconfigure.SpringBootApplication;
   import org.springframework.boot.web.servlet.ServletRegistrationBean;
   import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
   import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
   import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
   import org.springframework.cloud.netflix.hystrix.EnableHystrix;
   import org.springframework.context.annotation.Bean;
   
   /**
    * @author GuiGhost
    * @date 2021/04/07
    * @className DeptProvider_8001()
    * 描述：主启动类
    */
   @SpringBootApplication
   @EnableEurekaClient     //该注解作用是：在服务启动后，自动注册到Eureka中
   @EnableDiscoveryClient  //服务发现
   @EnableHystrix//添加对熔断的支持
   public class DeptProvider_hystrix_8001 {
       public static void main(String[] args) {
           SpringApplication.run(DeptProvider_hystrix_8001.class,args);
       }
   
       //增加一个Servlet
       @Bean
       public ServletRegistrationBean hystrixMetricsStreamServlet(){
           ServletRegistrationBean registrationBean = new ServletRegistrationBean(new HystrixMetricsStreamServlet());
           registrationBean.addUrlMappings("/actuator/hystrix.stream");
           return registrationBean;
       }
   }
   ```



# Zuul路由网关

### 概述

**什么是Zuul？**

​	Zuul包含了对请求的路由和过滤两个最主要的功能：

​	其中路由功能负责将外部请求转发到具体的微服务实例上，是实现外部访问统一入口的基础，而过滤功能则负责对请求的处理过程进行干预，是实现请求校验、服务聚合等功能的基础。Zuul和Eureka进行整合，将Zuul自身注册为Eureka服务治理下的应用，同时从Eureka中获得其他微服务的消息，也即以后的访问微服务都是通过Zuul跳转后获得

​	注意：Zuul服务最终还是会注册到Eureka

​	提供：代理 + 路由 + 过滤 三大功能



**Zuul能干嘛？**

* 路由
* 过滤



官网文档：https://github.com/Netflix/zuul



### 使用Zuul

1. new Module：springcloud-zuul-9527

2. pom.xml

   ```xml
   <dependencies>
        <!-- Zuul -->
        <!-- https://mvnrepository.com/artifact/org.springframework.cloud/spring-cloud-starter-netflix-zuul -->
        <dependency>
             <groupId>org.springframework.cloud</groupId>
             <artifactId>spring-cloud-starter-netflix-zuul</artifactId>
             <version>2.2.7.RELEASE</version>
        </dependency>
   
        <!-- Hystrix依赖 -->
        <dependency>
             <groupId>org.springframework.cloud</groupId>
             <artifactId>spring-cloud-starter-netflix-hystrix</artifactId>
             <version>2.2.7.RELEASE</version>
        </dependency>
        <!-- hystrix-dashboard -->
        <!-- https://mvnrepository.com/artifact/org.springframework.cloud/spring-cloud-starter-netflix-hystrix-dashboard -->
        <dependency>
             <groupId>org.springframework.cloud</groupId>
             <artifactId>spring-cloud-starter-netflix-hystrix-dashboard</artifactId>
             <version>2.2.7.RELEASE</version>
        </dependency>
        <!-- https://mvnrepository.com/artifact/org.springframework.cloud/spring-cloud-starter-netflix-eureka-client -->
        <dependency>
             <groupId>org.springframework.cloud</groupId>
             <artifactId>spring-cloud-starter-netflix-eureka-client</artifactId>
        </dependency>
   
        <dependency>
             <groupId>com.guighost</groupId>
             <artifactId>springcloud-api</artifactId>
             <version>1.0-SNAPSHOT</version>
        </dependency>
        <dependency>
             <groupId>org.springframework.boot</groupId>
             <artifactId>spring-boot-starter-web</artifactId>
        </dependency>
        <dependency>
             <groupId>org.springframework.boot</groupId>
             <artifactId>spring-boot-devtools</artifactId>
        </dependency>
   </dependencies>
   ```

3. application.yaml

   ```yaml
   server:
     port: 9527
   
   # 服务名
   spring:
     application:
       name: springcloud-zuul-geteway
   
   # eureka配置
   eureka:
     client:
       service-url:
         defaultZone: http://eureka7001:7001/eureka/,http://eureka7002:7002/eureka/,http://eureka7003:7003/eureka/
     instance:
       instance-id: zuul9527.com
       prefer-ip-address: true
   
   info:
     app.name: guighost
     version: 1.1.1
   ```

4. 编写主启动类并开启Zuul

   ```java
   package com.guighost.springcloud;
   
   import org.springframework.boot.SpringApplication;
   import org.springframework.boot.autoconfigure.SpringBootApplication;
   import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
   
   /**
    * @author GuiGhost
    * @date 2021/04/12
    * @className ZuulApplication_9527()
    * 描述：
    */
   @SpringBootApplication
   @EnableZuulProxy     //开启Zuul代理
   public class ZuulApplication_9527 {
       public static void main(String[] args) {
           SpringApplication.run(ZuulApplication_9527.class,args);
       }
   }
   ```

5. 到了这一步我们就可以通过127.0.0.1/服务名/Controller配置的接口  就可以去访问eureka中的服务服务了

   例：http://www.guighost.com:9527/springcloud-provider-dept/dept/get/1

6. 但是我们要隐藏我们真实的服务名，在yaml中设置

   ```yaml
   zuul:
     routes:
       mydept.serviceId: springcloud-provider-dept
       mydept.path: /mydept/**
   ```

   **到了这里，我们就可以使用mydept来代替我们真实的服务名了**

   但是，我们还是可以通过真实的服务名来访问，所以我们还得进行下一步操作

7. 忽略真实服务名，只能通过我们配置的名字来访问

   ignored-services: 忽略服务名（可以是具体的某个服务也可以是全部）

   ignored-services: springcloud-provider-dept	：忽略springcloud-provider-dept这个服务

   ignored-services: "*"	忽略所有

   ```yaml
   zuul:
     routes:
       mydept.serviceId: springcloud-provider-dept
       mydept.path: /mydept/**
     ignored-services: "*"  # 不能在使用这个路径访问了，ignored：忽略  这里是隐藏全部的
     prefix: /ghost  # 设置公共的前缀
   ```

   **到了这一步，我们就只能通过127.0.0.1:9527/ghost/mydept/**来访问springcloud-provider-dept服务中的请求了**



# Spring Cloud config分布式配置

### 概述

**分布式系统面临的——配置文件的问题**

微服务意味着要将单体应用中的业务拆分成一个个子服务，每个服务的粒度相对较小，因此系统中会出现大量的服务，由于每个服务都需要必要的配置信息才能运行，所以一套集中式的，动态的配置管理设施是必不可少的。SpringCloud提供了ConfigServer来解决这个问题，我们每一个微服务自己带着一个application.yml，那上百的的配置文件要修改起来，岂不是要发疯!

**什么是Spring Cloud config分布式配置中心**

![](images/26.png)

Spring Cloud Config 为微服务架构中的微服务提供集中化的外部配置支持，配置服务器为**各个不同的微服务应用**的所有环节提供了一个**中心化的外部配置**

Spring Cloud Config 分为**服务端**和**客户端**两部分

服务端也称为分布式配置中心，它是一个独立的微服务应用，用来连接配置服务器并为客户端提供获取配置信息，加密，解密信息等访问接口

客户端则是通过指定的配置中心来管理应用资源，以及与业务相关的配置内容，并在启动的时候从配置中心获取和加载配置信息。配置服务器默认采用git来存储配置信息，这样就有助于对环境配置进行版本管理。并且可以通过git客户端工具来方便的管理和访问配置内容。



**Spring Cloud Config分布式配置中心能干嘛**

* 集中管理配置文件
* 不同环境，不同配置，动态化的配置更新，分环境部署，比如/dev /test/ /prod /beta /release
* 运行期间动态调整配置，不再需要在每个服务部署的机器上编写配置文件，服务会向配置中心统一拉取配置自己的信息。
* 当配置发生变动时，服务不需要重启，即可感知到配置的变化，并应用新的配置
* 将配置信息以REST接口的形式暴露



**Spring Cloud Config 分布式配置中心于GitHub整合**

由于Spring Cloud Config默认使用Git来存储配置文件（也有其他方式，比如支持SVN和本地文件)，但是最推荐的还是Git,而且使用的是 http / https 访问的形式;



### 配置Spring Cloud Config 服务端

1. new Module：springcloud-config-server-3344

2. pom.xml

   ```xml
   <dependencies>
        <!-- web -->
        <dependency>
             <groupId>org.springframework.boot</groupId>
             <artifactId>spring-boot-starter-web</artifactId>
        </dependency>
        <!-- Eureka -->
        <dependency>
             <groupId>org.springframework.cloud</groupId>
             <artifactId>spring-cloud-starter-netflix-eureka-client</artifactId>
        </dependency>
        <!-- config server -->
        <!-- https://mvnrepository.com/artifact/org.springframework.cloud/spring-cloud-config-server -->
        <dependency>
             <groupId>org.springframework.cloud</groupId>
             <artifactId>spring-cloud-config-server</artifactId>
             <version>3.0.3</version>
        </dependency>
        <!-- 监控信息包 -->
        <dependency>
             <groupId>org.springframework.boot</groupId>
             <artifactId>spring-boot-starter-actuator</artifactId>
        </dependency>
   </dependencies>
   ```

3. application.yaml

   ```yaml
   server:
     port: 3344
   
   spring:
     application:
       name: springcloud-config-server
     # 连接远程仓库
     cloud:
       config:
         server:
           git:
             uri: https://gitee.com/GuiGhost/springcloud-config.git  # 是https的
   
   # 通过config-server 可以连接到git，访问其中的资源以及配置
   ```

4. 编写主启动类并开启config服务端

   ```java
   package com.guighost.springcloud;
   
   import org.springframework.boot.SpringApplication;
   import org.springframework.boot.autoconfigure.SpringBootApplication;
   import org.springframework.cloud.config.server.EnableConfigServer;
   
   /**
    * @author GuiGhost
    * @date 2021/04/12
    * @className ConfigServer_3344()
    * 描述：
    */
   @SpringBootApplication
   @EnableConfigServer     //开启config服务
   public class ConfigServer_3344 {
       public static void main(String[] args) {
           SpringApplication.run(ConfigServer_3344.class,args);
       }
   }
   ```

5. 测试，访问git仓库中的资源

   HTTP服务具有以下格式的资源：

   ```yaml
   /{application}/{profile}[/{label}]
   /{application}-{profile}.yml
   /{label}/{application}-{profile}.yml
   /{application}-{profile}.properties
   /{label}/{application}-{profile}.properties
   ```

   访问：http://localhost:3344/application-dev.yaml

   ![](images/27.png)



### 配置Spring Cloud Config 客户端

新建一个子工程：new Module：springcloud-config-client-3355

Spring Boot 2.4引入了一种新的方式来通过  `spring.config.import`财产。  现在，这是绑定到Config Server的默认方法

要有选择地连接到配置服务器，请在application.yaml中设置以下内容

```yaml
server:
  port: 3355


# 用户级别的配置
spring:
  application:
    name: springcloud-config-client-3355
  cloud:
    config:
      name: config-client   # 需要从git上读取的资源名称，不需要后缀
      profile: dev  # 指定dev环境
      label: master # 指定master分支
  config:
    import: configserver:http://localhost:3344
```

编写Controller

```java
package com.guighost.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author GuiGhost
 * @date 2021/04/12
 * @className ConfigClientController()
 * 描述：
 */
@RestController
public class ConfigClientController {

    @Value("${spring.application.name}")
    private String applicationName;
    @Value("${eureka.client.service-url.defaultZone}")
    private String eurekaServer;
    @Value("${server.port}")
    private String port;

    @RequestMapping("/config")
    public String getConfig(){
        return applicationName + ":" + port + "/" + eurekaServer;
    }
}
```

编写主启动类

```java
package com.guighost.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

/**
 * @author GuiGhost
 * @date 2021/04/12
 * @className ConfigClient_3355()
 * 描述：
 */
@SpringBootApplication
public class ConfigClient_3355 {
    public static void main(String[] args) {
        SpringApplication.run(ConfigClient_3355.class,args);
    }
}
```

启动测试

发现报错了：

```java
Caused by: java.lang.IllegalArgumentException: Could not resolve placeholder 'eureka.client.service-url.defaultZone' in value "${eureka.client.service-url.defaultZone}"
```

解决：

在主启动类中加入：

```java
package com.guighost.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

/**
 * @author GuiGhost
 * @date 2021/04/12
 * @className ConfigClient_3355()
 * 描述：
 */
@SpringBootApplication
public class ConfigClient_3355 {
    public static void main(String[] args) {
        SpringApplication.run(ConfigClient_3355.class,args);
    }

    @Bean
    public static PropertySourcesPlaceholderConfigurer placeholderConfigurer() {
        PropertySourcesPlaceholderConfigurer c = new PropertySourcesPlaceholderConfigurer();
        c.setIgnoreUnresolvablePlaceholders(true);
        return c;

    }

}
```

添加之后会忽略暂时在该配置文件里未取到的value，继续寻找下去，该问题就解决了

![](images/28.png)



另一种方式：使用旧版本

要使用旧版引导程序连接到Config Server的方式，必须通过属性或引导程序启用引导程序。  `spring-cloud-starter-bootstrap`起动启动器

并且使用旧版本的Config Server的客户端应用程序都需要一个  `bootstrap.yml`其中服务器地址设置为  `spring.cloud.config.uri` （默认为“ http：// localhost：8888”）

导入依赖：pom.xml

使用旧版本需要多引入一个依赖：spring-cloud-starter-bootstrap

```xml
<dependencies>
     <dependency>
          <groupId>org.springframework.cloud</groupId>
          <artifactId>spring-cloud-starter-bootstrap</artifactId>
     </dependency>
     <!-- config client -->
     <!-- https://mvnrepository.com/artifact/org.springframework.cloud/spring-cloud-starter-config -->
     <dependency>
          <groupId>org.springframework.cloud</groupId>
          <artifactId>spring-cloud-starter-config</artifactId>
          <version>3.0.3</version>
     </dependency>
     <!-- web -->
     <dependency>
          <groupId>org.springframework.boot</groupId>
          <artifactId>spring-boot-starter-web</artifactId>
     </dependency>
     <!-- 监控信息包 -->
     <dependency>
          <groupId>org.springframework.boot</groupId>
          <artifactId>spring-boot-starter-actuator</artifactId>
     </dependency>
</dependencies>
```

配置文件编写：application.yaml和bootstrap.yaml

bootstrap.yaml

```yaml
# 系统级别的配置
spring:
  cloud:
    config:
      name: config-client   # 需要从git上读取的资源名称，不需要后缀
      profile: dev  # 指定dev环境
      label: master # 指定master分支
      uri: http://localhost:3344
```

application.yaml

```yaml
# 用户级别的配置
spring:
  application:
    name: springcloud-config-client-3355
```

编写Controller

```java
package com.guighost.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author GuiGhost
 * @date 2021/04/12
 * @className ConfigClientController()
 * 描述：
 */
@RestController
public class ConfigClientController {

    @Value("${spring.application.name}")
    private String applicationName;
    @Value("${eureka.client.service-url.defaultZone}")
    private String eurekaServer;
    @Value("${server.port}")
    private String port;

    @RequestMapping("/config")
    public String getConfig(){
        return applicationName + ":" + port + "/" + eurekaServer;
    }
}
```

编写主启动类

```java
package com.guighost.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

/**
 * @author GuiGhost
 * @date 2021/04/12
 * @className ConfigClient_3355()
 * 描述：
 */
@SpringBootApplication
public class ConfigClient_3355 {
    public static void main(String[] args) {
        SpringApplication.run(ConfigClient_3355.class,args);
    }
}
```

启动测试：

这里就不需要在主启动类中编写其他配置了

![](images/29.png)

![](images/30.png)

另外，可以通过更改bootstrap.yaml中的配置来更改项目的环境

```yaml
# 系统级别的配置
spring:
  cloud:
    config:
      name: config-client   # 需要从git上读取的资源名称，不需要后缀
      profile: test  # 指定dev环境
      label: master # 指定master分支
      uri: http://localhost:3344
```

![](images/31.png)

总结：

两种方式的区别

1. 旧版本比新的版本多引入了一个依赖：spring-cloud-starter-bootstrap

2. 旧版本要比新版本多一个系统配置文件bootstrap.yaml；其中的配置也不一样

   1. 旧版是通过在bootstrap.yaml文件中的spring.cloud.config.下的name、profile、label、uri来指定
   2. 新版本使用通过application.yaml中通过config.import:来指定，替换了旧版本的uri

3. 新版本需要的项目需要指定端口；而旧版本可以直接使用git上引入的环境的端口，而项目本身不需要编写端口号

4. 新版本需要在主启动类中添加忽略暂时在该配置文件里未取到的value，否则会报错；而就版本则不需要

   

### 远程配置实战测试

我们这里使用的旧版本的方式

1. 新建一个子工程：springcloud-config-dept-8001

2. 导入依赖

   ```xml
   <dependencies>
        <!-- config -->
        <dependency>
             <groupId>org.springframework.cloud</groupId>
             <artifactId>spring-cloud-starter-config</artifactId>
        </dependency>
        <dependency>
             <groupId>org.springframework.cloud</groupId>
             <artifactId>spring-cloud-starter-bootstrap</artifactId>
        </dependency>
   
        <!-- Eureka -->
        <!-- https://mvnrepository.com/artifact/org.springframework.cloud/spring-cloud-starter-eureka -->
        <dependency>
             <groupId>org.springframework.cloud</groupId>
             <artifactId>spring-cloud-starter-eureka</artifactId>
             <version>1.4.7.RELEASE</version>
        </dependency>
        <!-- actuator：完善监控信息 -->
        <dependency>
             <groupId>org.springframework.boot</groupId>
             <artifactId>spring-boot-starter-actuator</artifactId>
        </dependency>
   
        <!-- 我们需要拿到我们的实体类，所以需要配置api Module -->
        <dependency>
             <groupId>com.guighost</groupId>
             <artifactId>springcloud-api</artifactId>
             <version>1.0-SNAPSHOT</version>
        </dependency>
   
        <!-- junit -->
        <dependency>
             <groupId>junit</groupId>
             <artifactId>junit</artifactId>
        </dependency>
   
        <!-- MySQL -->
        <dependency>
             <groupId>mysql</groupId>
             <artifactId>mysql-connector-java</artifactId>
        </dependency>
   
        <!-- 数据源：Druid -->
        <dependency>
             <groupId>com.alibaba</groupId>
             <artifactId>druid</artifactId>
        </dependency>
        <dependency>
             <groupId>ch.qos.logback</groupId>
             <artifactId>logback-core</artifactId>
        </dependency>
        <!-- springboot整合mybatis-->
        <dependency>
             <groupId>org.mybatis.spring.boot</groupId>
             <artifactId>mybatis-spring-boot-starter</artifactId>
        </dependency>
   
        <!-- test -->
        <dependency>
             <groupId>org.springframework.boot</groupId>
             <artifactId>spring-boot-test</artifactId>
        </dependency>
        <!-- WEB -->
        <dependency>
             <groupId>org.springframework.boot</groupId>
             <artifactId>spring-boot-starter-web</artifactId>
        </dependency>
        <!-- jetty 应用服务器：与Tomcat一样-->
        <dependency>
             <groupId>org.springframework.boot</groupId>
             <artifactId>spring-boot-starter-jetty</artifactId>
        </dependency>
        <!-- 热部署工具 -->
        <dependency>
             <groupId>org.springframework.boot</groupId>
             <artifactId>spring-boot-devtools</artifactId>
        </dependency>
   </dependencies>
   ```

3. 编写一个config-dept.yaml文件，并提交到远程

   ```yaml
   spring:
     profiles:
       active: dev
   
   
   
   ---
   # 配置端口号
   server:
     port: 8001
   
   # mybatis配置
   mybatis:
     # 配置实体类的别名
     type-aliases-package: com.guighost.springcloud.entity
     # 配置mapper文件路径
     mapper-locations: classpath:mybatis/mapper/*.xml
     # 配置mybatis的核心xml文件的路径（该核心配置文件可以省略，因为在application.yaml中都可以配置）
     config-location: classpath:mybatis/mybatis-config.xml
   
   # spring的配置
   spring:
     profiles: dev
     # 服务提供者的名字
     application:
       name: springcloud-config-dept
     # 配置数据库连接和数据源
     datasource:
       type: com.alibaba.druid.pool.DruidDataSource
       driver-class-name: com.mysql.cj.jdbc.Driver
       url: jdbc:mysql://localhost:3306/cloud-db03?serverTimezone=UTC&useUnicode=true&characterEncoding=utf-8
       username: root
       password: ghost
   
   # Eureka配置：服务注册到哪里
   eureka:
     client:
       service-url:
         defaultZone: http://eureka7001:7001/eureka/,http://eureka7002:7002/eureka/,http://eureka7003:7003/eureka/
     # 修改eureka上的默认描述信息
     instance:
       instance-id: springcloud-provider-dept8001
       prefer-ip-address: true   # true可以显示服务的IP地址
   
   # 配置监控服务的信息
   info:
     app.name: GhostSpringcloud
     app.date: ${java.version.date}
     message: "已经完善的监控信息"
   
   ---
   # 配置端口号
   server:
     port: 8001
   
   # mybatis配置
   mybatis:
     # 配置实体类的别名
     type-aliases-package: com.guighost.springcloud.entity
     # 配置mapper文件路径
     mapper-locations: classpath:mybatis/mapper/*.xml
     # 配置mybatis的核心xml文件的路径（该核心配置文件可以省略，因为在application.yaml中都可以配置）
     config-location: classpath:mybatis/mybatis-config.xml
   
   # spring的配置
   spring:
     profiles: test
     # 服务提供者的名字
     application:
       name: springcloud-config-dept
     # 配置数据库连接和数据源
     datasource:
       type: com.alibaba.druid.pool.DruidDataSource
       driver-class-name: com.mysql.cj.jdbc.Driver
       url: jdbc:mysql://localhost:3306/cloud-db02?serverTimezone=UTC&useUnicode=true&characterEncoding=utf-8
       username: root
       password: ghost
   
   # Eureka配置：服务注册到哪里
   eureka:
     client:
       service-url:
         defaultZone: http://eureka7001:7001/eureka/,http://eureka7002:7002/eureka/,http://eureka7003:7003/eureka/
     # 修改eureka上的默认描述信息
     instance:
       instance-id: springcloud-provider-dept8001
       prefer-ip-address: true   # true可以显示服务的IP地址
   
   # 配置监控服务的信息
   info:
     app.name: GhostSpringcloud
     app.date: ${java.version.date}
     message: "已经完善的监控信息"
   ```

4. 配置项目中配置文件：application.yaml和bootstrap.yaml

   application.yaml

   ```yaml
   spring:
     application:
       name: springcloud-config-dept-8001
   ```

   bootstrap.yaml

   ```yaml
   spring:
     cloud:
       config:
         uri: http://localhost:3344	# config server的路径
         name: config-dept	# 文件名
         label: master		# master分支
         profile: test		# 指定环境
   ```

5. 其他的代码与springcloud-provider-dept-8001一致



# 总结

### 常见面试题

1. 什么是微服务?
2. 微服务之间是如何独立通讯的?
3. SpringCloud和Dubbo有哪些区别?
4. SpringBoot和SpringCloud，请你谈谈对他们的理解
5. 什么是服务熔断?什么是服务降级
6. 微服务的优缺点是分别是什么?说下你在项目开发中遇到的坑
7. 你所知道的微服务技术栈有哪些?请列举一二
8. eureka和zookeeper都可以提供服务注册与发现的功能，请说说两个的区别?