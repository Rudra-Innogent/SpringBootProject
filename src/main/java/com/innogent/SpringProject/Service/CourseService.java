package com.innogent.SpringProject.Service;

import com.innogent.SpringProject.Entity.Course;

import jakarta.transaction.Transactional;

import java.util.List;

import org.springframework.stereotype.Service;
@Service
public interface CourseService {
	@Transactional
    Course addCourse(Course course);
	@Transactional
    List<Course> getAllCourses();
    
}
