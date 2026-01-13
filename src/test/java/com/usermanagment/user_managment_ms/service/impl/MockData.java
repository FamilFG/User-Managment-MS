package com.usermanagment.user_managment_ms.service.impl;

import com.usermanagment.user_managment_ms.dto.req.UserRequestDto;
import com.usermanagment.user_managment_ms.dto.res.UserResponseDto;
import com.usermanagment.user_managment_ms.entity.UserEntity;
import com.usermanagment.user_managment_ms.utils.UserRole;

public class MockData {
    public static UserRequestDto userRequestDto() {
        return UserRequestDto.builder()
                .reqName("Will")
                .surname("Smith")
                .userName("will_smith")
                .email("will@test.com")
                .password("123333")
                .role(UserRole.USER)
                .build();
    }


    public static UserEntity userEntity() {
        return UserEntity.builder()
                .name("Will")
                .surname("Smith")
                .userName("will_smith")
                .email("will@test.com")
                .password("encoded")
                .role(UserRole.USER)
                .build();
    }


    public static UserResponseDto userResponseDto(){
        return UserResponseDto.builder()
                .email("test")
                .userName("test")
                .build();
    }

}
