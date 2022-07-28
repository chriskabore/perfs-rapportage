package com.kirasoft.perfs.users.services;

import com.kirasoft.perfs.users.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    User saveUser(User user);
    Optional<User> getUserById(Long Id);
    List<User> getAllUsers();
    User updateUser(User user);
    void deleteUser(Long Id);
}
