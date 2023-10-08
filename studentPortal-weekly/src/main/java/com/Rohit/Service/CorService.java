package com.Rohit.Service;

import com.Rohit.Model.Course;
import com.Rohit.Model.Student;
import com.Rohit.Repo.ICorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class CorService {
    @Autowired
    ICorRepo iCorRepo;
    public String addCourse(Course course) {
        iCorRepo.save(course);
        return "Course Added";
    }

    public Set<Course> getCourses() {
        List<Course> cr= iCorRepo.findAll();
        Set<Course> hs=new HashSet<>(cr);
        return hs;
    }

    public String delCourse(Integer id) {
        iCorRepo.deleteById(id);
        return "Course Removed";
    }
}
