package com.kirasoft.perfs.users.services;

import com.kirasoft.perfs.users.model.AddressInformation;

import java.util.List;
import java.util.Optional;


public interface AddressInformationService {

    AddressInformation saveAddressInformation (AddressInformation addressInformation);
    Optional<AddressInformation> getAddressInformationById(Long Id);
    List<AddressInformation> getAllAddressInformations();
    AddressInformation updateAddressInformation(AddressInformation addressInformation);
    void deleteAddressInformation(Long Id);

}
