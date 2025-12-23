package com.usermanagment.user_managment_ms.service;

import com.usermanagment.user_managment_ms.dto.req.UserRequestDto;
import com.usermanagment.user_managment_ms.dto.req.UserUpdateRequestDto;
import com.usermanagment.user_managment_ms.dto.res.UserResponseDto;
import com.usermanagment.user_managment_ms.dto.res.UserUpdateResponseDto;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface UserService {

    UserResponseDto createUser(UserRequestDto userRequestDto);
    List<UserResponseDto> allStudents();
    void deleteUser(String username);
    UserUpdateResponseDto updateUser(UserUpdateRequestDto userRequestDto, String userName);
}
