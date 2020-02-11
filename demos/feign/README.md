# Feign 进行消费服务
默认引入了Ribbon（负载均衡）和Hystrix（熔断器）的依赖。
* 通过`@EnableFeignClients` 开启FeignClient功能
* 创建 feign 接口，并在接口上加入`@FeignClient`注解
* 程序启动后会进行包扫描，将带有`@FeignClient`的注解类加入容器中
* 接口被调用时，通过JDK的代理来生成具体的`RequestTemplate`模板
* 根据`RequestTemplate`模板再生成Http请求的Request对象
* Request对象交给Client去处理，其中网络请求框架可以是`HttpURLConnect、HttpClient、OkHttp`
* Client被封装到`LoadBalanceClient`类，结合Ribbon进行负载均衡

## FeignClient
申明一个Feign Client。
* value 为需要远程调用的服务的名称
* configuration 指定配置类，默认为`FeignClientsConfiguration`，可以重写覆盖默认的Bean

## Hystrix 熔断器
```
# 开启熔断机制
feign:
  hystrix:
    enabled: true
```





