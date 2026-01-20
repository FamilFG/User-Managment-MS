package com.usermanagment.user_managment_ms.controller;

import com.usermanagment.user_managment_ms.dto.SuccessDto;
import com.usermanagment.user_managment_ms.dto.req.LoginRequest;
import com.usermanagment.user_managment_ms.dto.res.AuthResponse;
import com.usermanagment.user_managment_ms.service.UserAuthService;
import com.usermanagment.user_managment_ms.utils.Status;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final UserAuthService userAuthService;

    @PostMapping("/login")
    ResponseEntity<SuccessDto<AuthResponse>> login(@RequestBody LoginRequest loginRequest) {
        AuthResponse authResponse = userAuthService.login(loginRequest);
        SuccessDto successDto = new SuccessDto<>(Status.SUCCESS, authResponse);
        return new ResponseEntity<>(successDto, HttpStatus.OK);

    }

    }
