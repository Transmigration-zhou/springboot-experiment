package com.example.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Equipment {
    private Integer id;
    private String name;
    private String description;
    private String code;
    private Date addTime;
    private Double price;
    private String place;
    private Integer userId;
    private User user;
}