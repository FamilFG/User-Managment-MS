package com.usermanagment.user_managment_ms.service.impl;

import com.usermanagment.user_managment_ms.config.PasswordEncoderConfig;
import com.usermanagment.user_managment_ms.dto.req.UserRequestDto;
import com.usermanagment.user_managment_ms.dto.res.UserResponseDto;
import com.usermanagment.user_managment_ms.entity.UserEntity;
import com.usermanagment.user_managment_ms.mapper.UserMapper;
import com.usermanagment.user_managment_ms.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Spy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.mockito.Mockito.*;

@SpringBootTest(classes = {UserRepository.class,
        UserMapper.class,
        PasswordEncoderConfig.class, UserServiceImpl.class
})
class UserServiceImplTest {

    @MockBean
    UserRepository userRepository;
    @MockBean
    UserMapper userMapper;
    @Spy
    PasswordEncoderConfig passwordEncoderConfig;

    @Autowired
    UserServiceImpl userService;

    UserRequestDto userRequestDto;

    UserEntity userEntity;

    UserResponseDto userResponseDto;

    @BeforeEach
    void setUp() {

        userRequestDto = MockData.userRequestDto();
        userEntity = MockData.userEntity();
        userResponseDto = MockData.userResponseDto();
    }

    @Test
    void testWhenUserIsCreated() {

        when(userRepository.existsByUserName(any())).thenReturn(false);
        when(userMapper.mapRequestDtoToEntity(userRequestDto)).thenReturn(userEntity);
        when(userMapper.mapUserResponseToEntity(userEntity)).thenReturn(userResponseDto);

        userService.createUser(userRequestDto);

        verify(userRepository).existsByUserName(userRequestDto.userName());
        verify(userMapper).mapRequestDtoToEntity(userRequestDto);
        verify(userRepository).save(userEntity);
        verify(userMapper).mapUserResponseToEntity(userEntity);
    }


}