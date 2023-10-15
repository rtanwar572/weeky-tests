package com.Rohit.Repo;

import com.Rohit.Model.User.Comments;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICommentRepo extends JpaRepository<Comments,Integer> {
}
