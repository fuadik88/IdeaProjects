package com.spring_aop.service;

import org.springframework.stereotype.Component;

@Component
public class TrafficFortuneService {
    public String getFortune() throws InterruptedException {
        Thread.sleep(5000);
        return "Expect heavy traffic...";
    }
}
