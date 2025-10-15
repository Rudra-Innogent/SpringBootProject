package com.innogent.SpringProject.StudentRepo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.innogent.SpringProject.Entity.Student;

import java.util.List;

@Repository
public interface StdRepository extends JpaRepository<Student,Integer>  {
    @Query("SELECT Count(testObj) FROM Student testObj")
    Integer getStudentCount(<Sturnt> stude);
}
