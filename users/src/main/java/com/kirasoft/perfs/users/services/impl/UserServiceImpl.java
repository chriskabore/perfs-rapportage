package com.kirasoft.perfs.users.services.impl;
import com.kirasoft.perfs.users.dtos.request.CreateOrUpdateUserDTO;
import com.kirasoft.perfs.users.exceptions.*;
import com.kirasoft.perfs.users.model.AddressInformation;
import com.kirasoft.perfs.users.model.ContactInformation;
import com.kirasoft.perfs.users.model.Gender;
import com.kirasoft.perfs.users.model.User;
import com.kirasoft.perfs.users.repositories.AddressInformationRepository;
import com.kirasoft.perfs.users.repositories.ContactInformationRepository;
import com.kirasoft.perfs.users.repositories.RoleRepository;
import com.kirasoft.perfs.users.repositories.UserRepository;
import com.kirasoft.perfs.users.services.UserService;
import com.kirasoft.perfs.users.validators.EmailValidator;
import com.kirasoft.perfs.users.validators.PasswordValidator;
import com.kirasoft.perfs.users.validators.PhoneValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

/**
 *  UserServiceImpl -- Class used to implement User Service methods
 * @author Sidnooma Christian KABORE
 */
@Service
@Slf4j
public class UserServiceImpl implements UserService {


    private UserRepository userRepository;

    private ContactInformationRepository contactInformationRepository;

    private AddressInformationRepository addressInformationRepository;

    private RoleRepository roleRepository;

    @Value("${kirasoft.security.password.salt}")
    private String salt;

    private PasswordValidator passwordValidator;
    private EmailValidator emailValidator;
    private PhoneValidator phoneValidator;

    @Autowired
    public UserServiceImpl(UserRepository userRepository,
                           ContactInformationRepository contactInformationRepository,
                           AddressInformationRepository addressInformationRepository,
                           RoleRepository roleRepository
                           ){

        this.userRepository = userRepository;
        this.contactInformationRepository = contactInformationRepository;
        this.addressInformationRepository = addressInformationRepository;
        this.roleRepository = roleRepository;
        passwordValidator = new PasswordValidator();
        emailValidator = new EmailValidator();
        phoneValidator = new PhoneValidator();

    }

    public UserServiceImpl(){
        passwordValidator = new PasswordValidator();
        emailValidator = new EmailValidator();
        phoneValidator = new PhoneValidator();
    }



    /**
     * This method implements the saveUser method used to save a user into database
     * It verifies first that the user we want to save is not already present in the
     * database before saving it
     * @param user
     * @return savedUser
     */
    @Override
    public User saveUser(User user) {
        checkIfUserAlreadyExists(user);
        User userSaved = userRepository.save(user);
        log.info(String.format("User %s has been created.", userSaved.getUserId()));
        return userSaved;
    }

    /**
     * This method checks if the user object we are saving already exists in the database
     * @param user -- the user object that we want to add
     */
    private void checkIfUserAlreadyExists(User user) {
        if(user!=null){
            checkIfUserIdInUse(user.getUserId());
            checkIfUserNameNotAlreadyUsed(user.getUsername());
            checkIfUserEmailNotAlreadyUsed(user.getEmailAddress());
        }

    }

    /**
     * This method checks if a user with the same userId
     * It throws an exception if a user exists with the same
     * UserId
     * @param userId -- The user Id that we are checking
     */
    private void checkIfUserIdInUse(Long userId){
        if(userId!=null && userRepository.existsById(userId)){
            String message = String.format("The userId %s is already used by anoter User", userId);
            log.error(message);
            throw new UserAlreadyExistsException(message);
        }
    }

    /**
     * This method checks that a given username is not already in use by another user
     * It throws an exception if the
     * @param userName -- the username we are checking
     */
    private void checkIfUserNameNotAlreadyUsed(String userName){
        if(userName!=null){
            Optional<User> userByUserName = userRepository.findByUsername(userName);
            if(userByUserName.isPresent()){
                User userInDB = userByUserName.get();
                String msg = String.format("The username %s it's already in use from another user with ID = %s",
                        userInDB.getUsername(), userInDB.getUserId());
                log.error(msg);
                throw new UserAlreadyExistsException(msg);
            }
        }
    }

    /**
     * This methods tries to get a user in the repository, using an email address
     * It throws an exception if the email address is an empty string
     * It retruns a valid user object if the user exists in the repository
     * It throws an exception if the user is not in the repository
     * @param email -- the email address of the user we are seeking
     * @return user -- the user who's email address matches the email address provided
     */
    public User getUserByEmail(String email) {
        if (email == null) {
            throw new InvalidEmailException("email cannot be null");
        }

        Optional<User> optionalUser = userRepository.findByEmail(email);
        if(optionalUser.isPresent()){
            return optionalUser.get();
        }else{
            throw new UserNotFoundException(String.format("User not found for email address = %s", email));
        }
    }

    /**
     * This method tries to find a user in the repository with a given username
     * It throws an exception if the username is empty
     * It returns a valid user if the username matches a user in the repository
     * It throws an exception if there is no user in the repository with the same username
     * @param userName -- The username of the user we are seeking
     * @return user - a user object that matches the username provided
     */
    public User getUserByUserName(String userName){
        if(userName == null){
            throw new InvalidUserNameException("username cannot be null");
        }
        Optional<User> optionalUser = userRepository.findByUsername(userName);
        if(optionalUser.isPresent()){
            return optionalUser.get();
        }else{
            throw new UserNotFoundException(String.format("User not found for Username = %s", userName));
        }
    }

    /**
     * This method is used to check if user email address is not already in use by another user
     * It throws an exception if the email address is already in used by another user
     * @param userEmail -- the email address of the user we are seeking
     */
    private void checkIfUserEmailNotAlreadyUsed(String userEmail){
        if(userEmail!=null){
            Optional<User> userByEmail = userRepository.findByEmail(userEmail);
            if(userByEmail.isPresent()){
                User userInDB = userByEmail.get();
                String msg = String.format("The email address %s it's already in use from another user with ID = %s",
                        userInDB.getUsername(), userInDB.getUserId());
                log.error(msg);
                throw new UserAlreadyExistsException(msg);
            }
        }
    }


    /**
     * This method is used to retrieve a user by a given Id
     * @param Id -- the user Id that we want to retrieve
     * @return user -- the user with the matching id
     */
    @Override
    public User getUserById(Long Id) {
        return userRepository.findById(Id).orElse(null);
    }

    /**
     * This methods retrieves a list of all users
     * @return usersList -- the list of the users
     */
    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    /**
     * This method updates an existing user
     * It throws an exception if the username is already in use by another user
     * It throws an exception if the email address is already in use by another user
     * It throws an exception if the user with the given Id is not in the repository
     * @param userId -- The Id of the user entity we want to update
     * @param updateData -- the data we want to update
     * @return userUpdated -- the update user
     */
    @Override
    public User updateUser(Long userId, CreateOrUpdateUserDTO updateData) {

        if (userId == null) {
            throw new InvalidUserIdentifierException("Id cannot be null");
        }

        if (updateData == null) {
            throw new InvalidUserDataException("User cannot be updated with empty data");
        }

        Optional<User> optionalUser = userRepository.findById(userId);

        if (!optionalUser.isPresent()) {
            throw new UserNotFoundException(String.format("The user with Id = %s doesn't exists", userId));
        }

        User userToBeUpdated = optionalUser.get();

        // check if the username has not been registered
        User userByUsername = getUserByUserName(updateData.getUsername());
        if (userByUsername != null) {
            // check if the user's id is different than the actual user
            if (!userToBeUpdated.getUserId().equals(userByUsername.getUserId())) {
                String msg = String.format("The username %s it's already in use from another user with ID = %s",
                        updateData.getUsername(), userByUsername.getUserId());
                log.error(msg);
                throw new UserAlreadyExistsException(msg);
            }
        }

        // check if the new email has not been registered yet
        User userByEmail = getUserByEmail(updateData.getEmail());
        if (userByEmail != null) {
            // check if the user's email is different than the actual user
            if (!userToBeUpdated.getUserId().equals(userByEmail.getUserId())) {
                String msg = String.format("The email %s it's already in use from another user with ID = %s",
                        updateData.getEmail(), userByEmail.getUserId());
                log.error(msg);
                throw new InvalidUserDataException(msg);
            }
        }

        // Validating update data
        passwordValidator.checkPassword(updateData.getPassword());
        emailValidator.checkEmail(updateData.getEmail());
        phoneValidator.checkPhone(updateData.getHomePhone());
        phoneValidator.checkPhone(updateData.getWorkPhone());

        userToBeUpdated.setUsername(updateData.getUsername());
        userToBeUpdated.setPassword(updateData.getPassword());
        userToBeUpdated.setFirstName(updateData.getFirstName());
        userToBeUpdated.setLastName(updateData.getLastName());

        Gender updatedGender = Gender.getValidGender(updateData.getGender());
        userToBeUpdated.setGender(updatedGender);

        userToBeUpdated.setDateOfBirth(updateData.getBirthDate());
        userToBeUpdated.setEnabled(updateData.isEnabled());
        userToBeUpdated.setDescription(updateData.getDescription());

        ContactInformation contactInformation = userToBeUpdated.getContactInformation();
        if (contactInformation == null) {
            contactInformation = new ContactInformation();
        }
        contactInformation.setEmail(updateData.getEmail());
        contactInformation.setFacebook(updateData.getFacebook());
        contactInformation.setHomePhone(updateData.getHomePhone());
        contactInformation.setWorkPhone(updateData.getWorkPhone());
        contactInformation.setWebsite(updateData.getWebsite());
        contactInformation.setSkype(updateData.getSkype());
        contactInformation.setLinkedIn(updateData.getLinkedin());
        contactInformation.setDescription(updateData.getDescription());
        

        AddressInformation addressInformation = userToBeUpdated.getAddressInformation();
        if (addressInformation == null) {
            addressInformation = new AddressInformation();
        }
        addressInformation.setAddress(updateData.getAddress());
        addressInformation.setPostAddress(updateData.getPostAddress());
        addressInformation.setCity(updateData.getCity());
        addressInformation.setCountry(updateData.getCountry());
        addressInformation.setZipCode(updateData.getZipCode());
        addressInformation.setDescription(updateData.getDescription());

        userToBeUpdated.setDateUpdated(LocalDateTime.now());





        User userUpdated = userRepository.save(userToBeUpdated);
        log.info(String.format("User %s has been updated.", userUpdated.getUserId()));

        return userUpdated;
    }

    /**
     * This method deletes the user with the given user Id
     * It throws an exception if any user with the specified Identifier is not found in the database
     * @param Id -- The identifier of the user that is to be deleted
     */
    @Override
    public void deleteUser(Long Id) {
        Optional userInDB = userRepository.findById(Id);
        if(userInDB.isPresent()){
            User userToDelete = (User) userInDB.get();
            userRepository.deleteById(userToDelete.getUserId());
        }else{
            throw new UserNotFoundException(String.format("The user with Id = %s doesn't exists", Id));
        }
    }
}
