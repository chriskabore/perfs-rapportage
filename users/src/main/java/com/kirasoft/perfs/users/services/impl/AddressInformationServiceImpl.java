package com.kirasoft.perfs.users.services.impl;

import com.kirasoft.perfs.users.model.AddressInformation;
import com.kirasoft.perfs.users.services.AddressInformationService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * AddressInformationServiceImpl -- class used to implement AddressInformation Service methods
 * @author Sidnooma Christian KABORE
 */
@Service
public class AddressInformationServiceImpl implements AddressInformationService {
    @Override
    public AddressInformation saveAddressInformation(AddressInformation addressInformation) {
        return null;
    }

    @Override
    public Optional<AddressInformation> getAddressInformationById(Long Id) {
        return Optional.empty();
    }

    @Override
    public List<AddressInformation> getAllAddressInformations() {
        return null;
    }

    @Override
    public AddressInformation updateAddressInformation(AddressInformation addressInformation) {
        return null;
    }

    @Override
    public void deleteAddressInformation(Long Id) {

    }
}
