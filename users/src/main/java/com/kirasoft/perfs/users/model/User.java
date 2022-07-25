package com.kirasoft.perfs.users.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

/**
 * User -- Entity class used to model users
 * @author Sidnooma Christian KABORE
 */

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="user_id")
    private Long userId;

    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private String description;

    private boolean enabled;
    private boolean secured;

    @Basic
    private LocalDate dateOfBirth;
    @Basic
    private LocalDateTime dateCreated;
    @Basic
    private LocalDateTime dateUpdated;

    @Basic
    private LocalDateTime dateOfLastLogin;

    @Enumerated
    @Column(columnDefinition = "tinyint")
    private Gender gender;

    @OneToOne (mappedBy = "user", cascade = CascadeType.ALL)
    private ContactInformation contactInformation;
    @OneToOne (mappedBy = "user", cascade = CascadeType.ALL)
    private AddressInformation addressInformation;

    @ManyToMany
    @JoinTable(joinColumns = @JoinColumn(name = "user_id"),
    inverseJoinColumns = @JoinColumn(name="role_id"))
    private Set<Role> roles = new HashSet<>();

    public List<Permission> getPermissions (){
        return this.roles.isEmpty() ? new ArrayList<>() : getRoles().stream()
                .map(Role::getPermissions)
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
    }


    public void addRole(Role role) {
        this.roles.add(role);
    }
}
