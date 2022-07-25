package com.kirasoft.perfs.users.model;

import lombok.*;

import javax.persistence.*;

/**
 *  ContactInformation -- Entity class used to model users' contact information
 * @author Sidnooma Christian KABORE
 */

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class ContactInformation {
    @Id
    @Column(name = "user_id")
    private Long userId;

    @Column(name ="email", nullable = false)
    private String email;
    private String homePhone;
    private String workPhone;
    private String skype;
    private String facebook;
    private String linkedIn;
    private String website;
    private String description;

    @OneToOne
    @MapsId
    private User user;



}
