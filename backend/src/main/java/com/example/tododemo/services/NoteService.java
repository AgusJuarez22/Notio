package com.example.tododemo.services;

import com.example.tododemo.dto.request.RequestNoteDto;

import java.util.UUID;

public interface NoteService {
    String insertNote(RequestNoteDto noteDto);
    String update(RequestNoteDto requestNoteDto);

    String delete(UUID noteId);
}
