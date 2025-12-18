package com.usermanagment.user_managment_ms.dto.req;

import com.usermanagment.user_managment_ms.utils.UserRole;
import lombok.Builder;

import java.time.Instant;

@Builder
public record UserRequestDto(String name,
                             String surname,
                             String userName,
                             String email,
                             String password,
                             UserRole role,
                             String phoneNumber,
                             Instant birthDate

) {
}
