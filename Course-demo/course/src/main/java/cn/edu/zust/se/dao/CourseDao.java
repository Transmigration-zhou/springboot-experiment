package cn.edu.zust.se.dao;

import cn.edu.zust.se.pojo.Course;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface CourseDao {
    @Select("select * from course where id=#{id}")
    Course getCourseById(Integer id);
}
