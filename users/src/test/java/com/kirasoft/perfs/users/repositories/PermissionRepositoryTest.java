package com.kirasoft.perfs.users.repositories;

import com.kirasoft.perfs.users.model.Permission;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;


import static org.junit.jupiter.api.Assertions.assertNotNull;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class PermissionRepositoryTest {

    @Autowired
    private PermissionRepository permissionRepository;

    @Test
    public void testContextLoads(){
        assertNotNull(permissionRepository);
    }

    @Test
    public void testStorePermission(){
        Permission testPerm = new Permission();
        testPerm.setPermissionId(1L);
        testPerm.setPermissionName("DUMMY_ACTION");
        testPerm.setEnabled(true);
        testPerm.setDescription("dummy permission");
         Permission savedPerm =permissionRepository.save(testPerm);
        assertNotNull(savedPerm);

    }

}
