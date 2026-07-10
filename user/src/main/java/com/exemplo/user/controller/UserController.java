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
import java.util.UUID;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping()
    public ResponseEntity<UserResponse> save(@RequestBody UserRequest userRequest){
        return ResponseEntity.status(HttpStatus.CREATED).body(UserMapper.toUserResponse(userService.saveAndPublish(UserMapper.toUser(userRequest))));
    }

    @GetMapping()
    public ResponseEntity<List<UserResponse>> getAll(){
        return ResponseEntity.ok().body(userService.getAll().stream().map(UserMapper::toUserResponse).toList());
    }

    @GetMapping("/{userId}")
    public ResponseEntity<UserResponse> getUserById(@PathVariable UUID userId){
        return ResponseEntity.ok().body(UserMapper.toUserResponse(userService.getUserById(userId).orElseThrow()));
    }

    @PutMapping("/{userId}")
    public ResponseEntity<UserResponse> updateUserById(@PathVariable UUID userId, @RequestBody UserRequest userRequest){
        return userService.updateById(userId, UserMapper.toUser(userRequest)).map(userModel -> ResponseEntity.ok().body(UserMapper.toUserResponse(userModel)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<Void> deleteUserById(@PathVariable UUID userId){
        userService.deleteById(userId);
        return ResponseEntity.noContent().build();
    }
}
