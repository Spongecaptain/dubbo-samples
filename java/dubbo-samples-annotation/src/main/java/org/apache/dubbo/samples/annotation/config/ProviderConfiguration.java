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

import org.apache.dubbo.config.ProviderConfig;
import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
/**
 * 客户端配置类
 */
@Configuration
//自动扫描服务对应接口所在的包下被 Dubbo 注解标记着的类
@EnableDubbo(scanBasePackages = "org.apache.dubbo.samples.annotation.impl")
//指定配置文件路径
@PropertySource("classpath:/spring/dubbo-provider.properties")
public class ProviderConfiguration {
    //这个 Bean 用于 Provider 侧的配置，例如 ProtocolConfig、RegistryConfig、ApplicationConfig 都可以通过这种方式加入，起到了利用 API 来修改配置的作用
    @Bean
    public ProviderConfig providerConfig() {
        ProviderConfig providerConfig = new ProviderConfig();
        providerConfig.setTimeout(1000);
        return providerConfig;
    }
}
