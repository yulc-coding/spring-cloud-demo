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
* @EnableHystrixDashboard
* http://localhost:8081/hystrix
* http://localhost:8081/hystrix.stream