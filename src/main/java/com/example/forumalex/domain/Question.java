package com.example.forumalex.domain;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    @NotEmpty(message = "The title has not been entered")
    @Size(min = 2, max = 60, message = "The name should be between 2 and 60 characters long")
    private String title;


    @NotEmpty(message = "The content of the body has not been entered")
    @Size(min = 2, max = 400, message = "The name should be between 2 and 400 characters long")
    private String body;


    public Question() {

    }
    public Question(int id, String title, String body) {
        this.id = id;
        this.title = title;
        this.body = body;
    }


    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setBody(String body) {
        this.body = body;
    }


}
