package com.example.servletstudy.login;

import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;  //필수 (final)

    public List<User> getAll() {
        return userRepository.findByAll();
    }
}
