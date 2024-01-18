package com.example.tododemo.services.impl;

import com.example.tododemo.domain.Note;
import com.example.tododemo.domain.User;
import com.example.tododemo.dto.request.RequestUserDto;
import com.example.tododemo.dto.response.ResponseNoteDto;
import com.example.tododemo.dto.response.ResponseUserDto;
import com.example.tododemo.repository.UserRepository;
import com.example.tododemo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.OptimisticLockingFailureException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public String insertUser(RequestUserDto requestUserDto) {
       try{
           User newUser = mapResponseUserDtoToUser(requestUserDto);
           userRepository.save(newUser);
           return "User added with success";
       }catch(IllegalArgumentException | OptimisticLockingFailureException e){
           return "Error inserting user: " + e.getMessage();
       }
    }

    @Override
    public List<ResponseUserDto> getAllUsers() {
        List<User> allUsers = userRepository.findAll();
        return allUsers.stream()
                .map(this::mapUsersToResponseUserDto)
                .collect(Collectors.toList());
    }

    @Override
    public ResponseUserDto getUserById(java.util.UUID userid) {
        Optional<User> usersOptional = userRepository.findById(userid);
        if(usersOptional.isPresent()){
            User user = usersOptional.get();
            return detailMapUsersToResponseUserDto(user);
        }
        else{
            return null;
        }
    }

    private User mapResponseUserDtoToUser(RequestUserDto dto){
        User user = new User();
        user.setUserName(dto.getUserName());
        user.setPassword(dto.getPassword());
        return user;
    }

    private ResponseUserDto mapUsersToResponseUserDto(User user){
        ResponseUserDto userDto = new ResponseUserDto();
        userDto.setUserName(user.getUserName());
        userDto.setPassword(user.getPassword());
        return userDto;
    }

    private ResponseUserDto detailMapUsersToResponseUserDto(User user){
        ResponseUserDto responseUserDto = new ResponseUserDto();
        responseUserDto.setUserName(user.getUserName());
        responseUserDto.setPassword(user.getPassword());
        List<ResponseNoteDto> responseNoteDto = user.getNotes().stream()
                .map(this::mapNotesToResponseNoteDto)
                .toList();
        responseUserDto.setNotes(responseNoteDto);
        return responseUserDto;
    }

    private ResponseNoteDto mapNotesToResponseNoteDto(Note notes){
        ResponseNoteDto dto = new ResponseNoteDto();
        dto.setDescription(notes.getDescription());
        dto.setCategories(notes.getCategories());
        dto.setActive(notes.getIsActive());
        dto.setArchive(notes.getIsArchive());
        dto.setId(notes.getId());
        return dto;
    }
}
