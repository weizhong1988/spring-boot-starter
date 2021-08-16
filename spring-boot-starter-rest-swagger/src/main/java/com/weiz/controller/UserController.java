package com.weiz.controller;

import com.weiz.pojo.SysUser;
import com.weiz.service.UserService;
import com.weiz.utils.JSONResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.n3r.idworker.Sid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(tags = {"用户接口"})
@RestController
@RequestMapping("/")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private Sid sid;

    @ApiOperation(value="创建用户", notes="根据User对象创建用户")
    @PostMapping(value = "user")
    public JSONResult create(@RequestBody SysUser user) throws Exception {
        String userId = sid.nextShort();
        user.setId(userId);
        userService.saveUser(user);
        return JSONResult.ok("保存成功");
    }

    @ApiOperation(value="更新用户详细信息", notes="根据id来指定更新对象，并根据传过来的user信息来更新用户详细信息")
    @PutMapping(value = "user")
    public JSONResult update(@RequestBody SysUser user) {
        userService.updateUser(user);
        return JSONResult.ok("保存成功");
    }

    @ApiOperation(value="删除用户", notes="根据url的id来指定删除对象")
    @DeleteMapping("user/{userId}")
    public JSONResult delete(@PathVariable String userId) {
        userService.deleteUser(userId);
        return JSONResult.ok("删除成功");
    }

    @ApiOperation(value="查询用户",notes = "通过用户ID获取用户信息")
    @GetMapping("user/{userId}")
    public JSONResult queryUserById(@PathVariable String userId) {
        return JSONResult.ok(userService.queryUserById(userId));
    }
}
