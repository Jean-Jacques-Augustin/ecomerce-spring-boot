package com.me.forum.model;


import javax.persistence.*;


@Entity
@Table

public class User {
    @Id
    @SequenceGenerator(name = "user", sequenceName = "user_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_sequence")
    private Long Id;
    private String username;
    private String password;
    private String email;
    private String name;
    private String city;
    private String type;

    public User() {
    }

    public User (Long Id, String username, String password, String email, String name, String city, String type) {
        this.Id = Id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.name = name;
        this.city = city;
        this.type = type;
    }

    public User(String username, String password, String email, String name, String city, String type) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.name = name;
        this.city = city;
        this.type = type;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "User{" +
                "Id=" + Id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", name='" + name + '\'' +
                ", city='" + city + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
