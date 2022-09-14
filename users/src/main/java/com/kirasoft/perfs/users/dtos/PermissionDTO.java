package com.kirasoft.perfs.users.dtos;

import com.kirasoft.perfs.users.model.Permission;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * PermissionDTO - Class used to model transfer data for permission
 * @author Sidnooma Christian KABORE
 */
@Data
@NoArgsConstructor
public class PermissionDTO implements Serializable {

    private Long permissionId;
    private String permissionName;
    private boolean isEnabled;
    private String description;


    public PermissionDTO(Permission permission){
        if(permission!=null){
            this.permissionId = permission.getPermissionId();
            this.permissionName = permission.getPermissionName();
            this.isEnabled = permission.isEnabled();
            this.description = permission.getDescription();
        }
    }
}
