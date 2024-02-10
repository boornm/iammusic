package com.company.models;

public class User {
    private int id;
    private String name;
    private String song;
    private String date;

    public User() {

    }

    public User(String name, String surname, String gender) {
        setName(name);
        setSong(surname);
        setDate(date);
    }

    public User(int id, String name, String song, String date) {
        this(name, song, date);
        setId(id);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSong() {
        return song;
    }

    public void setSong(String song) {
        this.song = song;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
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
