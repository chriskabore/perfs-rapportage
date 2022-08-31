package com.kirasoft.perfs.users.services;

import com.kirasoft.perfs.users.dtos.CreateOrUpdateUserDTO;
import com.kirasoft.perfs.users.model.User;

import java.util.List;

public interface UserService {
    User saveUser(User user);
    User getUserById(Long Id);
    List<User> getAllUsers();
    User updateUser(Long userId, CreateOrUpdateUserDTO user);
    void deleteUser(Long Id);
}
