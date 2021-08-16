package com.weiz.controller;

import com.weiz.dao.RoleRespository;
import com.weiz.dao.UserRespository;
import com.weiz.pojo.Roles;
import com.weiz.pojo.Users;
import com.weiz.pojo.UsersDetail;
import com.weiz.utils.JSONResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserRespository userRespository;

    @Autowired
    private RoleRespository roleRespository;

    @RequestMapping("/save")
    public JSONResult save(){
        //用户
        Users user = new Users();
        user.setName("springbootjpa");
        user.setAccount("admin");
        user.setPwd("123456");
        //详情
        UsersDetail usersDetail = new UsersDetail();
        usersDetail.setAge(19);
        usersDetail.setAddress("beijing,haidian,");
        //保存用户和详情
        user.setUserDetail(usersDetail);
        userRespository.save(user);
        return JSONResult.ok("保存成功");
    }

    @RequestMapping("/update")
    public JSONResult update() {
        Users user = new Users();
        user.setId((long) 1);
        user.setName("spring boot jpa update");
        user.setPwd("123456");
        user.setAccount("sbj");
        userRespository.save(user);
        return JSONResult.ok("修改成功");
    }

    @RequestMapping("/updateRole/{id}")
    public JSONResult updateRole(@PathVariable Long id) {
        Users user = userRespository.findById(id).orElse(null);
        Long roleId = Long.valueOf(25);
        Roles role = roleRespository.findById(roleId).orElse(null);
        if (user!=null){
            user.setRole(role);
        }
        userRespository.save(user);
        return JSONResult.ok("修改成功");
    }

    @RequestMapping("/delete/{id}")
    public JSONResult delete(@PathVariable long id) {
        userRespository.deleteById(id);
        return JSONResult.ok("删除成功");
    }

    @RequestMapping("/select/{id}")
    public JSONResult select(@PathVariable long id) {
        Optional<Users> users = userRespository.findById(id);
        return JSONResult.ok(users);
    }

    @RequestMapping("/test")
    public void test() {
        Users user = new Users();
        user.setId((long) 1);
        userRespository.findById((long) 1);
        userRespository.findAll();
        userRespository.delete(user);
        userRespository.deleteById((long) 1);
        userRespository.existsById((long) 1);
    }
}
