package com.usermanagment.user_managment_ms.service;

import com.usermanagment.user_managment_ms.dto.req.UserRequestDto;
import com.usermanagment.user_managment_ms.dto.res.UserResponseDto;
import com.usermanagment.user_managment_ms.entity.UserEntity;

import java.util.List;

public interface UserService {

    UserResponseDto createUser(UserRequestDto userRequestDto);
    List<UserResponseDto> allStudents();
    UserResponseDto deleteUser(Integer id);

}
