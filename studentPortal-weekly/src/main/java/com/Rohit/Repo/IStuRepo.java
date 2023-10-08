package com.Rohit.Repo;

import com.Rohit.Model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.repository.CrudRepository;

public interface IStuRepo extends JpaRepository<Student,Integer> {
}
