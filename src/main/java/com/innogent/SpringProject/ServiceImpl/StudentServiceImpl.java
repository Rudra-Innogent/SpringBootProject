package com.innogent.SpringProject.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.innogent.SpringProject.Entity.Student;
import com.innogent.SpringProject.Service.StdService;
import com.innogent.SpringProject.StudentDAO.StdDao;

import java.util.List;

@Service
public class StudentServiceImpl implements StdService {

    @Autowired
    private StdDao stdDao;

    @Override
    @Transactional
    public Student insert(Student student) {
        return stdDao.save(student);
    }

    @Override
    @Transactional
    public Student update(Student student) {
        return stdDao.save(student);
    }

    @Override
    @Transactional
    public void deleteById(Integer id) {
        stdDao.deleteById(id);
    }

    @Override
    public List<Student> getAll() {
        return stdDao.findAll();
    }

    @Override
    public Student getById(Integer id) {
        return stdDao.findById(id);
    }
}
