package com.kirasoft.perfs.users.repositories;


import com.kirasoft.perfs.users.model.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;


/**
 * UserRepositoryTest -- Test class used to test UserRepository
 * @author Sidnooma Christian KABORE
 */
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class UserRepositoryTest {

    @Autowired
    private PermissionRepository permissionRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ContactInformationRepository contactInformationRepository;
    @Autowired
    private AddressInformationRepository addressInformationRepository;

    /**
     * This method tests that context loads successfully
     */
    @Test
    public void shouldLoadContext(){
        assertThat(permissionRepository).isNotNull();
        assertThat(roleRepository).isNotNull();
        assertThat(userRepository).isNotNull();
        assertThat(contactInformationRepository).isNotNull();
        assertThat(addressInformationRepository).isNotNull();
    }

    /**
     * This method tests that UserRepository returns an empty list of Users
     * If there is nos User stored into the database
     */
    @Test
    public void shouldFindNoUserIfRepositoryIsEmpty(){
        Iterable users = userRepository.findAll();
        assertThat(users).isEmpty();

    }

    /**
     * This method tests that a User entity is successfully store into the database
     */
    @Test
    public void shouldStoreAUser(){
        Permission testPermission = new Permission();
        testPermission.setPermissionName("CAN_VIEW_DASHBOARD");
        testPermission.setEnabled(true);
        testPermission.setDescription("Can view dashboard");
        Permission savedPermission = permissionRepository.save(testPermission);
        HashSet<Permission> permissions = new HashSet<>();
        permissions.add(savedPermission);
        Role testRole = new Role();
        testRole.setPermissions(permissions);
        testRole.setRoleName("ADMINISTRATOR");
        testRole.setDescription("Adminsitrator role");
        Role savedRole = roleRepository.save(testRole);

        User testUser = new User();
        testUser.setUsername("chriskabor");
        testUser.setLastName("KABORE");
        testUser.setFirstName("Sidnooma Christian");
        User savedUser = userRepository.save(testUser);
        Set roleUsers = new HashSet();
        roleUsers.add(testUser);
        testRole.setUsers(roleUsers);

        AddressInformation testAddressInfo = new AddressInformation();

        testAddressInfo.setAddress("Rue 17.409, porte 289, secteur 26, Pissy");
        testAddressInfo.setPostAddress("s/c 11 BP 550 Ouagadougou 11 ");
        testAddressInfo.setZipCode("11BP550");
        testAddressInfo.setCity("Ouagadougou");
        testAddressInfo.setCountry("Burkina Faso");
        testAddressInfo.setDescription("dummy address");

        testAddressInfo.setUser(savedUser);
        testAddressInfo.setUserId(savedUser.getUserId());

        AddressInformation savedAddressInfo = addressInformationRepository.save(testAddressInfo);

        ContactInformation testContactInformation = new ContactInformation();
        testContactInformation.setUser(savedUser);
        testContactInformation.setUserId(savedUser.getUserId());
        testContactInformation.setDescription("Dummy contact information");
        testContactInformation.setWebsite("www.christiankabore.me");
        testContactInformation.setEmail("chriskabor@gmail.com");
        testContactInformation.setHomePhone("+22625000000");
        testContactInformation.setHomePhone("+22670000000");
        testContactInformation.setFacebook("facebook/chriskabor");
        testContactInformation.setFacebook("linkedin/chriskabor");
        testContactInformation.setFacebook("chriskabor");
        ContactInformation savedContactInformation = contactInformationRepository.save(testContactInformation);

        assertThat(savedUser).isNotNull();
        assertThat(savedUser.getFirstName()).isEqualTo("Sidnooma Christian");
    }

}
