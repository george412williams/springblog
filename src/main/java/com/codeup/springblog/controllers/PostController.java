package com.codeup.springblog.controllers;


import com.codeup.springblog.models.Post;
import com.codeup.springblog.models.User;
import com.codeup.springblog.repositories.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.codeup.springblog.repositories.PostRepository;
import com.codeup.springblog.services.EmailService;

import java.util.List;

@Controller
public class PostController {




    //======== post and user injection
    private final PostRepository postDao;
    private final UserRepository userDao;
    //email service
    private EmailService emailService;

    public PostController(PostRepository postDao, UserRepository userDao, EmailService emailService){
        this.postDao = postDao;
        this.userDao = userDao;
        this.emailService = emailService;
    }
    //======== end injections


//    @GetMapping("/profile")
//    public String profile(Model model) {
//        model.addAttribute("id", id);
//        User user = userDao.getOne(id);
//    }

    @GetMapping("/posts")
    public String index(Model model) {
        List<Post> myPosts = postDao.findAll();
            //making a list for validation on posting side, may not matter
        model.addAttribute("posts", myPosts);
            //need to be flexable for the storage
        return "posts/index";
        //simulated table items for testing prior to learning dependency injection
        //the repository leads to the injection which gives you postDao which then gives you all posts
//        ArrayList<Post> myPosts = new ArrayList<>();
//        myPosts.add(new Post(2, "Blog2","Blog2 Text"));
//        myPosts.add(new Post(3, "Blog3","Blog2 Text"));
//        myPosts.add(new Post(4, "Blog4","Blog4 Text"));
    }

    @GetMapping("/posts/{id}")
    //need somewhere to get info
    public String show(@PathVariable long id, Model model) {
//        Post myPost = new Post(id, "blog1", "Hey there");
//        model.addAttribute("post", postDao.getOne(id));
        Post singlePost = postDao.getOne(id);
        User singleUser = userDao.getOne(id);
        //do not need the parameter attribs now, the object has been defined
//        model.addAttribute("title", singlePost.getTitle());
//        model.addAttribute("body", singlePost.getBody());
        //refactor to: (because all attribs will go, don't have to write a line for every attrib bigger real world
        model.addAttribute("post", singlePost);
        model.addAttribute("user", singleUser);
        //return postDao.getOne(id).toString();
//        return "redirect:/posts/" + id;
        return "posts/show";
    }

    // edit ================
    @PostMapping("/posts/{id}/edit")
    public String update(@PathVariable long id, @ModelAttribute Post posts){
        //hardcoded user for pre spring security purposes so that the post has a placeholder user_id
        User user = userDao.getOne(1L);
        //todo good place for a do list item; no authentication yet, later make user dynamic when spring security is incorped
        posts.setUser(user);
//        Post postToUpdate = new Post(); //old way
        //get post from db to edit
//        Post postToUpdate = postDao.getOne(id);
        //these must match the names in form fields:
        //then set the post to edit title and body w values/params from the request
//        postToUpdate.setTitle(title);
//        postToUpdate.setBody(body);
        //now save the changes to the db w the built in method
//        postDao.save(postToUpdate);
        postDao.save(posts);
        //redirect to that id's page

//        return "redirect:/posts/" + id;
        return "redirect:/posts";
        // or mine:
        //return "redirect:posts/show";
//       return "posts/show";

        // NOTE: may delete body if empty, in logic: if(body = null){do not save; return body;}
        //if(!body.isempty()), postDao.
    }


//    THE VIEW TO EDIT THE POST
    @GetMapping("/posts/{id}/edit")
    public String editPost(@PathVariable long id, Model model){
        //send to view of specific post:
        model.addAttribute("posts",postDao.getOne(id));
        return "/posts/edit";
    }

    // delete ================
    @PostMapping("/posts/{id}/delete")
    public String deletePost(@PathVariable long id){
        //old way
//        Post postToDelete = new Post();
//        postDao.delete(postToDelete);
        postDao.deleteById(id);
        return "redirect:/posts/";
        //need a getmapping to index to do this:
        //where you redirect is where the controller is listening with getmapping
    }

    // New Post ============= [before form model binding

//    @GetMapping("/posts/create")
////    @ResponseBody // removed now bc is now redirecting
//    public String create() {
//        return "posts/create";
//    }
//
//    @PostMapping("/posts/create")
//    public String insert(@RequestParam String title, @RequestParam String body){
//        User user = userDao.getOne(1L);
//        Post post = new Post(title, body);
//        postDao.save(post);
//        return "redirect:/posts";
//    }

    // New Post ============== now with FORM MODEL BINDING!

        //Get: add Model, add attrib for new obj in order to expose the view to the object

    @GetMapping("/posts/create")
    public String showCreateForm(Model model) {
        model.addAttribute("post", new Post());
        return "posts/create";
    }

        //Post: remove reqParams, replace with @ModelAtt obj, remove old logic

    @PostMapping("/posts/create")
    public String createPost(@ModelAttribute Post post){
        //hardcoding placeholder for now; to address user_id
        User user = userDao.getOne(1L);
        post.setUser(user);
        postDao.save(post);
        emailService.prepareAndSend(postDao.getOne(1L),"Post created!","You have created a post. If you received this in error, do something about it");
        return "redirect:/posts";
    }


    //Edit your PostController class to return the views you created above.
    //
    //Inside the method that shows an individual post, create a new post object and pass it to the view.
    //Inside the method that shows all the posts, create a new array list and add two post objects to it, then pass that list to the view.
    //In these two pages, you should display information based on the data passed from the controller.


}
