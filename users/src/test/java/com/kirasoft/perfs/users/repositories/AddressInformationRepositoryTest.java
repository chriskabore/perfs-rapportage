package com.kirasoft.perfs.users.repositories;


import com.kirasoft.perfs.users.model.AddressInformation;
import com.kirasoft.perfs.users.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;


import static org.junit.jupiter.api.Assertions.assertNotNull;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class AddressInformationRepositoryTest {



    @Autowired
    private AddressInformationRepository addressInformationRepository;

    @Autowired
    private UserRepository userRepository;

    @Test
    public void testContextLoads (){
        assertNotNull(addressInformationRepository);
    }

    @Test
    public void testStoreAddressInformation(){
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
        assertNotNull(savedAddressInfo);
        //assertEquals(10L,savedAddressInfo.getUserId());


    }
}
