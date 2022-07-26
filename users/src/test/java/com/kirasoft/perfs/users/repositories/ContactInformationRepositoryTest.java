package com.kirasoft.perfs.users.repositories;


import com.kirasoft.perfs.users.model.ContactInformation;
import com.kirasoft.perfs.users.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * ContactInformationRepositoryTest -- Test Class used to test ContactInformation repository
 * @author Sidnooma Christian KABORE
 */
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class ContactInformationRepositoryTest {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ContactInformationRepository contactInformationRepository;

    /**
     * This method tests that the context loads successfully
     */
    @Test
    public void shouldLoadContext(){
        assertNotNull(userRepository);
        assertNotNull(contactInformationRepository);
    }

    /**
     * This method tests that an empty list of ContactInformation objects is returned by repository if
     * no ContactInformation object is stored in database
     */
    @Test
    public void shouldFindNoContactInformationIfRepositoryIsEmpty(){
        Iterable contactInformations = contactInformationRepository.findAll();
        assertThat(contactInformations).isEmpty();
    }


    /**
     * This method tests that a ContactInformation entity is successfully saved into the database
     */
    @Test
    public void shouldStoreAContactInformation(){

        User testUser = new User();
        testUser.setUsername("chriskabor@gmail.com");
        testUser = userRepository.save(testUser);
        ContactInformation testContactInformation = new ContactInformation();
        testContactInformation.setUser(testUser);
        testContactInformation.setUserId(testUser.getUserId());
        testContactInformation.setDescription("Dummy contact information");
        testContactInformation.setWebsite("www.christiankabore.me");
        testContactInformation.setEmail("chriskabor@gmail.com");
        testContactInformation.setHomePhone("+22625000000");
        testContactInformation.setHomePhone("+22670000000");
        testContactInformation.setFacebook("facebook/chriskabor");
        testContactInformation.setFacebook("linkedin/chriskabor");
        testContactInformation.setFacebook("chriskabor");
        ContactInformation savedContactInformation = contactInformationRepository.save(testContactInformation);
        assertThat(savedContactInformation).isNotNull();
        assertThat(savedContactInformation.getUserId()).isEqualTo(testUser.getUserId());

    }


}
