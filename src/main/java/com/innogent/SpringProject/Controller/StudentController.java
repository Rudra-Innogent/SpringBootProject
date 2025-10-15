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
    private StdService stdService;

    @PostMapping("/insert")
    public ResponseEntity<Student> create(@RequestBody Student student){
        return new ResponseEntity<>(stdService.insert(student), HttpStatus.CREATED);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Student>> showAll(){
        return new ResponseEntity<>(stdService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<Student> showById(@PathVariable Integer id){
        Student student = stdService.getById(id);
        if(student != null){
            return new ResponseEntity<>(student, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Student> update(@PathVariable Integer id, @RequestBody Student student){
        student.setId(id);
        return new ResponseEntity<>(stdService.update(student), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id){
        stdService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
