package com.example.controller;

import com.example.pojo.User;
import com.example.service.UserServiceI;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(tags = "用户管理")
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserServiceI userService;

    @GetMapping("/login")
    @ApiOperation("用户登录")
    public String userLogin(@ApiParam("登录用户名") String login_name, @ApiParam("登陆密码") String password) {
        User user = userService.getUserByName(login_name);
        if (password.equals(user.getPassword())) {
            if (user.getType() == 0) {
                return "admin";
            }
            else {
                return "user";
            }
        }
        else {
            return "error";
        }
    }

    @PostMapping("/register")
    @ApiOperation("用户注册")
    public String register(User user) {
        userService.register(user);
        return "注册成功";
    }

    @GetMapping("/getAllUser")
    @ApiOperation("查看所有用户信息")
    public List<User> getAllUser(String login_name) {
        User user = userService.getUserByName(login_name);
        if (user.getType() == 0) {
            return userService.getAllUserList();
        }
        return null;
    }

    @PostMapping("/addUser")
    @ApiOperation("添加用户")
    public String addUser(User user) {
        userService.register(user);
        return "添加成功";
    }

    @PostMapping("/resetPassword")
    @ApiOperation("重置用户密码")
    public String resetPassword(Integer id, String password) {
        userService.resetPassword(id, password);
        return "重置成功";
    }
}
