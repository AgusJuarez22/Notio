package com.example.tododemo.services.impl;

import com.example.tododemo.domain.Note;
import com.example.tododemo.domain.User;
import com.example.tododemo.dto.request.RequestNoteDto;
import com.example.tododemo.repository.NoteRepository;
import com.example.tododemo.repository.UserRepository;
import com.example.tododemo.services.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.OptimisticLockingFailureException;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.UUID;
@Service
public class NoteServiceImpl implements NoteService {
    private final NoteRepository noteRepository;
    private final UserRepository userRepository;

    @Autowired
    public NoteServiceImpl(NoteRepository noteRepository, UserRepository userRepository) {
        this.noteRepository = noteRepository;
        this.userRepository = userRepository;
    }

    @Override
    public String insertNote(RequestNoteDto noteDto) {
        try{
            Optional<User> userOptional = userRepository.findById(noteDto.getUserId());
            User user = userOptional.orElseThrow();

            Note note = mapRequestNoteDtoToNoteINSERT(noteDto);
            note.setUser(user);
            noteRepository.save(note);
            return "note added successfully";
        }catch(IllegalArgumentException | NoSuchElementException e){
            return "Error:" + e.getMessage();
        }
    }

    @Override
    public String update(RequestNoteDto requestNoteDto) {
        try{
            Optional<Note> optionalNote = noteRepository.findById(requestNoteDto.getId());
            Note note = optionalNote.orElseThrow();
            note.setIsArchive(requestNoteDto.getArchive());
            note.setIsActive(requestNoteDto.getActive());
            note.setDescription(requestNoteDto.getDescription());
            note.setCategories(requestNoteDto.getCategories());
            noteRepository.save(note);

            return "note updated successfully";
        }catch (IllegalArgumentException | NoSuchElementException | OptimisticLockingFailureException e){
            return "Error: " + e.getMessage();
        }


    }

    @Override
    public String delete(UUID noteId) {
        try{
            noteRepository.deleteById(noteId);
            return "note deleted successfully";
        }catch (IllegalArgumentException e){
            return "Error: " + e.getMessage();
        }
    }


    private Note mapRequestNoteDtoToNoteINSERT(RequestNoteDto dto){
        Note note = new Note();
        note.setId(dto.getId());
        note.setCategories(dto.getCategories());
        note.setDescription(dto.getDescription());
        return note;
    }
}
