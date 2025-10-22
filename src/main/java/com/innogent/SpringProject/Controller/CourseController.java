package com.innogent.SpringProject.Controller;

import com.innogent.SpringProject.Entity.Course;
import com.innogent.SpringProject.Service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/course")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @PostMapping("/add")
    public ResponseEntity<Course> addCourse(@RequestBody Course course) {
    	System.out.println(course);
        return ResponseEntity.ok(courseService.addCourse(course));
    }

    @GetMapping("/getAllCourses")
    public ResponseEntity<List<Course>> getAllCourses() {
        return ResponseEntity.ok(courseService.getAllCourses());
    }
    
    @GetMapping("/findByCourse")
    public Optional<Course> findByCourseName(@RequestParam String courseName) {
        return courseService.findByCourseName(courseName);
    }
}
