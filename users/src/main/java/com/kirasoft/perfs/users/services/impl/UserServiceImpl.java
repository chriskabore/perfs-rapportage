package com.kirasoft.perfs.users.services.impl;

import com.kirasoft.perfs.users.model.User;
import com.kirasoft.perfs.users.services.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 *  UserServiceImpl -- Class used to implement User Service methods
 * @author Sidnooma Christian KABORE
 */
@Service
public class UserServiceImpl implements UserService {
    @Override
    public User saveUser(User user) {
        return null;
    }

    @Override
    public Optional<User> getUserById(Long Id) {
        return Optional.empty();
    }

    @Override
    public List<User> getAllUsers() {
        return null;
    }

    @Override
    public User updateUser(User user) {
        return null;
    }

    @Override
    public void deleteUser(Long Id) {

    }
}
