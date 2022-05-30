package com.nhnacademy.security.service.impl;

import com.nhnacademy.security.entity.User;
import com.nhnacademy.security.repository.UserRepository;
import com.nhnacademy.security.service.UserService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public boolean matches(String userId, String userPwd) {
        Optional<User> user = userRepository.findById(userId);

        // user에 값이 있으면서, pwd가 일치하면 true
        return user.isPresent() && user.get().getPwd().equals(userPwd);
    }
}
