package com.innogent.SpringProject.StudentRepo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.innogent.SpringProject.Entity.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
    
    //Course findByCourseName(String courseName);
    Optional<Course> findByCourseName(String courseName);
}
