package com.kirasoft.perfs.users.dtos;

import com.kirasoft.perfs.users.model.ContactInformation;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * ContactInformationDTO - Class used to model transfer data of Contact information
 * @author Sidnooma Christian KABORE
 */
@Data
@NoArgsConstructor
public class ContactInformationDTO implements Serializable {

    private Long userId;
    private String email;
    private String homePhone;
    private String workPhone;
    private String skype;
    private String facebook;
    private String linkedIn;
    private String website;
    private String description;



    public ContactInformationDTO(ContactInformation contactInformation) {
        if(contactInformation!= null){
           this.userId = contactInformation.getUserId();
           this.email = contactInformation.getEmail();
           this.homePhone = contactInformation.getHomePhone();
           this.skype = contactInformation.getSkype();
           this.facebook = contactInformation.getFacebook();
           this.linkedIn = contactInformation.getLinkedIn();
           this.website = contactInformation.getWebsite();
           this.description = contactInformation.getDescription();

        }
    }
}
