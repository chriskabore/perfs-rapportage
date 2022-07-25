package com.kirasoft.perfs.users.model;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 *  Permission -- Entity Class used to model user permissions
 * @author Sidnooma Christian KABORE
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class Permission {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "permission_id")
    private Long permissionId;

    private String permissionName;
    private boolean isEnabled;
    private String description;

    @ManyToMany(mappedBy = "permissions")
    private Set<Role> roles = new HashSet<>();

    public Permission(Long permissionId, String permissionName,
                      boolean isEnabled,String description){
        this.permissionId = permissionId;
        this.permissionName = permissionName;
        this.isEnabled = isEnabled;
        this.description = description;

    }

}
