package com.kirasoft.perfs.users.services.impl;

import com.kirasoft.perfs.users.model.Role;
import com.kirasoft.perfs.users.services.RoleService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * RoleServiceImpl -- Class used to implement Role Service methods
 * @author Sidnooma Christian KABORE
 */
@Service
public class RoleServiceImpl implements RoleService {
    @Override
    public Role saveRole(Role role) {
        return null;
    }

    @Override
    public Optional<Role> getRoleById(Long Id) {
        return Optional.empty();
    }

    @Override
    public List<Role> getAllRoles() {
        return null;
    }

    @Override
    public Role updateRole(Role role) {
        return null;
    }

    @Override
    public void deleteRole(Long Id) {

    }
}
