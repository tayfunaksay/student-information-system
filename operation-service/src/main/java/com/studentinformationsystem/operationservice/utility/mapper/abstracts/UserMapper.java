package com.studentinformationsystem.operationservice.utility.mapper.abstracts;

import com.studentinformationsystem.operationservice.dto.user.CreateUserRequest;
import com.studentinformationsystem.operationservice.dto.user.UpdateUserRequest;
import com.studentinformationsystem.operationservice.dto.user.UserDto;
import com.studentinformationsystem.operationservice.model.User;

import java.util.List;

public interface UserMapper {
    UserDto toUserDto(User from);
    List<UserDto> toUserDtoList (List<User> from);
    User toUser(CreateUserRequest request);
    User toUser(UpdateUserRequest request);

}
