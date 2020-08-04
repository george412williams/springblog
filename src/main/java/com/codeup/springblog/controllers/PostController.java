package com.codeup.springblog.controllers;


import com.codeup.springblog.models.Post;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.codeup.springblog.repositories.PostRepository;

@Controller
public class PostController {

    //======== injection
    private final PostRepository postDao;

    public PostController(PostRepository postDao){
        this.postDao = postDao;
    }
    //======== end injection

    @GetMapping("/posts")
    public String index(Model model) {
        model.addAttribute("posts", postDao.findAll());
        return "posts/index";
        //simulated table items for testing prior to learning dependency injection
//        ArrayList<Post> myPosts = new ArrayList<>();
//        myPosts.add(new Post(2, "Blog2","Blog2 Text"));
//        myPosts.add(new Post(3, "Blog3","Blog2 Text"));
//        myPosts.add(new Post(4, "Blog4","Blog4 Text"));
    }

    @GetMapping("/posts/{id}")
    public String show(@PathVariable long id, Model model) {
//        Post myPost = new Post(id, "blog1", "Hey there");
//        model.addAttribute("title", myPost.getTitle());
//        model.addAttribute("body", myPost.getBody());
        return postDao.getOne(id).toString();
//        model.addAttribute("post", postDao.getOne(id));
//        return "posts/show";
    }

    // edit ================
    @PostMapping("/posts/edit/{id}")
    public String saveEdit(@PathVariable long id, @RequestParam(name = "title") String title, @RequestParam(name = "body") String body){
        Post postToUpdate = new Post();
        postToUpdate.setTitle(title);
        postDao.save(postToUpdate);
        return "redirect:posts/show";
//       return "posts/show";
//        return "posts/edit";
    }

    @GetMapping("/posts/edit")
    public String getEditPost(Model model){
        model.addAttribute("posts",postDao.findAll());
        return "/posts/edit";
    }

            //"/posts/edit/{id}"?
    @PostMapping("/posts/delete/{id}")
    public String delete(@PathVariable long id){
//        Post postToDelete = new Post();
//        postDao.delete(postToDelete);
        postDao.deleteById(id);
        return "redirect:posts/show";
    }

    @GetMapping("/posts/create")
    @ResponseBody
    public String create() {
        return "view the form for creating a post";
    }

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


}
