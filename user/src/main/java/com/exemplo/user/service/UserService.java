package com.exemplo.user.service;

import com.exemplo.user.domain.UserModel;
import com.exemplo.user.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    @Transactional
    public UserModel save(UserModel userModel){
        return userRepository.save(userModel);
    }

    public List<UserModel> getAll(){
        return userRepository.findAll();
    }
}
