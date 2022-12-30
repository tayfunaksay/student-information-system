package com.studentinformationsystem.operationservice.utility.mapper.concretes;

import com.studentinformationsystem.operationservice.dto.user.CreateUserRequest;
import com.studentinformationsystem.operationservice.dto.user.UpdateUserRequest;
import com.studentinformationsystem.operationservice.dto.user.UserDto;
import com.studentinformationsystem.operationservice.model.User;
import com.studentinformationsystem.operationservice.utility.mailGenerator.EducationalMailGenerator;
import com.studentinformationsystem.operationservice.utility.mapper.abstracts.UserMapper;
import com.studentinformationsystem.operationservice.utility.passwordGenerator.FirstPasswordGenerator;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserConverter implements UserMapper {

    @Override
    public UserDto toUserDto(User from) {
        return UserDto.builder()
                .id(from.getId())
                .educationalEmail(from.getEducationalEmail())
                .userRole(from.getUserRole())
                .isSentToAuthServer(from.isSentToAuthServer())
                .build();
    }

    @Override
    public List<UserDto> toUserDtoList(List<User> from) {
        return from.stream()
                .map(user -> toUserDto(user))
                .collect(Collectors.toList());
    }

    @Override
    public User toUser(CreateUserRequest request) {
        return User.builder()
                .id(request.getId())
                .firstPassword(FirstPasswordGenerator.generate())
                .educationalEmail(EducationalMailGenerator.generate(request.getFirstName(),request.getLastName()))
                .userRole(request.getUserRole())
                .build();
    }

    @Override
    public User toUser(UpdateUserRequest request) {
        return User.builder()
                .id(request.getId())
                .userRole(request.getUserRole())
                .build();
    }


}
