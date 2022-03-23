package com.example.dto;

import lombok.Data;

/**
 * 封装json对象，所有返回结果都使用它
 */
@Data
public class Result<T> {
    private Integer code;// 是否成功标志
    private String message;// 提示信息
    private T data;// 成功时返回的数据

    public Result() {
    }

    //成功时构造器
    public Result(Integer code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    //错误时
    public Result(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
