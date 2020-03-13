![](https://github.com/yulc-coding/spring-cloud-demo/blob/master/QR_code.png)

## Ribbon 负载均衡
Ribbon是客户端负载均衡。它可以存在于多个客户端中。在SpringCloud中，Ribbon可以配合`Eureka`使用，在调用接口时，会从`Eureka Server`中获取服务列表，并基于指定的负载策略请求其中的一个实例。

### [官方文档](https://cloud.spring.io/spring-cloud-netflix/multi/multi_spring-cloud-ribbon.html)

### LoadBalancerClient
`LoadBalancerClient`是`Ribbon`的核心组件。它是定义客户端负载均衡的接口。
* 定义了几个方法：
    * execute()方法：用于执行请求；
    * econstructURI()方法：重构URI。整合Eureka后可以直接通过服务名去访问其他服务，如：http://api/restTemplate/ 其中api是其他服务在Eureka中注册的服务名称，在实际调用的时候需要将服务名api转为换具体的IP和端口的形式；
* 继承了`ServiceInstanceChooser`接口：
    * 定义了choose()方法，用来从LoadBalancer中获取指定服务的一个实例；
* 实现类为`RibbonLoadBalancerClient`

可以调用`choose`方法来获取服务实例：
```
ServiceInstance instance = loadBalancerClient.choose("serviceId");
```
在`RibbonLoadBalancerClient`的`choose()`方法中，通过负载均衡器`ILoadBalancer`去获取实例信息:
```
	protected Server getServer(ILoadBalancer loadBalancer, Object hint) {
		if (loadBalancer == null) {
			return null;
		}
		// 获取服务实例
		return loadBalancer.chooseServer(hint != null ? hint : "default");
	}
```


### ILoadBalancer 
定义负载均衡具体操作的接口。维护服务实例信息；
```java
public interface ILoadBalancer {

	/**
	 * 初始化服务列表
	 */
	public void addServers(List<Server> newServers);
	
	/**
	 * 从负载均衡中获取一个服务实例
	 */
	public Server chooseServer(Object key);
	
	/**
	 * 标记指定服务已下线
	 */
	public void markServerDown(Server server);

	/**
	 * 获取可用的服务列表
     */
    public List<Server> getReachableServers();

    /**
     * 获取所有已知服务器，包括可用和不可用的
     */
	public List<Server> getAllServers();
}
```


### IRule
具定义体负载均衡策略的接口。`ILoadBalancer`会根据`IRule`的规则去选择一个符合条件的服务实例
```
public interface IRule{

    public Server choose(Object key);
    
    public void setLoadBalancer(ILoadBalancer lb);
    
    public ILoadBalancer getLoadBalancer();    
}
```
`IRule`默认实现了一些策略，具体可以查看接口实现类：
* RoundRobinRule：轮询方式（默认规则）；
* RandomRule：随机访问；
* RetryRule：在轮询方式上加入重试机制；
* BestAvailableRule：请求数最小的；
* WeightedResponseTimeRule：根据响应时间加权
* ...
 
> 如果有特殊的需要可以自定义负载策略，只需要实现IRule`接口


### 捋一捋
整理一下负载均衡获取实例的流程：
* loadBalancerClient调用choose方法；
* ILoadBalancer调用chooseServer方法；
* IRule调用choose方法；

