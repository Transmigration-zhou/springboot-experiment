package cn.edu.zust.se.controller;


import cn.edu.zust.se.pojo.Course;
import cn.edu.zust.se.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/course")
public class CourseController {
    @Autowired
    CourseService courseService;

    @GetMapping("/{id}")
    public Course getCourseById(@PathVariable("id") Integer id) {
        return courseService.getCourseById(id);
    }
}
