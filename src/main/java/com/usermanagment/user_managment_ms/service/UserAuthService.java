package com.usermanagment.user_managment_ms.service;

import com.usermanagment.user_managment_ms.dto.req.LoginRequest;
import com.usermanagment.user_managment_ms.dto.res.AuthResponse;

public interface UserAuthService {
    AuthResponse login(LoginRequest loginRequest);
}
