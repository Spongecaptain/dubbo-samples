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

package org.apache.dubbo.samples.basic;

import org.apache.dubbo.samples.basic.api.DemoService;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

public class BasicConsumer {

    public static void main(String[] args) {
        //1. 加载配置
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring/dubbo-demo-consumer.xml");
        //2. 获取消费代理
        context.start();
        DemoService demoService = (DemoService) context.getBean("demoService");
        //改为调用 3 次
        for (int i = 0; i < 3; i++) {
            //3. 调用远程方法
            String hello = demoService.sayHello("world");
            //在控制台输出红色更醒目一点
            System.err.println(hello);
        }
        //System.in.read(); 用于避免 Consumer 的 main 方法暂停运行
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }

//        System.out.println("start void test...");
//        demoService.testVoid();
    }
}
