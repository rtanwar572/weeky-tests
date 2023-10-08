package com.Rohit.Repo;

import com.Rohit.Model.Laptop;
import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.repository.CrudRepository;

public interface ILapRepo extends JpaRepository<Laptop,Integer> {
}
