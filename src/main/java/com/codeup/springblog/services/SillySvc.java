package com.codeup.springblog.services;


import com.codeup.springblog.models.Post;
import com.codeup.springblog.models.User;
import com.codeup.springblog.repositories.PostRepository;
import com.codeup.springblog.repositories.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class SillySvc {

//NOTE: instructor used ads db;

    //want total number characters in all posts?

    //in order to ...
    //inject here
    private PostRepository postDao;
    private UserRepository userDao;

    public SillySvc(PostRepository postDao, UserRepository userDao){
        this.postDao = postDao;
        this.userDao = userDao;
    }
    //end inject

    public int totalPostCharacters(){
        //iterate over all posts, find all posts, and get lengths of bodies and add em
        //make a list
        Iterable<Post> posts = postDao.findAll();
        Iterable<User> users = userDao.findAll();
        //make a bucket
        int total = 0;

        //now loop em
        for (Post post : posts){
            total += post.getBody().length();
        }

        for (User user : users){
            total += user.getUsername().length();
        }
        return total;
        //now add to the controller, inject its dependency
    }

}
