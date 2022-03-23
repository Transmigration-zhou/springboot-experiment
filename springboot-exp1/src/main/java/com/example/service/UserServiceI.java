package com.example.service;

import com.example.dto.UserDto;

import java.util.List;

public interface UserServiceI {
    List<UserDto> findAllByLoginNameAndType(String loginName, Integer type);

    List<UserDto> findAll();

    int delUser(String delUserName, String adminName, int type);

    UserDto queryUserById(Integer id);

    UserDto save(UserDto user);
}
