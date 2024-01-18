package com.example.tododemo.domain;

import jakarta.persistence.*;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private UUID userId;
    private String userName;
    private String password;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Note> notes;

    public User() {
    }

    public User(java.util.UUID id, String userName, String password, List<Note> notes) {
        this.userId = id;
        this.userName = userName;
        this.password = password;
        this.notes = notes;
    }

    public java.util.UUID getUserId() {
        return userId;
    }

    public void setUserId(java.util.UUID userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Note> getNotes() {
        return notes;
    }

    public void setNotes(List<Note> notes) {
        this.notes = notes;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + userId +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", notes=" + notes +
                '}';
    }
}
