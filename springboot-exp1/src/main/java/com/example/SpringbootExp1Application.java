package com.example;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.dao")
public class SpringbootExp1Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootExp1Application.class, args);
    }

}
