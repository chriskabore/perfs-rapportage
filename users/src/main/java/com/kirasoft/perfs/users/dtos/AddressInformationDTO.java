package com.kirasoft.perfs.users.dtos;

import com.kirasoft.perfs.users.model.AddressInformation;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * AddressInformationDTO - Class used to model transfer data for address information
 * @author Sidnooma Christian KABORE
 */
@Data
@NoArgsConstructor
public class AddressInformationDTO implements Serializable {

    private Long userId;
    private String address;
    private String postAddress;
    private String city;
    private String country;
    private String zipCode;
    private String description;


    public AddressInformationDTO(AddressInformation addressInformation) {
        if(addressInformation!=null){
            this.userId = addressInformation.getUserId();
            this.postAddress = addressInformation.getPostAddress();
            this.city = addressInformation.getCity();
            this.country = addressInformation.getCountry();
            this.zipCode = addressInformation.getZipCode();
            this.description = addressInformation.getDescription();
        }
    }
}
