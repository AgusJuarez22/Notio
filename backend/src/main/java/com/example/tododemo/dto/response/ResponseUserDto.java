package com.example.tododemo.dto.response;

import java.util.List;

public class ResponseUserDto {
    private String userName;
    private String password;
    private List<ResponseNoteDto> notes;

    public ResponseUserDto(String userName, String password, List<ResponseNoteDto> notes) {
        this.userName = userName;
        this.password = password;
        this.notes = notes;
    }

    public ResponseUserDto() {
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

    public List<ResponseNoteDto> getNotes() {
        return notes;
    }

    public void setNotes(List<ResponseNoteDto> notes) {
        this.notes = notes;
    }

    @Override
    public String toString() {
        return "ResponseUserDto{" +
                "userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", notes=" + notes +
                '}';
    }
}
