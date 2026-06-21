package com.exemplo.user.mapper;

import com.exemplo.user.domain.UserModel;
import com.exemplo.user.dto.request.UserRequest;
import com.exemplo.user.dto.response.UserResponse;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public static UserModel toUser(UserRequest userRequest){
        return UserModel.builder()
                .name(userRequest.name())
                .email(userRequest.email())
                .build();
    }

    public static UserResponse toUserResponse(UserModel userModel){
        return UserResponse.builder()
                .userId(userModel.getUserId())
                .name(userModel.getName())
                .email(userModel.getEmail())
                .build();
    }
}
