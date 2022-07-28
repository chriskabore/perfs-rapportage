package com.kirasoft.perfs.users.services.impl;

import com.kirasoft.perfs.users.model.ContactInformation;
import com.kirasoft.perfs.users.services.ContactInformationService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * ContactInformationServiceImpl -- Class used to implement ContactInformation Service methods
 * @author Sidnooma Christian KABORE
 */
@Service
public class ContactInformationServiceImpl implements ContactInformationService {
    @Override
    public ContactInformation saveContactInformation(ContactInformation contactInformation) {
        return null;
    }

    @Override
    public Optional<ContactInformation> getContactInformationById(Long Id) {
        return Optional.empty();
    }

    @Override
    public List<ContactInformation> getAllContactInformations() {
        return null;
    }

    @Override
    public ContactInformation updateContactInformation(ContactInformation contactInformation) {
        return null;
    }

    @Override
    public void deleteContactInformation(Long Id) {

    }
}
