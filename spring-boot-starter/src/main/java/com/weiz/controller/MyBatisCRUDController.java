package com.weiz.controller;

import com.weiz.utils.JSONResult;
import com.weiz.pojo.SysUser;
import com.weiz.service.UserService;
import org.n3r.idworker.Sid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("mybatis")
public class MyBatisCRUDController {

    @Autowired
    private UserService userService;

    @Autowired
    private Sid sid;

    @RequestMapping("/saveUser")
    public JSONResult saveUser() throws Exception {

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

    @RequestMapping("/updateUser")
    public JSONResult updateUser() {

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


    @RequestMapping("/deleteUser")
    public JSONResult deleteUser(String userId) {

        userService.deleteUser(userId);

        return JSONResult.ok("删除成功");
    }

    @RequestMapping("/queryUserById")
    public JSONResult queryUserById(String userId) {

        return JSONResult.ok(userService.queryUserById(userId));
    }

    @RequestMapping("/queryUserList")
    public JSONResult queryUserList() {

        SysUser user = new SysUser();
        user.setUsername("spring boot");
        user.setNickname("weiz");

        List<SysUser> userList = userService.queryUserList(user);

        return JSONResult.ok(userList);
    }

    @RequestMapping("/queryUserListPaged")
    public JSONResult queryUserListPaged(Integer page) {
        if (page == null) {
            page = 1;
        }

        int pageSize = 10;

        SysUser user = new SysUser();

        List<SysUser> userList = userService.queryUserListPaged(user, page, pageSize);

        return JSONResult.ok(userList);
    }

    @RequestMapping("/queryUserByIdCustom")
    public JSONResult queryUserByIdCustom(String userId) {

        return JSONResult.ok(userService.queryUserByIdCustom(userId));
    }

    @RequestMapping("/queryAllUserListCustom")
    public JSONResult queryAllUserListCustom() {

        return JSONResult.ok(userService.queryAllUserListCustom());
    }

    @RequestMapping("/saveUserTransactional")
    public JSONResult saveUserTransactional() {

        String userId = sid.nextShort();

        SysUser user = new SysUser();
        user.setId(userId);
        user.setUsername("weiz" + new Date());
        user.setNickname("weiz" + new Date());
        user.setPassword("abc123");
        user.setIsDelete(0);
        user.setRegistTime(new Date());

        userService.saveUserTransactional(user);

        return JSONResult.ok("保存成功");
    }


}
