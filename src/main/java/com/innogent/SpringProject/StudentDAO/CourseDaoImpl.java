package com.innogent.SpringProject.StudentDAO;

import com.innogent.SpringProject.Entity.Course;
import com.innogent.SpringProject.StudentRepo.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public class CourseDaoImpl implements CourseDao {

    @Autowired
    private CourseRepository courseRepository;

    @Override
    public Course save(Course course) {
    	System.out.println(course);
        return courseRepository.save(course);
    }

    @Override
    public List<Course> findAll() {
        return courseRepository.findAll();
    }

    @Override
    public Optional<Course> findByCourseName(String courseName) {
        return courseRepository.findByCourseName(courseName);
    }
}
