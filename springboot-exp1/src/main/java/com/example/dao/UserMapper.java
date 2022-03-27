package com.example.dao;

import com.example.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface UserMapper {
    @Select("select * from tuser")
    List<User> getUserList();

    @Select("select * from tuser where login_name=#{loginName}")
    User getUserByName(String loginName);

    @Insert("insert into tuser(login_name,password,real_name,tel,email) value(#{loginName},#{password},#{realName},#{tel},#{email})")
    void addUser(User user);

    @Update("update tuser set password=#{password} where id=#{id}")
    void updatePassword(Integer id, String password);
}
