package com.kirasoft.perfs.users.repositories;


import com.kirasoft.perfs.users.model.AddressInformation;
import com.kirasoft.perfs.users.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;


import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;


/**
 * AddressInformationRepositoryTest -- Test Class used to test AdddressInformation Repository
 * @author Sidnooma Christian KABORE
 */

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class AddressInformationRepositoryTest {



    @Autowired
    private AddressInformationRepository addressInformationRepository;

    @Autowired
    private UserRepository userRepository;

    /**
     *  This method tests that the context is loaded successfully
     */
    @Test
    public void shouldLoadContext (){
        assertNotNull(addressInformationRepository);
    }


    /**
     * This method tests that the repository returns an empty list of AddressInformation objects
     * if there is no AddressInformation Object stored in the database
     */
    @Test
    public void shouldFindNoAddressInformationIfRepositoryIsEmpty(){
        Iterable addressInformations = addressInformationRepository.findAll();
        assertThat(addressInformations).isEmpty();
    }

    /**
     * This method tests that an AdressInformation entity is successfully saved into the database
     */
    @Test
    public void shouldStoreAnAddressInformation(){
        AddressInformation testAddressInfo = new AddressInformation();

        testAddressInfo.setAddress("Rue 17.409, porte 289, secteur 26, Pissy");
        testAddressInfo.setPostAddress("s/c 11 BP 550 Ouagadougou 11 ");
        testAddressInfo.setZipCode("11BP550");
        testAddressInfo.setCity("Ouagadougou");
        testAddressInfo.setCountry("Burkina Faso");
        testAddressInfo.setDescription("dummy address");
        User testUser = new User();
        testUser.setUsername("chriskabor@gmail.com");
        testUser = userRepository.save(testUser);
        testAddressInfo.setUser(testUser);
        testAddressInfo.setUserId(testUser.getUserId());

        assertNotNull(addressInformationRepository);

        AddressInformation savedAddressInfo = addressInformationRepository.save(testAddressInfo);
        assertThat(savedAddressInfo).isNotNull();
        assertThat(savedAddressInfo.getUserId()).isEqualTo(testUser.getUserId());

    }
}
