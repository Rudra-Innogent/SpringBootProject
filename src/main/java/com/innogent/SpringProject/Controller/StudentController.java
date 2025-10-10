package com.innogent.SpringProject.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.innogent.SpringProject.Entity.Student;
import com.innogent.SpringProject.Service.StdService;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    StdService stdService;

    @PostMapping("/insert")
    public ResponseEntity<Student> create(@RequestBody Student student){
        return new ResponseEntity<>(stdService.insert(student), HttpStatus.CREATED);
    }

    @GetMapping("/getDetails")
    public ResponseEntity<List<Student>> show(){
        return new ResponseEntity<List<Student>>(stdService.getAll(),HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Student> update(@PathVariable("id")Integer id,@RequestBody Student student){
        return new ResponseEntity<Student>(stdService.update( student),HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Student> delete(@RequestBody Student student){
        return new ResponseEntity<Student>(stdService.delete(student),HttpStatus.OK);
    }

}