package com.example.Task_3.models;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Comment {

    private String text;
    private String date;

    public Comment(String text, String date) {
        this.text = text;
        this.date = date;
    }

}
