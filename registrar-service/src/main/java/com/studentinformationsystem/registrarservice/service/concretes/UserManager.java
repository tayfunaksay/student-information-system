package com.studentinformationsystem.registrarservice.service.concretes;

import com.studentinformationsystem.registrarservice.dto.user.CreateUserRequest;
import com.studentinformationsystem.registrarservice.dto.user.UpdateUserRequest;
import com.studentinformationsystem.registrarservice.dto.user.UserDto;
import com.studentinformationsystem.registrarservice.exception.UserNotFoundException;
import com.studentinformationsystem.registrarservice.repository.UserRepository;
import com.studentinformationsystem.registrarservice.service.UserService;
import com.studentinformationsystem.registrarservice.utility.mapper.abstracts.UserMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserManager implements UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserManager(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @Override
    public UserDto create(CreateUserRequest request) {
        return userMapper.toUserDto(userRepository.save(userMapper.toUser(request)));
    }

    @Override
    public void delete(String userId) {
        userRepository.deleteById(userId);
    }

    @Override
    public UserDto update(UpdateUserRequest request) {
        if (userRepository.existsById(request.getId())) {
            throw new UserNotFoundException("User could not found by id: " + request.getId());
        } else {
            return userMapper.toUserDto(userRepository.save(userMapper.toUser(request)));
        }
    }

    @Override
    public List<UserDto> getAll() {
        return userMapper.toUserDtoList(userRepository.findAll());
    }

    @Override
    public List<UserDto> getAllNotSentUserToAuthServer() {
        return userMapper.toUserDtoList(userRepository.findAllNotSentUserToAuthServer());
    }

    @Override
    public UserDto getById(String userId) {
        return userMapper.toUserDto(userRepository.findById(userId)
                .orElseThrow(()-> new UserNotFoundException("User could not found by id: " + userId)));
    }
}
