![](https://github.com/yulc-coding/spring-cloud-demo/blob/master/QR_code.png)

****

## 目前国内趋势：
* Dubbo + ZooKeeper 体系（国内早期的微服务体系）
* Spring Cloud Netflix为主的一套技术栈 (Netflix的组件 更新不活跃)
* Spring Cloud Alibaba 技术栈 + 国内开源组件

## 微服务核心：
* 注册中心：每个服务将自己的服务信息注册到注册中心上，并且通过注册中心去发现其他服务的信息，如IP地址
    * ZooKeeper
        > `Leader` + `Follower`。服务在`Leader`节点注册，然后`Leader`节点将数据同步到所有`Follower`节点。典型的`CP`模型，一旦`leader`崩溃，zk会有一段时间不可用，需要重新选举一个`leader`，然后再做数据同步。
    * Netflix Eureka
        > 每个节点平等，每当有服务在一个`Eureka`节点注册，该`Eureka`节点会将新的注册服务异步同步到其他`Eureka`节点（**会有几十秒的延迟**）。AP模型
    * Consul
        > 基于`raft`算法的CP模型，类似于`ZooKeeper`
    * Alibaba Nacos (大趋势，推荐使用)
        > 也是基于`raft`算法的CP模型，同时也支持配置成类似`Eureka`的`AP`模式

* RPC框架：远程调用其他的服务。
    * Dubbo => (基于TCP协议)
    * Feign + Netflix Ribbon => (基于Http协议)
    * gRPC
* 多环境隔离
* 自动化部署
    * jenkins
* 分布式事务
    * Alibaba 开源的 Seata
* 限流/熔断/降级
    * Netflix Hystrix
    * sentinel
* 安全认证
    * Spring Cloud OAuth2
* API网关: 屏蔽所有的服务，通过API网关统一调用接口，由API网关路由到具体的服务
    * Netflix Zuul
    * Spring Cloud Gateway
    * Nginx + Lua
    * Kong
* 配置中心：统一在配置中心配置，然后推送到各个服务，无需重新部署服务
    * Spring Cloud Config
    * 协程开源的 Apollo
* 监控中心：业务指标、每台服务器的CPU、内存、磁盘网络IO、负载
    * Prometheus
* 链路监控：链路的性能监控，链路的每个环节耗时、是否执行成功
    * Sleuth + Zipkin
    * 大众点评开源的 CAT 
* 日志中心：将每个服务的日志统一上报到日志中心，方便集中检索
    * ELK
* 服务治理

## 组件版本
* Spring Cloud 基于 Hoxton.RELEASE
* Spring Boot 基于 2.2.5.RELEASE
* spring-cloud-alibaba 基于 2.2.0.RELEASE

## 相关系列
### [1、Eureka 服务注册](https://github.com/yulc-coding/spring-cloud-demo/tree/Hoxton-v1/eureka)

### [2、Ribbon 负载均衡](https://github.com/yulc-coding/spring-cloud-demo/tree/Hoxton-v1/ribbon)

### [3、Feign 服务调用](https://github.com/yulc-coding/spring-cloud-demo/tree/Hoxton-v1/feign)

### 4、Hystrix & Turbine

### [5、Zuul 服务网关](https://github.com/yulc-coding/spring-cloud-demo/tree/Hoxton-v1/zuul)

### [6、Gateway 路由网关](https://github.com/yulc-coding/spring-cloud-demo/tree/Hoxton-v1/gateway)

### [7、Config 服务统一配置](https://github.com/yulc-coding/spring-cloud-demo/tree/Hoxton-v1/config)

### [8、Sleuth 服务链追踪](https://github.com/yulc-coding/spring-cloud-demo/tree/Hoxton-v1/sleuth)

### [9、Nacos 服务注册](https://github.com/yulc-coding/spring-cloud-demo/tree/Hoxton-v1/nacos)

### [10、Nacos 配置中心](https://github.com/yulc-coding/spring-cloud-demo/tree/Hoxton-v1/nacos/nacos-config)
