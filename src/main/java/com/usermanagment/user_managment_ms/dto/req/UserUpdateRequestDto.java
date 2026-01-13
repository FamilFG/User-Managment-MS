package com.usermanagment.user_managment_ms.dto.req;

import com.usermanagment.user_managment_ms.utils.UserRole;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Builder;

import java.time.Instant;
@Builder
public record UserUpdateRequestDto(
        @NotBlank(message = "Name cant be null")
        String name,
        @Size(min = 3,max = 10,message = "Too long/short!")
        String surname,
        String email,
        @Min(value = 8,message = "8 digits at least!")
        String password,
        UserRole role,
        String phoneNumber,
        Instant birthDate


) {
}
