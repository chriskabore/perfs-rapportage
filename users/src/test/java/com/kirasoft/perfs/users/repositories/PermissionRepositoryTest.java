package com.kirasoft.perfs.users.repositories;

import com.kirasoft.perfs.users.model.Permission;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;


import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 *  PermissionRepositoryTest -- Test class used to test permission repository
 * @author Sidnooma Christian KABORE
 */
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class PermissionRepositoryTest {

    @Autowired
    private PermissionRepository permissionRepository;

    /**
     * This method tests that test context is loaded successfully
     */
    @Test
    public void shouldLoadContext(){
        assertNotNull(permissionRepository);
    }

    /**
     * This method tests that repository returns an empty list of permissions if there is no
     * permission stored in the database
     */
    @Test
    public void shouldFindNoPermissionIfRepositoryIsEmpty(){
        Iterable permissions = permissionRepository.findAll();
        assertThat(permissions).isEmpty();
    }

    /**
     * This method tests that a permission entity is successfully saved to database
     */
    @Test
    public void shouldStoreAPermission(){
        Permission testPerm = new Permission();
        testPerm.setPermissionId(1L);
        testPerm.setPermissionName("DUMMY_ACTION");
        testPerm.setEnabled(true);
        testPerm.setDescription("dummy permission");
         Permission savedPerm =permissionRepository.save(testPerm);
        assertNotNull(savedPerm);
        assertEquals(1L, savedPerm.getPermissionId());

    }

}
