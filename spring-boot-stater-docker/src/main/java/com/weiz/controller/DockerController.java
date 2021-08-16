package com.weiz.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DockerController {
    @RequestMapping("/")
    public String index() {
        return "Hello Spring Boot Docker!";
    }
}
