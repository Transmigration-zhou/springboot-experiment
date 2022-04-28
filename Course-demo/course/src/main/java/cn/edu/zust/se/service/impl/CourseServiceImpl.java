package cn.edu.zust.se.service.impl;

import cn.edu.zust.se.dao.CourseDao;
import cn.edu.zust.se.pojo.Course;
import cn.edu.zust.se.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CourseServiceImpl implements CourseService {
    @Autowired
    CourseDao CourseDao;

    @Override
    public Course getCourseById(Integer Id) {
        return CourseDao.getCourseById(Id);
    }
}
