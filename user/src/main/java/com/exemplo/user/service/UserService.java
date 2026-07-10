package com.exemplo.user.service;

import com.exemplo.user.domain.UserModel;
import com.exemplo.user.exception.EmailAlreadyUsedException;
import com.exemplo.user.exception.UserNotFoundException;
import com.exemplo.user.producer.UserProducer;
import com.exemplo.user.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final UserProducer userProducer;

    @Transactional
    public UserModel saveAndPublish(UserModel userModel){
        if (userRepository.existsByEmail(userModel.getEmail())) {
            throw new EmailAlreadyUsedException(userModel.getEmail());
        }
        userModel = userRepository.save(userModel);
        userProducer.publishEvent(userModel);
        return userModel;
    }

    public List<UserModel> getAll(){
        return userRepository.findAll();
    }

    public Optional<UserModel> getUserById(UUID userId){
        return Optional.of(userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException(userId.toString())));
    }

    @Transactional
    public Optional<UserModel> updateById(UUID userId, UserModel userModelUpdate) {
        return userRepository.findById(userId).map(user -> {
            if (!user.getEmail().equals(userModelUpdate.getEmail()) && userRepository.existsByEmail(userModelUpdate.getEmail())) {
                throw new EmailAlreadyUsedException(userModelUpdate.getEmail());
            }
            user.setName(userModelUpdate.getName());
            user.setEmail(userModelUpdate.getEmail());
            userRepository.save(user);
            userProducer.publishEvent(user);
            return user;
        });
    }

    public void deleteById(UUID userId){
        UserModel user = userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException(userId.toString()));
        userRepository.delete(user);
    }

}
