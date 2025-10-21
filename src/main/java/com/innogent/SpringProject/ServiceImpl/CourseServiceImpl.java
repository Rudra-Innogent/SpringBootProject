package com.innogent.SpringProject.ServiceImpl;

import com.innogent.SpringProject.Entity.Course;
import com.innogent.SpringProject.Service.CourseService;
import com.innogent.SpringProject.StudentDAO.CourseDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseDao courseDao;

    @Override
    public Course addCourse(Course course) {
        return courseDao.save(course);
    }

    @Override
    public List<Course> getAllCourses() {
        return courseDao.findAll();
    }
}
