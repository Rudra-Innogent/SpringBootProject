package com.innogent.SpringProject.ServiceImpl;

import com.innogent.SpringProject.Entity.Course;
import com.innogent.SpringProject.Service.CourseService;
import com.innogent.SpringProject.StudentDAO.CourseDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

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

	@Override
	public Optional<Course> findByCourseName(String courseName) {
		return courseDao.findByCourseName(courseName);
	}
}
