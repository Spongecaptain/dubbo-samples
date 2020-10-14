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

package org.apache.dubbo.samples.annotation;

import org.apache.dubbo.samples.annotation.action.AnnotationAction;

import org.apache.dubbo.samples.annotation.config.ConsumerConfiguration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.IOException;

public class AnnotationConsumerBootstrap {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ConsumerConfiguration.class);
        context.start();

        final AnnotationAction annotationAction = (AnnotationAction) context.getBean("annotationAction");
        //为了避免与超时异常撞色，打印出蓝色的提示
        System.out.println("\033[34;4m" + "hello : " + annotationAction.doSayHello("world") + "\033[0m");
        System.out.println("\033[34;4m" + "goodbye : " + annotationAction.doSayGoodbye("world") + "\033[0m");
        System.out.println("\033[34;4m" + "greeting : " + annotationAction.doGreeting("world") + "\033[0m");
        System.out.println("\033[34;4m" + "reply : " + annotationAction.replyGreeting("world") + "\033[0m");
        //阻塞输入，避免 Consumer 快速退出
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
