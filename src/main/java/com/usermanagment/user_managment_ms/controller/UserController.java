package com.usermanagment.user_managment_ms.controller;

import com.usermanagment.user_managment_ms.dto.SuccessDto;
import com.usermanagment.user_managment_ms.dto.req.UserRequestDto;
import com.usermanagment.user_managment_ms.dto.res.UserResponseDto;
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

    @PostMapping("/add-users")
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

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<SuccessDto<UserResponseDto>> deleteUser(@PathVariable Integer id) {
        userService.deleteUser(id);
        SuccessDto<UserResponseDto> successDto = new SuccessDto<>(SUCCESS, null);
        return new ResponseEntity<>(successDto, HttpStatus.OK);
    }

    @PutMapping("/put")
}
