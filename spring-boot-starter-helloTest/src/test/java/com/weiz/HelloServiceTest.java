package com.weiz;

import com.weiz.service.HelloService;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.junit.Test;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HelloServiceTest {
    @Resource
    HelloService helloService;
    @Test
    public void sayHelloTest(){
        helloService.sayHello();
    }
}