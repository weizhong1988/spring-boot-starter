package com.weiz.service;

import com.weiz.pojo.User;

public interface UserService {
    public int saveUser(User user);
    public int updateUser(User user);
    public int deleteUser(String userId);
    public User queryUserById(String userId);
}
