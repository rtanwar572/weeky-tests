package com.Rohit.Controller;

import com.Rohit.Model.Student;
import com.Rohit.Service.StuService;
import jakarta.persistence.GeneratedValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/students")
public class StuController {
    @Autowired
    StuService stuService;

    @PostMapping
    public String addStudent(@RequestBody Student stu){
        return stuService.addStudent(stu);
    }
    @GetMapping
    public Set<Student> getStudents(){
        return stuService.getStudent();
    }
    @DeleteMapping("/{id}")
    public String delStudent(@PathVariable Integer id){
        return stuService.delStudent(id);
    }
}
