package com.codeup.springblog.models;


import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "tags")
public class Tag {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    public Tag() {
    }

    //other side is simpler
    @ManyToMany(mappedBy = "tags")
    @JsonBackReference
    private List<Ad> ads;

}
