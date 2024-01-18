package com.example.tododemo.controllers;

import com.example.tododemo.dto.request.RequestUserDto;
import com.example.tododemo.dto.response.ResponseUserDto;
import com.example.tododemo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController()
@RequestMapping("/api/v1/user")
public class UserController {
    private final UserService userServices;

    @Autowired
    public UserController(UserService userServices) {
        this.userServices = userServices;
    }

    @PostMapping("/create")
    ResponseEntity<String> createUser(@RequestBody RequestUserDto requestUserDto){
        String response = userServices.insertUser(requestUserDto);
        if(response.contains("success")){
            return ResponseEntity.status(HttpStatus.CREATED).body(response);
        }else{
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }
    }

    @GetMapping
    ResponseEntity<List<ResponseUserDto>> findAllUsers(){
        List<ResponseUserDto> response = userServices.getAllUsers();
        if(response.isEmpty()){
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(response);
        }else{
            return ResponseEntity.status(HttpStatus.OK).body(response);
        }
    }

    @GetMapping("/{userId}")
    ResponseEntity<ResponseUserDto> findUser(@PathVariable UUID userId){
        ResponseUserDto response = userServices.getUserById(userId);
        if(response == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        else{
            return ResponseEntity.status(HttpStatus.FOUND).body(response);
        }
    }
}
