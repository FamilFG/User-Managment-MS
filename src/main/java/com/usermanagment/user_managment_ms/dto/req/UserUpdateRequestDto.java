package com.usermanagment.user_managment_ms.dto.req;

import com.usermanagment.user_managment_ms.utils.UserRole;
import lombok.Builder;

import java.time.Instant;
@Builder
public record UserUpdateRequestDto(
        String name,
        String surname,
        String email,
        String password,
        UserRole role,
        String phoneNumber,
        Instant birthDate

) {
}
