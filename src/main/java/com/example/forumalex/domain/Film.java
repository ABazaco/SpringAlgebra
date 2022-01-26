package com.example.forumalex.domain;

import javax.persistence.*;

@Entity
@Table(name = "Film")
public class Film {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "title")
    private String title;

    @Column(name = "rating")
    private int rating;

    @Column(name = "watched")
    private boolean watched;

    @Column(name = "comments")
    private String comments;

    public Film(String title, int rating, boolean watched, String comments) {
        this.title = title;
        this.rating = rating;
        this.watched = watched;
        this.comments = comments;
    }

    public Film() {
    }

    public String getTitle() {
        return title;
    }

    public int getRating() {
        return rating;
    }

    public boolean isWatched() {
        return watched;
    }

    public String getComments() {
        return comments;
    }

    public int getId() {
        return id;
    }


    public void setTitle(String title) {
        this.title = title;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public void setWatched(boolean watched) {
        this.watched = watched;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }
}
