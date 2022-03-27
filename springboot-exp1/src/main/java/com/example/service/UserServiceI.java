package com.example.service;


import com.example.pojo.User;

import java.util.List;

public interface UserServiceI {
    List<User> getAllUserList();

    User getUserByName(String login_name);

    void register(User user);

    void addUser(User user);

    void resetPassword(Integer id, String password);
}
