package com.softwaredevblog.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 */
@Entity
public class Movie {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    private String director;
    private String title;

    // Default constructor required by JPA
    public Movie() {
    }

    public Movie(String title,String director) {
        this.title = title;
        this.director = director;
    }

    public Integer getId() {
        return id;
    }

    public String getDirector() {
        return director;
    }

    public String getTitle() {
        return title;
    }
}
