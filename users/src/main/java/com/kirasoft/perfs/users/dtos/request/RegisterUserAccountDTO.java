package com.kirasoft.perfs.users.dtos.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 *  RegisterUserAccountDTO - Class used to model transfer data for user account registration
 * @author Sidnooma Christian KABORE
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterUserAccountDTO  implements Serializable {
    private String username;
    private String password;

    private String firstName;
    private String lastName;
    private String email;
    private String gender;
}
