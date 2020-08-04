package com.codeup.springblog.repositories;


import com.codeup.springblog.models.Ad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AdRepository extends JpaRepository<Ad, Long> {
    // Ad is the reference type of the entity to CRUD
    // long is the ref type for the primary key of Ad
    // now for concept:  ______
        // after adding Ad controller for url testing getting data from ad table

    //LEVEL 1
    //from curric: derived from jpa query builder, baked in JpaRepository
    Ad findByTitle(String title);
        //should be able just to put in string to find a title
    //add another getmapping in ctrler to enact

    //LEVEL 2
    //combine the right allowable terms:
    Ad findDistinctFirstByTitleAsc();

    //LEVEL 3
    //custom using query annotation
    // exs using JPQL(mainly) / HQL ('a' is a name of ad object)
//    @Query("from Ad a where a.id like ?1")
//    Ad getAdBy(long id);
//
//    @Query("select title from Ad where LENGTH(title) < 10")
//    List<String> getAdsOfCertainTitleLength();

    //using native query which is: _____________ research
    //@Query(nativeQuery = true, value + "select title from ads where LENGTH(title) < 10")
    //List<String> getAdsOfCertainTitleLengthNative();

    //LEVEL 1: first you have baked in meths
    //LEVEL 2: then you can combo the right terms to get what you need
    //LEVEL 3: then you can @Query any java and sql
}
