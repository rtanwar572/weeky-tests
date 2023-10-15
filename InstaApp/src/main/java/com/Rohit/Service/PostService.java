package com.Rohit.Service;

import com.Rohit.Model.User.Post;
import com.Rohit.Model.User.User;
import com.Rohit.Repo.IPostRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {

    @Autowired
    IPostRepo iPostRepo;
    public void savePost(Post userPost) {
        iPostRepo.save(userPost);
    }

    public Post getPostOwnerById(Integer postId) {
        return iPostRepo.findById(postId).orElseThrow();
    }

    public void deletePost(Post existPost) {
        iPostRepo.delete(existPost);
    }

//    public List<Post> getAllPosts(Integer userId) {
//        return iPostRepo.findByUserId(userId);
//    }
}
