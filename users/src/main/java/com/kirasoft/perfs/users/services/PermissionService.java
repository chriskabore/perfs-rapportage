package com.kirasoft.perfs.users.services;

import com.kirasoft.perfs.users.model.Permission;

import java.util.List;
import java.util.Optional;

public interface PermissionService {
    Permission savePermission(Permission permission);
    Optional<Permission> getPermissionById(Long Id);
    List<Permission> getAllPermissions();
    Permission updatePermission(Permission permission);
    void deletePermission();

}
