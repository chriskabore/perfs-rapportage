package com.kirasoft.perfs.users.repositories;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

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
}
