package com.innogent.SpringProject.StudentDAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.innogent.SpringProject.Entity.Student;
import com.innogent.SpringProject.StudentRepo.StdRepository;

import java.util.List;
import java.util.Optional;

@Repository
public class StdntDao implements StdDao {

    @Autowired
    private StdRepository stdRepository;

    @Override
    public Student save(Student student) {
        return stdRepository.save(student);
    }

    @Override
    public void deleteById(Integer id) {
        stdRepository.deleteById(id);
    }

    @Override
    public List<Student> findAll() {
        return stdRepository.findAll();
    }

    @Override
    public Student findById(Integer id) {
        Optional<Student> optional = stdRepository.findById(id);
        return optional.orElse(null);
    }
    @Query("select b from Book b where b.author = ?1 or b.title = ?2")
   public List<Student> findByCourseInstructor(String course, String instructorName){

    }
}
