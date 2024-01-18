package com.example.tododemo.dto.request;

import java.util.List;
import java.util.UUID;

public class RequestNoteDto {
    private UUID id;
    private List<String> categories;
    private String description;
    private Boolean active;
    private Boolean archive;
    private UUID userId;

    public RequestNoteDto(UUID id, List<String> categories, String description, Boolean isActive, Boolean isArchive, UUID userId) {
        this.id = id;
        this.categories = categories;
        this.description = description;
        this.active = isActive;
        this.archive = isArchive;
        this.userId = userId;
    }

    public RequestNoteDto() {
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

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Boolean getArchive() {
        return archive;
    }

    public void setArchive(Boolean archive) {
        this.archive = archive;
    }

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "RequestNoteDto{" +
                "id=" + id +
                ", categories=" + categories +
                ", description='" + description + '\'' +
                ", isActive=" + active +
                ", isArchive=" + archive +
                ", userId=" + userId +
                '}';
    }
}
