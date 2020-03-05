# RestTemplate + Ribbon 进行消费服务

## RestTemplate
一个访问第三方RESTful API接口的网络请求框架。

## Ribbon 负载均衡

### ribbon-loadbalancer: 负载均衡API

### ribbon-eureka: Ribbon结合Eureka的API

### ribbon-core: Ribbon的核心

## Hystrix 熔断器
* `@EnableHystrix`

## Hystrix Dashboard
* 依赖
    * spring-boot-starter-actuator
    * spring-cloud-starter-netflix-hystrix
    * spring-cloud-starter-netflix-hystrix-dashboard
* @EnableCircuitBreaker  启动断路器
* http://localhost:8081/actuator/hystrix.stream
* @EnableHystrixDashboard  开启dashboard，通过图形化的方式监控
* http://localhost:8081/actuator/hystrix
### 注意
* `actuator`2.0之前访问路径默认是/，2.0默认是 /actuator
* `management.endpoints.web.exposure.exclude=info, health`默认只开启了`info, health`，需要设为*开启全部，或者指定要开启的：`info, health`
