package com.example.tododemo.dto.response;

import java.util.List;
import java.util.UUID;

public class ResponseNoteDto {
    private UUID id;
    private List<String> categories;
    private String description;
    private Boolean isActive;
    private Boolean isArchive;

    public ResponseNoteDto(List<String> categories, String description, Boolean isActive, Boolean isArchive, UUID noteId) {
        this.categories = categories;
        this.description = description;
        this.isActive = isActive;
        this.isArchive = isArchive;
        this.id = noteId;
    }

    public ResponseNoteDto() {
    }

    public List<String> getCategories() {
        return categories;
    }

    public void setCategories(List<String> categories) {
        this.categories = categories;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public Boolean getArchive() {
        return isArchive;
    }

    public void setArchive(Boolean archive) {
        isArchive = archive;
    }

    @Override
    public String toString() {
        return "ResponseNoteDto{" +
                "categories=" + categories +
                ", description='" + description + '\'' +
                ", isActive=" + isActive +
                ", isArchive=" + isArchive +
                '}';
    }
}
