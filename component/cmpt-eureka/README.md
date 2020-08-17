## Eureka服务注册

### 介绍
服务发现是微服务体系结构的核心内容之一。`Eureka`是`NetFlix`的一个子模块，用于服务的定位和注册，**只需要使用服务的标识，就可以访问服务**，它遵循分布式事务的**AP原则**。功能类似`Dubbo`的注册中心，比如`Zookeeper`

### Eureka Server
主管服务注册，是服务注册中心，存储所有可用的服务节点信息。系统中的其他服务通过`Eureka`客户端注册到服务中心，并维持心跳连接，并且可以通过服务中心来发现其他服务进行调用。

#### pom
```
    <dependency>
        <groupId>org.springframework.cloud</groupId>
        <artifactId>spring-cloud-starter-netflix-eureka-server</artifactId>
    </dependency>
```

#### yml配置

#### 引入Eureka服务注解：@EnableEurekaServer

#### 

### Eureka Client
每个客户端节点启动后会主动向`EurekaServce`注册自己，并维持一个心跳链接。当需要和其他服务通信时，会想`EurekaServce`询问目标服务的地址进行访问。

#### pom
```
    <dependency>
        <groupId>org.springframework.cloud</groupId>
        <artifactId>spring-cloud-starter-netflix-eureka-client</artifactId>
    </dependency>
```

#### yml配置

#### 引入Eureka客户端注解：@EnableEurekaClient


### 自我保护机制(server)
遵循：宁可保留错误的服务信息，也不会盲目注销任何可能健康的服务。
* 它是一种应对网络异常的保护措施，生成环境建议开启。
* 15分钟内超过85%的节点都没有正常的心跳，进入自我保护状态。
* 自我保护状态下不会删除注册表中的服务信息。
* 当它收到心跳数重新恢复到阈值以上时，退出自我保护状态。

### Eureka和Zookeeper
CAP:
* C 强一致性
* A 可用性
* P 分区容错（分布式的核心）

* Eureka AP原则
* Zookeeper CP原则

