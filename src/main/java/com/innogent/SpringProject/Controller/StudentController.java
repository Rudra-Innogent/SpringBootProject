package com.innogent.SpringProject.Controller;

import com.innogent.SpringProject.Entity.Course;
import com.innogent.SpringProject.Entity.Student;
import com.innogent.SpringProject.Service.StdService;
import com.innogent.SpringProject.StudentRepo.StdRepository;
import com.innogent.SpringProject.dto.StudentRequest;
import com.innogent.SpringProject.dto.StudentResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StdService stdService;

    @Autowired
    private StdRepository stdRepository;

    @PostMapping("/create")
    public ResponseEntity<Student> create(@RequestBody StudentRequest studentRequest) {
        Student student = new Student();
        student.setName(studentRequest.getName());
        student.setEmail(studentRequest.getEmail());
        student.setCity(studentRequest.getCity());
        
        return ResponseEntity.ok(stdService.create(student, studentRequest.getCourseNames()));
    }
    
    @PutMapping("/update")
    public ResponseEntity<StudentResponse> updateStudent(@RequestBody StudentRequest request) {
        StudentResponse response = stdService.updateStudent(request);
        return response != null ? ResponseEntity.ok(response)
                                : ResponseEntity.notFound().build();
    }


 
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable Integer id) {
        stdService.deleteStudentById(id);
        return ResponseEntity.ok("Student deleted successfully!");
    }

  
    @GetMapping("/getStudentById/{id}")
    public ResponseEntity<StudentResponse> getStudentById(@PathVariable Integer id) {
        StudentResponse studentResponse = stdService.findStudentById(id);
        return studentResponse != null ? ResponseEntity.ok(studentResponse)
                                       : ResponseEntity.notFound().build();
    }

   
    @GetMapping("/findAll")
    public ResponseEntity<List<StudentResponse>> getAllStudents() {
        return ResponseEntity.ok(stdService.findAllStudents());
    }

    
    @GetMapping("/coursesWithoutStudents")
    public List<Course> getCoursesWithoutStudents() {
        return stdService.getCoursesWithoutStudents();
    }

    @GetMapping("/with-courses")
    public ResponseEntity<List<Student>> getAllWithCourses() {
        return ResponseEntity.ok(stdRepository.findAllWithCourses());
    }
  
    @GetMapping("/no-course")
    public ResponseEntity<List<Student>> getWithoutCourse() {
        return ResponseEntity.ok(stdRepository.getStudentsWithoutCourses());
    }


    @GetMapping("/searchByCityAndInstructor")
    public ResponseEntity<List<Student>> search(
            @RequestParam String city,
            @RequestParam String instructor) {
        return ResponseEntity.ok(stdRepository.findStudentsByCityAndInstructor(city, instructor));
    }
    
 
    @PutMapping("/updateInstructor/{id}")
    public String updateInstructor(@PathVariable Long id, @RequestParam String instructor) {
        int updated = stdService.updateInstructorByCourseId(id, instructor);
        return updated > 0 ? "Instructor updated successfully!" : "Course not found!";
    }

   
    @GetMapping("/courseWithCount")
    public List<Object[]> getCourseWithStudentCount() {
        return stdService.getCourseWithStudentCount();
    }

    
    @GetMapping("/topCourses")
    public List<Object[]> getTopCourses(@RequestParam int n) {
        return stdService.getTopNCoursesByEnrollment(n);
    }
}
