package com.innogent.SpringProject.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.innogent.SpringProject.Entity.Student;
import com.innogent.SpringProject.Service.StdService;
import com.innogent.SpringProject.StudentRepo.StdRepository;

import java.util.List;

@Service
public class StudentServiceImpl implements StdService {
    @Autowired
    private StdRepository studentRepository;

    @Override
    public Student insert(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Student delete(Student student) {
       studentRepository.delete(student);
       return student;
    }

    @Override
    public Student update(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public List<Student> getAll() {
        return studentRepository.findAll();
    }
}

