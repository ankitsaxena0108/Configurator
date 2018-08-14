package com.prudential.core.common.authority;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.prudential.core.common.Transferrable;
import com.prudential.core.common.model.BillingSystemEntity;


@Entity
@Table(name = "COR_PERMISSION")
public class Permission extends BillingSystemEntity implements Transferrable<PermissionDTO>{

    private static final long serialVersionUID = 1L;

	public static final String PERM_AGENCY_MANAGE = "PERM_AGENCY_MANAGE";

    @Column(name = "PERMISSION_NAME")
    private String permissionName;
    
    @ManyToMany(mappedBy = "permissions") 
    private List<Role> roles;

    public String getPermissionName() {
        return permissionName;
    }

    public void setPermissionName(String permissionName) {
        this.permissionName = permissionName;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

	@Override
	public void populate(PermissionDTO dto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(PermissionDTO dto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public PermissionDTO extract(String... skipProperties) {
		PermissionDTO permDTO = new PermissionDTO();
		permDTO.setId(this.id);
		permDTO.setLastModified(getLastModified());
		permDTO.setPermissionName(permissionName);
		return permDTO;
	}
}
