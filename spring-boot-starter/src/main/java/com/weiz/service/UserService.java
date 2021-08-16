package com.weiz.service;

import com.weiz.pojo.SysUser;

import java.util.List;

public interface UserService {

    void saveUser(SysUser user) throws Exception;

    void updateUser(SysUser user);

    void deleteUser(String userId);

    SysUser queryUserById(String userId);

    List<SysUser> queryUserList(SysUser user);

    List<SysUser> queryUserListPaged(SysUser user, Integer page, Integer pageSize);

    SysUser queryUserByIdCustom(String userId);

    List<SysUser> queryAllUserListCustom();

    void saveUserTransactional(SysUser user);
}
