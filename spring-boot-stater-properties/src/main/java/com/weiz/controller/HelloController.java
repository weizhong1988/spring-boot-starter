package com.weiz.controller;

import com.weiz.pojo.WebSiteProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("hello")
public class HelloController {

    @Value("${com.weiz.costum.name}")
    private String name;
    @Value("${com.weiz.costum.website}")
    private String website;
    @Value("${com.weiz.costum.language}")
    private String language;

    @Autowired
    private WebSiteProperties properties;


    @RequestMapping("/getvalue")
    public String getValue() {
        System.out.println(name);
        System.out.println(website);
        System.out.println(language);
        return "getvalue";
    }

    @RequestMapping("/getpro")
    public String getProperties() {
        System.out.println(properties.getName());
        System.out.println(properties.getWebsite());
        System.out.println(properties.getLanguage());
        return "hello";
    }

    @Autowired
    private Environment env;

    @RequestMapping("/getenv")
    public String getEnvironment() {
        System.out.println(env.getProperty("com.weiz.resource.name"));
        System.out.println(env.getProperty("com.weiz.resource.website"));
        System.out.println(env.getProperty("com.weiz.resource.language"));
        return "hello";
    }

}