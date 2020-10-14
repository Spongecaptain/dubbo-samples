# XML 配置案例模块

有关 XML 的详细配置项，请参见：[配置参考手册](http://dubbo.apache.org/zh-cn/docs/user/references/xml/introduction.html)。如果不想使用 Spring 配置，而希望通过 API 的方式进行调用，请参见： [API 配置](http://dubbo.apache.org/zh-cn/docs/user/configuration/api.html)。想知道如何使用配置，请参见：[快速启动](http://dubbo.apache.org/zh-cn/docs/user/quick-start.html)。

请在此查看文档描述的[完整示例](https://github.com/apache/dubbo-samples/tree/master/java/dubbo-samples-basic)

---

因为我自己 Mac 上跑了监听着 2181 端口的 ZooKeeper(Stand Alone)，因此我选择注释掉启动内嵌 ZooKeeper 的代码。

运行方式是：

- 先运行 org.apache.dubbo.samples.basic.BasicProvider#main
- 再运行 org.apache.dubbo.samples.basic.BasicConsumer#main

控制台此时会抛出一些异常，但是我们先不用理会。

我们可以在 BasicProvider 控制台发现有如下的打印日志：

```
[11:40:35] Hello world, request from consumer: /192.168.0.112:58672
[11:40:35] Hello world, request from consumer: /192.168.0.112:58672
[11:40:35] Hello world, request from consumer: /192.168.0.112:58672
```

可以在 BasicConsumer 的控制台发现有如下的控制台输出：

```
Hello world, response from provider: 192.168.0.112:20880
Hello world, response from provider: 192.168.0.112:20880
Hello world, response from provider: 192.168.0.112:20880
```

---

至此，Dubbo 最简单的 XML 配置已经完成了。