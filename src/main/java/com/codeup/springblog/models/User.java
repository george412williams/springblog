package com.codeup.springblog.models;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(length = 20, nullable = false, unique = true)
    private String username;

    @Column(length = 100, nullable = false, unique = true)
    private String email;

    @Column(length = 50, nullable = false, unique = true)
    private String password;


    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
//    @JsonManagedReference
    private List<Post> posts;

    public List<Post> getPost() {
        return posts;
    }

    public void setPost(List<Post> posts) {
        this.posts = posts;
    }



    public User() {
    }

    //sec - takes in user obj and makes copy, frameworks often require copy, need a way to reference the properties of the object wo messing w it and maybe messing it up
        //don't want spring sec contract to amek any changes or manip it
        //if clone and made two, will still ahve the same object id in java, is manip'd inthe contract
        //contract, set of tasks that srpin sec need to perform in order to to its job, its set up to do list, uses the copy to do it
            //curric, copy constructor in authentication
    public User(User copy) {
        id = copy.id; // This line is SUPER important! Many things won't work if it's absent
        email = copy.email;
        username = copy.username;
        password = copy.password;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
