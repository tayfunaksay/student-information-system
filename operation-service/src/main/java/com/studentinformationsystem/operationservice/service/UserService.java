package com.studentinformationsystem.operationservice.service;

import com.studentinformationsystem.operationservice.dto.user.CreateUserRequest;
import com.studentinformationsystem.operationservice.dto.user.UpdateUserRequest;
import com.studentinformationsystem.operationservice.dto.user.UserDto;

import java.util.List;

public interface UserService {
    UserDto create (CreateUserRequest request);
    void delete (String userId);
    UserDto update (UpdateUserRequest request);
    List<UserDto> getAll();
    List<UserDto> getAllNotSentUserToAuthServer();
    UserDto getById(String userId);
}
