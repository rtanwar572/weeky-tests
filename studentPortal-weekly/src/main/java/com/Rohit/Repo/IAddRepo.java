package com.Rohit.Repo;

import com.Rohit.Model.Address;
import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.repository.CrudRepository;

public interface IAddRepo extends JpaRepository<Address,Long> {
}
