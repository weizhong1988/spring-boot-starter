package com.weiz.controller;

import com.weiz.utils.JSONResult;
import com.weiz.pojo.User;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

//@Controller
@RestController   // RestController = Controller + ResponseBody
@RequestMapping("/user")
public class UserController {
    @RequestMapping("/getUser")
    //@ResponseBody
    public JSONResult getUserJson(){
        User u = new User();
        u.setName("weiz222");
        u.setAge(20);
        u.setBirthday(new Date());
        u.setPassword("weiz222");
        return JSONResult.ok(u);
    }
}
