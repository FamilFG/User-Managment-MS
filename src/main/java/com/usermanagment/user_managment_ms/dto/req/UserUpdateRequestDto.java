package com.usermanagment.user_managment_ms.dto.req;

import com.usermanagment.user_managment_ms.utils.UserRole;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Builder;

import java.time.Instant;
@Builder
public record UserUpdateRequestDto(
        @NotBlank(message = "name bos ola bilmez")
        String name,
        @Size(min = 3,max = 10,message = "qebul edilen olcuden az simvol yazilib!")
        String surname,
        String email,
        @Min(value = 8,message = "parola en az 8 simvol olmalidir!")
        String password,
        UserRole role,
        String phoneNumber,
        Instant birthDate


) {
}
