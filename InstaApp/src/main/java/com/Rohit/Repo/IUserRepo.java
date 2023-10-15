package com.Rohit.Repo;

import com.Rohit.Model.User.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepo extends JpaRepository<User,Integer> {
    User findFirstByUserEmail(String email);
}
