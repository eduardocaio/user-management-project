package com.eduardocaio.user_management.dto;

import org.springframework.beans.BeanUtils;

import com.eduardocaio.user_management.entities.PermissionProfileResourceEntity;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PermissionProfileResourceDTO {

    private Long id;
    private ProfileDTO profile;
    private ResourceDTO resource;

    public PermissionProfileResourceDTO(PermissionProfileResourceEntity permission){
        BeanUtils.copyProperties(permission, this);
        if (permission != null && permission.getProfile() != null) {
            this.profile = new ProfileDTO(permission.getProfile());
        }
        if (permission != null && permission.getResource() != null) {
            this.resource = new ResourceDTO(permission.getResource());
        }
    }

}
