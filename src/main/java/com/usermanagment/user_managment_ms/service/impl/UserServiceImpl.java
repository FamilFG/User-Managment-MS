package com.usermanagment.user_managment_ms.service.impl;

import com.usermanagment.user_managment_ms.config.PasswordEncoderConfig;
import com.usermanagment.user_managment_ms.dto.req.UserRequestDto;
import com.usermanagment.user_managment_ms.dto.req.UserUpdateRequestDto;
import com.usermanagment.user_managment_ms.dto.res.UserResponseDto;
import com.usermanagment.user_managment_ms.dto.res.UserUpdateResponseDto;
import com.usermanagment.user_managment_ms.entity.UserEntity;
import com.usermanagment.user_managment_ms.exception.*;
import com.usermanagment.user_managment_ms.mapper.UserMapper;
import com.usermanagment.user_managment_ms.repository.UserRepository;
import com.usermanagment.user_managment_ms.service.UserService;
import jakarta.transaction.Transactional;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    UserRepository userRepository;
    UserMapper userMapper;
    PasswordEncoderConfig passwordEncoderConfig;



    @Override
    public UserResponseDto createUser(UserRequestDto userRequestDto) {
        if (userRepository.existsByUserName(userRequestDto.userName())) {
            throw new UserAlreadyExists("User already exists");
        }
        UserEntity userEntity = userMapper.mapRequestDtoToEntity(userRequestDto);
        userEntity.setPassword(passwordEncoderConfig.passwordEncoder()
                .encode(userRequestDto.password()));
        userRepository.save(userEntity);


        return userMapper.mapUserResponseToEntity(userEntity);

    }


    @Override
    public List<UserResponseDto> allUsers() {
        List<UserEntity> userEntities = userRepository.findAll();
        return userMapper.mapEntityListToResponseList(userEntities);

    }

    @Override
    @Transactional
    public void deleteUser(String userName) {
        UserEntity user = userRepository.findByUserName(userName);
        if (user == null) {
            throw new UserNotFoundException("User not found");
        }
        userRepository.deleteByUserName(userName);
    }

    @Override
    @Transactional
    public UserUpdateResponseDto updateUser(UserUpdateRequestDto userRequestDto, String username) {
        UserEntity userEntity = userRepository.findByUserName(username);
        if (userEntity == null) {
            throw new UserNotFoundException("User not found");
        }

        userEntity.setName(userRequestDto.name());
        userEntity.setSurname(userRequestDto.surname());
        userEntity.setEmail(userRequestDto.email());
        userEntity.setPassword(
                passwordEncoderConfig.passwordEncoder()
                        .encode(userRequestDto.password())
        );
        userEntity.setRole(userRequestDto.role());
        userEntity.setBirthDate(userRequestDto.birthDate());
        userEntity.setUpdatedAt(LocalDateTime.now());

        userRepository.save(userEntity);

        return UserUpdateResponseDto.builder()
                .name(userEntity.getName())
                .surname(userEntity.getSurname())
                .phoneNumber(userEntity.getPhoneNumber())
                .email(userEntity.getEmail())
                .birthDate(userEntity.getBirthDate())
                .role(userEntity.getRole())
                .build();
    }
    @Override
    public UserResponseDto getUserByUsername(String username) {
        UserEntity userEntity = userRepository.findByUserName(username);
        if (userEntity == null) {
            throw new UserNotFoundException("User not found with username: " + username);
        }
        return userMapper.mapUserResponseToEntity(userEntity);
    }

}
