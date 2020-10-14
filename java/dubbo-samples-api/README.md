# About this sample

这个模块用于说明如何基于 API 来配置 Dubbo 的 Consumer 以及 Provider，然后实现 RPC 调用。
运行方式很简单：

- 首先，运行 provider 包下的 Application#main
- 其次，运行 client 包下的 Application#main

不过此模块=并没有提供内嵌的 ZooKeeper 实例，这点不太好，因为和 dubbo-samples-basic 相比，这显然是前后不一致。
这是需要注意的一点，请你自己启动 ZooKeeper 并监听 2181 端口。


This sample code demonstrates building up dubbo service provider and service consumer with the pure API approach. In this example, multicast is facilitated as the registration mechanism, therefore it is necessary to explicitly specify system property `java.net.preferIPv4Stack`.

## Start the service provider

```bash
mvn clean package
mvn -Djava.net.preferIPv4Stack=true -Dexec.mainClass=org.apache.dubbo.samples.provider.Application exec:java
```

## Invoke the service consumer

```bash
mvn -Djava.net.preferIPv4Stack=true -Dexec.mainClass=org.apache.dubbo.samples.client.Application exec:java
```
