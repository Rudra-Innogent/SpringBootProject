package com.innogent.SpringProject.Service;

import java.util.List;

import com.innogent.SpringProject.Entity.Student;

public interface StdService {

    public Student insert(Student student);
    public Student delete(Student student);
    public Student update(Student student);
    public List<Student> getAll();
}
	

