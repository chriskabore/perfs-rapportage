package com.kirasoft.perfs.users.services;

import com.kirasoft.perfs.users.model.Role;

import java.util.List;
import java.util.Optional;

public interface RoleService {
    Role saveRole(Role role);
    Optional<Role> getRoleById(Long Id);
    List<Role> getAllRoles();
    Role updateRole(Role role);
    void deleteRole(Long Id);
}
