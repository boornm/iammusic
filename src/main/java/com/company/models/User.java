package com.company.models;

import lombok.*;

@Getter
@AllArgsConstructor
@Setter
@NoArgsConstructor
public class User {
    private int id;
    private String name;
    private String song;
    private String date;

    public User (String name, String song, String date){
        this.name = name;
        this.song = song;
        this.date = date;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", song name='" + song + '\'' +
                ", release date=" + (date + "\'") +
                '}';
    }
}
