package com.kirasoft.perfs.users.model;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class UnitTests {

    @Test
    public void checkThatConstructorsAndGettersAndSettersWork(){

        // user constructor

        User chris = new User();
        chris.setUserId(1L);
        chris.setFirstName("Sidnooma Christian");
        chris.setLastName("KABORE");
        chris.setUsername("chriskabor");
        chris.setDescription("Utilisateur test");
        chris.setGender(Gender.MALE);
        chris.setEnabled(true);
        chris.setSecured(false);

        // Contact Information constructor
        ContactInformation contactInfoChris = new ContactInformation();
        contactInfoChris.setEmail("chriskabor@kirasoft.com");
        contactInfoChris.setHomePhone("+22670000000");
        contactInfoChris.setWorkPhone("+22625000000");
        contactInfoChris.setFacebook("facebook/chriskabor");
        contactInfoChris.setFacebook("facebook/chriskabor");
        contactInfoChris.setLinkedIn("linkedIn/chriskabor");
        contactInfoChris.setSkype("chriskabor");
        contactInfoChris.setWebsite("www.christiankabore.me");
        contactInfoChris.setDescription("Test contact information for chris");

        chris.setContactInformation(contactInfoChris);

        // Address Information constructor
        AddressInformation addressInfoChris = new AddressInformation();
        addressInfoChris.setAddress("Rue 17.406, Porte 289,Pissy, Secteur 26");
        addressInfoChris.setPostAddress("s/c 11 BP 004 Ouagadougou 11");
        addressInfoChris.setZipCode("11BP004");
        addressInfoChris.setCity("Ouagadougou");
        addressInfoChris.setCountry("Burkina Faso");

        chris.setAddressInformation(addressInfoChris);

        // Dates
        LocalDate dateOfBirth = LocalDate.of(1985,12,8);
        LocalDateTime dateCreated = LocalDateTime.of(2022,1,24,13,45);
        LocalDateTime dateUpdated = LocalDateTime.of(2022,3,24,15,55);
        LocalDateTime dateOfLastLogin = LocalDateTime.of(2022,5,31,12,55);
        chris.setDateCreated(dateCreated);
        chris.setDateOfBirth(dateOfBirth);
        chris.setDateUpdated(dateUpdated);
        chris.setDateOfLastLogin(dateOfLastLogin);

        // Role constructor
        Role roleUser = new Role("USER");
        Role roleAdmin = new Role ("ADMINISTRATOR");

        // Permissions constructor
        Permission canLogin = new Permission(100L,"CAN_LOGIN",
                true,"Can login");
        Permission viewProfile = new Permission(101L,"VIEW_PROFILE",
                true,"Can view profile");
        Permission statisticsManagement = new Permission(100L,"ADMIN_STATISTICS",
                true,"Can manage statistics");
        Permission profilesManagement = new Permission(100L,"MANAGE_PROFILES",
                true,"Can manage profiles");

        roleUser.getPermissions().add(canLogin);
        roleUser.getPermissions().add(viewProfile);

        roleAdmin.getPermissions().add(statisticsManagement);
        roleAdmin.getPermissions().add(profilesManagement);

        chris.addRole(roleUser);
        chris.addRole(roleAdmin);

        /* begining tests for getters and setters */
        // Testing User entity
        assertEquals(chris.getUserId(), 1L);
        assertEquals(chris.getUsername(), "chriskabor");
        assertTrue(chris.isEnabled());
        assertFalse(chris.isSecured());

        // Testing dates
        assertEquals(dateCreated, chris.getDateCreated());
        assertEquals(dateUpdated, chris.getDateUpdated());
        assertEquals(dateOfLastLogin, chris.getDateOfLastLogin());
        assertEquals(dateOfBirth, chris.getDateOfBirth());

        //  Testing Contact Info
        ContactInformation actualContactInfo = chris.getContactInformation();
        assertNotNull(actualContactInfo);
        assertEquals(actualContactInfo.getEmail(), "chriskabor@kirasoft.com");

        // Testing Address Info
        AddressInformation actualAddressInfo = chris.getAddressInformation();
        assertNotNull(actualAddressInfo);
        assertEquals(actualAddressInfo.getCity(), "Ouagadougou");

        // Testing Role entity
        Set<Role> actualRoles = chris.getRoles();
        assertNotNull(actualRoles);
        assertEquals(2, actualRoles.size());
        assertTrue(actualRoles.contains(roleUser));
        assertTrue(actualRoles.contains(roleAdmin));

        // Testing permission entity
        List<Permission> actualPermissions = chris.getPermissions();
        assertNotNull(actualPermissions);
        assertEquals(4, actualPermissions.size());
        assertTrue(actualPermissions.contains(viewProfile));
        assertTrue(actualPermissions.contains(statisticsManagement));

    }
}
