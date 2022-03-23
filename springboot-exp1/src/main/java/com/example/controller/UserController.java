package com.example.controller;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RestController("user")
public class UserController {
    @GetMapping("/{id}")
    public UserDto getUser(@PathVariable int id){
        return null;
    }
    @PostMapping("")
    public UsetDto addUser(@RequestBody UserDto user){
        return null;
    }
    @GetMapping("list")
    public List<UserDto> allUsers(){
        return null;
    }
}
