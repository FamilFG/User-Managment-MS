package com.usermanagment.user_managment_ms.dto.req;

import com.usermanagment.user_managment_ms.utils.UserRole;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;

import java.time.Instant;

@Builder
public record UserRequestDto(@NotBlank(message = "Name cant be null!") String reqName,
                             String surname,
                             @NotBlank(message = "userName cant be null!")
                             String userName,
                             String email,
                             @NotBlank(message = "password cant be null!")
                             String password,
                             UserRole role,
                             String phoneNumber,
                             Instant birthDate


) {
}
