package com.kirasoft.perfs.users.repositories;

import com.kirasoft.perfs.users.model.Permission;
import com.kirasoft.perfs.users.model.Role;
import com.kirasoft.perfs.users.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * RoleRepositoryTest -- Test class used to test Role repository
 * @author Sidnooma Christian KABORE
 */
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class RoleRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PermissionRepository permissionRepository;

    @Autowired
    private RoleRepository roleRepository;


    /**
     * This method tests that the context loads successfully
     */
    @Test
    public void shouldLoadContext(){
        assertThat(userRepository).isNotNull();
        assertThat(permissionRepository).isNotNull();
        assertThat(roleRepository).isNotNull();
    }

    /**
     * This method tests that RoleRepository returns an empty list of roles if
     * no role is stored into the database
     */
    @Test
    public void shouldFindNoRoleIfRepositoryIsEmpty(){
        Iterable roles = roleRepository.findAll();
        assertThat(roles).isEmpty();
    }

    /**
     * This method tests that a user entity is successfully stored into the database
     */
    @Test
    public void shouldStoreARole(){
        Role testRole = new Role();
        testRole.setDescription("Dummy role");
        testRole.setRoleName("ADMINISTRATOR");

        User testUser = new User();
        testUser.setUsername("chriskabor");
        testUser.setLastName("KABORE");
        testUser.setFirstName("Sidnooma Christian");

        User savedUser = userRepository.save(testUser);
        Set roleUsers = new HashSet();
        roleUsers.add(testUser);
        testRole.setUsers(roleUsers);

        Permission testPermission = new Permission();
        testPermission.setPermissionName("CAN_VIEW_DASHBOARD");
        testPermission.setDescription("Can view dashboard");
        testPermission.setEnabled(true);
        Permission savedPermission = permissionRepository.save(testPermission);
        Set rolePermissions = new HashSet();
        rolePermissions.add(savedPermission);
        testRole.setPermissions(rolePermissions);
        Role savedRole = roleRepository.save(testRole);

        assertThat(savedRole).isNotNull();
        assertThat(savedRole.getRoleId()).isGreaterThan(0L);
        assertThat(savedRole.getPermissions().size()).isEqualTo(rolePermissions.size());
    }
}
