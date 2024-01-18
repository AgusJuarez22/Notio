package com.example.tododemo.controllers;

import com.example.tododemo.dto.request.RequestNoteDto;
import com.example.tododemo.services.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/note")
public class NoteController {

    private final NoteService noteService;

    @Autowired
    public NoteController(NoteService noteService) {
        this.noteService = noteService;
    }


    @PostMapping("/create")
    ResponseEntity<String> createNote(@RequestBody RequestNoteDto requestNoteDto){
        String response = noteService.insertNote(requestNoteDto);
        if(response.contains("successfully")){
            return ResponseEntity.status(HttpStatus.CREATED).body(response);
        }
        else return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }

    @PutMapping("/update")
    ResponseEntity<String> updateNote(@RequestBody RequestNoteDto requestNoteDto){
        String response = noteService.update(requestNoteDto);
        if(response.contains("successfully")){
            return ResponseEntity.status(HttpStatus.OK).body(response);
        }
        else{
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }
    }

    @DeleteMapping("/delete/{id}")
    ResponseEntity<String> deleteNote(@PathVariable UUID id){
        String response = noteService.delete(id);
        if(response.contains("successfully")){
            return ResponseEntity.status(HttpStatus.OK).body(response);
        }
        else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
    }
}
