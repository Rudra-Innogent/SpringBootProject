package com.innogent.SpringProject.StudentDAO;

import com.innogent.SpringProject.Entity.Course;
import com.innogent.SpringProject.Entity.Student;
import com.innogent.SpringProject.dto.StudentRequest;
import com.innogent.SpringProject.dto.StudentResponse;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public interface StdDao{

    Student save(Student student);
    
    StudentResponse updateStudent(StudentRequest request);

    void deleteStudentById(Integer id);

    StudentResponse findStudentById(Integer id);

    List<StudentResponse> findAllStudents();
    
    List<Course> getCoursesWithoutStudents(); 
    
    int updateInstructorByCourseId(Long id, String instructor);
  
    List<Object[]> getCourseWithStudentCount();
   
    List<Object[]> getTopNCoursesByEnrollment(int n);
}
