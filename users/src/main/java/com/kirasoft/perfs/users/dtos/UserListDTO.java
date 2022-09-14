package com.kirasoft.perfs.users.dtos;

import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * UserList - Class used to model transfer data for lists of users
 * @author Sidnooma Christian KABORE
 */
@Data
public class UserListDTO implements Serializable {

    private List<UserDTO> userList;

    public UserListDTO(){
        userList = new ArrayList<>();
    }
}
