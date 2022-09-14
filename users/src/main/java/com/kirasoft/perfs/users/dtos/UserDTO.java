package com.kirasoft.perfs.users.dtos;

import com.kirasoft.perfs.users.model.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * UserDTO - Class used to model transfer data for the user entity
 * @author Sidnooma Christian KABORE
 *
 */
@Data
public class UserDTO implements Serializable {

    private Long userId;
    private String username;
    private String password;

    private String firstName;
    private String lastName;
    private String gender;
    private java.time.LocalDate birthDate;
    private LocalDateTime dateCreated;
    private LocalDateTime dateUpdated;
    private LocalDateTime dateOfLastLogin;


    private boolean enabled;
    private boolean secured;

    private String description;

    private AddressInformationDTO addressInformation;
    private ContactInformationDTO contactInformation;


    private List<String> roles = new ArrayList<>();
    private List<String> permissions = new ArrayList<>();

    public UserDTO(){
        roles = new ArrayList<>();
        permissions = new ArrayList<>();
    }

    public UserDTO (User user){
        if(user !=null){
            this.userId = user.getUserId();
            this.username = user.getUsername();
            this.firstName = user.getFirstName();
            this.lastName = user.getLastName();
            this.password = user.getPassword();
            this.description = user.getDescription();
            this.enabled = user.isEnabled();
            this.secured = user.isSecured();
            this.birthDate = user.getDateOfBirth();
            this.dateCreated = user.getDateCreated();
            this.dateUpdated = user.getDateUpdated();
            this.dateOfLastLogin = user.getDateOfLastLogin();

            // contact if any contact information is set
            if(user.getContactInformation()!=null){
                this.contactInformation = new ContactInformationDTO(user.getContactInformation());
            }

            // address if any address information is set
            if(user.getAddressInformation()!=null){
                this.addressInformation = new AddressInformationDTO(user.getAddressInformation());
            }

           // get all assigned roles
            for (Role role: user.getRoles()) {
                roles.add(role.getRoleName());
            }

            // get all active permissions
            for (Permission p:user.getActivePermissions()) {
                permissions.add(p.getPermissionName());
            }

        }
    }
}
