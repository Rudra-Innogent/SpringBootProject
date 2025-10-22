package com.innogent.SpringProject.StudentDAO;

import com.innogent.SpringProject.Entity.*;
import com.innogent.SpringProject.StudentRepo.*;
import com.innogent.SpringProject.dto.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class StdntDao implements StdDao {

    @Autowired
    private StdRepository stdRepository;
    
    @Autowired
    private CourseRepository courseRepository;

    @Override
    public Student save(Student student) {
        return stdRepository.save(student);
    }
    
    @Override
    public StudentResponse updateStudent(StudentRequest request) {
        Student student = stdRepository.findById(request.getId()).orElse(null);
        if (student == null) {
            return null;
        }

        student.setName(request.getName());
        student.setEmail(request.getEmail());
        student.setCity(request.getCity());

       
        if (request.getCourseNames() != null) {
            Set<Course> courses = new HashSet<>();

            for (String courseName : request.getCourseNames()) {
                Course course = courseRepository.findByCourseName(courseName).orElse(null);
                if (course != null) {
                    courses.add(course);
                }
            }

            student.setCourses(courses);
        }

        stdRepository.save(student);   
        StudentResponse response = new StudentResponse();
        response.setId(student.getId());
        response.setName(student.getName());
        response.setEmail(student.getEmail());
        response.setCity(student.getCity());
   
        List<String> courseNames = new ArrayList<>();
        if (student.getCourses() != null) {
            for (Course course : student.getCourses()) {
                courseNames.add(course.getCourseName());
            }
        }
        response.setCourseNames(courseNames);

        return response;
    }



    @Override
    public StudentResponse findStudentById(Integer id) {
        Student student = stdRepository.findById(id).orElse(null);
        if(student == null) return null;

        StudentResponse response = new StudentResponse();
        response.setId(student.getId());
        response.setName(student.getName());
        response.setEmail(student.getEmail());
        response.setCity(student.getCity());
        response.setCourseNames(student.getCourses().stream().map(c -> c.getCourseName()).toList());
        return response;
    }

    @Override
    public List<StudentResponse> findAllStudents() {
        List<Student> students = stdRepository.findAll();
        return students.stream().map(student -> {
            StudentResponse response = new StudentResponse();
            response.setId(student.getId());
            response.setName(student.getName());
            response.setEmail(student.getEmail());
            response.setCity(student.getCity());
            response.setCourseNames(student.getCourses().stream()
                                    .map(c -> c.getCourseName())
                                    .toList());
            return response;
        }).toList();
    }
  
    @Override
    public void deleteStudentById(Integer id) {
        stdRepository.deleteById(id);
    }
    
    
    @Override
    public List<Course> getCoursesWithoutStudents() {
        return stdRepository.getCoursesWithoutStudents();
    }

  
    @Override
    public int updateInstructorByCourseId(Long id, String instructor) {
        return stdRepository.updateInstructorByCourseId(id, instructor);
    }

   
    @Override
    public List<Object[]> getCourseWithStudentCount() {
        return stdRepository.getCourseWithStudentCount();
    }

  
    @Override
    public List<Object[]> getTopNCoursesByEnrollment(int n) {
        List<Object[]> allCourses = stdRepository.getAllCoursesByEnrollmentDesc();
        return allCourses.stream().limit(n).collect(Collectors.toList());
    }

}
