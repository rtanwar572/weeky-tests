package com.Rohit.Service;

import com.Rohit.Model.Student;
import com.Rohit.Repo.IStuRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class StuService {
    @Autowired
    IStuRepo iStuRepo;
    public String addStudent(Student stu) {
        iStuRepo.save(stu);
        return "Student Added";
    }

    public Set<Student> getStudent() {
        List<Student> st= iStuRepo.findAll();
        Set<Student> hs=new HashSet<>(st);
        return hs;
    }

    public String delStudent(Integer id) {
        iStuRepo.deleteById(id);
        return "Student Deleted";
    }
}
