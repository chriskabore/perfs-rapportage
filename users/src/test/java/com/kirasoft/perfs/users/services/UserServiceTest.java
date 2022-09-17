package com.kirasoft.perfs.users.services;



import com.kirasoft.perfs.users.exceptions.UserNotFoundException;
import com.kirasoft.perfs.users.model.User;
import com.kirasoft.perfs.users.repositories.UserRepository;
import com.kirasoft.perfs.users.services.impl.UserServiceImpl;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

/**
 * UserServiceTest -- Class used to test User Service class
 * @author Sidnoma Christian KABORE
 */
@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @Mock
    private UserRepository userRepository;



    @Autowired
    @InjectMocks
    private UserServiceImpl userService;

    private User chris;
    private User jane;

    private List<User> usersList;

    @BeforeEach
    public void setUp(){
        usersList = new ArrayList<>();
        chris = new User();
        chris.setUserId(1L);
        chris.setFirstName("Sidnooma Christian");
        chris.setLastName("KABORE");
        chris.setUsername("chriskabor");
        jane = new User();
        jane.setUserId(2L);
        jane.setFirstName("Jane");
        jane.setLastName("Doe");
        jane.setUsername("janedoe");
        usersList.add(chris);
        usersList.add(jane);
    }



    @AfterEach
    public void tearDown(){
        usersList = null;
        chris = jane = null;
    }

    /**
     * This method tests that given a user to save the service returns
     * a valid saved user
     */
    @Test
    public void givenAUserToAddShouldReturnAddedUser(){

        // we stub our mocked object here
        when(userRepository.save(any())).thenReturn(chris);
        userService.saveUser(chris);
        verify(userRepository,times(1)).save(any());

    }

    /**
     * This methods test that the service returns the list of all users in the repository
     */
    @Test
    public void givenGetAllUsersShouldReturnAListOfAllUsers(){
        userRepository.save(chris);
        userRepository.save(jane);
        // We stub our mocked service
        when(userRepository.findAll()).thenReturn(usersList);
        List<User> usersListFromService = userService.getAllUsers();
        assertThat(usersList).isEqualTo(usersListFromService);
        verify(userRepository,times(1)).save(chris);
        verify(userRepository,times(1)).save(jane);
        verify(userRepository,times(1)).findAll();

    }

    /**
     * This method tests that given a user Id the service returns a user with that Id
     */
    @Test
    public void givenAUserIdShouldReturnAUserOfThatId(){
        // we stub our mocked service here
        when(userRepository.findById(1L)).thenReturn(Optional.ofNullable(chris));
        assertThat(userService.getUserById(chris.getUserId())).isEqualTo(chris);
    }

    /**
     * This method tests that given a user Id the service deletes the user with that Id
     */
    @Test
    public void givenAUserIdToDeleteShouldDeleteTheUserOfThatId(){
        // We stub the service here
        when(userRepository.findById(1L)).thenReturn(Optional.ofNullable(chris));
        userService.deleteUser(chris.getUserId());
        verify(userRepository, times(1)).deleteById(chris.getUserId());

    }

    /**
     * This method tests that given a user Id the service updates the user with the given ID
     */
    @Test
    public void givenAUserToUpdateShouldReturnUpdatedUserIfFound(){
        // we stub the service here
        when(userRepository.findById(1L)).thenReturn(Optional.ofNullable(chris));
        User userToUpdate = userRepository.findById(1L).get();
        String newFirstName = "Sid";
        String oldFirstName = userToUpdate.getFirstName();
        userToUpdate.setFirstName(newFirstName);
        userRepository.save(userToUpdate);
        verify(userRepository,times(1)).save(chris);

        assertThat(userService.getUserById(1L).getFirstName()).isEqualTo(newFirstName);
        assertThat(userService.getUserById(1L).getFirstName()).isNotEqualTo(oldFirstName);

    }

    /**
     * This method tests that given an invalid user Id the service
     * throws an exception when get user by Id
     */

    @Test
    public void givenANonExistingUserShouldThrowExceptionWhenGetUserById(){
        Long testUserId = 3L;
        given(userRepository.findById(testUserId)).willReturn(Optional.empty());
        Assertions.assertThrows(UserNotFoundException.class, () -> {
            userService.getUserById(testUserId);
        });

    }



    /**
     * This method tests that given an invalid username the service
     * throws an exception when get user by username
     */

    @Test
    public void givenANonExistingUserShouldThrowExceptionWhenGetUserByUsername(){
        String  username = "chriskabor";
        given(userRepository.findByUsername(username)).willReturn(Optional.empty());
        Assertions.assertThrows(UserNotFoundException.class, () -> {
            userService.getUserByUserName(username);
        });

    }

    /**
     * This method tests that given an invalid email the service
     * throws an exception when get user by email
     */

    @Test
    public void givenANonExistingUserShouldThrowExceptionWhenGetUserByEmail(){
        String  email = "chriskabor@gmail.com";
        given(userRepository.findByUsername(email)).willReturn(Optional.empty());
        Assertions.assertThrows(UserNotFoundException.class, () -> {
            userService.getUserByUserName(email);
        });

    }


    /**
     * This method tests that given an invalid email the service
     * throws an exception when get user by email
     */

    @Test
    public void givenANonExistingUserShouldThrowExceptionWhenDeleteUser(){
        Long  testUserId = 3L;
        given(userRepository.findById(testUserId)).willReturn(Optional.empty());
        Assertions.assertThrows(UserNotFoundException.class, () -> {
            userService.deleteUser(testUserId);
        });

    }







}
