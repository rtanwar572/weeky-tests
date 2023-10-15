package com.Rohit.Repo;

import com.Rohit.Model.User.Follow;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IFollowRepo extends JpaRepository<Follow,Integer> {
}
