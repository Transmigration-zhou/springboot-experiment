package com.example.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private Integer id;
    private String loginName;
    private String realName;
    private String password;
    private String tel;
    private String email;
    private Integer type;
    private Date lastLoginTime;
}