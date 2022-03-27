package com.example.service.impl;

import com.example.dao.UserMapper;
import com.example.pojo.User;
import com.example.service.UserServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserServiceI {
    @Autowired
    UserMapper userMapper;

    @Override
    public List<User> getAllUserList() {
        return userMapper.getUserList();
    }

    @Override
    public User getUserByName(String login_name) {
        return userMapper.getUserByName(login_name);
    }

    @Override
    public void register(User user) {
        userMapper.addUser(user);
    }

    @Override
    public void addUser(User user) {
        userMapper.addUser(user);
    }

    @Override
    public void resetPassword(Integer id, String password) {
        userMapper.updatePassword(id,password);
    }
}
