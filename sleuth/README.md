# 链路追踪
### Zipkin 服务端
在使用 Spring Boot 2.x 版本后，官方就不推荐自行定制编译了，反而是直接提供了编译好的 jar 包来给我们使用
```$xslt
curl -sSL https://zipkin.io/quickstart.sh | bash -s
java -jar zipkin.jar
http://localhost:9411/zipkin/ 
```
### trace-zuul
服务网关，转发请求。作为zipkin客户端，上传链路数据到zipkin服务器
#### pom
引入服务注册、zuul网关、zipkin组件
```
    <dependency>
        <groupId>org.springframework.cloud</groupId>
        <artifactId>spring-cloud-starter-netflix-eureka-client</artifactId>
    </dependency>
    <dependency>
        <groupId>org.springframework.cloud</groupId>
        <artifactId>spring-cloud-starter-netflix-zuul</artifactId>
    </dependency>
    <dependency>
        <groupId>org.springframework.cloud</groupId>
        <artifactId>spring-cloud-starter-zipkin</artifactId>
    </dependency>
```
#### 配置文件
设置采样比例、指定Zipkin服务器的地址、注册服务、配置路由
```$xslt
server:
  port: 9412
spring:
  application:
    name: trace-zuul
  sleuth:
    web:
      client:
        enabled: true
    sampler:
      # 将采样比例设置为 1.0，也就是全部都需要。默认是 0.1
      probability: 1.0
  # 指定了 Zipkin 服务器的地址
  zipkin:
    base-url: http://localhost:9411/
eureka:
  instance:
    # 以IP地址注册到服务中心，相互注册使用IP地址
    prefer-ip-address: true
    instance-id: ${spring.cloud.client.ipaddress}:${server.port}
  client:
    serviceUrl:
      defaultZone: http://localhost:8761/eureka/
# 配置路由
zuul:
  routes:
    trace-api:
      path: /trace-api/**
      serviceId: TRACE-API
```

### trace-api
对外调用接口链路跟踪
#### pom
引入web组件、服务注册、zipkin组件
```
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-web</artifactId>
    </dependency>
    <dependency>
        <groupId>org.springframework.cloud</groupId>
        <artifactId>spring-cloud-starter-netflix-eureka-client</artifactId>
    </dependency>
    <dependency>
        <groupId>org.springframework.cloud</groupId>
        <artifactId>spring-cloud-starter-zipkin</artifactId>
    </dependency>
```
#### 配置文件
设置采样比例、指定Zipkin服务器的地址、注册服务
```
server:
  port: 9413
spring:
  application:
    name: trace-api
  sleuth:
    sampler:
      # 将采样比例设置为 1.0，也就是全部都需要。默认是 0.1
      probability: 1.0
  # 指定了 Zipkin 服务器的地址
  zipkin:
    base-url: http://localhost:9411/
eureka:
  instance:
    # 以IP地址注册到服务中心，相互注册使用IP地址
    prefer-ip-address: true
    instance-id: ${spring.cloud.client.ipaddress}:${server.port}
  client:
    serviceUrl:
      defaultZone: http://localhost:8761/eureka/
```