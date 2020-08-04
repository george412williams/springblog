package controllers;


import models.Post;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import repositories.PostRepository;

import java.sql.ClientInfoStatus;
import java.util.ArrayList;
import java.util.List;

@Controller
public class PostController {

    //===== injection
    private final PostRepository postDao;

    public PostController(PostRepository postDao){
        this.postDao = postDao;
    }
    //======== end injection

    @GetMapping("/posts")
    public String index(@PathVariable long id, Model model) {
        ArrayList<Post> myPosts = new ArrayList<>();
        myPosts.add(new Post(2, "Blog2","Blog2 Text"));
        myPosts.add(new Post(3, "Blog3","Blog2 Text"));
        myPosts.add(new Post(4, "Blog4","Blog4 Text"));
        model.addAttribute("posts", myPosts);
//        ArrayList<String> allPosts = new ArrayList<String>();
//        allPosts.add(1, "bodyone");
//        allPosts.add(2, "bodytwo");
        return "posts/index";
    }

    @GetMapping("/posts/{id}")
    public String show(
            @PathVariable long id,
            Model model) {
        Post myPost = new Post(id, "blog1", "Hey there");
        model.addAttribute("title", myPost.getTitle());
        model.addAttribute("body", myPost.getBody());
        model.addAttribute("post", myPost);
        return "posts/show";
    }

    //for editing
    @PostMapping("/posts/edit/{id}")
    public String saveEdit(@RequestParam(name = "title") String title){
        Post postToUpdate = new Post();
        postToUpdate.setTitle(title);

       return "posts/show";
    }

    //for deleting
    @PostMapping("/posts/delete/{id}")
    public String deletePost(@PathVariable long id) {
        return "posts/index";
    }


    @GetMapping("/posts/create")
    @ResponseBody
    public String create() {
        return "view the form for creating a post";
    }

//    @RequestMapping(path = "/posts/create", method = RequestMethod.POST)
//    @ResponseBody
//    public String postBlog() {
//        return "create a new post";
//    }

    @PostMapping("/posts/create")
    @ResponseBody
    public String insert(){
        return "post has been created";
    }

    //Edit your PostController class to return the views you created above.
    //
    //Inside the method that shows an individual post, create a new post object and pass it to the view.
    //Inside the method that shows all the posts, create a new array list and add two post objects to it, then pass that list to the view.
    //In these two pages, you should display information based on the data passed from the controller.

//    @PostMapping("/index")
//    @ResponseBody
//    public String all() {
//        return "all posts page";
//    }
//
//    @GetMapping("/posts/show")
//    @ResponseBody
//    public String all() {
//        return "all posts page";
//    }

}
