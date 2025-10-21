package com.innogent.SpringProject.ServiceImpl;

import com.innogent.SpringProject.Entity.Course;
import com.innogent.SpringProject.Entity.Student;
import com.innogent.SpringProject.Service.*;
import com.innogent.SpringProject.StudentDAO.CourseDao;
import com.innogent.SpringProject.StudentDAO.StdDao;
import com.innogent.SpringProject.dto.StudentRequest;
import com.innogent.SpringProject.dto.StudentResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class StudentServiceImpl implements StdService {

    @Autowired
    private StdDao stdDao;
    
    @Autowired 
    private CourseDao courseDao;
    
    @Transactional
    @Override
    public Student create(Student student, Set<String> courseNames) {
        Set<Course> courses = new HashSet<>();

        for (String courseName : courseNames) {
            Optional<Course> courseOpt = courseDao.findByCourseName(courseName);
            if (courseOpt.isPresent()) {
                courses.add(courseOpt.get());
            } else {
                throw new RuntimeException("Course not found: " + courseName);
            }
        }

        for (Course course : courses) {
            student.addCourse(course);
        }

        return stdDao.save(student);
    }

    @Override
    @Transactional
    public StudentResponse updateStudent(StudentRequest request) {
        return stdDao.updateStudent(request);
    }

    @Override
    public void deleteStudentById(Integer id) {
        stdDao.deleteStudentById(id);
    }

    @Override
    public StudentResponse findStudentById(Integer id) {
        return stdDao.findStudentById(id);
    }

    @Override
    public List<StudentResponse> findAllStudents() {
        return stdDao.findAllStudents();
    }
    
    @Override
    public List<Course> getCoursesWithoutStudents() {
        return stdDao.getCoursesWithoutStudents();
    }

    @Override
    @Transactional
    public int updateInstructorByCourseId(Long id, String instructor) {
        return stdDao.updateInstructorByCourseId(id, instructor);
    }

    @Override
    @Transactional
    public List<Object[]> getCourseWithStudentCount() {
        return stdDao.getCourseWithStudentCount();
    }

    @Override
    @Transactional
    public List<Object[]> getTopNCoursesByEnrollment(int n) {
        return stdDao.getTopNCoursesByEnrollment(n);
    }
}
