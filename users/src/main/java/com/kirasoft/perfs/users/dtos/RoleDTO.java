package com.kirasoft.perfs.users.dtos;

import com.kirasoft.perfs.users.model.Role;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * RoleDTO - Class used to model transfer data for Role
 * @author Sidnooma christian KABORE
 */
@Data
@NoArgsConstructor
public class RoleDTO implements Serializable {

    private Long roleId;
    private String roleName;
    private List<PermissionDTO> permissions = new ArrayList<>();

    public RoleDTO(Role role){
        if(role!=null){
            this.roleId = role.getRoleId();
            this.roleName = role.getRoleName();
            role.getPermissions().stream().forEach(p->permissions.add(new PermissionDTO(p)));
        }
    }

    public RoleDTO(Long roleId, String roleName){
       this.roleId = roleId;
       this.roleName = roleName;
    }

}
