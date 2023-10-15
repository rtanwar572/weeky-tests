package com.Rohit.Service;

import com.Rohit.Model.AuthToken;
import com.Rohit.Model.Dto.AuthenticationInputDto;
import com.Rohit.Model.Dto.SignInInputDto;
import com.Rohit.Model.User.Post;
import com.Rohit.Model.User.User;
import com.Rohit.Repo.IUserRepo;
import com.Rohit.Service.HashingUtility.PassEncryptor;
import com.Rohit.Service.MailUtility.EmailHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    IUserRepo iUserRepo;

    @Autowired
    UAuthToken uAuthToken;

    @Autowired
    PostService postService;
//    @Autowired
//    AuthToken authToken;

    public String addUser(User user) {
        String email=user.getUserEmail();
        User existuser=iUserRepo.findFirstByUserEmail(email);
        if(existuser!=null){
            return "User alReady Exist just Login";
        }
        String pass=user.getUserPass();
        try {
            String encryptedpass= PassEncryptor.encrypt(pass);
            user.setUserPass(encryptedpass);
            iUserRepo.save(user);
            return "User Registered !!";
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    public String signInUser(SignInInputDto signInInputDto) {
        String email=signInInputDto.getEmail();
        User existuser=iUserRepo.findFirstByUserEmail(email);
        if(existuser==null){
            return "Invalid id and pass, You May SignUp First";
        }
        String pass=signInInputDto.getPass();
        try {
            String encryptPass=PassEncryptor.encrypt(pass);
            if(encryptPass.equals(existuser.getUserPass())){
                AuthToken token=new AuthToken(existuser);
                if (EmailHandler.sendEmail(existuser.getUserEmail(),"Otp After Login",token.getTokValue())){
                    uAuthToken.createToken(token);
                    return "Otp/Token Sent Successfully !!";
                }
                else {
                    return "Error While Sending Opt/Token";
                }
            }
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
        return "Invalid Credentials !";
    }

    public String updateUser(User user) {
        if (iUserRepo.findById(user.getUserId())==null){
            return "No Such User Found";
        }
        iUserRepo.save(user);
        return user.getUserName()+ " Your Details Has Been Changed !!";

    }

    public String savePost(String email,String tokenVal ,Post userPost) {
        if (uAuthToken.AuthenticateU(email,tokenVal)){
            User existingUser=iUserRepo.findFirstByUserEmail(email);
            userPost.setUser(existingUser);
            postService.savePost(userPost);
            return userPost.getPostType() +" Uploaded";
        }
        else {
            return "UnAuthorized User !!";
        }
    }

    public String delPost(String email, String tokenVal, Integer postId) {
        if (uAuthToken.AuthenticateU(email,tokenVal)){
            User existUser=iUserRepo.findFirstByUserEmail(email);
            Post existPost=postService.getPostOwnerById(postId);
            if(existPost.getUser().equals(existUser)){
                postService.deletePost(existPost);
                return existPost.getPostType()+ " Deleted !!";

            }
            else {
                return "UnAuthorized User";
            }
        }
        else {
            return "UnAuthorized User !!";
        }
    }

    public String signOutUser(AuthenticationInputDto authenticationInputDto) {
        String email=authenticationInputDto.getEmail();
        String tokenVal=authenticationInputDto.getTokenVal();
        if(uAuthToken.AuthenticateU(email,tokenVal)){
            return uAuthToken.delUserToken(tokenVal);
        }
        else {
            return "UnAuthorized User";
        }
    }

//    public List<Post> getUserPosts(Integer userId) {
//        return
//    }

    public User getuserById(Integer userId) {
        return iUserRepo.findById(userId).orElseThrow();
    }
}
