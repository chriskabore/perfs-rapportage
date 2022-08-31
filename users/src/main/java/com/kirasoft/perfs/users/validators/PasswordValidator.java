package com.kirasoft.perfs.users.validators;

import com.google.common.base.Strings;
import com.kirasoft.perfs.users.exceptions.InvalidUserDataException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * PasswordValidator -- Class used to validate user passwords
 * @author Sidnooma Christian KABORE
 */
public class PasswordValidator {

    private static final int MAX_PASSWORD_LENGTH = 60;
    private static final int MIN_PASSWORD_LENGTH = 8;

    private static final String PASSWORD_REGEX = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&*])(?=\\S+$).{8,}$";

    private Pattern pattern;

    public PasswordValidator() {
        pattern = Pattern.compile(PASSWORD_REGEX);
    }

    public void checkPassword(String password) {
        if (Strings.isNullOrEmpty(password)) {
            throw new InvalidUserDataException("Password cannot be null or empty");
        }

        // check min length
        if(password.length() < MIN_PASSWORD_LENGTH){
            throw new InvalidUserDataException(String.format("Password is too short: min number of chars is %s",
                    MIN_PASSWORD_LENGTH));
        }

        // check max length
        if (password.length() > MAX_PASSWORD_LENGTH) {
            throw new InvalidUserDataException(String.format("Password is too long: max number of chars is %s",
                    MAX_PASSWORD_LENGTH));
        }

        // Password must to be at least 8 chars, 1 number, 1 upper case, 1 lower case letter, 1 special char, no spaces
        Matcher matcher = pattern.matcher(password);
        if (!matcher.matches()) {
            throw new InvalidUserDataException("Password must to be at least 8 chars, 1 number, 1 upper case," +
                    " 1 lower case letter, 1 special char, no spaces");
        }
    }
}
