package com.usermanagment.user_managment_ms.service.impl;

import com.usermanagment.user_managment_ms.dto.req.UserRequestDto;
import com.usermanagment.user_managment_ms.dto.res.UserResponseDto;
import com.usermanagment.user_managment_ms.entity.UserEntity;
import com.usermanagment.user_managment_ms.mapper.UserMapper;
import com.usermanagment.user_managment_ms.repository.UserRepository;
import com.usermanagment.user_managment_ms.service.UserService;
import jakarta.transaction.Transactional;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    UserRepository userRepository;
    UserMapper userMapper;


    @Override
    public UserResponseDto createUser(UserRequestDto userRequestDto) {

        UserEntity userEntity = userMapper.mapRequestDtoToEntity(userRequestDto);
        userRepository.save(userEntity);
        return userMapper.mapUserResponseToEntity(userEntity);

    }

    @Override
    public List<UserResponseDto> allStudents() {
        List<UserEntity> users = userRepository.findAll();
        List<UserResponseDto> userResponses = new ArrayList<>();
        for (UserEntity user : users) {
            userResponses.add(userMapper.mapUserResponseToEntity(user));
        }
        return userResponses;
    }

    @Override
    @Transactional
    public void deleteUser(String userName) {
        UserEntity user = userRepository.findByUserName(userName);
        if (user == null) {
            throw new RuntimeException("User not found");
        }
        userRepository.deleteByUserName(userName);
    }




}