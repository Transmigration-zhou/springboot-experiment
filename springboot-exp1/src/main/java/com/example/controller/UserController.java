package com.example.controller;

import com.example.dto.UserDto;
import com.example.dto.Result;
import com.example.service.UserServiceI;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@Api(tags = {"简易设备资产管理接口"})
@RestController
@RequestMapping("user")
public class UserController {
    @Resource
    UserServiceI userService;

    @PostMapping("/login")
    @ApiOperation("登录方法")
    public Result Login(@RequestParam("loginName") String loginName, String password, Integer type) {
        List<UserDto> userList = userService.findAll();
        boolean flag = false;
        for (UserDto u : userList) {
            System.out.println(u.getLoginName());
            System.out.println(u.getLoginName().equals(loginName));
            if (u.getLoginName().equals(loginName)) {
                flag = true;
                if (u.getPassword().equals(password) && u.getType().equals(type)) {
                    return new Result(200, "登录成功", u);
                }
            }
            if (flag == false) return new Result(400, "密码错误");
        }
        return new Result(400, "false");
    }

    @PostMapping("/delUser")
    @ApiOperation("删除用户")
    public Result deluser(String userName, String adminName, Integer type) {
        int t = userService.delUser(userName, adminName, type);
        if (t != 0) return new Result(200, "删除成功");
        else return new Result(400, "删除失败");

    }

    @GetMapping("/queryUser")
    @ApiOperation("管理员查看用户信息")
    public Result queryUser(Integer id) {
        UserDto user = userService.queryUserById(id);
        if (user != null) return new Result(200, "success", user);
        else return new Result(100, "false");
    }

    @GetMapping("queryAllUser")
    @ApiOperation(("查看所有用户信息"))
    public Result queryAllUser() {
        List<UserDto> userList = userService.findAll();
        if (userList != null)
            return new Result(200, "successs", userList);
        else return new Result(400, "为找到任何用户信息");
    }

    @PostMapping("resetPass")
    @ApiOperation("重置密码")
    public Result resetPasssword(String loginName, String Resetpass, int id) {
        UserDto user = userService.queryUserById(id);
        user.setPassword(Resetpass);
        UserDto a = userService.save(user);
        return new Result(200, "success", a);
    }
}
