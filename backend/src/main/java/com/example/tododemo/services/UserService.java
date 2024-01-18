package com.example.tododemo.services;

import com.example.tododemo.dto.request.RequestUserDto;
import com.example.tododemo.dto.response.ResponseUserDto;

import java.util.List;
import java.util.UUID;

public interface UserService {
    String insertUser(RequestUserDto requestUserDto);
    List<ResponseUserDto> getAllUsers();
    ResponseUserDto getUserById(UUID userid);
}
