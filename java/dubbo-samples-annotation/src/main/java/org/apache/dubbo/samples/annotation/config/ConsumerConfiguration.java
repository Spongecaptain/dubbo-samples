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

package org.apache.dubbo.samples.annotation.config;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * 客户端配置类
 */
@Configuration
//自动扫描服务对应接口所在的包下被 Dubbo 注解标记着的类
@EnableDubbo(scanBasePackages = "org.apache.dubbo.samples.annotation.action")
//指定配置文件路径
@PropertySource("classpath:/spring/dubbo-consumer.properties")
//这个注解用于指定包下被 Spring 注解标记着的实现类，这是必要的，
//因为只有被 @Component 注解标记着的类才能够依赖于 IoC 容器实现对 @Reference 注解标记类实例的自动注入
@ComponentScan(value = {"org.apache.dubbo.samples.annotation.action"})
public class ConsumerConfiguration {

}
