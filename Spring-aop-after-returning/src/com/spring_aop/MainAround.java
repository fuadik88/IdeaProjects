package com.spring_aop;

import com.spring_aop.service.TrafficFortuneService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class MainAround {
    public static void main(String[] args) throws InterruptedException {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(JavaConfig.class);

        TrafficFortuneService fortuneService = context
                .getBean("trafficFortuneService", TrafficFortuneService.class);
        System.out.println(fortuneService.getFortune());

        context.close();
    }
}