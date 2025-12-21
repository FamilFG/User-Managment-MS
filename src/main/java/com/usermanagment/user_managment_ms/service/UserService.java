package com.usermanagment.user_managment_ms.service;

import com.usermanagment.user_managment_ms.dto.req.UserRequestDto;
import com.usermanagment.user_managment_ms.dto.res.UserResponseDto;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface UserService {

    UserResponseDto createUser(UserRequestDto userRequestDto);
    List<UserResponseDto> allStudents();
    void deleteUser(String username);

}
