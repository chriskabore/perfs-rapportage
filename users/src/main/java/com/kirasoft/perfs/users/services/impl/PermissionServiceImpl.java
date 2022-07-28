package com.kirasoft.perfs.users.services.impl;

import com.kirasoft.perfs.users.model.Permission;
import com.kirasoft.perfs.users.services.PermissionService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * PermissionServiceImpl -- Class used to implement Permission Service methods
 * @author Sidnooma Christian KABORE
 */
@Service
public class PermissionServiceImpl implements PermissionService {
    @Override
    public Permission savePermission(Permission permission) {
        return null;
    }

    @Override
    public Optional<Permission> getPermissionById(Long Id) {
        return Optional.empty();
    }

    @Override
    public List<Permission> getAllPermissions() {
        return null;
    }

    @Override
    public Permission updatePermission(Permission permission) {
        return null;
    }

    @Override
    public void deletePermission() {

    }
}
