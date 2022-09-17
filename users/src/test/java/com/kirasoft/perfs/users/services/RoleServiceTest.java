package com.kirasoft.perfs.users.services;

import com.kirasoft.perfs.users.repositories.PermissionRepository;
import com.kirasoft.perfs.users.repositories.RoleRepository;
import com.kirasoft.perfs.users.services.impl.UserServiceImpl;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;


/**
 * RoleServiceTest -- Class used to test Role Service class
 * @author Sidnoma Christian KABORE
 */
@ExtendWith(MockitoExtension.class)
public class RoleServiceTest {

    @Mock
    private RoleRepository roleRepository;

    @Mock
    private PermissionRepository permissionRepository;

    @Autowired
    @InjectMocks
    private RoleService roleService;





}
