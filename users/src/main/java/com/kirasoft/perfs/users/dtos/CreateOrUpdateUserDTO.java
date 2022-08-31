package com.kirasoft.perfs.users.dtos;

import lombok.*;

import java.io.Serializable;

/**
 * CreateOrUpdateUserDTO -- Class used to model transfer data when creating or
 * updating a user
 * @author Sidnooma Christian KABORE
 */
@Data
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateOrUpdateUserDTO implements Serializable {

    private String username;
    private String password;

    private String firstName;
    private String lastName;
    private String gender;
    private java.time.LocalDate birthDate;

    private boolean enabled;
    private boolean secured;

    private String description;

    // contact information
    private String email;
    private String homePhone;
    private String workPhone;
    private String skype;
    private String facebook;
    private String linkedin;
    private String website;
    private String contactNote;

    // address information
    private String address;
    private String postAddress;
    private String city;
    private String country;
    private String zipCode;
}
