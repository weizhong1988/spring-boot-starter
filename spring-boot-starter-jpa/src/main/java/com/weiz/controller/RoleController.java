package com.weiz.controller;

import com.weiz.dao.PermissionRespository;
import com.weiz.dao.RoleRespository;
import com.weiz.dao.UserRespository;
import com.weiz.pojo.Permissions;
import com.weiz.pojo.Roles;
import com.weiz.pojo.Users;
import com.weiz.pojo.UsersDetail;
import com.weiz.utils.JSONResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private RoleRespository roleRespository;

    @Autowired
    private PermissionRespository permissionRespository;

    @RequestMapping("/save")
    public JSONResult save(){
        // 角色
        Roles role1 = new Roles();
        role1.setName("admin role");
        // 角色赋权限
        Set<Permissions> ps = new HashSet<Permissions>();
        for (int i = 0; i < 3; i++) {
            Permissions pm = new Permissions();
            pm.setName("permission"+i);
            permissionRespository.save(pm);  /**由于我的Role类没有设置级联持久化，所以这里需要先持久化pm,否则报错！*/
            ps.add(pm);
        }
        role1.setPermissions(ps);
        // 保存
        roleRespository.save(role1);
        return JSONResult.ok("保存成功");
    }

    @RequestMapping("/update")
    public JSONResult update() {
        // roleRespository.save(user);
        Roles role1 = new Roles();

        return JSONResult.ok("修改成功");
    }

    @RequestMapping("/delete/{id}")
    public JSONResult delete(@PathVariable Long id) {
        roleRespository.deleteById(id);
        return JSONResult.ok("删除成功");
    }

    @RequestMapping("/select/{id}")
    public JSONResult select(@PathVariable Long id) {
        Optional<Roles> roles = roleRespository.findById(id);
        return JSONResult.ok(roles);
    }
}
