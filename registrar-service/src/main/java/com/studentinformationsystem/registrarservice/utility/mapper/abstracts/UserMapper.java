package com.studentinformationsystem.registrarservice.utility.mapper.abstracts;

import com.studentinformationsystem.registrarservice.dto.instructor.InstructorDto;
import com.studentinformationsystem.registrarservice.dto.staff.StaffDto;
import com.studentinformationsystem.registrarservice.dto.student.StudentDto;
import com.studentinformationsystem.registrarservice.dto.user.CreateUserRequest;
import com.studentinformationsystem.registrarservice.dto.user.UpdateUserRequest;
import com.studentinformationsystem.registrarservice.dto.user.UserDto;
import com.studentinformationsystem.registrarservice.model.User;

import java.util.List;

public interface UserMapper {
    UserDto toUserDto(User from);
    List<UserDto> toUserDtoList (List<User> from);
    User toUser(CreateUserRequest request);
    User toUser(UpdateUserRequest request);
    CreateUserRequest toCreateUserRequest (StudentDto createdStudentDto);
    CreateUserRequest toCreateUserRequest (InstructorDto createdInstructorDto);
    CreateUserRequest toCreateUserRequest (StaffDto createdStaffDto);

}
