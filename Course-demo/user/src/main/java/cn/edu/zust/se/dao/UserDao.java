package cn.edu.zust.se.dao;

import cn.edu.zust.se.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserDao {
    @Select("select * from user where id=#{id}")
    User getUserById(Integer id);
}
