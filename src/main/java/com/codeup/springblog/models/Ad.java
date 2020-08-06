package com.codeup.springblog.models;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "ads")
public class Ad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String title;
    private String description;



    public Ad() {
    }

    public Ad(long id, String title, String description) {
        this.id = id;
        this.title = title;
        this.description = description;
    }

    public Ad(String title, String description) {
        this.title = title;
        this.description = description;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @OneToMany(mappedBy = "parentAd")
    //this annote it to keep json from constantly building
    @JsonManagedReference
    private List<Comment> comments;
    public List<Comment> getComments() {
        return comments;
    }

    //owning side of tag rel
    @ManyToMany(cascade = CascadeType.ALL)
        //cascade gets tricky w delete, could delete a tag and end up deleteing the ad, or deleting all tags to other ads or somehting
        //NOTE, delete is a very low feature, high cost low return
    @JsonManagedReference
    @JoinTable(
            name = "ad_tag",
            joinColumns = {@JoinColumn(name = "ad_id")},
            //order matters here
            inverseJoinColumns = {@JoinColumn(name = "tag_id")}
    )
    private List<Tag> tags;

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }
}
