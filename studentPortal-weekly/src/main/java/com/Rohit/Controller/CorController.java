package com.Rohit.Controller;

import com.Rohit.Model.Course;
import com.Rohit.Service.CorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.PublicKey;
import java.util.Set;

@RestController
@RequestMapping("/Courses")
public class CorController {
    @Autowired
    CorService corService;

    @PostMapping
    public String getCourse(@RequestBody Course course){
        return corService.addCourse(course);
    }
    @GetMapping
    public Set<Course> getCourses(){
        return corService.getCourses();
    }
    @DeleteMapping("/id/{id}")
    public String delCourse(@PathVariable Integer id){
        return corService.delCourse(id);
    }
}
