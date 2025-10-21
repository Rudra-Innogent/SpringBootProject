package com.innogent.SpringProject.StudentRepo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.innogent.SpringProject.Entity.Course;
import com.innogent.SpringProject.Entity.Student;

import jakarta.transaction.Transactional;

import java.util.List;

@Repository
public interface StdRepository extends JpaRepository<Student,Integer>  {
    

	@Query("SELECT DISTINCT s FROM Student s LEFT JOIN FETCH s.courses")
	List<Student> findAllWithCourses();

	@Query("SELECT c FROM Course c LEFT JOIN c.students s WHERE s IS NULL")
	List<Course> getCoursesWithoutStudents();
	
	@Query("SELECT s FROM Student s WHERE s.courses IS EMPTY")
	List<Student> getStudentsWithoutCourses();

	@Query("SELECT DISTINCT s FROM Student s JOIN s.courses c WHERE s.city = :city AND c.instructor = :instructor")
	List<Student> findStudentsByCityAndInstructor(String city, String instructor);

	@Transactional
    @Modifying
    @Query("UPDATE Course c SET c.instructor = :instructor WHERE c.id = :id")
    int updateInstructorByCourseId(Long id, String instructor);
    
    @Query("SELECT c.courseName, COUNT(s) FROM Course c LEFT JOIN c.students s GROUP BY c.courseName")
    List<Object[]> getCourseWithStudentCount();

    @Query("SELECT c.courseName, COUNT(s) as cnt FROM Course c LEFT JOIN c.students s GROUP BY c.courseName ORDER BY cnt DESC")
    List<Object[]> getAllCoursesByEnrollmentDesc();

}
