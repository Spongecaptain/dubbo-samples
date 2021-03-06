/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.dubbo.samples.provider;


import org.apache.dubbo.config.ApplicationConfig;
import org.apache.dubbo.config.RegistryConfig;
import org.apache.dubbo.config.ServiceConfig;
import org.apache.dubbo.samples.api.GreetingsService;

import java.util.concurrent.CountDownLatch;

public class Application {
    private static String zookeeperHost = System.getProperty("zookeeper.address", "127.0.0.1");

    public static void main(String[] args) throws Exception {
        //应用配置
        //注意：ServiceConfig 类为重对象，内部封装了与注册中心的连接以及开启服务端口
        ServiceConfig<GreetingsService> service = new ServiceConfig<>();
        //设置应用名
        service.setApplication(new ApplicationConfig("first-dubbo-provider"));
        //设置注册中心
        service.setRegistry(new RegistryConfig("zookeeper://" + zookeeperHost + ":2181"));
        //设置要注册的接口
        service.setInterface(GreetingsService.class);
        //设置注册接口的具体实现类
        service.setRef(new GreetingsServiceImpl());
        //暴露以及注册服务
        service.export();

        System.out.println("dubbo service started");
        new CountDownLatch(1).await();
    }
}
