package com.weiz.controller;

import com.weiz.pojo.User;
import com.weiz.utils.JSONResult;
import com.weiz.service.UserService;
import org.n3r.idworker.Sid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("mybatis")
public class MyBatisCRUDController {

    @Autowired
    private UserService userService;

    @Autowired
    private Sid sid;

    @RequestMapping("/saveUser")
    public JSONResult saveUser() {

        String userId = sid.nextShort();
        User user = new User();
        user.setId(userId);
        user.setUsername("spring boot" + new Date());
        user.setNickname("spring boot" + new Date());
        user.setPassword("abc123");
        user.setIsDelete(0);
        user.setRegistTime(new Date());

        userService.saveUser(user);
        return JSONResult.ok("保存成功");
    }

    @RequestMapping("/updateUser")
    public JSONResult updateUser() {
        User user = new User();
        user.setId("10011001");
        user.setUsername("10011001-updated" + new Date());
        user.setNickname("10011001-updated" + new Date());
        user.setPassword("10011001-updated");
        user.setIsDelete(0);
        user.setRegistTime(new Date());

        userService.updateUser(user);
        return JSONResult.ok("保存成功");
    }


    @RequestMapping("/deleteUser")
    public JSONResult deleteUser(String userId) {
        userService.deleteUser(userId);
        return JSONResult.ok("删除成功");
    }

    @RequestMapping("/queryUserById")
    public JSONResult queryUserById(String userId) {
        return JSONResult.ok(userService.queryUserById(userId));
    }





}
