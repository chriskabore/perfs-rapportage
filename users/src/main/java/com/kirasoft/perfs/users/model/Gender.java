package com.kirasoft.perfs.users.model;

/**
 * Gender --- enumeration class used to model users' gender
 * @author  Sidnooma Christian KABORE
 */
public enum Gender {

    MALE(1),FEMALE(2);

    private int gender;

    Gender(int gender){
        this.gender = gender;
    }

    public int getGender(){
        return this.gender;
    }

    /**
     * This method is used to get a valid gender object corresponding to a gender name parameter
     * @param genderName This is the name of the gender from which we need a gender
     * @return Gender This returns the corresponding gender object
     */
    public static Gender getValidGender(String genderName){
        try {
            return   Gender.valueOf(genderName);
        }catch (IllegalArgumentException iae){
            throw new IllegalArgumentException(
                    String.format("Invalid gender string %s. Are supported only: MALE or FEMALE strings",
                            genderName));
        }
    }
}
