package com.weiz.service.impl;

import com.weiz.mapper.test1.User1Mapper;
import com.weiz.mapper.test2.User2Mapper;
import com.weiz.pojo.User;
import com.weiz.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private User1Mapper user1Mapper;

    @Autowired
    private User2Mapper user2Mapper;

    @Override
    public int saveUser(User user) {
        user1Mapper.insert(user);
        return user2Mapper.insert(user);
    }

    @Override
    public int updateUser(User user) {
        user1Mapper.updateByPrimaryKey(user);
        return user2Mapper.updateByPrimaryKey(user);
    }

    @Override
    public int deleteUser(String userId) {
        user1Mapper.deleteByPrimaryKey(userId);
        return user2Mapper.deleteByPrimaryKey(userId);
    }

    @Override
    public User queryUserById(String userId) {
        user1Mapper.selectByPrimaryKey(userId);
        return user2Mapper.selectByPrimaryKey(userId);
    }
}
