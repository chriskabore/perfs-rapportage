package com.kirasoft.perfs.users.services;

import com.kirasoft.perfs.users.model.ContactInformation;

import java.util.List;
import java.util.Optional;

public interface ContactInformationService {
    ContactInformation saveContactInformation(ContactInformation contactInformation);
    Optional<ContactInformation> getContactInformationById(Long Id);
    List<ContactInformation> getAllContactInformations();
    ContactInformation updateContactInformation(ContactInformation contactInformation);
    void deleteContactInformation(Long Id);
}
