package com.codeup.springblog.repositories;

import com.codeup.springblog.models.Ad;
import com.codeup.springblog.models.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PostRepository extends JpaRepository<Post,Long> {

    //use dependency inj to forward on
    //refactor the controller
//    @Query(nativeQuery = true, value = "SELECT title from ads where length(title) < 10")
//    List<Post> findAllByOrderByIdDesc();

    @Query(nativeQuery = true, value = "select title from posts where length(title) < 10")
    List<Post> findAllByOrderByIdDesc();

    //for search feat later:
    Post findByTitle(String title);
}
