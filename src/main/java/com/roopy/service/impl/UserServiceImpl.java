package com.roopy.service.impl;

import com.roopy.model.User;
import com.roopy.repository.UserRepository;
import com.roopy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public User findUserByUserId(String userId) {
        return userRepository.findUserByUserId(userId);
    }

    @Override
    public void remove(User user) {
        userRepository.delete(user);
    }
}
