package com.Rohit.Controller;

import com.Rohit.Model.Dto.AuthenticationInputDto;
import com.Rohit.Model.Dto.SignInInputDto;
import com.Rohit.Model.User.Post;
import com.Rohit.Model.User.User;
import com.Rohit.Service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.security.PublicKey;
import java.util.List;

@RestController
@RequestMapping("/user")
@Validated
public class UserContoller {
    @Autowired
    UserService userService;
    @PostMapping("/signUpUser")
    public String addUser(@Valid @RequestBody User user){
        return userService.addUser(user);
    }

    @PostMapping("/SignInUser")
    public String signInUser(@RequestBody SignInInputDto signInInputDto){
        return userService.signInUser(signInInputDto);
    }
    @DeleteMapping("/signOut")
    public String singOutUser(@RequestBody AuthenticationInputDto authenticationInputDto){
        return userService.signOutUser(authenticationInputDto);
    }
    @PutMapping("/id/{id}")
    public String updateUser(@Valid @RequestBody User user){
        return  userService.updateUser(user);
    }
    @PostMapping("/savePost/email/{email}/tokenVal/{tokenVal}")
    @Valid
    public String saveUserPost(@PathVariable String email, @PathVariable String tokenVal ,@RequestBody Post userPost){
        return userService.savePost(email,tokenVal,userPost);
    }
    @GetMapping("userId/{userId}/posts")
    public User getUserPosts(@PathVariable Integer userId){
        return userService.getuserById(userId);
    }

    @DeleteMapping("/deletePost/email/{email}/tokenVal/{tokenVal}/id/{postId}")
    public String delUserPost(@PathVariable String email, @PathVariable String tokenVal ,@PathVariable Integer postId){
        return userService.delPost(email,tokenVal,postId);
    }

}
