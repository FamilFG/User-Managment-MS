package com.usermanagment.user_managment_ms.controller;

import com.usermanagment.user_managment_ms.dto.SuccessDto;
import com.usermanagment.user_managment_ms.dto.req.UserRequestDto;
import com.usermanagment.user_managment_ms.dto.req.UserUpdateRequestDto;
import com.usermanagment.user_managment_ms.dto.res.UserResponseDto;
import com.usermanagment.user_managment_ms.dto.res.UserUpdateResponseDto;
import com.usermanagment.user_managment_ms.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.usermanagment.user_managment_ms.utils.Status.SUCCESS;

@RestController
@RequestMapping("/v1")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/users")
    public ResponseEntity<SuccessDto<UserResponseDto>> createUsers(@RequestBody UserRequestDto userRequestDto) {

        UserResponseDto userResponseDto = userService.createUser(userRequestDto);
        SuccessDto<UserResponseDto> successDto = new SuccessDto<>(SUCCESS, userResponseDto);
        return new ResponseEntity<>(successDto, HttpStatus.CREATED);

    }
    @GetMapping("/users")
    public SuccessDto<List<UserResponseDto>> allStudents(@RequestBody UserRequestDto userRequestDto) {
        List<UserResponseDto> users = userService.allStudents();
        SuccessDto<List<UserResponseDto>> successDto = new SuccessDto<>(SUCCESS, users);
        return new ResponseEntity<>(successDto, HttpStatus.OK).getBody();
    }

    @DeleteMapping("/users/{userName}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUsers(@PathVariable String userName) {
        userService.deleteUser(userName);
    }

    @PutMapping("/user/{userName}")
    public ResponseEntity<SuccessDto<UserUpdateResponseDto>> updateUser(@PathVariable String userName, @RequestBody UserUpdateRequestDto userRequestDto) {
        UserUpdateResponseDto userResponseDto = userService.updateUser(userRequestDto, userName);

        SuccessDto<UserUpdateResponseDto> successDto = new SuccessDto<>(SUCCESS, userResponseDto);
        return new ResponseEntity<>(successDto, HttpStatus.CREATED);

    }



}
