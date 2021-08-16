package com.weiz.service.Impl;

import com.weiz.service.HelloService;
import org.springframework.stereotype.Service;

@Service
public class HelloServiceImpl implements HelloService {
    @Override
    public void sayHello() {
        System.out.println("hello service");
    }
}