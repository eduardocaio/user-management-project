package com.eduardocaio.user_management.entities;

import org.springframework.beans.BeanUtils;

import com.eduardocaio.user_management.dto.PermissionProfileResourceDTO;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tb_permission_profile_resource")
@Getter
@Setter
@NoArgsConstructor
public class PermissionProfileResourceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_profile")
    private ProfileEntity profile;

    @ManyToOne
    @JoinColumn(name = "id_resource")
    private ResourceEntity resource;

    public PermissionProfileResourceEntity(PermissionProfileResourceDTO permission){
        BeanUtils.copyProperties(permission, this);
        if (permission != null && permission.getProfile() != null) {
            this.profile = new ProfileEntity(permission.getProfile());
        }
        if (permission != null && permission.getResource() != null) {
            this.resource = new ResourceEntity(permission.getResource());
        }
    }

}
