package com.kirasoft.perfs.users.model;

import lombok.*;

import javax.persistence.*;

/**
 * AddressInformation -- Entity class used to model users' address information
 * @author Sidnooma Christian KABORE
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class AddressInformation {
    @Id
    @Column(name = "user_id")
    private Long userId;

    private String address;
    private String postAddress;
    private String city;
    private String country;
    private String zipCode;
    private String description;

    @OneToOne
    @MapsId
    private User user;

    public AddressInformation(String address, String postAddress,
                              String city, String country, String zipCode) {
        this.address = address;
        this.postAddress = postAddress;
        this.city = city;
        this.country = country;
        this.zipCode = zipCode;
    }


}
