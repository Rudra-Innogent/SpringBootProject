package com.innogent.SpringProject.Service;

import com.innogent.SpringProject.Entity.*;
import com.innogent.SpringProject.dto.*;
import java.util.*;

public interface StdService{

    Student create(Student student, Set<String> courseNames);

    StudentResponse updateStudent(StudentRequest request);

    void deleteStudentById(Integer id);

    StudentResponse findStudentById(Integer id);

    List<StudentResponse> findAllStudents();
     
    List<Course> getCoursesWithoutStudents();
    
    int updateInstructorByCourseId(Long id, String instructor);

    List<Object[]> getCourseWithStudentCount();

    List<Object[]> getTopNCoursesByEnrollment(int n);
}
