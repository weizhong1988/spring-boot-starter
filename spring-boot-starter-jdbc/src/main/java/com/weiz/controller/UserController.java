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
        System.out.println("若下面没出现“无缓存的时候调用”字样且能打印出数据表示测试成功");
        return JSONResult.ok(u);
    }
}
