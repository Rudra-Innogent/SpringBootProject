package com.innogent.SpringProject.Service;

import com.innogent.SpringProject.Entity.Student;
import java.util.List;

public interface StdService {

    Student insert(Student student);
    Student update(Student student);
    void deleteById(Integer id);
    List<Student> getAll();
    Student getById(Integer id);
}
