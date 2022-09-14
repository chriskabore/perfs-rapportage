package com.kirasoft.perfs.users.dtos;

import com.kirasoft.perfs.users.model.User;
import lombok.Data;
import lombok.NoArgsConstructor;

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

    public UserListDTO(List<User> listOfUsers){
        if(listOfUsers!=null){
            userList = new ArrayList<>();
            listOfUsers.forEach(user -> userList.add(new UserDTO(user)));
        }
    }
}
