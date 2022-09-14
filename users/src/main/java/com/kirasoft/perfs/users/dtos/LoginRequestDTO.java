package com.kirasoft.perfs.users.dtos;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * LoginRequestDTO - Class used to model login request data
 * @author Sidnooma Christian KABORE
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginRequestDTO implements Serializable {
    private String username;
    private String password;
}
