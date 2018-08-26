# RPC
实现RPC框架(Netty+Spring)

#### 相关说明

```
RPC-common         定义传输数据，提供序列化和反序列化方法、socket解码编码handler
RPC-registry       zookeeper的服务注册和服务发现方法
RPC-client         rpc客户端
RPC-server         rpc服务端
```

#### 难点

```
1. Proxy.newProxyInstance（ClassLoader loader,Class<?>[] interfaces,InvocationHandler h）方法实现动态代理
2. ApplicationContextAware, InitializingBean接口，通过自定义注解获得用户的业务接口和实现类
```
```
