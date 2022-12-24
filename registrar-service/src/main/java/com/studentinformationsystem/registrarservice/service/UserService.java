package com.studentinformationsystem.registrarservice.service;

import com.studentinformationsystem.registrarservice.dto.user.CreateUserRequest;
import com.studentinformationsystem.registrarservice.dto.user.UpdateUserRequest;
import com.studentinformationsystem.registrarservice.dto.user.UserDto;

import java.util.List;

public interface UserService {
    UserDto create (CreateUserRequest request);
    void delete (String userId);
    UserDto update (UpdateUserRequest request);
    List<UserDto> getAll();
    List<UserDto> getAllNotSentUserToAuthServer();
    UserDto getById(String userId);
}
