package com.codeup.springblog;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class PostController {

    @GetMapping("/posts")
    @ResponseBody
    public String index() {
        return "posts index page";
    }

    @GetMapping("/posts/{id}")
    @ResponseBody
    public String show(@PathVariable long id) {
        return "view an individual post: " + id;
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
}
