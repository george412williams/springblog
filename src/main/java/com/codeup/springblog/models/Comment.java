package com.codeup.springblog.models;


import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
@Table(name = "comments")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String content;

    //
    @ManyToOne
    @JoinColumn(name = "ad_id")
    //this annote is to keep json from contantly building, in curric append
    @JsonBackReference
    private Ad parentAd;

    public Ad getParentAd() {
        return parentAd;
    }

    public void setParentAd(Ad parentAd) {
        this.parentAd = parentAd;
    }

    public Comment() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
