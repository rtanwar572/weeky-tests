package com.Rohit.Repo;

import com.Rohit.Model.User.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IPostRepo extends JpaRepository<Post,Integer> {
//    List<Post> findByUserId(Integer userId);

}
