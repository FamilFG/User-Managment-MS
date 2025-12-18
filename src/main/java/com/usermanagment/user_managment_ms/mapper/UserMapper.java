package com.usermanagment.user_managment_ms.mapper;

import com.usermanagment.user_managment_ms.dto.req.UserRequestDto;
import com.usermanagment.user_managment_ms.dto.res.UserResponseDto;
import com.usermanagment.user_managment_ms.entity.UserEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {


    UserEntity mapRequestDtoToEntity(UserRequestDto userRequestDto);
    UserResponseDto mapUserResponseToEntity(UserEntity userEntity);

}
