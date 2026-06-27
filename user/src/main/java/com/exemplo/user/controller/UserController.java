package com.exemplo.user.controller;

import com.exemplo.user.dto.request.UserRequest;
import com.exemplo.user.dto.response.UserResponse;
import com.exemplo.user.mapper.UserMapper;
import com.exemplo.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping()
    public ResponseEntity<UserResponse> save(@RequestBody UserRequest userRequest){
        return ResponseEntity.status(HttpStatus.CREATED).body(UserMapper.toUserResponse(userService.save(UserMapper.toUser(userRequest))));
    }

    @GetMapping()
    public ResponseEntity<List<UserResponse>> getAll(){
        return ResponseEntity.ok().body(userService.getAll().stream().map(UserMapper::toUserResponse).toList());
    }
}
