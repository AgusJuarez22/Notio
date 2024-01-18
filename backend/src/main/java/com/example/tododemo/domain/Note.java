package com.example.tododemo.domain;

import jakarta.persistence.*;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "notes")
public class Note {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private List<String> categories;
    private String description;
    private Boolean isActive = true;
    private Boolean isArchive = false;

    @ManyToOne
    @JoinColumn(name = "posted_by")
    private User user;

    public Note() {
    }

    public Note(UUID id, List<String> categories, String description, Boolean isActive, Boolean isArchive, User userId) {
        this.id = id;
        this.categories = categories;
        this.description = description;
        this.isActive = isActive;
        this.isArchive = isArchive;
        this.user = userId;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public List<String> getCategories() {
        return categories;
    }

    public void setCategories(List<String> categories) {
        this.categories = categories;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    public Boolean getIsArchive() {
        return isArchive;
    }

    public void setIsArchive(Boolean isArchive) {
        this.isArchive = isArchive;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User userId) {
        this.user = userId;
    }

    @Override
    public String toString() {
        return "Note{" +
                "id=" + id +
                ", categories=" + categories +
                ", description='" + description + '\'' +
                ", isActive=" + isActive +
                ", isArchive=" + isArchive +
                ", user=" + user +
                '}';
    }
}