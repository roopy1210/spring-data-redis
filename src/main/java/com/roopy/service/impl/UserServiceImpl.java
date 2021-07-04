package com.roopy.service.impl;

import com.roopy.exception.UserExistException;
import com.roopy.exception.UserNotFoundException;
import com.roopy.model.User;
import com.roopy.repository.UserRepository;
import com.roopy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User save(User user) throws UserExistException {

        Optional<User> registeredUser = userRepository.findUserByUserId(user.getUserId());
        if (registeredUser.isPresent()) {
            throw new UserExistException("[" + user.getUserId() + "] 등록된 사용자 입니다.");
        }

        return userRepository.save(user);
    }

    @Override
    public User update(User user) throws UserNotFoundException {
        Optional<User> registeredUser = Optional.ofNullable(userRepository.findUserByUserId(user.getUserId())
                .orElseThrow(() -> new UserNotFoundException("사용자 정보가 존재하지 않습니다.")));

        if (registeredUser.isPresent()) {
            user = userRepository.save(user);
        }

        return user;
    }

    @Override
    public User findUserByUserId(String userId) throws  UserNotFoundException {
        Optional<User> user = Optional.ofNullable(userRepository.findUserByUserId(userId)
                        .orElseThrow(() -> new UserNotFoundException("사용자 정보가 존재하지 않습니다.")));

        return user.get();
    }

    @Override
    public User findById(Long id) throws UserNotFoundException {
        Optional<User> user = Optional.ofNullable(userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("사용자 정보가 존재하지 않습니다.")));

        return user.get();
    }

    @Override
    public void remove(Long id) {
        Optional<User> user = Optional.ofNullable(userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("사용자 정보가 존재하지 않습니다.")));

        userRepository.delete(user.get());
    }
}
