/*
 *
 *   Licensed to the Apache Software Foundation (ASF) under one or more
 *   contributor license agreements.  See the NOTICE file distributed with
 *   this work for additional information regarding copyright ownership.
 *   The ASF licenses this file to You under the Apache License, Version 2.0
 *   (the "License"); you may not use this file except in compliance with
 *   the License.  You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 *
 */

package org.apache.dubbo.samples.annotation.action;

import org.apache.dubbo.config.annotation.Method;
import org.apache.dubbo.config.annotation.Reference;
import org.apache.dubbo.samples.annotation.AnnotationConstants;
import org.apache.dubbo.samples.annotation.api.GreetingService;
import org.apache.dubbo.samples.annotation.api.HelloService;

import org.springframework.stereotype.Component;

/**
 * 这个类服务于 Consumer 端，用于提供：
 * - 封装了依赖于某一个接口（实现类）来完成方法调用的逻辑
 * -
 */
//@Component 用于表明此类希望被 IoC 容器纳入管理
@Component("annotationAction")
public class AnnotationAction {
    //@Reference 注解用于 Spring 来提供自动注入对应接口的代理类实例（代理类完成了对 RPC 远程调用的封装）
    @Reference(interfaceClass = HelloService.class, version = AnnotationConstants.VERSION /*,
            methods = {
                    @Method(
                            name = "sayHello",
                            oninvoke = "notify.oninvoke",
                            onreturn = "notify.onreturn",
                            onthrow = "notify.onthrow")
            }
             */
    )
    private HelloService helloService;

    @Reference(interfaceClass = GreetingService.class,
            version = AnnotationConstants.VERSION,
            timeout = 1000,
            methods = {@Method(name = "greeting", timeout = 3000, retries = 1)})
    private GreetingService greetingService;

    //下面的若干方法都依赖于 @Reference 注解标记的实例来完成调用
    public String doSayHello(String name) {
        try {
            return helloService.sayHello(name);
        } catch (Exception e) {
            e.printStackTrace();
            return "Throw Exception";
        }
    }

    public String doSayGoodbye(String name) {
        try {
            return helloService.sayGoodbye(name);
        } catch (Exception e) {
            e.printStackTrace();
            return "Throw Exception";
        }

    }

    public String doGreeting(String name) {
        try {
            return greetingService.greeting(name);
        } catch (Exception e) {
            e.printStackTrace();
            return "Throw Exception";
        }

    }

    public String replyGreeting(String name) {
        try {
            return greetingService.replyGreeting(name);
        } catch (Exception e) {
            e.printStackTrace();
            return "Throw Exception";
        }
    }
}
