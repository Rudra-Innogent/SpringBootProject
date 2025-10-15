package com.innogent.SpringProject.StudentDAO;

import com.innogent.SpringProject.Entity.Student;
import java.util.List;

public interface StdDao {
    Student save(Student student);
    void deleteById(Integer id);
    List<Student> findAll();
    Student findById(Integer id);
    Integer studentCount();
}
