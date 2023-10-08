package com.Rohit.Repo;

import com.Rohit.Model.Books;
import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.repository.CrudRepository;

public interface IBookRepo extends JpaRepository<Books,Integer> {
}
