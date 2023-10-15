package com.Rohit.Repo;

import com.Rohit.Model.User.Likes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ILikeRepo extends JpaRepository<Likes,Integer> {
}
