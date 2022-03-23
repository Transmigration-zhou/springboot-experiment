package com.example.service.impl;

import com.example.dao.UserRepository;
import com.example.dto.UserDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service("service")
@Transactional
public class UserServiceImpl implements com.example.service.UserServiceI {
    @Resource
    UserRepository userMapper;

    @Override
    public List<UserDto> findAllByLoginNameAndType(String loginName, Integer type) {
        List<UserDto> userList = userMapper.findAll();
        return userList;
    }

    @Override
    public List<UserDto> findAll() {
        List<UserDto> userList = userMapper.findAll();
        return userList;
    }

    @Override
    public int delUser(String delUserName, String adminName, int type) {
        UserDto admin = userMapper.findByLoginName(adminName);
        int t = 0;
        if (admin.getType().equals(0)) {
            t = userMapper.deleteUserByLoginName(delUserName);
        }
        return t;
    }

    @Override
    public UserDto queryUserById(Integer id) {
        UserDto user = userMapper.findAllById(id);
        return user;
    }

    @Override
    public UserDto save(UserDto user) {
        UserDto t = userMapper.save(user);
        return t;
    }
}