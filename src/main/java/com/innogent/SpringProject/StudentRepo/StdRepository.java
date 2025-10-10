package com.innogent.SpringProject.StudentRepo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.innogent.SpringProject.Entity.Student;

@Repository
public interface StdRepository extends JpaRepository<Student,Integer>  {
	
}
