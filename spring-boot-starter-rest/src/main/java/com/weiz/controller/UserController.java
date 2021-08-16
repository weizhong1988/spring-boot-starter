package com.weiz.controller;

import com.weiz.pojo.SysUser;
import com.weiz.service.UserService;
import com.weiz.utils.JSONResult;
import org.n3r.idworker.Sid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private Sid sid;

    @PostMapping(value = "user")
    public JSONResult create() throws Exception {

        String userId = sid.nextShort();
        SysUser user = new SysUser();
        user.setId(userId);
        user.setUsername("spring boot" + new Date());
        user.setNickname("spring boot" + new Date());
        user.setPassword("abc123");
        user.setIsDelete(0);
        user.setRegistTime(new Date());

        userService.saveUser(user);
        return JSONResult.ok("保存成功");
    }

    @PutMapping(value = "user")
    public JSONResult update() {
        SysUser user = new SysUser();
        user.setId("10011001");
        user.setUsername("10011001-updated" + new Date());
        user.setNickname("10011001-updated" + new Date());
        user.setPassword("10011001-updated");
        user.setIsDelete(0);
        user.setRegistTime(new Date());
        userService.updateUser(user);
        return JSONResult.ok("保存成功");
    }

    @DeleteMapping("user/{userId}")
    public JSONResult delete(@PathVariable String userId) {
        userService.deleteUser(userId);
        return JSONResult.ok("删除成功");
    }

    @GetMapping("user/{userId}")
    public JSONResult queryUserById(@PathVariable String userId) {
        return JSONResult.ok(userService.queryUserById(userId));
    }

}
