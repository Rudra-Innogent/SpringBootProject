package com.innogent.SpringProject.StudentDAO;

import com.innogent.SpringProject.Entity.Course;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

@Service
public interface CourseDao {
    Course save(Course course);
    List<Course> findAll();
    
    Optional<Course> findByCourseName(String courseName);
}


