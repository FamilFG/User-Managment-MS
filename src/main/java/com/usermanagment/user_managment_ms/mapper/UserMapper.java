package com.usermanagment.user_managment_ms.mapper;

import com.usermanagment.user_managment_ms.dto.req.UserRequestDto;
import com.usermanagment.user_managment_ms.dto.res.UserResponseDto;
import com.usermanagment.user_managment_ms.entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(source = "reqName", target = "name")
    UserEntity mapRequestDtoToEntity(UserRequestDto userRequestDto);
    UserResponseDto mapUserResponseToEntity(UserEntity userEntity);

    List<UserResponseDto> mapEntityListToResponseList(List<UserEntity> userEntities);
}
