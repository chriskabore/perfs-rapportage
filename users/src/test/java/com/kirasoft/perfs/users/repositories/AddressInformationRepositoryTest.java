package com.kirasoft.perfs.users.repositories;


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

    @Test
    public void testContextLoads (){
        assertNotNull(addressInformationRepository);
    }

    public void testStoreAddressInformation(){


    }
}
